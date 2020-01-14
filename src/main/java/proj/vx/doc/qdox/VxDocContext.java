package proj.vx.doc.qdox;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaParameter;
import com.thoughtworks.qdox.model.JavaType;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import proj.vx.doc.qdox.generator.Generator;

import java.io.File;
import java.util.*;
import java.util.logging.Logger;

import static proj.vx.doc.qdox.tag.VxTag.*;

/**
 * Created by admin on 2020/1/13 14:19:02.
 */
public class VxDocContext {
    Logger logger = Logger.getLogger(this.getClass().getName());
    
    
    Map<String, JavaClass> routeClassMap   = new HashMap<>();
    Map<String, JavaClass> modelClassMap   = new HashMap<>();
    Map<String, JavaClass> apiInfoClassMap = new HashMap<>();
    
    OpenAPI               oas        = new OpenAPI();
    Collection<JavaClass> allClasses = Collections.EMPTY_LIST;
    List<String>          errors     = new ArrayList<>();
    
    private VxDocConfig config    = new VxDocConfig();
    private Generator   generator = Generator.map.get(config.getOutputType().name());
    
    public void scanJavaSource() {
        JavaProjectBuilder builder = new JavaProjectBuilder();
        builder.addSourceTree(new File(config.getPathName()));
        allClasses = builder.getClasses();
    }
    
    public void sortJavaClass() {
        for (JavaClass javaClass : allClasses) {
            //apiInfo class
            if (javaClass.getTagsByName(apiInfo).size() > 0) {
                apiInfoClassMap.put(javaClass.getFullyQualifiedName(), javaClass);
            }
            //route class
            if (javaClass.getTagsByName(route).size() > 0) {
                routeClassMap.put(javaClass.getFullyQualifiedName(), javaClass);
            }
            //model class
            if (javaClass.getTagsByName(model).size() > 0) {
                modelClassMap.put(javaClass.getFullyQualifiedName(), javaClass);
            }
        }
        System.out.println("apiInfo:" + apiInfoClassMap);
        System.out.println("route:" + routeClassMap);
        System.out.println("model:" + modelClassMap);
        
        logger.info("apiInfo:" + apiInfoClassMap);
        logger.info("route:" + routeClassMap);
        logger.info("model:" + modelClassMap);
    }
    
    public void buildOpenApiModel() {
        //todo apiInfo解析
        Map<String, String> map = apiInfoClassMap
                .get("proj.doc.test.model.UserRoute")
                .getTagByName(apiInfo)
                .getNamedParameterMap();
        Info info = new Info()
                .title(map.get(title))
                .description(map.get(description))
                .termsOfService(map.get(termsOfService))
                .contact(new Contact()
                        .name(map.get(contactName))
                        .email(map.get(contactEmail))
                        .url(map.get(contactUrl)))
                .license(new License().name(map.get(licenseName)).url(licenseUrl));
        oas.info(info);
        
        //todo 解析routemap
        routeClassMap.forEach((k, v) -> {
            // step 1: 解析 class级的注释
            String path = v.getTagByName(route) == null ? "" : v.getTagByName(route).getValue();
            if (path.equals("/")) {
                path = "";
            } else if (!path.isEmpty() && !path.startsWith("/")) {
                errors.add(k + " has a illegal route. Route must start with '/' or empty");
            }
            //step 2: 解析方法
            for (JavaMethod method : v.getMethods()) {
                JavaClass          rClass = method.getReturns();
                JavaType           rType = method.getReturnType();
                String             code = method.getCodeBlock();
                List<JavaParameter> parameters = method.getParameters();
                List<JavaType> javaTypes = method.getParameterTypes();
                //todo debug this
                ModelConverters.getInstance().read()
                
                System.out.println("sdfsd");
            }
        });
        
        //todo 解析modelmap
        
        //todo 解析三类map ，modelMap需要 getTagsByName("model", true); 递归。其他两类不需要递归
        modelClassMap.get("proj.doc.test.model.UserExtend").getTagsByName("model", true);
        apiInfoClassMap.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
            
        });
    }
    
    public VxDocConfig getConfig() {
        return config;
    }
    
    public void setConfig(VxDocConfig config) {
        this.config = config;
        this.generator = Generator.map.get(config.getOutputType().name());
    }
    
    public Generator getGenerator() {
        return generator;
    }
    
    public void setGenerator(Generator generator) {
        this.generator = generator;
    }
}

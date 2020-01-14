package proj.vx.doc.qdox;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import proj.vx.doc.qdox.generator.Generator;
import proj.vx.doc.qdox.tag.VxTag;

import java.io.File;
import java.util.*;
import java.util.logging.Logger;

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
            if (javaClass.getTagsByName(VxTag.apiInfo).size() > 0) {
                apiInfoClassMap.put(javaClass.getFullyQualifiedName(), javaClass);
            }
            //route class
            if (javaClass.getTagsByName(VxTag.route).size() > 0) {
                routeClassMap.put(javaClass.getFullyQualifiedName(), javaClass);
            }
            //model class
            if (javaClass.getTagsByName(VxTag.model).size() > 0) {
                modelClassMap.put(javaClass.getFullyQualifiedName(), javaClass);
            }
            //model class
            if (javaClass.getTagsByName("modela").size() > 0) {
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
        oas.info(new Info());
        //todo 解析三类map ，modelMap需要 getTagsByName("modela", true); 递归。其他两类不需要递归
        modelClassMap.get("proj.doc.test.model.UserExtend").getTagsByName("modela", true);
        apiInfoClassMap.get("proj.doc.test.model.UserRoute").getTagByName("apiInfo").getNamedParameterMap();
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

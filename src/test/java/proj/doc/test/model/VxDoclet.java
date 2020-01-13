package proj.doc.test.model;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.DocErrorReporter;
import com.sun.javadoc.LanguageVersion;
import com.sun.javadoc.RootDoc;
import com.sun.tools.doclets.formats.html.ConfigurationImpl;
import com.sun.tools.doclets.internal.toolkit.AbstractDoclet;
import com.sun.tools.doclets.internal.toolkit.Configuration;
import com.sun.tools.doclets.internal.toolkit.util.ClassTree;
import com.sun.tools.doclets.internal.toolkit.util.DocletAbortException;
import com.sun.tools.doclets.internal.toolkit.util.FatalError;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import proj.vx.doc.qdox.VxTag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2020/1/11 13:18:22.
 */
public class VxDoclet extends AbstractDoclet {
    
    
    static Map<String, ClassDoc> routeClassMap   = new HashMap<>();
    static Map<String, ClassDoc> modelClassMap   = new HashMap<>();
    static Map<String, ClassDoc> apiInfoClassMap = new HashMap<>();
    
    static List<String> vxCustomTaglets = new ArrayList<>();
    static OpenAPI      oas             = new OpenAPI();
    
    private static      VxDoclet          docletToStart            = null;
    public static final ConfigurationImpl configuration            = new ConfigurationImpl();
    public static final ConfigurationImpl sharedInstanceForOptions = new ConfigurationImpl();
    
    
    public VxDoclet() {
        super();
        super.configuration = this.configuration;
    }
    
    @Override
    public Configuration configuration() {
        super.configuration = this.configuration;
        return this.configuration;
    }
    
    private boolean isValidDoclet(AbstractDoclet var1) {
        if (!var1.getClass().getName().equals(this.getClass().getName())) {
            this.configuration.message.error("doclet.Toolkit_Usage_Violation", new Object[]{"sssssssssss"});
            return false;
        } else {
            return true;
        }
    }
    
    //third execute, generate openapi.yml by swagger/openapi model
    public void generateOpenApiFile() throws Exception {
        this.generateOpenApiFile("");
    }
    
    public void generateOpenApiFile(String path) throws Exception {
        System.out.println("step 3：generate openapi.yml by swagger/openapi model");
        
    }
    
    //second execute, generate swagger/openapi model
    public void generateOpenApi() throws Exception {
        System.out.println("step 2： generate swagger/openapi model");
        //生成apiInfo
        if (apiInfoClassMap.isEmpty()) {
            //默认定义
            Info info = new Info();
            oas.info(info);
        } else if (apiInfoClassMap.size() == 1) {
            //读取代码中的定义
            Info info = new Info();
            info.title("titless").description("descriptionss");
            oas.info(info);
        } else {
            throw new Exception("There are multiple \"apiInfo\" in this project");
        }
    }
    
    //first execute, sort java source
    @Override
    protected void generateClassFiles(ClassDoc[] classDocs, ClassTree classTree) {
        System.out.println("step 1：sort java source file");
        for (ClassDoc classDoc : classDocs) {
            //apiInfo class
            if (classDoc.tags(VxTag.apiInfo).length > 0) {
                apiInfoClassMap.put(classDoc.qualifiedName(), classDoc);
            }
            //route class
            if (classDoc.tags(VxTag.route).length > 0) {
                routeClassMap.put(classDoc.qualifiedName(), classDoc);
            }
            //model class
            if (classDoc.tags(VxTag.model).length > 0) {
                modelClassMap.put(classDoc.qualifiedName(), classDoc);
            }
        }
        System.out.println("routeMap=" + routeClassMap);
        System.out.println("modelMap=" + modelClassMap);
        System.out.println("apiinfo=" + apiInfoClassMap);
    }
    
    @Override
    protected void generateProfileFiles() throws Exception {
        //do nothing
    }
    
    @Override
    protected void generatePackageFiles(ClassTree classTree) throws Exception {
        //do nothing
    }
    
    public static boolean start(RootDoc rootDoc) {
        VxDoclet var1;
        if (docletToStart != null) {
            var1 = docletToStart;
            docletToStart = null;
        } else {
            var1 = new VxDoclet();
        }
        return var1.start(var1, rootDoc);
    }
    
    public static void addSeenCustomTaglets(List<String> taglets) {
        if (taglets != null) {
            vxCustomTaglets.addAll(taglets);
        }
    }
    
    public boolean start(AbstractDoclet var1, RootDoc var2) {
        this.configuration.root = var2;
        if (!this.isValidDoclet(var1)) {
            return false;
        } else {
            try {
                this.startGeneration(var2);
                return true;
            } catch (Configuration.Fault var5) {
                var2.printError(var5.getMessage());
                return false;
            } catch (FatalError var6) {
                return false;
            } catch (DocletAbortException var7) {
                Throwable var4 = var7.getCause();
                if (var4 != null) {
                    if (var4.getLocalizedMessage() != null) {
                        var2.printError(var4.getLocalizedMessage());
                    } else {
                        var2.printError(var4.toString());
                    }
                }
                
                return false;
            } catch (Exception var8) {
                var8.printStackTrace();
                return false;
            }
        }
    }
    
    private void startGeneration(RootDoc var1) throws Configuration.Fault, Exception {
        if (var1.classes().length == 0) {
            this.configuration.message.error("doclet.No_Public_Classes_To_Document", new Object[0]);
        } else {
            this.configuration.setOptions();
            this.configuration
                    .getDocletSpecificMsg()
                    .notice("doclet.build_version", new Object[]{this.configuration.getDocletSpecificBuildDate()});
            // seen vx custom taglets
            vxCustomTaglets.forEach(x -> {
                configuration.tagletManager.seenCustomTag(x);
            });
            
            ClassTree var2 = new ClassTree(this.configuration, this.configuration.nodeprecated);
            //分类根据 route/model 分类
            this.generateClassFiles(var1, var2);
            //生成openapi对象
            this.generateOpenApi();
            //根据openapi对象生成file
            this.generateOpenApiFile();
            
            this.configuration.tagletManager.printReport();
        }
    }
    
    public static int optionLength(String var0) {
        return sharedInstanceForOptions.optionLength(var0);
    }
    
    public static boolean validOptions(String[][] var0, DocErrorReporter var1) {
        docletToStart = new VxDoclet();
        return docletToStart.configuration.validOptions(var0, var1);
        
    }
    
    public static LanguageVersion languageVersion() {
        return LanguageVersion.JAVA_1_1;
    }
}

package proj.vx.doc.qdox.tag;

/**
 * Created by admin on 2020/1/11 13:39:08.
 */
public interface VxTag {
    String route   = "route";
    String model   = "model";
    String apiInfo = "apiInfo";
    
    //HTTP METHOD
    String post    = "post";
    String get     = "get";
    String put     = "put";
    String patch   = "patch";
    String delete  = "delete";
    String head    = "head";
    String options = "options";
    
    //apiInfo
    String version        = "version";
    String title          = "title";
    String description    = "description";
    String termsOfService = "termsOfService";
    String contactName    = "contact.name";
    String contactEmail   = "contact.email";
    String contactUrl     = "contact.url";
    String licenseName    = "license.name";
    String licenseUrl     = "license.url";
    
    //parameter
    String header      = "header";
    String query       = "query";
    String path        = "path";
    String body        = "body";
    String response    = "response";
    String operationId = "operationId";
    
    
}

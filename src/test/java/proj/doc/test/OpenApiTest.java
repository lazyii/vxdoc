package proj.doc.test;

import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.QueryParameter;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.servers.ServerVariable;
import io.swagger.v3.oas.models.servers.ServerVariables;
import org.junit.Test;

/**
 * Created by admin on 2020/3/17 10:06:40.
 */
public class OpenApiTest {
    
    @Test
    public void createApi() {
        OpenAPI api = new OpenAPI();
        
        // todo 设置info
        Info info = new Info();
        info.setTitle("info-title");
        info.setDescription("info-description");
        info.setVersion("info-version");
        info.setTermsOfService("info-TermsOfService");
        info.setContact(new Contact().url("contact-url").name("contact-name").email("contact-email@qq.com"));
        info.setLicense(new License().url("license-url").name("license-name"));
    
        api.setInfo(info);
        
        // todo 设置servers
        Server server = new Server();
        server.setDescription("server-description");
        server.setUrl("server-url");
        
        ServerVariable serverVariable = new ServerVariable();
        serverVariable.setDefault("default-sv");
        serverVariable.setDescription("default-sv-description");
        
        server.setVariables(new ServerVariables().addServerVariable("sv11", serverVariable));
    
        api.addServersItem(server);
        
        // todo pathItem1 设置path（url等参数）
        PathItem item1 = new PathItem();
        Operation operation1 = new Operation();
        operation1.addTagsItem("tag1");
        operation1.setSummary("operation1-summary-这是接口摘要");
        operation1.setDescription("operation1-description-这是接口详情描述");
        operation1.setOperationId("unique-operation1-id");
        
        //参数设置
        QueryParameter qp1 = new QueryParameter();
        qp1.setName("param-name");
        qp1.required(false);
        qp1.explode(true);
        qp1.setExample("qp1-example");
        qp1.setSchema(new StringSchema().$ref("sdfsd"));
        qp1.setSchema(new ObjectSchema().$ref("sdfds"));
    
        operation1.addParametersItem(qp1);
        
        //body设置
        Content content = new Content();
        content.addMediaType("requestBody-content-media111", new MediaType().schema(new ObjectSchema()));
        content.addMediaType("requestBody-content-media222", new MediaType().schema(new ObjectSchema().$ref("/#/ref/hahaha")));
        
        
        RequestBody requestBody = new RequestBody();
        requestBody.content(content);
        operation1.setRequestBody(requestBody);
        
        
        item1.setOptions(operation1.responses(new ApiResponses().addApiResponse("1231321", new ApiResponse())));
        // todo pathItem1
        
        
        
        
        // todo pathItem2
        PathItem item2 = new PathItem();
        item2.setPost(new Operation().description("pathitem2-option-desc").responses(new ApiResponses().addApiResponse("1231321", new ApiResponse())));
        // todo pathItem2
        
        
        Paths paths = new Paths();
        paths.addPathItem("/all-option/aa.do", item1);
        paths.addPathItem("/post-option/aa.do", item2);
        
        api.setPaths(paths);
        
        // todo 设置components
    
        System.out.println(Yaml.pretty(api));
//        System.out.println(Json.pretty(api));
    
    }
}

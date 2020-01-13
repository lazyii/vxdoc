package proj.vx.qdox;

/**
 * Created by admin on 2020/1/13 15:12:14.
 */
public class VxDocStand {
    
    private static VxDocContext context = new VxDocContext();
    
    //scanSource => sortClass => buildOpenApiModel => output
    public static String generate() throws Exception {
        context.scanJavaSource();
        context.sortJavaClass();
        context.buildOpenApiModel();
    
        return context.getGenerator().generate();
    }
    
    //scanSource => sortClass => buildOpenApiModel => output
    public static String generate(VxDocConfig config) throws Exception {
        context.setConfig(config);
        return generate();
    }
}

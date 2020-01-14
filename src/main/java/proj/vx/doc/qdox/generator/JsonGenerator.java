package proj.vx.doc.qdox.generator;

/**
 * Created by admin on 2020/1/13 15:23:16.
 */
public class JsonGenerator implements Generator{
    @Override
    public String generate() {
        return "json";
    }
    
    @Override
    public void register() {
        map.put("json", this);
    }
}

package proj.vx.doc.qdox;

/**
 * Created by admin on 2020/1/13 15:23:16.
 */
public class YmlGenerator implements Generator{
    @Override
    public String generate() {
        return "yml";
    }
    
    @Override
    public void register() {
        map.put("yml", this);
    }
}

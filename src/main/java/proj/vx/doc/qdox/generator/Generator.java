package proj.vx.doc.qdox.generator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2020/1/13 15:22:34.
 */
public interface Generator {
    Map<String, Generator> map = new HashMap<>();
    
    String generate();
    
    void register();
}

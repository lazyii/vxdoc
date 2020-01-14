package proj.vx.doc.qdox.translator;

import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;

/**
 * Created by admin on 2020/1/13 19:51:50.
 */
public class RouteTranslator implements Translator<Paths> {
    
    @Override
    public Paths translate() {
    
        PathItem item = new PathItem();
        Paths paths = new Paths();
        return null;
    }
}

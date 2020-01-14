package proj.vx.doc.qdox.translator;

import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;

/**
 * Created by admin on 2020/1/13 19:51:50.
 */
public class ModelTranslator implements Translator<Schema<String>> {
    @Override
    public Schema<String> translate() {
        ObjectSchema objectSchema = new ObjectSchema();
        ArraySchema arraySchema = new ArraySchema();
        
        return null;
    }
}

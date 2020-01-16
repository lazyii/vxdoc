package proj.doc.test;

import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.models.media.Schema;
import org.junit.Test;
import proj.doc.test.model.ModelWithArray;

import java.util.Map;

/**
 * Created by admin on 2020/1/16 15:51:00.
 */
public class ModelConverterTest {

    @Test
    public void arraySchemaTest() {
        final Map<String, Schema> models = ModelConverters.getInstance().read(ModelWithArray.class);
        final Map<String, Schema> models1 = ModelConverters.getInstance().read(ModelWithArray.class);
        //判断是否是array
        
        System.out.println("sdfsd");
    }
}

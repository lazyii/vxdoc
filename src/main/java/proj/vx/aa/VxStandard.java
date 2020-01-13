package proj.vx.aa;

import com.sun.javadoc.DocErrorReporter;
import com.sun.javadoc.LanguageVersion;
import com.sun.javadoc.RootDoc;
import proj.vx.taglets.ModelTaglet;
import proj.vx.taglets.RouteTaglet;
import proj.vx.taglets.TestTaglet;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2020/1/11 13:18:22.
 * @apiRoute titleddd descriptionssss
 */
public class VxStandard {
    
    public VxStandard() {
    }
    
    // 1
    public static int optionLength(String var0) {
        return VxDoclet.optionLength(var0);
    }
    
    // 4
    public static boolean start(RootDoc var0) {
        //add seen custom taglets
        List<String> seenTags = Arrays.asList(ModelTaglet.tag, RouteTaglet.tag, TestTaglet.tag);
        VxDoclet.addSeenCustomTaglets(seenTags);
        
        return VxDoclet.start(var0);
    }
    
    // 2
    public static boolean validOptions(String[][] var0, DocErrorReporter var1) {
        return VxDoclet.validOptions(var0, var1);
    }
    
    // 3
    public static LanguageVersion languageVersion() {
        return VxDoclet.languageVersion();
    }
}

package proj.vx.aa;

import com.sun.tools.javadoc.Main;
import proj.vx.doclet.Utils;
import proj.vx.taglets.ModelTaglet;
import proj.vx.taglets.RouteTaglet;
import proj.vx.taglets.TestTaglet;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2020/1/8 15:23:01.
 */
public class JavadocMain {
    /**
     * 执行文档解析
     */
    public static void main(String[] args) {
        String       file       = "D:/IdeaProject/vxDoclet/src/main/java";
        List<String> path       = Arrays.asList(file);
        String       sourcepath = Utils.join(path, ";");
        
        
        List<String> packages    = Arrays.asList("proj.vx.aa");
        String       subpackages = Utils.join(packages, ":");
        
        //执行javadoc 命令
        Main.execute(new String[]{
                "-private",
                "-doclet", VxStandard.class.getName(),
                "-taglet", ModelTaglet.class.getName(),
                "-taglet", RouteTaglet.class.getName(),
                "-taglet", TestTaglet.class.getName(),
                "-encoding", System.getProperty("file.encoding"),
                "-quiet",
                "-sourcepath", sourcepath,
                "-subpackages", subpackages
        });
    }
}

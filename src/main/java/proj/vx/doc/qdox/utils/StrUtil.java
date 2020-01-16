package proj.vx.doc.qdox.utils;

/**
 * Created by admin on 2020/1/15 9:31:58.
 */
public class StrUtil {
    
    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }
    
    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

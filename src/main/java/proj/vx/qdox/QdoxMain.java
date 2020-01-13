package proj.vx.qdox;

/**
 * Created by admin on 2020/1/9 10:16:03.
 */
public class QdoxMain {
    
    
    public static void main(String[] args) {
        try {
            VxDocConfig config = new VxDocConfig();
            VxDocStand.generate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

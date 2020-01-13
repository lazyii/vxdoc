package proj.vx.qdox;

/**
 * Created by admin on 2020/1/13 15:01:46.
 */
public class VxDocConfig {
    //default src
    OutputType outputType = OutputType.Yml;
    String     pathName   = "src";
    
    public OutputType getOutputType() {
        return outputType;
    }
    
    public void setOutputType(OutputType outputType) {
        this.outputType = outputType;
    }
    
    public String getPathName() {
        return pathName;
    }
    
    public void setPathName(String pathName) {
        this.pathName = pathName;
    }
    
    public enum OutputType {
        Yml, Json
    }
}

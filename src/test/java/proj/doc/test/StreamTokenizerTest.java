package proj.doc.test;

import com.thoughtworks.qdox.model.util.TagParser;
import org.junit.Test;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * Created by admin on 2020/1/14 9:49:35.
 */
public class StreamTokenizerTest {
    String tagValue = "version = 1.0.0\n" + "title = title\n" + "description = 这个api描述\n" + "termsOfService = \"http://swagger.io/terms/\"\n" + "contact.name = swagger\n" + "contact.email = \"swagger@qq.com\"\n" + "contact.url = \"https://swagger.io\"\n" + "license.name = \"Apache 2.0\"\n" + "license.url = \"http://www.apache.org/licenses/LICENSE-2.0.html\"";
    String urlValue = "license.url = 例如url： http://www.apache.org/licenses/LICENSE-2.0.htm lkdsjlfkdsjlfkjsdlkfjk\nsdf\na=b";

    @Test
    public void tokenizerDefault() {
        //https://www.runoob.com/manual/jdk1.6/java/io/StreamTokenizer.html
        StreamTokenizer tokenizer =
                new StreamTokenizer(new StringReader(tagValue));
        tokenizer.resetSyntax();
        tokenizer.wordChars('A','Z');
        tokenizer.wordChars('a','z');
        tokenizer.wordChars('0','9');
        tokenizer.wordChars('-','-');
        tokenizer.wordChars('_','_');
        tokenizer.wordChars('.','.');
        tokenizer.wordChars('<','<');
        tokenizer.wordChars('>','>');
        tokenizer.quoteChar('\'');
        tokenizer.quoteChar('"');
        tokenizer.whitespaceChars(' ',' ');
        tokenizer.whitespaceChars('\t','\t');
        tokenizer.whitespaceChars('\n','\n');
        tokenizer.whitespaceChars('\r','\r');
        tokenizer.eolIsSignificant(false);
        
        //todo print
        this.printStream(tokenizer);
    
    }
    
    @Test
    public void tokenizerOrdinary() {
        //https://www.runoob.com/manual/jdk1.6/java/io/StreamTokenizer.html
        StreamTokenizer tokenizer =
                new StreamTokenizer(new StringReader(urlValue));
        tokenizer.resetSyntax();
        //todo print
        this.printStream(tokenizer);
    
    }
    
    @Test
    public void tokenizerChar() {
        String s = " \t\n\r\f";
        //https://www.runoob.com/manual/jdk1.6/java/io/StreamTokenizer.html
        StreamTokenizer tokenizer =
                new StreamTokenizer(new StringReader(urlValue));
        tokenizer.resetSyntax();
        // asicc 61 为 = 。等号
        tokenizer.wordChars(0, 60);
        tokenizer.wordChars(62, 256);
        
        tokenizer.whitespaceChars(' ',' ');
        tokenizer.whitespaceChars('\t','\t');
        tokenizer.whitespaceChars('\n','\n');
        tokenizer.whitespaceChars('\r','\r');
        tokenizer.whitespaceChars('\f','\f');
        
        
//        tokenizer.wordChars('-','-');
//        tokenizer.wordChars('_','_');
//        tokenizer.wordChars('<','<');
//        tokenizer.wordChars('>','>');
        //todo print
        this.printStream(tokenizer);
        
        System.out.println(TagParser.parseNamedParameters(urlValue));
        
    
    }
    
    public void printStream(StreamTokenizer tokenizer) {
    
        try {
            while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                System.out.println("ttype: " + tokenizer.ttype + "  " + (char) tokenizer.ttype + " " + (tokenizer.sval != null ? tokenizer.sval
                        .length() : 0) + "    val: " + tokenizer.sval);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void printString(StringTokenizer tokenizer) {
        System.out.println(tokenizer.countTokens());
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
            
        }
    }
}

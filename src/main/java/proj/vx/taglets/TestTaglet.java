package proj.vx.taglets;

import com.sun.javadoc.Doc;
import com.sun.javadoc.SeeTag;
import com.sun.javadoc.Tag;
import com.sun.tools.doclets.internal.toolkit.Content;
import com.sun.tools.doclets.internal.toolkit.taglets.BaseTaglet;
import com.sun.tools.doclets.internal.toolkit.taglets.InheritableTaglet;
import com.sun.tools.doclets.internal.toolkit.taglets.Taglet;
import com.sun.tools.doclets.internal.toolkit.taglets.TagletWriter;
import com.sun.tools.doclets.internal.toolkit.util.DocFinder.Input;
import com.sun.tools.doclets.internal.toolkit.util.DocFinder.Output;

import java.util.Map;

/**
 * Created by admin on 2020/1/11 13:59:10.
 */
public class TestTaglet extends BaseTaglet implements InheritableTaglet {
    public static String tag = "test.tag";
    
    public TestTaglet() {
        this.name = tag;
    }
    
    @Override
    public void inherit(Input input, Output output) {
        
        SeeTag[] var3 = input.element.seeTags();
        if (var3.length > 0) {
            output.holder = input.element;
            output.holderTag = var3[0];
            output.inlineTags = input.isFirstSentence ? var3[0].firstSentenceTags() : var3[0].inlineTags();
        }
    }
    public static void register(Map tagletMap) {
        TestTaglet tag = new TestTaglet();
        Taglet     t   = (Taglet) tagletMap.get(tag.getName());
        if (t != null) {
            tagletMap.remove(tag.getName());
        }
        tagletMap.put(tag.getName(), tag);
    }
    
    
    @Override
    public Content getTagletOutput(Tag tag, TagletWriter tagletWriter) {
        return super.getTagletOutput(tag, tagletWriter);
    }
    
    @Override
    public Content getTagletOutput(Doc doc, TagletWriter tagletWriter) {
        return super.getTagletOutput(doc, tagletWriter);
    }
}

package proj.vx.taglets;

import com.sun.javadoc.Doc;
import com.sun.javadoc.SeeTag;
import com.sun.javadoc.Tag;
import com.sun.tools.doclets.internal.toolkit.Content;
import com.sun.tools.doclets.internal.toolkit.taglets.*;
import com.sun.tools.doclets.internal.toolkit.util.DocFinder;

import java.util.Map;

/**
 * Created by admin on 2020/1/11 13:59:10.
 */
public class ModelTaglet  extends BaseTaglet implements InheritableTaglet  {
    public static String tag = VxTag.model;
    
    public ModelTaglet() {
        this.name = tag;
    }
    
    public boolean inConstructor() {
        return false;
    }
    
    public boolean inField() {
        return false;
    }
    
    public boolean inMethod() {
        return false;
    }
    
    public boolean inOverview() {
        return false;
    }
    
    public boolean inPackage() {
        return false;
    }
    
    public boolean inType() {
        return true;
    }
    
    public boolean isInlineTag() {
        return false;
    }
    
    
    @Override
    public void inherit(DocFinder.Input input, DocFinder.Output output) {
        
        SeeTag[] var3 = input.element.seeTags();
        if (var3.length > 0) {
            output.holder = input.element;
            output.holderTag = var3[0];
            output.inlineTags = input.isFirstSentence ? var3[0].firstSentenceTags() : var3[0].inlineTags();
        }
    }
    
    public static void register(Map tagletMap) {
        ModelTaglet tag = new ModelTaglet();
        Taglet      t   = (Taglet) tagletMap.get(tag.getName());
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

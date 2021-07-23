import java.util.ArrayList;
import java.util.Iterator;

public class ElementArrayList implements Element {
    private ArrayList<Element> list = new ArrayList<Element>();
    public void add(Element element) {
        list.add(element);
    }
    public void accept(Visitor v) {
        Iterator<Element> it = list.iterator();
        while(it.hasNext()) {
            it.next().accept(v);
        }
    }
}

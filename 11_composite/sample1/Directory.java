import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
    private String name;
    private ArrayList<Entry> directory = new ArrayList<Entry>();
    public Directory(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getSize() {
        int size = 0;
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            size += it.next().getSize();
        }
        return size;
    }
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            it.next().printList(prefix + "/" + name);
        }
    }
}

import java.util.ArrayList;
import java.util.Iterator;

public class FileFindVisitor extends Visitor {
    private String filetype;
    private ArrayList<File> found = new ArrayList<File>();
    public FileFindVisitor(String filetype) {
        this.filetype = filetype;
    }
    public Iterator<File> getFoundFiles() {
        return found.iterator();
    }
    public void visit(File file) {
        if (file.getName().endsWith(filetype)) {
            found.add(file);
        }
    }
    public void visit(Directory directory) {
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            it.next().accept(this);
        }
    }
}

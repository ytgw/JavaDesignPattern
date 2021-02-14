import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MarkdownBuilder extends Builder {
    private String filename;
    private PrintWriter writer;
    public void makeTitle(String title) {
        filename = title + ".md";
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println("# " + title);
    }
    public void makeString(String str) {
        writer.println("## " + str);
    }
    public void makeItems(String[] items) {
        for (int i = 0; i < items.length; i++) {
            writer.println("- " + items[i]);
        }
    }
    public void close() {
        writer.close();
    }
    public String getResult() {
        return filename;
    }
}

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDisplayImpl extends DisplayImpl {
    private String filename;
    private FileReader reader;
    public FileDisplayImpl(String filename) {
        this.filename = filename;
    }
    public void rawOpen() {
        try {
            reader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("=-=-=-=-=-= " + filename + " =-=-=-=-=-="); // 飾り枠
    }
    public void rawPrint() {
        try {
            while (true) {
                int ch = reader.read();
                if (ch == -1) {
                    break;
                } else {
                    System.out.print((char)ch);
                }
            }
            reader.close();
            reader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void rawClose() {
        System.out.println("=-=-=-=-=-=");  // 飾り枠
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

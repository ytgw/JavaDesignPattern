import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileProperties implements FileIO {
    private Properties p;
    public FileProperties() {
        p = new Properties();
    }
    public void readFromFile(String filename) throws IOException {
        p.load(new FileInputStream(filename));
    }
    public void writeToFile(String filename) throws IOException {
        p.store(new FileOutputStream(filename), "written by FileProperties");
    }
    public void setValue(String key, String value) {
        p.setProperty(key, value);
    }
    public String getValue(String key) {
        return p.getProperty(key, "");
    }
}

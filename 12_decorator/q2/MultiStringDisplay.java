import java.util.ArrayList;

public class MultiStringDisplay extends Display {
    private ArrayList<String> strings = new ArrayList<String>();
    public MultiStringDisplay() {
    }
    public void add(String string) {
        strings.add(string);
    }
    public int getColumns() {
        int max = 0;
        for (int i = 0; i < strings.size(); i++) {
            max = Math.max(max, getStringLength(strings.get(i)));
        }
        return max;
    }
    public int getRows() {
        return strings.size();
    }
    public String getRowText(int row) {
        int columns = getColumns();
        String text = strings.get(row);
        for (int i = getStringLength(text); i < columns; i++) {
            text += " ";
        }
        return text;
    }
    private int getStringLength(String string) {
        char[] chars = string.toCharArray();
        int columns = 0;
        for (int i = 0; i < chars.length; i++) {
            if (String.valueOf(chars[i]).getBytes().length < 2) {
                // 半角の場合
                columns += 1;
            } else {
                // 全角の場合
                columns += 2;
            }
        }
        return columns;
    }
}

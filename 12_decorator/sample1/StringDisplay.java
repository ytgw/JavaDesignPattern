public class StringDisplay extends Display {
    private String string;
    public StringDisplay(String string) {
        this.string = string;
    }
    public int getColumns() {
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
    public int getRows() {
        return 1;
    }
    public String getRowText(int row) {
        if (row == 0) {
            return string;
        } else {
            return null;
        }
    }
}

public class FullBorder extends Border {
    public FullBorder(Display display) {
        super(display);
    }
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }
    public int getRows() {
        return 1 + display.getRows() + 1;
    }
    public String getRowText(int row) {
        if (row == 0) {
            // 枠の上端
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else if (row == display.getRows() + 1) {
            // 枠の下端
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {
            return "|" + display.getRowText(row - 1) + "|";
        }
    }
    private String makeLine(char ch, int count) {
        // 文字chをcount個連続させた文字列を作る
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}

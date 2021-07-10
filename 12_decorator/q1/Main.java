public class Main {
    public static void main(String[] args) {
        Display d1 = new StringDisplay("Hello, World.");
        Display d2 = new UpDownBorder(d1, '-');
        Display d3 = new SideBorder(d2, '*');
        d1.show();
        d2.show();
        d3.show();
        Display d4 = new FullBorder(
            new UpDownBorder(
                new SideBorder(
                    new UpDownBorder(
                        new SideBorder(
                            new StringDisplay("こんにちは。"),
                            '*'
                        ), 
                        '='
                    ),
                    '|'
                ), 
                '/'
            )
        );
        d4.show();
    }
}

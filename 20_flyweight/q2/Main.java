public class Main {
    public static void main(String[] args) {
        BigString bs;

        bs = new BigString(createString(), false);
        System.out.println("非共有時");
        showUsedMemory();

        bs = new BigString(createString(), true);
        System.out.println("共有時");
        showUsedMemory();
    }
    private static String createString() {
        String string = "";
        for (int i = 0; i < 1000; i++) {
            string += "1212123";
        }
        return string;
    }
    private static void showUsedMemory() {
        Runtime.getRuntime().gc();
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("使用メモリ = " + used);
    }
}

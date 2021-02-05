public class Main {
    public static void main(String[] args) {
        System.out.println("Start.");
        for (int i = 0; i < 9; i++) {
            Triple triple = Triple.getInstance(i % 3);
            System.out.println(i + ": id=" + triple.getID() + ", instance=" + triple);
        }
        System.out.println("End.");
    }
}

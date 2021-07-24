public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer = new FizzBuzzObserver();
        generator.addObserver(observer);
        generator.execute();
    }
}

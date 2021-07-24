public class FizzBuzzObserver implements Observer {
    public void update(NumberGenerator generator) {
        System.out.print("FizzBuzzObserver:");
        int number = generator.getNumber();
        if (number % 15 == 0) {
            System.out.println("FizzBuzz");
        } else if (number % 3 == 0) {
            System.out.println("Fizz");
        } else if (number % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(number);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}

public class DigitObserver implements Observer {
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserber:" + generator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}

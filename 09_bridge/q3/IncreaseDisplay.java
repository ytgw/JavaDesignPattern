public class IncreaseDisplay extends CountDisplay {
    private int step;
    public IncreaseDisplay(DisplayImpl impl, int step) {
        super(impl);
        this.step = step;
    }
    public void increaseDisplay(int level) {
        for (int i = 0; i < level; i++) {
            multiDisplay(step * i);
        }
    }
}

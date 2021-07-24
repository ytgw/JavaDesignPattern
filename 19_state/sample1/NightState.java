public class NightState implements State {
    private static NightState singleton = new NightState();
    private NightState() {
        // コンストラクタはprivate
    }
    public static State getInstance() {
        return singleton;
    }
    public void doClock(Context context, int hour) {
        if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }
    public void doUse(Context context) {
        context.callSecurityCenter("emegency: use safe at night");
    }
    public void doAlarm(Context context) {
        context.callSecurityCenter("alarm at night");
    }
    public void doPhone(Context context) {
        context.recordLog("call at night");
    }
    public String toString() {
        return "(night)";
    }
}

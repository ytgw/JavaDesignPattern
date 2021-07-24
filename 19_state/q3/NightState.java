public class NightState implements State {
    private static NightState singleton = new NightState();
    private NightState() {
        // コンストラクタはprivate
    }
    public static State getInstance() {
        return singleton;
    }
    public void doClock(Context context, int hour) {
        if (9 <= hour && hour < 17 && hour != 12) {
            context.changeState(DayState.getInstance());
        } else if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        } else if (hour == 12) {
            context.changeState(NoonState.getInstance());
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

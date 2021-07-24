public class NoonState implements State {
    private static NoonState singleton = new NoonState();
    private NoonState() {
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
        context.callSecurityCenter("emegency: use safe at noon");
    }
    public void doAlarm(Context context) {
        context.callSecurityCenter("alarm at noon");
    }
    public void doPhone(Context context) {
        context.recordLog("call at noon");
    }
    public String toString() {
        return "(noon)";
    }
}

public class DayState implements State {
    private static DayState singleton = new DayState();
    private DayState() {
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
        context.recordLog("use safe at daytime");
    }
    public void doAlarm(Context context) {
        context.callSecurityCenter("alarm at daytime");
    }
    public void doPhone(Context context) {
        context.callSecurityCenter("normal call at daytime");
    }
    public String toString() {
        return "(daytime)";
    }
}

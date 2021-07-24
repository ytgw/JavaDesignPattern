public class DayState implements State {
    private static DayState singleton = new DayState();
    private DayState() {
        // コンストラクタはprivate
    }
    public static State getInstance() {
        return singleton;
    }
    public void doClock(Context context, int hour) {
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }
    public void doUse(Context context) {
        context.recordLog("use safe at daytime");
    }
    public void doAlarm(Context context) {
        context.callSecurityCenter("alarm at daytime");
        context.changeState(UrgentState.getInstance());
    }
    public void doPhone(Context context) {
        context.callSecurityCenter("normal call at daytime");
    }
    public String toString() {
        return "(daytime)";
    }
}

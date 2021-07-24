public class UrgentState implements State {
    private static UrgentState singleton = new UrgentState();
    private UrgentState() {
        // コンストラクタはprivate
    }
    public static State getInstance() {
        return singleton;
    }
    public void doClock(Context context, int hour) {
    }
    public void doUse(Context context) {
        context.callSecurityCenter("emegency: use safe at urgent");
    }
    public void doAlarm(Context context) {
        context.callSecurityCenter("alarm at urgent");
    }
    public void doPhone(Context context) {
        context.callSecurityCenter("call at urgent");
    }
    public String toString() {
        return "(urgent)";
    }
}

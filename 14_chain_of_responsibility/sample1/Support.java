public abstract class Support {
    private String name;
    private Support next;   // たらい回しの先
    public Support(String name) {
        this.name = name;
    }
    public Support setNext(Support next) {
        this.next = next;
        return next;
    }
    public void support(Trouble trouble) {
        // トラブル解決の手順
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }
    public String toString() {
        return "[" + name + "]";
    }
    protected abstract boolean resolve(Trouble trouble);    // 解決用メソッド
    protected void done(Trouble trouble) {
        // 解決
        System.out.println(trouble + " is resolved by " + this + ".");
    }
    protected void fail(Trouble trouble) {
        // 未解決
        System.out.println(trouble + " cannot be resolved.");
    }
}

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
        Support support = this;
        while (support != null) {
            if (support.resolve(trouble)) {
                support.done(trouble);
                return;
            }
            support = support.next;
        }
        fail(trouble);
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

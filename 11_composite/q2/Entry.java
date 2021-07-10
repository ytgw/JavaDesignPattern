public abstract class Entry {
    protected Entry parent = null;
    public abstract String getName();
    public abstract int getSize();
    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }
    public void printList() {
        printList("");
    }
    protected abstract void printList(String prefix);
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
    public String getFullName() {
        String prefix = "";
        if (parent != null) {
            prefix = parent.getFullName() ;
        }
        return prefix + "/" + getName();
    }
}
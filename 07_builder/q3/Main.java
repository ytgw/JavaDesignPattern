public class Main {
    public static void main(String[] args) {
        MarkdownBuilder markdownbuilder = new MarkdownBuilder();
        Director director = new Director(markdownbuilder);
        director.construct();
        String filename = markdownbuilder.getResult();
        System.out.println(filename + "が作成されました。");
    }
}

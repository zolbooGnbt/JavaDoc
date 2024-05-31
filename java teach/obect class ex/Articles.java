import java.util.Scanner;

public class Articles {

    private String title;
    private String content;
    private String author;

    public Articles(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void edit(String content) {
        this.content = content;
    }

    public void changeAuthor(String author) {
        this.author = author;
    }

    public void rename(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s", title, content, author);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(", ");
        Articles article = new Articles(inputs[0], inputs[1], inputs[2]);
        int commandCount = Integer.parseInt(scanner.nextLine());
        for(; commandCount > 0; commandCount --) {
            String[] commands = scanner.nextLine().split(": ");
            switch (commands[0]) {
                case "Edit": article.edit(commands[1]); break;
                case "ChangeAuthor": article.changeAuthor(commands[1]); break;
                case "Rename": article.rename(commands[1]); break;
            }
        }
        System.out.print(article);
    }
}

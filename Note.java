public class Note {
    private String title;
    private String content;
    private String category;

    public Note() {
        this.title = "";
        this.content = "";
        this.category = "";
    }

    public Note(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public void printNote() {
        System.out.println("Заметка: " + title);
        System.out.println(content);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return content;
    }

    public String getCategory() {
        return category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.content = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

public class Guide {
    private int id;
    private String name;
    private String language;

    public Guide(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public String getLanguage() { return language; }

    @Override
    public String toString() {
        return "Guide: " + name + ", Language: " + language;
    }
}

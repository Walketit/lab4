public class UserInfo {
    private int id;
    private String name;
    private String email;
    private boolean isAdmin;

    public UserInfo(int id, String name, String email, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    // Геттеры для доступа к полям
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return String.format("User #%d: Name: %s, Email: %s, Status: %s",
                id, name, email, isAdmin ? "Admin" : "User");
    }
}
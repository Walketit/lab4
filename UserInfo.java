public class UserInfo {
    private int id;
    private String name;
    private boolean isAdmin;

    public UserInfo(int id, String name, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
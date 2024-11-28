import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users; // ������ �������������

    public UserManager() {
        this.users = new ArrayList<>();
    }

    // ����� ��� ���������� ������������
    public void addUser(User user) {
        users.add(user);
    }

    // ����� ��� �������� ������������ �� ID
    public void removeUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    // ����� ��� ��������� ������������ �� ID
    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // ����� ��� ����������� ���� �������������
    public void displayAllUsers() {
        for (User user : users) {
            user.printUser();
            System.out.println("--------------------");
        }
    }

    // ����� ��� ����������� ���� ������ ������������ �� ID
    public void displayUserAccounts(int id) {
        User user = getUserById(id);
        if (user != null) {
            user.displayAccounts();
        } else {
            System.out.println("������������ � ID " + id + " �� ������.");
        }
    }

    // ����� ��� ����������� ���� ������� ������������ �� ID
    public void displayUserNotes(int id) {
        User user = getUserById(id);
        if (user != null) {
            user.displayNotes();
        } else {
            System.out.println("������������ � ID " + id + " �� ������.");
        }
    }

    // ����� ��� ����������� ���� ����� ������������ �� ID
    public void displayUserGoals(int id) {
        User user = getUserById(id);
        if (user != null) {
            user.displayGoals();
        } else {
            System.out.println("������������ � ID " + id + " �� ������.");
        }
    }

    // ����� ��� ��������� ���������� � ������������ �� ID
    public UserInfo getUserInfoById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return new UserInfo(user.getId(), user.getName(), user.isAdmin());
            }
        }
        return null; // ���� ������������ �� ������
    }

}

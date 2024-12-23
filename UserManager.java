import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserManager {
    private List<User> users;

    public UserManager() {
        this.users = new ArrayList<User>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    // ����� ��� ���������� ������������� �� �����
    public void sortUsersByName() {
        Collections.sort(users, (user1, user2) -> user1.getName().compareTo(user2.getName()));
    }

    // ����� ��� ������ ������������ �� �����
    public void findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                System.out.println("������������ �� �����: " + name + " ������:\n");
                user.printUser();
                return;
            }
        }
        System.out.println("������������ �� �����: " + name + " �� �������.");
    }

    // ����� ��� ������ ���������� � ���� �������������
    public void displayUsers() {
        for (User user : users) {
            System.out.println(user.getFormattedInfo());
        }
    }
}

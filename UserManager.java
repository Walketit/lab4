import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users; // Список пользователей

    public UserManager() {
        this.users = new ArrayList<>();
    }

    // Метод для добавления пользователя
    public void addUser(User user) {
        users.add(user);
    }

    // Метод для удаления пользователя по ID
    public void removeUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    // Метод для получения пользователя по ID
    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // Метод для отображения всех пользователей
    public void displayAllUsers() {
        for (User user : users) {
            user.printUser();
            System.out.println("--------------------");
        }
    }

    // Метод для отображения всех счетов пользователя по ID
    public void displayUserAccounts(int id) {
        User user = getUserById(id);
        if (user != null) {
            user.displayAccounts();
        } else {
            System.out.println("Пользователь с ID " + id + " не найден.");
        }
    }

    // Метод для отображения всех заметок пользователя по ID
    public void displayUserNotes(int id) {
        User user = getUserById(id);
        if (user != null) {
            user.displayNotes();
        } else {
            System.out.println("Пользователь с ID " + id + " не найден.");
        }
    }

    // Метод для отображения всех целей пользователя по ID
    public void displayUserGoals(int id) {
        User user = getUserById(id);
        if (user != null) {
            user.displayGoals();
        } else {
            System.out.println("Пользователь с ID " + id + " не найден.");
        }
    }

    // Метод для получения информации о пользователе по ID
    public UserInfo getUserInfoById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return new UserInfo(user.getId(), user.getName(), user.isAdmin());
            }
        }
        return null; // Если пользователь не найден
    }

}

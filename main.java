import java.util.*;

public class main {
    public static void main(String[] args) throws MyExcpetions {
<<<<<<< HEAD
        Logs logs = new Logs();

        UserManager Manager = new UserManager();

        // �������� �������������
        User user1 = new User("John", "john@example.com", "password123", 0, logs);
        ParentUser admin1 = new ParentUser("Alex", "alex@example.com", "adminPass", logs, true, true, true);

        // ��������� ������������� � ������
        Manager.addUser(user1);
        Manager.addUser(admin1);

        // ����������� ������������� �� ����������
        System.out.println("������������ �� ����������:");
        Manager.displayUsers();
        System.out.println("\n");
        // ���������� ������������� �� �����
        System.out.println("������������ ����� ����������:");
        Manager.sortUsersByName();
        System.out.println("\n");

        // ����������� ������������� ����� ����������
        Manager.displayUsers();

        Manager.findUserByName("����");
        System.out.println("\n");
        Manager.findUserByName("John");
        System.out.println("\n");
        Manager.findUserByName("Alex");
=======
        // Создаем массив пользователей
        List<User> users = new ArrayList<>();

        Logs logs = new Logs(); // Предполагается, что класс Logs уже определен

        // Создание пользователей
        User user1 = new User("Иван", "ivan@example.com", "password1", 0, logs);
        User user2 = new User("Мария", "maria@example.com", "password2", 1, logs);
        User user3 = new User("Charlie", "charlie@example.com", "password3", 0, logs);

        // Профиль для проверки исключений
        // User user3 = new User(2, "", "maria@example.com", "password2", 1, logs);

        // Добавление пользователей в список
        users.add(user1);
        users.add(user2);
        users.add(user3);

        // Создание счетов для пользователей
        user1.addAccount(new Account("Основной счет", 1000.0, "USD"));
        user2.addAccount(new Account("Рабочий счет", 500.0, "EUR"));
        user3.addAccount(new Account("Сберегательный счет", 2000.0, "RUB"));

        // Выводим информацию о пользователях
        System.out.println("Информация о всех пользователях:");
        User.displayUsers(users);

        // Демонстрация поиска пользователя по имени
        User foundUser = User.findUserByName(users, "Иван");
        if (foundUser != null) {
            System.out.println("Найден пользователь: " + foundUser.getName());
        } else {
            System.out.println("Пользователь не найден.");
        }

        // Демонстрация удаления пользователя
        users.remove(user2);

        // Выводим информацию о пользователях после удаления
        System.out.println("Информация о всех пользователях после удаления:");
        User.displayUsers(users);

        // Демонстрация добавления нового пользователя
        User newUser = new User("David", "david@example.com", "password4", 0, logs);
        users.add(newUser);
        System.out.println("Новый пользователь David добавлен.");

        // Выводим информацию о пользователях после добавления
        System.out.println("Информация о всех пользователях после добавления:");
        User.displayUsers(users);

        // Демонстрация сортировки пользователей по имени
        User.sortUsersByName(users);
        System.out.println("Информация о всех пользователях после сортировки по имени:");
        User.displayUsers(users);

        System.out.println("Количество созданных пользователей: " + User.getUserCount());

        // Демонстрация работы со строками
        System.out.println("Форматирование строки");
        System.out.println(user1.getFormattedInfo());

        // Изменение пароля
        user1.changePassword("password1", "passwordBIG");

        // Возврат значения из метода через вспомогательный класс
        System.out.println("Возврат значения из метода через вспомогательный класс");
        System.out.println(user1.printUserHelpClass());
>>>>>>> parent of d4d8d44 (Старая лабораторная удалена)
    }
}
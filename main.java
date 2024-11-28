import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Logs logs = new Logs(); // Предполагается, что класс Logs уже определен

        // Создание пользователей
        User user1 = new User(1, "Иван", "ivan@example.com", "password1", 0, logs);
        User user2 = new User(2, "Мария", "maria@example.com", "password2", 1, logs);

        // Добавление пользователей в список
        userManager.addUser(user1);
        userManager.addUser(user2);

        // Создание счетов для пользователей
        Account account1 = new Account("Основной счёт", 1000.0, "USD");
        Account account2 = new Account("Сберегательный счёт", 5000.0, "EUR");

        user1.addAccount(account1);
        user2.addAccount(account2);

        // Создание заметок для пользователей
        Note note1 = new Note("Покупки", "Купить продукты на неделю", "Личные");
        Note note2 = new Note("Работа", "Завершить проект до конца месяца", "Работа");

        user1.addNote(note1);
        user2.addNote(note2);

        // Создание целей для пользователей
        Goal goal1 = new Goal("Купить новый телефон", 500.0, 1000.0, "Нужно обновить гаджет");
        Goal goal2 = new Goal("Сэкономить на отпуск", 2000.0, 5000.0, "Хочу отдохнуть");

        user1.addGoal(goal1);
        user2.addGoal(goal2);

        // Отображение всех пользователей
        userManager.displayAllUsers();

        // Отображение всех счетов пользователя с ID 1
        userManager.displayUserAccounts(1);

        // Отображение всех заметок пользователя с ID 2
        userManager.displayUserNotes(2);

        // Отображение всех целей пользователя с ID 1
        userManager.displayUserGoals(1);

        // Возврат значения из метода через вспомогательный класс
        UserInfo userInfo = userManager.getUserInfoById(1);
        if (userInfo != null) {
            System.out.println(userInfo);
        } else {
            System.out.println("Пользователь не найден.");
        }
    }
}
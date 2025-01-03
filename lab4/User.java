import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id; // Уникальный идентификатор пользователя
    private String name; // Имя пользователя
    private String email; // Адрес электронной почты
    private String password; // Пароль
    private int isAdmin; // Флаг администратора (0 - обычный пользователь, 1 - администратор)
    private Logs logs; // Объект для работы с логами
    private List<Account> accounts; // Список счетов пользователя
    private List<Note> notes; // Список заметок пользователя
    private List<Goal> goals; // Список целей пользователя

    // Конструктор для создания пользователя
    public User(int id, String name, String email, String password, int isAdmin, Logs logs) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.logs = logs;
        this.accounts = new ArrayList<>();
        this.notes = new ArrayList<>();
        this.goals = new ArrayList<>();

        // Создание файла профиля пользователя
        String filename = "profile" + id + ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Имя: " + name + " (" + id + ")\n");
            writer.write("Почта: " + email + "\n");
            writer.write("Пароль: " + password + "\n");
            if (isAdmin == 1) {
                writer.write("Статус: Админ\n");
            } else {
                writer.write("Статус: Юзер\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Логирование создания профиля
        logs.logfileCreate(id);
        logs.logfileUpdate(id, "Профиль создан");
    }

    // Метод для добавления счета пользователю
    public void addAccount(Account account) {
        account.setId(id + 100000); // Установка уникального ID для счета
        String filename = "account" + id + ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Счёт: " + account.getName() + " (" + account.getId() + ")\n");
            writer.write("Владелец: " + name + " (" + id + ")\n");
            writer.write("Баланс: " + account.getBalance() + " " + account.getCurrency() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Логирование создания счета
        String logname = "Счёт создан: " + account.getName();
        logs.logfileUpdate(id, logname);

        accounts.add(account); // Добавление счета в список счетов пользователя
    }

    // Метод для отображения всех счетов пользователя
    public void displayAccounts() {
        System.out.println("Счета " + name + ":");
        for (Account account : accounts) {
            System.out.println("Счёт: " + account.getName());
            System.out.printf("Баланс: %.2f %s\n", account.getBalance(), account.getCurrency());
        }
    }

    // Метод для добавления заметки пользователю
    public void addNote(Note note) {
        try (FileWriter writer = new FileWriter(note.getTitle() + ".txt")) {
            writer.write(note.getDescription());
        } catch (IOException e) {
            e.printStackTrace();
        }
        logs.logfileUpdate(id, "Создана заметка"); // Логирование создания заметки

        notes.add(note); // Добавление заметки в список заметок пользователя
    }

    // Метод для отображения всех заметок пользователя
    public void displayNotes() {
        System.out.println("Записки " + name + ":");
        for (Note note : notes) {
            System.out.println("Записка: " + note.getTitle() + ", Категория: " + note.getCategory());
            System.out.println(note.getDescription());
        }
    }

    // Метод для добавления цели пользователю
    public void addGoal(Goal goal) {
        String n = "Создана цель: " + goal.getTitle();
        logs.logfileUpdate(id, n); // Логирование создания цели
        goals.add(goal); // Добавление цели в список целей пользователя
    }

    // Метод для отображения всех целей пользователя
    public void displayGoals() {
        System.out.println("Цели " + name + ":");
        for (Goal goal : goals) {
            System.out.printf("Цель: %s, Текущая сумма: %.2f, Целевая сумма: %.2f\n", goal.getTitle(), goal.getCurrentBalance(), goal.getTargetAmount());
        }
    }

    // Метод для вывода информации о пользователе
    public void printUser() {
        System.out.println("Пользователь #" + id + ":");
        System.out.println("Имя: " + name);
        System.out.println("Email: " + email);
        System.out.println("Статус: " + (isAdmin == 1 ? "Администратор" : "Юзер"));
    }

    // Метод для получения счета по индексу
    public Account getAccount(int index) {
        if (index >= 0 && index < accounts.size()) {
            return accounts.get(index);
        }
        return null;
    }
}
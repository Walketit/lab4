import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private int isAdmin;
    private Logs logs;
    private List<Account> accounts;
    private List<Note> notes;
    private List<Goal> goals;

    public User() {
        this.id = 0;
        this.name = "";
        this.email = "";
        this.password = "";
        this.isAdmin = 0;
        this.logs = new Logs();
        this.accounts = new ArrayList<>();
        this.notes = new ArrayList<>();
        this.goals = new ArrayList<>();
    }

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

        logs.logfileCreate(id);
        logs.logfileUpdate(id, "Профиль создан");
    }

    public void addAccount(Account account) {
        account.setId(id + 100000);
        String filename = "account" + id + ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Счёт: " + account.getName() + " (" + account.getId() + ")\n");
            writer.write("Владелец: " + name + " (" + id + ")\n");
            writer.write("Баланс: " + account.getBalance() + " " + account.getCurrency() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String logname = "Счёт создан: " + account.getName();
        logs.logfileUpdate(id, logname);

        accounts.add(account);
    }

    public void displayAccounts() {
        System.out.println("Счета " + name + ":");
        for (Account account : accounts) {
            System.out.println("Счёт: " + account.getName());
            System.out.printf("Баланс: %.2f %s\n", account.getBalance(), account.getCurrency());
        }
    }

    public void addNote(Note note) {
        try (FileWriter writer = new FileWriter(note.getTitle() + ".txt")) {
            writer.write(note.getDescription());
        } catch (IOException e) {
            e.printStackTrace();
        }
        logs.logfileUpdate(id, "Создана заметка");

        notes.add(note);
    }

    public void displayNotes() {
        System.out.println("Записки " + name + ":");
        for (Note note : notes) {
            System.out.println("Записка: " + note.getTitle() + ", Категория: " + note.getCategory());
            System.out.println(note.getDescription());
        }
    }

    public void addGoal(Goal goal) {
        String n = "Создана цель: " + goal.getTitle();
        logs.logfileUpdate(id, n);
        goals.add(goal);
    }

    public void displayGoals() {
        System.out.println("Цели " + name + ":");
        for (Goal goal : goals) {
            System.out.printf("Цель: %s, Текущая сумма: %.2f, Целевая сумма: %.2f\n", goal.getTitle(), goal.getCurrentBalance(), goal.getTargetAmount());
        }
    }

    public void printUser() {
        System.out.println("Пользователь #" + id + ":");
        System.out.println("Имя: " + name);
        System.out.println("Email: " + email);
        System.out.println("Статус: " + (isAdmin == 1 ? "Администратор" : "Юзер"));
    }

    public Account getAccount(int index) {
        if (index >= 0 && index < accounts.size()) {
            return accounts.get(index);
        }
        return null;
    }
}

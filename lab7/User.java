import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

<<<<<<< HEAD
public class User implements Exportable {
    protected int id; // ���������� ������������� ������������
    protected String name; // ��� ������������
    protected String email; // ����� ����������� �����
    protected String password; // ������
    protected int isAdmin; // ���� �������������� (0 - ������� ������������, 1 - �������������)
    protected Logs logs; // ������ ��� ������ � ������
    protected List<Account> accounts; // ������ ������ ������������
    protected List<Note> notes; // ������ ������� ������������
    protected List<Goal> goals; // ������ ����� ������������

    // ����������� ���� ��� �������� ���������� �������������
    protected static int userCount = 0;

    // ����������� ��� �������� ������������
=======
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

    // Статическое поле для хранения количества пользователей
    private static int userCount = 0;

    // Конструктор для создания пользователя
>>>>>>> parent of d4d8d44 (Старая лабораторная удалена)
    public User(String name, String email, String password, int isAdmin, Logs logs) throws MyExcpetions {
        this.id = userCount;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.logs = logs;
        this.accounts = new ArrayList<>();
        this.notes = new ArrayList<>();
        this.goals = new ArrayList<>();

        userCount++;

<<<<<<< HEAD
        // �������� ����� ������� ������������
        if (name.isEmpty())
            throw new MyExcpetions("��� �� ����� ���� ������!");
        String filename = "profile" + id + ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("���: " + name + " (" + id + ")\n");
            writer.write("�����: " + email + "\n");
            writer.write("������: " + password + "\n");
            if (isAdmin == 1) {
                writer.write("������: �����\n");
            } else {
                writer.write("������: ����\n");
=======
        // Создание файла профиля пользователя
        if (name.isEmpty())
            throw new MyExcpetions("Имя не может быть пустым!");
        String filename = "profile" + id + ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Имя: " + name + " (" + id + ")\n");
            writer.write("Почта: " + email + "\n");
            writer.write("Пароль: " + password + "\n");
            if (isAdmin == 1) {
                writer.write("Статус: Админ\n");
            } else {
                writer.write("Статус: Юзер\n");
>>>>>>> parent of d4d8d44 (Старая лабораторная удалена)
            }
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }

<<<<<<< HEAD
        // ����������� �������� �������
        logs.logfileCreate(id);
        logs.logfileUpdate(id, "������� ������");
    }

    // ����� ��� ���������� ����� ������������
    public void addAccount(Account account) {
        account.setId(id + 100000); // ��������� ����������� ID ��� �����
        String filename = "account" + id + ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("����: " + account.getName() + " (" + account.getId() + ")\n");
            writer.write("��������: " + name + " (" + id + ")\n");
            writer.write("������: " + account.getBalance() + " " + account.getCurrency() + "\n");
=======
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
>>>>>>> parent of d4d8d44 (Старая лабораторная удалена)
        } catch (IOException e) {
            e.printStackTrace();
        }

<<<<<<< HEAD
        // ����������� �������� �����
        String logname = "���� ������: " + account.getName();
        logs.logfileUpdate(id, logname);

        accounts.add(account); // ���������� ����� � ������ ������ ������������
    }

    // ����� ��� ����������� ���� ������ ������������
    public void displayAccounts() {
        System.out.println("����� " + name + ":");
        for (Account account : accounts) {
            System.out.println("����: " + account.getName());
            System.out.printf("������: %.2f %s\n", account.getBalance(), account.getCurrency());
        }
    }

    // ����� ��� ���������� ������� ������������
=======
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
>>>>>>> parent of d4d8d44 (Старая лабораторная удалена)
    public void addNote(Note note) {
        try (FileWriter writer = new FileWriter(note.getTitle() + ".txt")) {
            writer.write(note.getDescription());
        } catch (IOException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
        logs.logfileUpdate(id, "������� �������"); // ����������� �������� �������

        notes.add(note); // ���������� ������� � ������ ������� ������������
    }

    // ����� ��� ����������� ���� ������� ������������
    public void displayNotes() {
        System.out.println("������� " + name + ":");
        for (Note note : notes) {
            System.out.println("�������: " + note.getTitle() + ", ���������: " + note.getCategory());
=======
        logs.logfileUpdate(id, "Создана заметка"); // Логирование создания заметки

        notes.add(note); // Добавление заметки в список заметок пользователя
    }

    // Метод для отображения всех заметок пользователя
    public void displayNotes() {
        System.out.println("Записки " + name + ":");
        for (Note note : notes) {
            System.out.println("Записка: " + note.getTitle() + ", Категория: " + note.getCategory());
>>>>>>> parent of d4d8d44 (Старая лабораторная удалена)
            System.out.println(note.getDescription());
        }
    }

<<<<<<< HEAD
    // ����� ��� ���������� ���� ������������
    public void addGoal(Goal goal) {
        String n = "������� ����: " + goal.getTitle();
        logs.logfileUpdate(id, n); // ����������� �������� ����
        goals.add(goal); // ���������� ���� � ������ ����� ������������
    }

    // ����� ��� ����������� ���� ����� ������������
    public void displayGoals() {
        System.out.println("���� " + name + ":");
        for (Goal goal : goals) {
            System.out.printf("����: %s, ������� �����: %.2f, ������� �����: %.2f\n", goal.getTitle(), goal.getCurrentBalance(), goal.getTargetAmount());
        }
    }

    // ����� ��� ������ ���������� � ������������
    public void printUser() {
        System.out.println("������������ #" + id + ":");
        System.out.println("���: " + name);
        System.out.println("Email: " + email);
        System.out.println("������: " + (isAdmin == 1 ? "�������������" : "����"));
=======
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
>>>>>>> parent of d4d8d44 (Старая лабораторная удалена)
    }

    public UserInfo printUserHelpClass() {
        return new UserInfo(id, name, email, isAdmin == 1);
    }

<<<<<<< HEAD
    // ����� ��� ��������� ����� �� �������
=======
    // Метод для получения счета по индексу
>>>>>>> parent of d4d8d44 (Старая лабораторная удалена)
    public Account getAccount(int index) {
        if (index >= 0 && index < accounts.size()) {
            return accounts.get(index);
        }
        return null;
    }

<<<<<<< HEAD
    // �������
=======
    // Геттеры
>>>>>>> parent of d4d8d44 (Старая лабораторная удалена)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

<<<<<<< HEAD
    // ������ ��� ������ ������
    public List<Account> getAccounts() {
        return accounts;
    }

    // ������ ��� ������ �������
    public List<Note> getNotes() {
        return notes;
    }

    // ������ ��� ������� Logs
    public Logs getLogs() {
        return logs;
    }

=======
>>>>>>> parent of d4d8d44 (Старая лабораторная удалена)
    public boolean isAdmin() {
        if (isAdmin == 1) return true;
        return false;
    }

<<<<<<< HEAD
    // ������ ��������� �����
    // ����� ��� �������������� ���������� � ������������
    public String getFormattedInfo() {
        return String.format("������������ #%d: ���: %s, Email: %s, ������: %s",
                id, name, email, isAdmin == 1 ? "�������������" : "����");
    }

    // ����� ��� ������ ������� �� ��������
=======
    // Методы обработки строк
    // Метод для форматирования информации о пользователе
    public String getFormattedInfo() {
        return String.format("Пользователь #%d: Имя: %s, Email: %s, Статус: %s",
                id, name, email, isAdmin == 1 ? "Администратор" : "Юзер");
    }

    // Метод для поиска заметки по названию
>>>>>>> parent of d4d8d44 (Старая лабораторная удалена)
    public Note findNoteByTitle(String title) {
        for (Note note : notes) {
            if (note.getTitle().equalsIgnoreCase(title)) {
                return note;
            }
        }
        return null;
    }

<<<<<<< HEAD
    // ����� ��� ������ ������
    public void changePassword(String oldPassword, String newPassword) {
        if (password.equals(oldPassword)) {
            password = newPassword;
            logs.logfileUpdate(id, "������ �������");
            System.out.println("������ ��� ������������ " + id + " ������� ������!");
        } else {
            System.out.println("������ ������ �������.");
        }
    }

    // ����������� ����� ��� ��������� ���������� �������������
=======
    // Метод для замены пароля
    public void changePassword(String oldPassword, String newPassword) {
        if (password.equals(oldPassword)) {
            password = newPassword;
            logs.logfileUpdate(id, "Пароль изменен");
            System.out.println("Пароль для пользователя " + id + " успешно изменён!");
        } else {
            System.out.println("Старый пароль неверен.");
        }
    }

    // Статический метод для получения количества пользователей
>>>>>>> parent of d4d8d44 (Старая лабораторная удалена)
    public static int getUserCount() {
        return userCount;
    }

<<<<<<< HEAD
    // ������ ������ � ��������
    // ����� ��� ������ ���������� � ���� �������������
=======
    // Методы работы с массивом
    // Метод для вывода информации о всех пользователях
>>>>>>> parent of d4d8d44 (Старая лабораторная удалена)
    public static void displayUsers(List<User> users) {
        for (User user : users) {
            user.printUser();
            user.displayAccounts();
            System.out.println();
        }
    }

<<<<<<< HEAD
    // ����� ��� ������ ������������ �� �����
=======
    // Метод для поиска пользователя по имени
>>>>>>> parent of d4d8d44 (Старая лабораторная удалена)
    public static User findUserByName(List<User> users, String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

<<<<<<< HEAD
    // ����� ��� ���������� ������������� �� �����
=======
    // Метод для сортировки пользователей по имени
>>>>>>> parent of d4d8d44 (Старая лабораторная удалена)
    public static void sortUsersByName(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getName().compareTo(user2.getName());
            }
        });
    }
<<<<<<< HEAD

    @Override
    public void exportToCSV(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("ID,Name,Email,IsAdmin\n");
            writer.write(id + "," + name + "," + email + "," + isAdmin + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exportToJSON(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("{\n");
            writer.write("  \"id\": " + id + ",\n");
            writer.write("  \"name\": \"" + name + "\",\n");
            writer.write("  \"email\": \"" + email + "\",\n");
            writer.write("  \"isAdmin\": " + isAdmin + "\n");
            writer.write("}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
=======
>>>>>>> parent of d4d8d44 (Старая лабораторная удалена)
}
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

<<<<<<< HEAD
public class User implements Exportable {
    protected int id; // Уникальный идентификатор пользователя
    protected String name; // Имя пользователя
    protected String email; // Адрес электронной почты
    protected String password; // Пароль
    protected int isAdmin; // Флаг администратора (0 - обычный пользователь, 1 - администратор)
    protected Logs logs; // Объект для работы с логами
    protected List<Account> accounts; // Список счетов пользователя
    protected List<Note> notes; // Список заметок пользователя
    protected List<Goal> goals; // Список целей пользователя

    // Статическое поле для хранения количества пользователей
    protected static int userCount = 0;

    // Конструктор для создания пользователя
=======
public class User {
    private int id; // РЈРЅРёРєР°Р»СЊРЅС‹Р№ РёРґРµРЅС‚РёС„РёРєР°С‚РѕСЂ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ
    private String name; // РРјСЏ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ
    private String email; // РђРґСЂРµСЃ СЌР»РµРєС‚СЂРѕРЅРЅРѕР№ РїРѕС‡С‚С‹
    private String password; // РџР°СЂРѕР»СЊ
    private int isAdmin; // Р¤Р»Р°Рі Р°РґРјРёРЅРёСЃС‚СЂР°С‚РѕСЂР° (0 - РѕР±С‹С‡РЅС‹Р№ РїРѕР»СЊР·РѕРІР°С‚РµР»СЊ, 1 - Р°РґРјРёРЅРёСЃС‚СЂР°С‚РѕСЂ)
    private Logs logs; // РћР±СЉРµРєС‚ РґР»СЏ СЂР°Р±РѕС‚С‹ СЃ Р»РѕРіР°РјРё
    private List<Account> accounts; // РЎРїРёСЃРѕРє СЃС‡РµС‚РѕРІ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ
    private List<Note> notes; // РЎРїРёСЃРѕРє Р·Р°РјРµС‚РѕРє РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ
    private List<Goal> goals; // РЎРїРёСЃРѕРє С†РµР»РµР№ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ

    // РЎС‚Р°С‚РёС‡РµСЃРєРѕРµ РїРѕР»Рµ РґР»СЏ С…СЂР°РЅРµРЅРёСЏ РєРѕР»РёС‡РµСЃС‚РІР° РїРѕР»СЊР·РѕРІР°С‚РµР»РµР№
    private static int userCount = 0;

    // РљРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ РґР»СЏ СЃРѕР·РґР°РЅРёСЏ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ
>>>>>>> parent of d4d8d44 (РЎС‚Р°СЂР°СЏ Р»Р°Р±РѕСЂР°С‚РѕСЂРЅР°СЏ СѓРґР°Р»РµРЅР°)
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
=======
        // РЎРѕР·РґР°РЅРёРµ С„Р°Р№Р»Р° РїСЂРѕС„РёР»СЏ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ
        if (name.isEmpty())
            throw new MyExcpetions("РРјСЏ РЅРµ РјРѕР¶РµС‚ Р±С‹С‚СЊ РїСѓСЃС‚С‹Рј!");
        String filename = "profile" + id + ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("РРјСЏ: " + name + " (" + id + ")\n");
            writer.write("РџРѕС‡С‚Р°: " + email + "\n");
            writer.write("РџР°СЂРѕР»СЊ: " + password + "\n");
            if (isAdmin == 1) {
                writer.write("РЎС‚Р°С‚СѓСЃ: РђРґРјРёРЅ\n");
            } else {
                writer.write("РЎС‚Р°С‚СѓСЃ: Р®Р·РµСЂ\n");
>>>>>>> parent of d4d8d44 (РЎС‚Р°СЂР°СЏ Р»Р°Р±РѕСЂР°С‚РѕСЂРЅР°СЏ СѓРґР°Р»РµРЅР°)
            }
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }

<<<<<<< HEAD
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
=======
        // Р›РѕРіРёСЂРѕРІР°РЅРёРµ СЃРѕР·РґР°РЅРёСЏ РїСЂРѕС„РёР»СЏ
        logs.logfileCreate(id);
        logs.logfileUpdate(id, "РџСЂРѕС„РёР»СЊ СЃРѕР·РґР°РЅ");
    }

    // РњРµС‚РѕРґ РґР»СЏ РґРѕР±Р°РІР»РµРЅРёСЏ СЃС‡РµС‚Р° РїРѕР»СЊР·РѕРІР°С‚РµР»СЋ
    public void addAccount(Account account) {
        account.setId(id + 100000); // РЈСЃС‚Р°РЅРѕРІРєР° СѓРЅРёРєР°Р»СЊРЅРѕРіРѕ ID РґР»СЏ СЃС‡РµС‚Р°
        String filename = "account" + id + ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("РЎС‡С‘С‚: " + account.getName() + " (" + account.getId() + ")\n");
            writer.write("Р’Р»Р°РґРµР»РµС†: " + name + " (" + id + ")\n");
            writer.write("Р‘Р°Р»Р°РЅСЃ: " + account.getBalance() + " " + account.getCurrency() + "\n");
>>>>>>> parent of d4d8d44 (РЎС‚Р°СЂР°СЏ Р»Р°Р±РѕСЂР°С‚РѕСЂРЅР°СЏ СѓРґР°Р»РµРЅР°)
        } catch (IOException e) {
            e.printStackTrace();
        }

<<<<<<< HEAD
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
=======
        // Р›РѕРіРёСЂРѕРІР°РЅРёРµ СЃРѕР·РґР°РЅРёСЏ СЃС‡РµС‚Р°
        String logname = "РЎС‡С‘С‚ СЃРѕР·РґР°РЅ: " + account.getName();
        logs.logfileUpdate(id, logname);

        accounts.add(account); // Р”РѕР±Р°РІР»РµРЅРёРµ СЃС‡РµС‚Р° РІ СЃРїРёСЃРѕРє СЃС‡РµС‚РѕРІ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ
    }

    // РњРµС‚РѕРґ РґР»СЏ РѕС‚РѕР±СЂР°Р¶РµРЅРёСЏ РІСЃРµС… СЃС‡РµС‚РѕРІ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ
    public void displayAccounts() {
        System.out.println("РЎС‡РµС‚Р° " + name + ":");
        for (Account account : accounts) {
            System.out.println("РЎС‡С‘С‚: " + account.getName());
            System.out.printf("Р‘Р°Р»Р°РЅСЃ: %.2f %s\n", account.getBalance(), account.getCurrency());
        }
    }

    // РњРµС‚РѕРґ РґР»СЏ РґРѕР±Р°РІР»РµРЅРёСЏ Р·Р°РјРµС‚РєРё РїРѕР»СЊР·РѕРІР°С‚РµР»СЋ
>>>>>>> parent of d4d8d44 (РЎС‚Р°СЂР°СЏ Р»Р°Р±РѕСЂР°С‚РѕСЂРЅР°СЏ СѓРґР°Р»РµРЅР°)
    public void addNote(Note note) {
        try (FileWriter writer = new FileWriter(note.getTitle() + ".txt")) {
            writer.write(note.getDescription());
        } catch (IOException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
        logs.logfileUpdate(id, "Создана заметка"); // Логирование создания заметки

        notes.add(note); // Добавление заметки в список заметок пользователя
    }

    // Метод для отображения всех заметок пользователя
    public void displayNotes() {
        System.out.println("Записки " + name + ":");
        for (Note note : notes) {
            System.out.println("Записка: " + note.getTitle() + ", Категория: " + note.getCategory());
=======
        logs.logfileUpdate(id, "РЎРѕР·РґР°РЅР° Р·Р°РјРµС‚РєР°"); // Р›РѕРіРёСЂРѕРІР°РЅРёРµ СЃРѕР·РґР°РЅРёСЏ Р·Р°РјРµС‚РєРё

        notes.add(note); // Р”РѕР±Р°РІР»РµРЅРёРµ Р·Р°РјРµС‚РєРё РІ СЃРїРёСЃРѕРє Р·Р°РјРµС‚РѕРє РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ
    }

    // РњРµС‚РѕРґ РґР»СЏ РѕС‚РѕР±СЂР°Р¶РµРЅРёСЏ РІСЃРµС… Р·Р°РјРµС‚РѕРє РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ
    public void displayNotes() {
        System.out.println("Р—Р°РїРёСЃРєРё " + name + ":");
        for (Note note : notes) {
            System.out.println("Р—Р°РїРёСЃРєР°: " + note.getTitle() + ", РљР°С‚РµРіРѕСЂРёСЏ: " + note.getCategory());
>>>>>>> parent of d4d8d44 (РЎС‚Р°СЂР°СЏ Р»Р°Р±РѕСЂР°С‚РѕСЂРЅР°СЏ СѓРґР°Р»РµРЅР°)
            System.out.println(note.getDescription());
        }
    }

<<<<<<< HEAD
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
=======
    // РњРµС‚РѕРґ РґР»СЏ РґРѕР±Р°РІР»РµРЅРёСЏ С†РµР»Рё РїРѕР»СЊР·РѕРІР°С‚РµР»СЋ
    public void addGoal(Goal goal) {
        String n = "РЎРѕР·РґР°РЅР° С†РµР»СЊ: " + goal.getTitle();
        logs.logfileUpdate(id, n); // Р›РѕРіРёСЂРѕРІР°РЅРёРµ СЃРѕР·РґР°РЅРёСЏ С†РµР»Рё
        goals.add(goal); // Р”РѕР±Р°РІР»РµРЅРёРµ С†РµР»Рё РІ СЃРїРёСЃРѕРє С†РµР»РµР№ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ
    }

    // РњРµС‚РѕРґ РґР»СЏ РѕС‚РѕР±СЂР°Р¶РµРЅРёСЏ РІСЃРµС… С†РµР»РµР№ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ
    public void displayGoals() {
        System.out.println("Р¦РµР»Рё " + name + ":");
        for (Goal goal : goals) {
            System.out.printf("Р¦РµР»СЊ: %s, РўРµРєСѓС‰Р°СЏ СЃСѓРјРјР°: %.2f, Р¦РµР»РµРІР°СЏ СЃСѓРјРјР°: %.2f\n", goal.getTitle(), goal.getCurrentBalance(), goal.getTargetAmount());
        }
    }

    // РњРµС‚РѕРґ РґР»СЏ РІС‹РІРѕРґР° РёРЅС„РѕСЂРјР°С†РёРё Рѕ РїРѕР»СЊР·РѕРІР°С‚РµР»Рµ
    public void printUser() {
        System.out.println("РџРѕР»СЊР·РѕРІР°С‚РµР»СЊ #" + id + ":");
        System.out.println("РРјСЏ: " + name);
        System.out.println("Email: " + email);
        System.out.println("РЎС‚Р°С‚СѓСЃ: " + (isAdmin == 1 ? "РђРґРјРёРЅРёСЃС‚СЂР°С‚РѕСЂ" : "Р®Р·РµСЂ"));
>>>>>>> parent of d4d8d44 (РЎС‚Р°СЂР°СЏ Р»Р°Р±РѕСЂР°С‚РѕСЂРЅР°СЏ СѓРґР°Р»РµРЅР°)
    }

    public UserInfo printUserHelpClass() {
        return new UserInfo(id, name, email, isAdmin == 1);
    }

<<<<<<< HEAD
    // Метод для получения счета по индексу
=======
    // РњРµС‚РѕРґ РґР»СЏ РїРѕР»СѓС‡РµРЅРёСЏ СЃС‡РµС‚Р° РїРѕ РёРЅРґРµРєСЃСѓ
>>>>>>> parent of d4d8d44 (РЎС‚Р°СЂР°СЏ Р»Р°Р±РѕСЂР°С‚РѕСЂРЅР°СЏ СѓРґР°Р»РµРЅР°)
    public Account getAccount(int index) {
        if (index >= 0 && index < accounts.size()) {
            return accounts.get(index);
        }
        return null;
    }

<<<<<<< HEAD
    // Геттеры
=======
    // Р“РµС‚С‚РµСЂС‹
>>>>>>> parent of d4d8d44 (РЎС‚Р°СЂР°СЏ Р»Р°Р±РѕСЂР°С‚РѕСЂРЅР°СЏ СѓРґР°Р»РµРЅР°)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

<<<<<<< HEAD
    // Геттер для списка счетов
    public List<Account> getAccounts() {
        return accounts;
    }

    // Геттер для списка записок
    public List<Note> getNotes() {
        return notes;
    }

    // Геттер для объекта Logs
    public Logs getLogs() {
        return logs;
    }

=======
>>>>>>> parent of d4d8d44 (РЎС‚Р°СЂР°СЏ Р»Р°Р±РѕСЂР°С‚РѕСЂРЅР°СЏ СѓРґР°Р»РµРЅР°)
    public boolean isAdmin() {
        if (isAdmin == 1) return true;
        return false;
    }

<<<<<<< HEAD
    // Методы обработки строк
    // Метод для форматирования информации о пользователе
    public String getFormattedInfo() {
        return String.format("Пользователь #%d: Имя: %s, Email: %s, Статус: %s",
                id, name, email, isAdmin == 1 ? "Администратор" : "Юзер");
    }

    // Метод для поиска заметки по названию
=======
    // РњРµС‚РѕРґС‹ РѕР±СЂР°Р±РѕС‚РєРё СЃС‚СЂРѕРє
    // РњРµС‚РѕРґ РґР»СЏ С„РѕСЂРјР°С‚РёСЂРѕРІР°РЅРёСЏ РёРЅС„РѕСЂРјР°С†РёРё Рѕ РїРѕР»СЊР·РѕРІР°С‚РµР»Рµ
    public String getFormattedInfo() {
        return String.format("РџРѕР»СЊР·РѕРІР°С‚РµР»СЊ #%d: РРјСЏ: %s, Email: %s, РЎС‚Р°С‚СѓСЃ: %s",
                id, name, email, isAdmin == 1 ? "РђРґРјРёРЅРёСЃС‚СЂР°С‚РѕСЂ" : "Р®Р·РµСЂ");
    }

    // РњРµС‚РѕРґ РґР»СЏ РїРѕРёСЃРєР° Р·Р°РјРµС‚РєРё РїРѕ РЅР°Р·РІР°РЅРёСЋ
>>>>>>> parent of d4d8d44 (РЎС‚Р°СЂР°СЏ Р»Р°Р±РѕСЂР°С‚РѕСЂРЅР°СЏ СѓРґР°Р»РµРЅР°)
    public Note findNoteByTitle(String title) {
        for (Note note : notes) {
            if (note.getTitle().equalsIgnoreCase(title)) {
                return note;
            }
        }
        return null;
    }

<<<<<<< HEAD
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
=======
    // РњРµС‚РѕРґ РґР»СЏ Р·Р°РјРµРЅС‹ РїР°СЂРѕР»СЏ
    public void changePassword(String oldPassword, String newPassword) {
        if (password.equals(oldPassword)) {
            password = newPassword;
            logs.logfileUpdate(id, "РџР°СЂРѕР»СЊ РёР·РјРµРЅРµРЅ");
            System.out.println("РџР°СЂРѕР»СЊ РґР»СЏ РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ " + id + " СѓСЃРїРµС€РЅРѕ РёР·РјРµРЅС‘РЅ!");
        } else {
            System.out.println("РЎС‚Р°СЂС‹Р№ РїР°СЂРѕР»СЊ РЅРµРІРµСЂРµРЅ.");
        }
    }

    // РЎС‚Р°С‚РёС‡РµСЃРєРёР№ РјРµС‚РѕРґ РґР»СЏ РїРѕР»СѓС‡РµРЅРёСЏ РєРѕР»РёС‡РµСЃС‚РІР° РїРѕР»СЊР·РѕРІР°С‚РµР»РµР№
>>>>>>> parent of d4d8d44 (РЎС‚Р°СЂР°СЏ Р»Р°Р±РѕСЂР°С‚РѕСЂРЅР°СЏ СѓРґР°Р»РµРЅР°)
    public static int getUserCount() {
        return userCount;
    }

<<<<<<< HEAD
    // Методы работы с массивом
    // Метод для вывода информации о всех пользователях
=======
    // РњРµС‚РѕРґС‹ СЂР°Р±РѕС‚С‹ СЃ РјР°СЃСЃРёРІРѕРј
    // РњРµС‚РѕРґ РґР»СЏ РІС‹РІРѕРґР° РёРЅС„РѕСЂРјР°С†РёРё Рѕ РІСЃРµС… РїРѕР»СЊР·РѕРІР°С‚РµР»СЏС…
>>>>>>> parent of d4d8d44 (РЎС‚Р°СЂР°СЏ Р»Р°Р±РѕСЂР°С‚РѕСЂРЅР°СЏ СѓРґР°Р»РµРЅР°)
    public static void displayUsers(List<User> users) {
        for (User user : users) {
            user.printUser();
            user.displayAccounts();
            System.out.println();
        }
    }

<<<<<<< HEAD
    // Метод для поиска пользователя по имени
=======
    // РњРµС‚РѕРґ РґР»СЏ РїРѕРёСЃРєР° РїРѕР»СЊР·РѕРІР°С‚РµР»СЏ РїРѕ РёРјРµРЅРё
>>>>>>> parent of d4d8d44 (РЎС‚Р°СЂР°СЏ Р»Р°Р±РѕСЂР°С‚РѕСЂРЅР°СЏ СѓРґР°Р»РµРЅР°)
    public static User findUserByName(List<User> users, String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

<<<<<<< HEAD
    // Метод для сортировки пользователей по имени
=======
    // РњРµС‚РѕРґ РґР»СЏ СЃРѕСЂС‚РёСЂРѕРІРєРё РїРѕР»СЊР·РѕРІР°С‚РµР»РµР№ РїРѕ РёРјРµРЅРё
>>>>>>> parent of d4d8d44 (РЎС‚Р°СЂР°СЏ Р»Р°Р±РѕСЂР°С‚РѕСЂРЅР°СЏ СѓРґР°Р»РµРЅР°)
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
>>>>>>> parent of d4d8d44 (РЎС‚Р°СЂР°СЏ Р»Р°Р±РѕСЂР°С‚РѕСЂРЅР°СЏ СѓРґР°Р»РµРЅР°)
}
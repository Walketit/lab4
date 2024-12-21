import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
            }
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }

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
        } catch (IOException e) {
            e.printStackTrace();
        }

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
    public void addNote(Note note) {
        try (FileWriter writer = new FileWriter(note.getTitle() + ".txt")) {
            writer.write(note.getDescription());
        } catch (IOException e) {
            e.printStackTrace();
        }
        logs.logfileUpdate(id, "������� �������"); // ����������� �������� �������

        notes.add(note); // ���������� ������� � ������ ������� ������������
    }

    // ����� ��� ����������� ���� ������� ������������
    public void displayNotes() {
        System.out.println("������� " + name + ":");
        for (Note note : notes) {
            System.out.println("�������: " + note.getTitle() + ", ���������: " + note.getCategory());
            System.out.println(note.getDescription());
        }
    }

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
    }

    public UserInfo printUserHelpClass() {
        return new UserInfo(id, name, email, isAdmin == 1);
    }

    // ����� ��� ��������� ����� �� �������
    public Account getAccount(int index) {
        if (index >= 0 && index < accounts.size()) {
            return accounts.get(index);
        }
        return null;
    }

    // �������
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

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

    public boolean isAdmin() {
        if (isAdmin == 1) return true;
        return false;
    }

    // ������ ��������� �����
    // ����� ��� �������������� ���������� � ������������
    public String getFormattedInfo() {
        return String.format("������������ #%d: ���: %s, Email: %s, ������: %s",
                id, name, email, isAdmin == 1 ? "�������������" : "����");
    }

    // ����� ��� ������ ������� �� ��������
    public Note findNoteByTitle(String title) {
        for (Note note : notes) {
            if (note.getTitle().equalsIgnoreCase(title)) {
                return note;
            }
        }
        return null;
    }

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
    public static int getUserCount() {
        return userCount;
    }

    // ������ ������ � ��������
    // ����� ��� ������ ���������� � ���� �������������
    public static void displayUsers(List<User> users) {
        for (User user : users) {
            user.printUser();
            user.displayAccounts();
            System.out.println();
        }
    }

    // ����� ��� ������ ������������ �� �����
    public static User findUserByName(List<User> users, String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    // ����� ��� ���������� ������������� �� �����
    public static void sortUsersByName(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getName().compareTo(user2.getName());
            }
        });
    }

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
}
import java.util.*;

public class main {
    public static void main(String[] args) throws MyExcpetions {


        EmailNotification emailNotification = new EmailNotification("Ваш счет пополнен на 100$", "user@example.com");
        emailNotification.send();

        User user = new User("John Doe", "john@example.com", "password", 0, new Logs());
        user.exportToCSV("user.csv");
        user.exportToJSON("user.json");

        Account originalAccount = new Account("Main Account", 1000.0, "USD");

        // Мелкое клонирование
        Account shallowClone = originalAccount.clone();
        System.out.println("Мелкое клонирование:");
        System.out.println("Оригинал: " + originalAccount.getName() + ", Баланс: " + originalAccount.getBalance());
        System.out.println("Клон: " + shallowClone.getName() + ", Баланс: " + shallowClone.getBalance());

        // Глубокое клонирование
        Account deepClone = originalAccount.deepClone();
        System.out.println("Глубокое клонирование:");
        System.out.println("Оригинал: " + originalAccount.getName() + ", Баланс: " + originalAccount.getBalance());
        System.out.println("Клон: " + deepClone.getName() + ", Баланс: " + deepClone.getBalance());

        Logs logs = new Logs();

        user.addAccount(new Account("Main Account", 1000.0, "USD"));
        user.addAccount(new Account("Savings Account", 5000.0, "EUR"));
        user.addNote(new Note("Shopping List", "Buy milk, bread, and eggs", "Personal"));
        user.addNote(new Note("Work Tasks", "Finish the report and send it to the client", "Work"));

        user.printUser();
        user.displayAccounts();
        user.displayNotes();

        ParentUser admin = new ParentUser("Родитель", "parent@example.com", "parentpassword", logs, true, true, true);

        // Продемонстрируем возможности родительского аккаунта
        System.out.println("\nРодитель удаляет счет пользователя:");
        admin.deleteAccount(user, user.getAccounts().get(0));
        user.displayAccounts();

        System.out.println("\nРодитель удаляет заметку пользователя:");
        admin.deleteNote(user, user.getNotes().get(0));
        user.displayNotes();

        System.out.println("\nРодитель просматривает логи пользователя:");
        admin.viewUserLogs(user);
    }
}
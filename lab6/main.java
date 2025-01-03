import java.util.*;

public class main {
    public static void main(String[] args) throws MyExcpetions {
        Logs logs = new Logs();
        
        // При вызове конструктора производного класса, происходит вызов конструктора базового класса
        ParentUser admin = new ParentUser("Родитель", "parent@example.com", "parentpassword", logs, true, true, true);

        // Вызов перегруженного метода с использованием базового класса
        admin.printUser();

        System.out.println("\n");
        // Вызов перегруженного метода без использования базового класса
        admin.printUserWithoutBaseCall();
        System.out.println("\n");

        // Создание списка уведомлений
        List<Notification> notifications = new ArrayList<>();

        // Добавление различных типов уведомлений
        notifications.add(new EmailNotification("Ваша заявка была одобрена!", "user@example.com"));
        notifications.add(new SMSNotification("Ваш баланс менее 100 рублей", "+1234567890"));

        // Отправка всех уведомлений
        for (Notification notification : notifications) {
            notification.send();
            System.out.println("-----------");
        }

        // Демонстрация интерфейса
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

    }
}
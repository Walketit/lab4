import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class main {
    public static void main(String[] args) {
        Logs logs = new Logs();
        logs.getTime().printCurrentTime();

        User user1 = new User(1, "John", "Johnmail@gmail.com", "123", 0, logs);

        user1.printUser();

        Account account1 = new Account("main", 0.0, "RUB");
        Account account2 = new Account("Основа", 100.0, "EUR");

        user1.addAccount(account1);
        user1.addAccount(account2);

        user1.displayAccounts();

        System.out.println();

        Transaction transaction = new Transaction(1, user1.getAccount(0));
        transaction.changeValue("Стипендия", 0, 5000);

        transaction.setTransaction(2, user1.getAccount(1));
        transaction.changeValue("Оплата за подписку", 1, 5);

        System.out.println();

        user1.displayAccounts();

        System.out.println();

        CurrencyChange cur = new CurrencyChange();
        cur.setCurrencyChange("RUBEUR");
        cur.change(1000);

        System.out.println();

        Goal goal1 = new Goal("BMW M5", 5000000.0, 0.0, "Хочу машину");
        user1.addGoal(goal1);
        user1.displayGoals();

        System.out.println();

        Note note1 = new Note("Список продуктов", "Купить молоко,хлеб,колбасу", "Покупки");
        user1.addNote(note1);
        user1.displayNotes();

        System.out.println();

        logs.readLogs(1);

        // Работа с динамическим массивом объектов класса
        int numUsers = 3;
        User[] users = new User[numUsers];
        users[0] = new User(3, "Layla", "Layla1999@gmail.com", "asd", 0, logs);
        users[1] = new User(4, "Matt", "MattSmith@gmail.com", "asdzxc", 1, logs);
        users[2] = new User(5, "Лео", "Messi@gmail.com", "111111", 0, logs);

        System.out.println("\nДинамический список объектов:");
        for (int i = 0; i < numUsers; ++i) {
            users[i].printUser();
            System.out.println();
        }

        // Работа с массивом динамических объектов класса
        int numGoals = 2;
        Goal[] goals = new Goal[numGoals];
        goals[0] = new Goal("Квартира", 500000000.0, 0.0, "Мечта");
        goals[1] = new Goal("Playstation 5", 65000.0, 0.0, "Купить на новогодних скидках");

        System.out.println("\nСписок Динамических объектов:");
        for (int i = 0; i < numGoals; ++i) {
            goals[i].printGoal();
            System.out.println();
        }
    }
}
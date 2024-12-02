public class Account implements Cloneable {
    private int id; // Уникальный идентификатор счета
    private String name; // Название счета
    private String currency; // Валюта счета
    private double balance; // Баланс счета

    // Конструктор по умолчанию
    public Account() {
        this.id = 0;
        this.name = "";
        this.currency = "";
        this.balance = 0.0;
    }

    // Конструктор с параметрами
    public Account(String accName, double initialBalance, String accCurrency) {
        createAccount(accName, accCurrency, initialBalance);
    }

    // Метод для создания счета
    public void createAccount(String accName, String accCurrency, double initialBalance) {
        this.name = accName;
        this.balance = initialBalance;
        this.currency = accCurrency;
    }

    // Метод для вывода информации о счете
    public void printAccount() {
        System.out.println("Название счета: " + name);
        System.out.printf("Баланс: %.2f %s\n", balance, currency);
    }

    // Метод для пополнения счета
    public void deposit(double amount) {
        balance += amount;
    }

    // Метод для списания со счета
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    // Сеттер для баланса
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Сеттер для названия счета
    public void setName(String name) {
        this.name = name;
    }

    // Сеттер для валюты счета
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // Сеттер для идентификатора счета
    public void setId(int id) {
        this.id = id;
    }

    // Геттер для баланса
    public double getBalance() {
        return balance;
    }

    // Геттер для названия счета
    public String getName() {
        return name;
    }

    // Геттер для валюты счета
    public String getCurrency() {
        return currency;
    }

    // Геттер для идентификатора счета
    public int getId() {
        return id;
    }

    // Метод для мелкого клонирования
    @Override
    public Account clone() {
        try {
            return (Account) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // Метод для глубокого клонирования
    public Account deepClone() {
        Account clonedAccount = new Account();
        clonedAccount.setId(this.id);
        clonedAccount.setName(this.name);
        clonedAccount.setCurrency(this.currency);
        clonedAccount.setBalance(this.balance);
        return clonedAccount;
    }
}
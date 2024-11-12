public class Account {
    private int id;
    private String name;
    private String currency;
    private double balance;

    public Account() {
        this.id = 0;
        this.name = "";
        this.currency = "";
        this.balance = 0.0;
    }

    public Account(String accName, double initialBalance, String accCurrency) {
        createAccount(accName, accCurrency, initialBalance);
    }

    public void createAccount(String accName, String accCurrency, double initialBalance) {
        this.name = accName;
        this.balance = initialBalance;
        this.currency = accCurrency;
    }

    public void printAccount() {
        System.out.println("Название счета: " + name);
        System.out.printf("Баланс: %.2f %s\n", balance, currency);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public int getId() {
        return id;
    }
}

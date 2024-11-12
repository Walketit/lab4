public class Transaction {
    private int id;
    private Account account;
    private int type;
    private String name;
    private double amount;

    public Transaction() {
        this.id = 0;
        this.account = null;
        this.type = 0;
        this.name = "";
        this.amount = 0.0;
    }

    public Transaction(int id, Account account) {
        setTransaction(id, account);
    }

    public void setTransaction(int id, Account account) {
        this.id = id;
        this.account = account;
        this.type = 0;
        this.name = "";
        this.amount = 0.0;
    }

    public void changeValue(String name, int type, double value) {
        this.name = name;
        this.type = type;
        this.amount = value;

        if (type == 0) {
            account.deposit(amount);
            System.out.printf("Пополнение на %.2f, на счёт %s\n", amount, account.getName());
        } else if (type == 1) {
            account.withdraw(amount);
            System.out.printf("Списание %.2f, со счёта %s\n", amount, account.getName());
        }
    }
}

public class Goal {
    private String name;
    private String description;
    private double targetAmount;
    private double currentAmount;

    public Goal() {
        this.name = "";
        this.description = "";
        this.targetAmount = 0;
        this.currentAmount = 0;
    }

    public Goal(String name, double targetAmount, double currentAmount, String description) {
        this.name = name;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.description = description;
    }

    public void printGoal() {
        System.out.println("Цель: " + name);
        System.out.printf("%.0f/%.0f\n", currentAmount, targetAmount);
        System.out.println("Описание: " + description);
    }

    public void addToBalance(double amount) {
        currentAmount += amount;
    }

    public boolean isAchieved() {
        return currentAmount >= targetAmount;
    }

    public String getTitle() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCurrentBalance() {
        return currentAmount;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentAmount = currentBalance;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }
}

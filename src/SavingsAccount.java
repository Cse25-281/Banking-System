public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance, "Savings");
        this.interestRate = interestRate;
    }

    public void applyMonthlyInterest() {
        balance += balance * interestRate / 100;
        System.out.println("Monthly interest applied.");
    }

    @Override
    public boolean withdraw(double amount) {
        System.out.println("Savings account does not allow withdrawals.");
        return false;
    }
}
public class InvestmentAccount extends Account {
    private double interestRate;

    public InvestmentAccount(String accountNumber, double initialDeposit, double interestRate) {
        super(accountNumber, initialDeposit, "Investment");

        if (initialDeposit < 500) {
            throw new IllegalArgumentException("Minimum initial deposit is BWP 500.");
        }

        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount);
    }

    public void applyInterest() {
        balance += balance * interestRate / 100;
        System.out.println("Investment interest applied.");
    }
}
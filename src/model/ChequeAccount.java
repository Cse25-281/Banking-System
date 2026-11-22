package model;
public class ChequeAccount extends Account {

    public ChequeAccount(String accountNumber, double balance) {
        super(accountNumber, balance, "Cheque");
    }

    public void creditSalary(double salary) {
        if (salary > 0) {
            balance += salary;
            System.out.println("Salary credited successfully.");
        } else {
            System.out.println("Invalid salary amount.");
        }
    }
}
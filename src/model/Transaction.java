package model;

public class Transaction {
    private int transactionId;
    private int accountId;
    private String transactionType;
    private double amount;

    public Transaction() {}

    public Transaction(int transactionId, int accountId,
                      String transactionType, double amount) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int id) { this.transactionId = id; }

    public int getAccountId() { return accountId; }
    public void setAccountId(int id) { this.accountId = id; }

    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String type) { this.transactionType = type; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}

public class Transaction {
    private TransactionType type;
    private double amount;

    public enum TransactionType {
        DEPOSIT, WITHDRAWAL
    }

    public Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}

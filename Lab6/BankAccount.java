import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BankAccount implements Serializable {
    private int id;
    private String holder;
    private double balance;
    private List<Transaction> movements;

    public BankAccount(int id, String holder, double balance) {
        if(id <= 0) {
            throw new IllegalArgumentException("ID must be positive.");
        }
        if(holder == null || holder.trim().isEmpty()) {
            throw new IllegalArgumentException("Holder name cannot be null or empty.");
        }
        if(balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.id = id;
        this.holder = holder;
        this.balance = balance;
        this.movements = new ArrayList<>();
    }

    public void deposit(double amount) throws BankAccountException.InvalidAmountException {
        if(amount <= 0) {
            throw new BankAccountException.InvalidAmountException("Deposit amount must be positive.");
        }
        if(amount > 5000) {
            throw new BankAccountException.InvalidAmountException("Deposit amount cannot exceed 5000.");
        }
        balance += amount;
        movements.add(new Transaction(Transaction.TransactionType.DEPOSIT, amount));
    }

    public void withdraw(double amount) throws BankAccountException.InvalidAmountException, BankAccountException.InsufficientFundsException {
        if(amount <= 0) {
            throw new BankAccountException.InvalidAmountException("Withdrawal amount must be positive.");
        }
        if(amount > balance) {
            throw new BankAccountException.InsufficientFundsException("Não tem dinheiro suficiente para esse montante");
        }
        balance -= amount;
        movements.add(new Transaction(Transaction.TransactionType.WITHDRAWAL, amount));
    }

    public int getId() {
        return id;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getMovements() {
        return movements;
    }

    public void saveToFile() throws IOException {
        String filename = id + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Conta: " + id);
            writer.newLine();
            writer.write("Titular: " + holder);
            writer.newLine();
            writer.write("Saldo atual: " + balance);
            writer.newLine();
            writer.newLine();
            writer.write("Movimentos:");
            writer.newLine();

            for (Transaction transaction : movements) {
                String transactionType = transaction.getType().name();
                writer.write(transactionType + " | " + transaction.getAmount());
                writer.newLine();
            }
        }
    }

    public void Serialize(BankAccount account) throws IOException {
        String filename = id + ".ser";
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(account);
        } catch (IOException e) {
            throw new IOException("Error during serialization: " + e.getMessage());
        }
    }

}

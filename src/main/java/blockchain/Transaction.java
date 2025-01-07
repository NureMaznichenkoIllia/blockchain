package blockchain;

public class Transaction {
    private final String sender;
    private final String recipient;
    private final double amount;

    public Transaction(String sender, String recipient, double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }
}

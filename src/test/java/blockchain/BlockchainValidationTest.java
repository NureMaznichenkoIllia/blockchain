package blockchain;


import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class BlockchainValidationTest {
    @Test
    public void isBlockChainValid() {
        Blockchain blockchain = new Blockchain();

        Transaction transaction1 = new Transaction("Alice", "Bob", 10.0);
        Transaction transaction2 = new Transaction("Bob", "Charlie", 5.0);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);

        List<Transaction> transactions2 = new ArrayList<>();

        Transaction transaction3 = new Transaction("Dmytro", "Sashko", 35);
        Transaction transaction4 = new Transaction("Sashko", "Dmytro", 49);

        transactions2.add(transaction3);
        transactions2.add(transaction4);

        Block block1 = new Block(1, System.currentTimeMillis(), transactions, blockchain.getLastBlock().getHash());
        blockchain.addBlock(block1);

        Block block2 = new Block(2, System.currentTimeMillis(), transactions2, blockchain.getLastBlock().getHash());
        blockchain.addBlock(block2);

        Assert.assertTrue(blockchain.isChainValid());

        List<Transaction> transactions3 = new ArrayList<>();

        Transaction transaction5 = new Transaction("Eric", "Petro", 98);
        Transaction transaction6 = new Transaction("Danylo", "Eric", 23);

        transactions3.add(transaction5);
        transactions3.add(transaction6);

        block2.setIndex(345);
        block2.setTransactions(transactions3);

        Assert.assertTrue(blockchain.isChainValid());
    }
}

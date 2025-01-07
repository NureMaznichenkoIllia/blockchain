package blockchain;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private final List<Block> chain;

    public Blockchain() {
        chain = new ArrayList<>();
        chain.add(createFirstBlock());
    }

    private Block createFirstBlock() {
        List<Transaction> transactions = new ArrayList<>();
        return new Block(0, System.currentTimeMillis(), transactions, "0");
    }

    public void addBlock(Block newBlock) {
        if (isValidNewBlock(newBlock, getLastBlock())) {
            chain.add(newBlock);
        }
    }

    public Block getLastBlock() {
        return chain.get(chain.size() - 1);
    }

    public boolean isValidNewBlock(Block newBlock, Block previousBlock) {
        if (newBlock.getIndex() != previousBlock.getIndex() + 1) {
            return false;
        }

        if (!newBlock.getHash().equals(newBlock.calculateHash())) {
            return false;
        }

        if (!newBlock.getPreviousHash().equals(previousBlock.getHash())) {
            return false;
        }

        return true;
    }


    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }

            if (!isValidNewBlock(currentBlock, previousBlock)) {
                return false;
            }
        }
        return true;
    }
}

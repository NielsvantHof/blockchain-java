package nl.nielsvanthof.blockchain;

import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;

import static nl.nielsvanthof.blockchain.ChainUtil.isChainValid;

public class Blockchain
{
    private static List<Block> blockchain = new ArrayList<>();

    public static void main(String[] args) {
        final int difficulty = 5;

        // Add blocks to the blockchain
        blockchain.add(new Block("First block", "0"));
        System.out.println("Trying to Mine block 1... ");

        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("Second block",blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 2... ");
        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block("Third block",blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 3... ");
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is valid: " + isChainValid(blockchain));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
    }
}
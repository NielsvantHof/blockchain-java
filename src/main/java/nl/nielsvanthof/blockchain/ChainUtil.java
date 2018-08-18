package nl.nielsvanthof.blockchain;

import java.util.List;

class ChainUtil {

    static Boolean isChainValid(List<Block> blockchain) {
        Block currentBlock;
        Block previousBlock;

        // Loop through blockchain to check hashes:
        for(int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);

            // Compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                System.out.println("Current Hashes not equal");
                return false;
            }

            // Compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }

        return true;
    }

}
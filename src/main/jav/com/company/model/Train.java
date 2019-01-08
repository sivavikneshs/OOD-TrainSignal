package jav.com.company.model;

public class Train {

    private String name;
    private Route route;
    private Block currentBlock;

    public Train(final String name, final Route route) {
        this.name = name;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public Block getBlock() {
        return currentBlock;
    }

    public void setBlock(final Block block) {
        this.currentBlock = block;
    }

    public void move() {

        if (currentBlock == null) {
            if (route == null) {
                System.out.println("Train-" + name + " has crossed this route" + "\n");
                return;
            }
            currentBlock = route.getBlocks().get(0);
            if (!currentBlock.isClear()) {
                System.out.println("Block-" + currentBlock.getBlockNumber() + " is busy. Train " + name + " is "
                        + "Waiting for Signal" +
                        "\n");
                return;
            }
        }

        updateBlocks();

    }

    // update states - similar to state design pattern
    private void updateBlocks() {
        currentBlock.updateBeginSignal();
        currentBlock.updatePreviousBlocks();
        System.out.println("train-" + name + " is in block-" + currentBlock.getBlockNumber());
        System.out.println();

        // last block
        if (currentBlock.getNextBlock() == null) {
            currentBlock.updateEndSignal();
            currentBlock.updateBeginSignal();
            currentBlock.updatePreviousBlocks();
            // train has crossed the route
            route = null;
        }
        currentBlock = currentBlock.getNextBlock();
    }
}

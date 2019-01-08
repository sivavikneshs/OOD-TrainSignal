package jav.com.company.model;

import jav.com.company.enums.SignalState;


public class Block {

    private int blockNumber;
    private Signal beginSignal;
    private Signal endSignal;
    private Block nextBlock;
    private Block prevBlock;

    public Block(final int blockNumber, final Signal beginSignal, final Signal endSignal) {
        this.blockNumber = blockNumber;
        this.beginSignal = beginSignal;
        this.endSignal = endSignal;
    }

    public void updateBeginSignal() {
        beginSignal.updateSignal();
    }

    public void updateEndSignal() {
        endSignal.updateSignal();
    }

    public int getBlockNumber() {
        return blockNumber;
    }

    public Signal getBeginSignal() {
        return beginSignal;
    }

    public Signal getEndSignal() {
        return endSignal;
    }

    public Block getNextBlock() {
        return nextBlock;
    }

    public Block getPrevBlock() {
        return prevBlock;
    }

    public void setNextBlock(final Block nextBlock) {
        this.nextBlock = nextBlock;
    }

    public void setPrevBlock(final Block prevBlock) {
        this.prevBlock = prevBlock;
    }

    public void updatePreviousBlocks() {
        Block temp = this;
        while (temp.getPrevBlock() != null) {
            temp = temp.getPrevBlock();
            temp.updateBeginSignal();
        }
    }

    public boolean isClear() {
        return getBeginSignal().getSignalState() != SignalState.RED;
    }
}

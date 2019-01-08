package jav.com.company.model;

import java.util.List;


public class Route {

    public static final int SIGNAL_COUNT = 4;

    private Station begin;
    private Station end;

    private List<Block> blocks;

    private List<Signal> signals;

    // can use builder pattern owing to multiple parameters
    public Route(final Station begin, final Station end, final List<Block> blocks, final List<Signal> signals) {
        this.begin = begin;
        this.end = end;
        this.blocks = blocks;
        this.signals = signals;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(final List<Block> blocks) {
        this.blocks = blocks;
    }

}

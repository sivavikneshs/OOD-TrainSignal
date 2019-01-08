package jav.com.company.model;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import jav.com.company.enums.SignalState;


public class TrainTest {

    private Train train;

    @Before
    public void setUp() throws Exception {
        train = new Train("A", new Route(new Station("A"), new Station("B"), new ArrayList<>(), new ArrayList<>()));
    }

    @Test
    public void move() {

        Signal beginSignal = new Signal(11, SignalState.GREEN);
        Signal endSignal = new Signal(22, SignalState.GREEN);
        Block block1 = new Block(1, beginSignal, endSignal);
        Block block2 = new Block(2, endSignal, null);
        block1.setNextBlock(block2);
        train.setBlock(block1);
        train.move();

        Assert.assertEquals(SignalState.RED.getSignalValue(), beginSignal.getSignalState().getSignalValue());

    }
}
package jav.com.company;

import jav.com.company.enums.SignalState;
import jav.com.company.model.Block;
import jav.com.company.model.Route;
import jav.com.company.model.Signal;
import jav.com.company.model.Station;
import jav.com.company.model.Train;
import java.util.Arrays;
import java.util.List;


public class Application {

    public static void main(String[] args) {

        Station stationA = new Station("A");
        Station stationB = new Station("B");

        Signal signal0 = new Signal(0, SignalState.GREEN);
        Signal signal1 = new Signal(1, SignalState.GREEN);
        Signal signal2 = new Signal(2, SignalState.GREEN);
        Signal signal3 = new Signal(3, SignalState.GREEN);

        List<Signal> signals = Arrays.asList(signal0, signal1, signal2, signal3);

        Block block0 = new Block(0, signal0, signal1);
        Block block1 = new Block(1, signal1, signal2);
        Block block2 = new Block(2, signal2, signal3);

        block0.setNextBlock(block1);

        block1.setNextBlock(block2);
        block1.setPrevBlock(block0);

        block2.setPrevBlock(block1);

        List<Block> blocks = Arrays.asList(block0, block1, block2);

        Route route = new Route(stationA, stationB, blocks, signals);

        Train trainA = new Train("A", route);
        Train trainB = new Train("B", route);

        trainA.move();
        trainB.move();
        trainA.move();
        trainA.move();
        trainA.move();
        trainB.move();
        trainA.move();


    }




}

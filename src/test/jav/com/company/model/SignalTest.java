package jav.com.company.model;

import org.junit.Assert;
import org.junit.Test;
import jav.com.company.enums.SignalState;


public class SignalTest {

    @Test
    public void updateSignal() {
        Signal signal = new Signal(1, SignalState.DOUBLE_YELLOW);

        signal.updateSignal();

        Assert.assertEquals(SignalState.GREEN, signal.getSignalState());
    }
}
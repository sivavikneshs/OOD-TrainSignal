package jav.com.company.model;

import jav.com.company.enums.SignalState;


public class Signal {

    private int id;

    private SignalState signalState;

    // can hard-cord initial state to green
    // parametrized for extensibility in future

    public Signal(final int id, final SignalState signalState) {
        this.id = id;
        this.signalState = signalState;
    }
    public int getId() {
        return id;
    }

    public SignalState getSignalState() {
        return signalState;
    }

    public void setSignalState(final SignalState signalState) {
        this.signalState = signalState;
    }

    public void updateSignal() {
        SignalState oldSignalState = getSignalState();
        int signalValue = oldSignalState.getSignalValue();
        signalValue = (signalValue + 1) % 4;

        SignalState newSignalState = SignalState.getSignalState(signalValue);
        setSignalState(newSignalState);

        System.out.println(
                "Current state of signal" + getId() + " is " + newSignalState.name());
    }



}

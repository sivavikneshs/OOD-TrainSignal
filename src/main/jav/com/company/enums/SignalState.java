package jav.com.company.enums;

public enum SignalState {
    RED(0), YELLOW(1), DOUBLE_YELLOW(2), GREEN(3);

    int signalValue;

    SignalState(final int signalValue) {
        this.signalValue = signalValue;
    }

    public static SignalState getSignalState(int signalValue) throws IllegalStateException {
        SignalState[] signalStates = SignalState.values();
        for (SignalState signalState : signalStates) {
            if (signalState.signalValue == signalValue) {
                return signalState;
            }
        }

        throw new IllegalStateException("Invalid signal Value" + signalValue);
    }

    public int getSignalValue() {
        return signalValue;
    }
}

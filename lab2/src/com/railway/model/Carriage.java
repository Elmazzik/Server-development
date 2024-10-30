package com.railway.model;

public class Carriage {
    private int comfortLevel;
    private int passengerCount;
    private int baggageCount;

    public Carriage(int comfortLevel, int passengerCount, int baggageCount) {
        this.comfortLevel = comfortLevel;
        this.passengerCount = passengerCount;
        this.baggageCount = baggageCount;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public int getBaggageCount() {
        return baggageCount;
    }

    @Override
public String toString() {
    return "Carriage{" +
           "comfortLevel=" + comfortLevel +
           ", passengerCount=" + passengerCount +
           ", baggageCount=" + baggageCount +
           '}';
}

}

package com.railway.model;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private List<Carriage> carriages;

    public Train() {
        this.carriages = new ArrayList<>();
    }

    public void addCarriage(Carriage carriage) {
        carriages.add(carriage);
    }

    public int getTotalPassengers() {
        return carriages.stream().mapToInt(Carriage::getPassengerCount).sum();
    }

    public int getTotalBaggage() {
        return carriages.stream().mapToInt(Carriage::getBaggageCount).sum();
    }

    public void sortByComfortLevel() {
        carriages.sort((c1, c2) -> Integer.compare(c2.getComfortLevel(), c1.getComfortLevel()));
    }

    public List<Carriage> findCarriagesByPassengerRange(int min, int max) {
        List<Carriage> result = new ArrayList<>();
        for (Carriage carriage : carriages) {
            if (carriage.getPassengerCount() >= min && carriage.getPassengerCount() <= max) {
                result.add(carriage);
            }
        }
        return result;
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }
}

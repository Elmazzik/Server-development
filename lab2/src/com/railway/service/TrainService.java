package com.railway.service;

import com.railway.model.Train;
import com.railway.model.Carriage;

public class TrainService {
    public void printTrainInfo(Train train) {
        System.out.println("Total Passengers: " + train.getTotalPassengers());
        System.out.println("Total Baggage: " + train.getTotalBaggage());

        System.out.println("Carriages sorted by comfort level:");
        train.sortByComfortLevel();
        for (Carriage carriage : train.getCarriages()) {
            System.out.println("Comfort Level: " + carriage.getComfortLevel() +
                    ", Passengers: " + carriage.getPassengerCount() +
                    ", Baggage: " + carriage.getBaggageCount());
        }
    }
}

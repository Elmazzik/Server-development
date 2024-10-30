package com.railway.main;

import com.railway.model.*;
import com.railway.service.TrainService;

public class MainApp {
    public static void main(String[] args) {
        Train train = new Train();

       
        train.addCarriage(new PassengerCarriage(3, 50, 20));
        train.addCarriage(new PassengerCarriage(5, 30, 10));
        train.addCarriage(new PassengerCarriage(2, 70, 40));

        System.out.println("Carriages from 40 to 80: " + train.findCarriagesByPassengerRange(40, 80)
        );
        
        TrainService trainService = new TrainService();
        trainService.printTrainInfo(train);
    }
}

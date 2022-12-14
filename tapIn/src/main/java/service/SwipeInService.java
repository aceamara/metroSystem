package service;

import entity.*;

import java.util.Collection;
import java.util.List;

public interface SwipeInService {

    public Customer login (String customerId);
    public Customer addNewCustomer (Customer customer);
    Collection<station> getAllStations();
    double calculatePrice (int startingPoint,int finishingPoint,double price);
    Bill tapOut(int stationId, int customerId, double price);
    Customer setNewStationId(int customerId, int stationId);
    Customer deductCustomerBalance(int customerId, double amount);
    station getStation(int stationId);

    //getting the route price
    public double routeCost (String startingPoint,String finishingPoint);

    //saving the details to the database
    public trip saveTransaction (trip Trip, int customerId);

    public trip showTrips (int customerId);

    public StationList showAllStations();

    public station getStationbyId (String stationId);


}

package service;

import entity.Customer;
import entity.station;
import entity.trip;

import java.util.List;

public interface SwipeInService {

    //customer enters id to login
    public Customer login (int customerId);

    List<trip> SearchCustomerTrip (Integer customerId);

    trip startTrip (int customerId,station stationId);

}

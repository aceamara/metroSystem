package service;

import entity.Customer;

import entity.station;
import entity.trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import persistence.TripDao;

import java.time.LocalDate;

@Service
public class SwipeInServiceImpl implements SwipeInService {

    //dependency injection
    @Autowired
    private TripDao tripdao;

    @Autowired
    private RestTemplate restTemplate;

    //logged in?
    public Customer loggedIn(int customerId, station startingStation) {
        Customer customer = restTemplate.getForObject("http://localhost:8086/customer/customerid" + customerId, Customer.class);
        return customer;
    }
    //getting customer route
public double customerRoute (int startingPoint, int CustomerId ) {

    double startRoute = restTemplate.getForObject("http://localhost:8082/stations/" + startingPoint + "/" + customerId, trip.class);
    return startRoute;
}}







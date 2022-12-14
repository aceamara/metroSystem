package service;

import entity.Customer;

import entity.station;
import entity.trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import persistence.TripDao;

@Service
public class SwipeInServiceImpl implements SwipeInService {

    @Autowired
    private TripDao tripdao;

    @Autowired
    private RestTemplate restTemplate;

    //login
    public Customer login (String customerId){
        Customer customer = restTemplate.getForObject("http://localhost:8086/customer/"+customerId,Customer.class);
        if (customer!=null)
            return customer;
        return null;
    }

    //starting the journey
    public trip createNewTrip (int customerId, station SwipeInStation){
        Customer customer =restTemplate.getForObject("http://localhost:8086/customer/customerid"+customerId,Customer.class);
        double balance = customer.getCustomerBalance();

        if (balance>0 ){
            //need code for getting the stationid
            SwipeInStation = restTemplate.getForObject();
        }
    }


}

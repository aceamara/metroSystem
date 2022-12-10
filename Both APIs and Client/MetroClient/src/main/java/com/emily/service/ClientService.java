package com.emily.service;

import com.emily.entity.Customer;

public interface ClientService {

	Customer loginCheck(int id);

	Customer addNewCustomer(Customer customer);

}

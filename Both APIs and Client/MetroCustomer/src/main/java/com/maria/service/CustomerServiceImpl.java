package com.maria.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.maria.entity.Customer;
import com.maria.entity.CustomerInvoice;
import com.maria.persistence.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao dao;

	
	public Customer getCustomer(int id){
		 return dao.findById(id).get();
	
	}
	
	public Customer addCustomer(Customer customer) {
		if(dao.save(customer)==null) {
			return customer;
		}
		else {
			return null;
			
		}
	}
	
	public Customer deductBalance(int id, double amount) {
		Customer nCustomer =getCustomer(id); 
			if(nCustomer !=null) {
				nCustomer.setCustomerBalance(nCustomer.getCustomerBalance()-amount);
				return dao.save(nCustomer);
			}
			return null;
		
	}
	public Customer topUpbalance(int id, double amount) {
		Customer theCustomer = getCustomer(id);
		if(theCustomer !=null) {
			theCustomer.setCustomerBalance(theCustomer.getCustomerBalance()+amount);
			return dao.save(theCustomer);
			
			
			
		}
		return null;
	}
	
	public Customer setStationToNull(int id) {
		Customer customer = getCustomer(id);
		if(customer !=null) {
			customer.setStationId(0);
			return dao.save(customer);
		}
		return null;
	}
	
	public List<CustomerInvoice> getCustomerInvoices(int customerId){
		return dao.getInvoicesByCustomerId(customerId);
	}
}
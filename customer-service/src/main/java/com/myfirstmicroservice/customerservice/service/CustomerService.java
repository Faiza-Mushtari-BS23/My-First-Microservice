package com.myfirstmicroservice.customerservice.service;

import com.myfirstmicroservice.customerservice.dto.CustomerRequest;
import com.myfirstmicroservice.customerservice.dto.CustomerResponse;
import com.myfirstmicroservice.customerservice.model.Customer;
import com.myfirstmicroservice.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponse> customerResponses = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerResponse customerResponse = CustomerResponse.builder()
                    .id(customer.getId())
                    .userId(customer.getUserId())
                    .userName(customer.getUserName())
                    .mobileNumber(customer.getMobileNumber())
                    .build();

            customerResponses.add(customerResponse);
        }

        return customerResponses;
    }

    public void addCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .userId(customerRequest.getUserId())
                .userName(customerRequest.getUserName())
                .mobileNumber(customerRequest.getMobileNumber())
                .build();

        customerRepository.save(customer);
        logger.info("Customer {} is added", customer.getId());
    }

    public void updateCustomer(Long id, CustomerRequest customerRequest) {
        Customer existingCustomer = customerRepository.findByOnlyId(id);
        if (existingCustomer != null) {
            existingCustomer.setUserId(customerRequest.getUserId());
            existingCustomer.setUserName(customerRequest.getUserName());
            existingCustomer.setMobileNumber(customerRequest.getMobileNumber());
            customerRepository.save(existingCustomer);
            logger.info("Customer {} is updated", existingCustomer.getId());
        } else {
            logger.error("Customer {} not found", id);
        }
    }

    public void deleteCustomer(Long id) {
        Customer existingCustomer = customerRepository.findByOnlyId(id);
        if (existingCustomer != null) {
            customerRepository.delete(existingCustomer);
            logger.info("Customer {} is deleted", existingCustomer.getId());
        } else {
            logger.error("Customer {} not found", id);
        }
    }

    public CustomerResponse getCustomerById(Long id) {
        Customer existingCustomer = customerRepository.findByOnlyId(id);
        if (existingCustomer != null) {
            return CustomerResponse.builder()
                    .id(existingCustomer.getId())
                    .userId(existingCustomer.getUserId())
                    .userName(existingCustomer.getUserName())
                    .mobileNumber(existingCustomer.getMobileNumber())
                    .build();
        } else {
            logger.error("Customer {} not found", id);
            return null;
        }
    }
}
package com.springframework.springmvc.services.map;

/*
PROJECT NAME : 6. Introducing Spring MVC
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/26/2022 11:06 PM
*/

import com.springframework.springmvc.domain.Customer;
import com.springframework.springmvc.domain.DomainObject;
import com.springframework.springmvc.services.CustomerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@Profile("map")
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    public CustomerServiceImpl() {
        loadDomainObjects();
    }

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Customer getById(Integer id) {
        return (Customer) super.getById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return (Customer) super.saveOrUpdate(domainObject);
    }

    @Override
    public boolean delete(Integer id) {
        return super.delete(id);
    }

    @Override
    protected void loadDomainObjects() {
        domainMap = new HashMap<>();

        Customer customerOne = new Customer();
        customerOne.setId(1);
        customerOne.setFirstName("John");
        customerOne.setLastName("Doe");
        customerOne.getBillingAddress().setAddressLineOne("1 Main St");
        customerOne.getBillingAddress().setAddressLineTwo("2 Main St");
        customerOne.getBillingAddress().setCity("Miami");
        customerOne.getBillingAddress().setState("Florida");
        customerOne.getBillingAddress().setZipCode("33101");
        customerOne.setEmail("john.doe@springframework.org");
        customerOne.setPhoneNumber("305.333.0101");
        domainMap.put(1, customerOne);

        Customer customerTwo = new Customer();
        customerTwo.setId(2);
        customerTwo.setFirstName("Jane");
        customerTwo.setLastName("Doe");
        customerTwo.getBillingAddress().setAddressLineOne("3 Main St");
        customerTwo.getBillingAddress().setAddressLineTwo("4 Main St");
        customerTwo.getBillingAddress().setCity("Illinois");
        customerTwo.getBillingAddress().setState("Chicago");
        customerTwo.getBillingAddress().setZipCode("44101");
        customerTwo.setEmail("jane.doe@springframework.org");
        customerTwo.setPhoneNumber("405.333.0404");
        domainMap.put(2, customerTwo);

        Customer customerThree = new Customer();
        customerThree.setId(3);
        customerThree.setFirstName("Michel");
        customerThree.setLastName("Weston");
        customerThree.getBillingAddress().setAddressLineOne("5 Main St");
        customerThree.getBillingAddress().setAddressLineTwo("6 Main St");
        customerThree.getBillingAddress().setCity("Illinois");
        customerThree.getBillingAddress().setState("Boston");
        customerThree.getBillingAddress().setZipCode("55101");
        customerThree.setEmail("jane.doe@springframework.org");
        customerThree.setPhoneNumber("905.666.0808");
        domainMap.put(3, customerThree);

    }
}

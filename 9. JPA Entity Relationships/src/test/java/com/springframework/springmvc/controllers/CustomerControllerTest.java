package com.springframework.springmvc.controllers;

import com.springframework.springmvc.domain.Address;
import com.springframework.springmvc.domain.Customer;
import com.springframework.springmvc.domain.Product;
import com.springframework.springmvc.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


/*
PROJECT NAME : 7. Spring MVC Test and mockito
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/28/2022 11:08 PM
*/

public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void listCustomersTest() throws Exception {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customers.add(new Customer());

        when(customerService.listAll()).thenReturn((List) customers);

        mockMvc.perform(get("/customer/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customerList"))
                .andExpect(model().attribute("customers", hasSize(2)));
    }

    @Test
    public void displayCustomerTest() throws Exception {
        Integer id = 1;

        when(customerService.getById(id)).thenReturn(new Customer());

        mockMvc.perform(get("/customer/display/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customerDisplay"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    public void newCustomerTest() throws Exception {
        verifyNoInteractions(customerService);

        mockMvc.perform(get("/customer/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customerForm"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    public void editCustomerTest() throws Exception {
        Integer id = 1;
        when(customerService.getById(id)).thenReturn(new Customer());

        mockMvc.perform(get("/customer/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customerForm"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    public void saveOrUpdateCustomerTest() throws Exception {
        Integer id = 1;
        Customer returnCustomer = new Customer();

        String firstName = "John";
        String lastName = "Doe";
        String addressLineOne = "1 Main First St";
        String addressLineTwo = "2 Main Second St";
        String city = "Miami";
        String state = "Florida";
        String zipCode = "33101";
        String email = "john.doe@springframework.org";
        String phoneNumber = "303-333-0101";

        Address shippingAddress = new Address();

        returnCustomer.setId(id);
        returnCustomer.setFirstName(firstName);
        returnCustomer.setLastName(lastName);
        returnCustomer.setShippingAddress(shippingAddress);
        returnCustomer.getShippingAddress().setAddressLineOne(addressLineOne);
        returnCustomer.getShippingAddress().setAddressLineTwo(addressLineTwo);
        returnCustomer.getShippingAddress().setCity(city);
        returnCustomer.getShippingAddress().setState(state);
        returnCustomer.getShippingAddress().setZipCode(zipCode);
        returnCustomer.setEmail(email);
        returnCustomer.setPhoneNumber(phoneNumber);

        when(customerService.saveOrUpdate(ArgumentMatchers.<Customer>any())).thenReturn(returnCustomer);

        mockMvc.perform(post("/customer")
                .param("id", "1")
                .param("firstName", firstName)
                .param("lastName", lastName)
                .param("shippingAddress.addressLineOne", addressLineOne)
                .param("shippingAddress.addressLineTwo", addressLineTwo)
                .param("shippingAddress.city", city)
                .param("shippingAddress.state", state)
                .param("shippingAddress.zipCode", zipCode)
                .param("email", email)
                .param("phoneNumber", phoneNumber))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/customer/display/1"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)))
                .andExpect(model().attribute("customer", hasProperty("firstName", is(firstName))))
                .andExpect(model().attribute("customer", hasProperty("lastName", is(lastName))))
                .andExpect(model().attribute("customer", hasProperty("shippingAddress", hasProperty("addressLineOne",is(addressLineOne)))))
                .andExpect(model().attribute("customer", hasProperty("shippingAddress", hasProperty("addressLineTwo",is(addressLineTwo)))))
                .andExpect(model().attribute("customer", hasProperty("shippingAddress", hasProperty("city",is(city)))))
                .andExpect(model().attribute("customer", hasProperty("shippingAddress", hasProperty("state",is(state)))))
                .andExpect(model().attribute("customer", hasProperty("shippingAddress", hasProperty("zipCode",is(zipCode)))))
                .andExpect(model().attribute("customer", hasProperty("email", is(email))))
                .andExpect(model().attribute("customer", hasProperty("phoneNumber", is(phoneNumber))));

        // verify properties of bound object
        ArgumentCaptor<Customer> customerCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerService).saveOrUpdate(customerCaptor.capture());

        Customer boundCustomer = customerCaptor.getValue();


        assertEquals(id, boundCustomer.getId());
        assertEquals(firstName, boundCustomer.getFirstName());
        assertEquals(lastName, boundCustomer.getLastName());
        assertEquals(addressLineOne, boundCustomer.getShippingAddress().getAddressLineOne());
        assertEquals(addressLineTwo, boundCustomer.getShippingAddress().getAddressLineTwo());
        assertEquals(city, boundCustomer.getShippingAddress().getCity());
        assertEquals(state, boundCustomer.getShippingAddress().getState());
        assertEquals(zipCode, boundCustomer.getShippingAddress().getZipCode());
        assertEquals(email, boundCustomer.getEmail());
        assertEquals(phoneNumber, boundCustomer.getPhoneNumber());
    }

    @Test
    public void deleteCustomerTest() throws Exception{
        Integer id = 1;

        mockMvc.perform(get("/customer/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/customer/list"));
    }
}
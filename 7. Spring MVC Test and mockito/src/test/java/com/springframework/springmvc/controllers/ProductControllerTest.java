package com.springframework.springmvc.controllers;

import com.springframework.springmvc.domain.Product;
import com.springframework.springmvc.services.ProductService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import org.mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/*
PROJECT NAME : 7. Spring MVC Test and mockito
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 2/28/2022 10:00 PM
*/

public class ProductControllerTest {

    @Mock // Mockito Mock object
    private ProductService productService;

    @InjectMocks // setups controller, and injects mock objects into it.
    private ProductController productController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // initializes controller & mocks

        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void listProductsTest() throws Exception{
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());

        // specific Mockito interaction, tell stub to return list of products
        // need to strip generics to keep Mockito happy.
        when(productService.listAll()).thenReturn((List) products);

        mockMvc.perform(get("/product/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/productList"))
                .andExpect(model().attribute("products", hasSize(2)));
    }

    @Test
    public void displayProductTest() throws Exception{
        Integer id = 1;

        // Tell Mockito stub to return new product for Id 1
        when(productService.getById(id)).thenReturn(new Product());

        mockMvc.perform(get("/product/display/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/productDisplay"))
                .andExpect(model().attribute("product", instanceOf(Product.class)));
    }

    @Test
    public void editProductTest() throws Exception{
        Integer id = 1;

        //Tell Mockito stub to return new product for Id 1
        when(productService.getById(id)).thenReturn(new Product());

        mockMvc.perform(get("/product/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/productForm"))
                .andExpect(model().attribute("product", instanceOf(Product.class)));
    }

    @Test
    public void newProductTest() throws Exception {
        Integer id = 1;

        // should not call service
        verifyNoInteractions(productService);

        mockMvc.perform(get("/product/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/productForm"))
                .andExpect(model().attribute("product", instanceOf(Product.class)));
    }

    @Test
    public void saveOrUpdateTest() throws Exception {
        Integer id = 1;
        String description = "Test Description";
        BigDecimal price = new BigDecimal("12.00");
        String imageURL = "example.com";

        Product returnedProduct = new Product();
        returnedProduct.setId(id);
        returnedProduct.setDescription(description);
        returnedProduct.setPrice(price);
        returnedProduct.setImageURL(imageURL);

        when(productService.saveOrUpdate(ArgumentMatchers.<Product>any())).thenReturn(returnedProduct);

        mockMvc.perform(post("/product")
                .param("id", "1")
                .param("description", description)
                .param("price", "12.00")
                .param("imageURL","example.com"))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(view().name("redirect:/product/display/1"))
                    .andExpect(model().attribute("product", instanceOf(Product.class)))
                    .andExpect(model().attribute("product", hasProperty("id", is(id))))
                    .andExpect(model().attribute("product", hasProperty("description", is(description))))
                    .andExpect(model().attribute("product", hasProperty("price", is(price))))
                    .andExpect(model().attribute("product", hasProperty("imageURL", is(imageURL))));

        // verify properties of bound object
        ArgumentCaptor<Product> boundProduct = ArgumentCaptor.forClass(Product.class);
        verify(productService).saveOrUpdate(boundProduct.capture());

        assertEquals(id, boundProduct.getValue().getId());
        assertEquals(description, boundProduct.getValue().getDescription());
        assertEquals(price, boundProduct.getValue().getPrice());
        assertEquals(imageURL, boundProduct.getValue().getImageURL());
    }

    @Test
    public void deleteProductTest() throws Exception{
        Integer id = 1;

        mockMvc.perform(get("/product/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/product/list"));

        verify(productService, times(1)).delete(id);
    }
}
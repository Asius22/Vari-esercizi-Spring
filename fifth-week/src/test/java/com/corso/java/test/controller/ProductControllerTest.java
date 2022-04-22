package com.corso.java.test.controller;

import com.corso.java.test.domain.Product;
import com.corso.java.test.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    private Product product;
    private List<Product> productList;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setup() {
        product = new Product(1, "bat", 1200);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @AfterEach
    public void tearDown() {
        product = null;
    }

    @Test
    public void GetMappingOfAllProduct() throws Exception {
        when(productService.getAllProducts()).thenReturn(productList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(product)))
                .andDo(MockMvcResultHandlers.print());
        verify(productService).getAllProducts();
        verify(productService, times(1)).getAllProducts();
    }


    @Test
    public void GetMappingOfProductShouldReturnRespectiveProduct() throws Exception {
        when(productService.getProductByid(any(Integer.class))).thenReturn(product);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product/1"))
                .andDo(MockMvcResultHandlers.print());
        verify(productService, times(1)).getProductByid(any(Integer.class));
    }

    @Test
    public void PostMappingOfProduct() throws Exception {
        when(productService.addProduct(any())).thenReturn(product);
        mockMvc.perform(
                post("/api/v1/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(product))
        ).andExpect(status().isCreated());
        verify(productService, times(1)).addProduct(any());
    }

    @Test
    public void DeleteMappingUrlAndIdThenShouldReturnDeletedProduct() throws Exception {
        when(productService.deleteProductById(any(Integer.class))).thenReturn(product);
        mockMvc.perform(delete("/api/v1/product/{id}", any(Integer.class)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

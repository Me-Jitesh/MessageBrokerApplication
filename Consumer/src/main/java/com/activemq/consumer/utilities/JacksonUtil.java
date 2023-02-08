package com.activemq.consumer.utilities;

import com.activemq.consumer.models.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JacksonUtil {

    public String toJson(Product product) {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(product);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public Product fromJson(String json) {
        Product product = null;
        try {
            product = new ObjectMapper().readValue(json, Product.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return product;
    }
}

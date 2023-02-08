package com.p2p.producer.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.p2p.producer.models.Product;
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

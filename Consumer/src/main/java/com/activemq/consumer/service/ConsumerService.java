package com.activemq.consumer.service;

import com.activemq.consumer.models.Product;
import com.activemq.consumer.utilities.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    private JacksonUtil jacksonUtil;
    @Autowired
    private ProductService service;

    @JmsListener(destination = "${my.jms.destination-name}")
    public void consumeData(String data) {

        System.out.println("Data Reached to Consumer");

        Product product = jacksonUtil.fromJson(data);
        service.saveProduct(product);

        System.out.println("Product Stored in DB");

        System.out.println(service.getAllProduct());
    }
}

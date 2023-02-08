package com.p2p.producer.services;

import com.p2p.producer.models.Product;
import com.p2p.producer.utilities.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private JacksonUtil jacksonUtil;

    @Value("${my.jms.destination-name}")
    private String destinationName;

    public boolean produceData(Product product) {
        String json = jacksonUtil.toJson(product);
        return produceData(json);
    }

    public boolean produceData(String message) {
        boolean sent = false;
        try {
            jmsTemplate.send(destinationName, (session) -> session.createTextMessage(message));
            sent = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sent;
    }
}

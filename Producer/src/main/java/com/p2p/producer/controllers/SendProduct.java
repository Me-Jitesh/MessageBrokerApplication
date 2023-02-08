package com.p2p.producer.controllers;

import com.p2p.producer.models.Product;
import com.p2p.producer.services.ProducerService;
import com.p2p.producer.utilities.FileReadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SendProduct implements CommandLineRunner {

    @Autowired
    private FileReadUtil fileUtil;

    @Autowired
    private ProducerService service;

    @Value("${my.file.file-path}")
    private String filePath;

    private List<Product> list;
    private int counter = 0;

    @Override
    public void run(String... args) {
        list = fileUtil.readFile(filePath);
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void sendToConsumer() {
        boolean sent = service.produceData(list.get(counter % list.size()));
        counter++;
        if (sent) {
            System.out.println("PRODUCT IS SENT");
            System.out.println(list.get((counter - 1) % (list.size())));
        } else {
            System.err.println("PRODUCT SENDING FAILED !");
        }
    }
}

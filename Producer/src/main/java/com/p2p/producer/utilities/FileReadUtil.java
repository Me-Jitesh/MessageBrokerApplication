package com.p2p.producer.utilities;

import com.p2p.producer.models.Product;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileReadUtil {

    public List<Product> readFile(String file) {

        List<Product> list = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file)) {
            // Read Data
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);

            // Parsing Data & Prepare List
            String fileData = new String(bytes);
            String[] rows = fileData.split("\n");
            for (String row : rows) {
                String[] elements = row.split(",");
                Product product = new Product(Integer.valueOf(elements[0]), elements[1], Double.valueOf(elements[2]));
                list.add(product);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}

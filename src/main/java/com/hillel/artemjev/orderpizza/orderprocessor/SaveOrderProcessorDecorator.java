package com.hillel.artemjev.orderpizza.orderprocessor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hillel.artemjev.orderpizza.entities.Order;
import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@AllArgsConstructor
public class SaveOrderProcessorDecorator implements OrderProcessor {
    private OrderProcessor processor;
    private final String filePath;
    private final ObjectMapper mapper;

    @Override
    public void process(Order order) {
        createFileIfNotExist();
        saveOrderInFile(order);
        processor.process(order);
    }

    private void saveOrderInFile(Order order) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filePath, true), true)) {
            writer.println(mapper.writeValueAsString(order));
        } catch (FileNotFoundException | JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void createFileIfNotExist() {
        try {
            Files.writeString(Path.of(filePath), "", StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

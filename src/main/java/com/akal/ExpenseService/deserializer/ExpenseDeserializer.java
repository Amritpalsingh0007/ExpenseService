package com.akal.ExpenseService.deserializer;

import com.akal.ExpenseService.dto.ExpenseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class ExpenseDeserializer implements Deserializer<ExpenseDto> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public ExpenseDto deserialize(String s, byte[] bytes) {
        ObjectMapper objectMapper = new ObjectMapper();
        ExpenseDto expenseDto = null;
        try{
            expenseDto = objectMapper.readValue(bytes, ExpenseDto.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return expenseDto;
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}

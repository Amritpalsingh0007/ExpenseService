package com.akal.ExpenseService.consumer;

import com.akal.ExpenseService.dto.ExpenseDto;
import com.akal.ExpenseService.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseConsumer  {
    private ExpenseService expenseService;

    @Autowired
    ExpenseConsumer(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @KafkaListener(topics="${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listener(ExpenseDto expenseDto){
        try{
            expenseService.createExpense(expenseDto);
        } catch (Exception e) {
            System.out.println("Error listening the event : " + e.getMessage());
        }
    }

}

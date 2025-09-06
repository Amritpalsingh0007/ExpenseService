package com.akal.ExpenseService.controller;

import com.akal.ExpenseService.dto.ExpenseDto;
import com.akal.ExpenseService.service.ExpenseService;
import jakarta.websocket.server.PathParam;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/expense/v1")
public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ExpenseDto>> getExpenses(@PathParam("user_id") @NonNull String userId){
        try{
            return new ResponseEntity<>(expenseService.getExpenses(userId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}

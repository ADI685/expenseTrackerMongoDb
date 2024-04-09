package com.adi685.expenseTrackerMongoDb.controller;

import com.adi685.expenseTrackerMongoDb.model.Expense;
import com.adi685.expenseTrackerMongoDb.model.ExpenseCategory;
import com.adi685.expenseTrackerMongoDb.service.ExpenseService;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

  private final ExpenseService expenseService;

  public ExpenseController(ExpenseService expenseService){
    this.expenseService=expenseService;
  }

  @PostMapping
  public ResponseEntity<String> addExpense(@RequestBody Expense expense){
    expenseService.addExpense(expense);
    return ResponseEntity.status(HttpStatus.CREATED).body("created");
  }

  @GetMapping
  public ResponseEntity<List<Expense>> getAllExpense(){
    return ResponseEntity.ok(expenseService.getAllExpense());

  }

  @PutMapping
  public ResponseEntity updateExpense(@RequestBody Expense expense){
    expenseService.updateExpense(expense);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteExpense(@PathVariable String id){
    expenseService.deleteExpense(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }


  @GetMapping("/{name}")
  public ResponseEntity<Expense> getExpenseByName(@PathVariable String name){
    return ResponseEntity.ok(expenseService.getExpenseByName(name));

  }

  @GetMapping("/category/{category}")
  public ResponseEntity<List<Expense>> getExpenseByCategory(@PathVariable ExpenseCategory category ){
    return ResponseEntity.ok(expenseService.getExpenseByCategory(category));
  }

}

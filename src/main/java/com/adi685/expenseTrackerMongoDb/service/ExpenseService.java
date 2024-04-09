package com.adi685.expenseTrackerMongoDb.service;

import com.adi685.expenseTrackerMongoDb.model.Expense;
import com.adi685.expenseTrackerMongoDb.model.ExpenseCategory;
import com.adi685.expenseTrackerMongoDb.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

  private final ExpenseRepository expenseRepository;

  public ExpenseService(ExpenseRepository expenseRepository) {
    this.expenseRepository = expenseRepository;
  }

  public void addExpense(Expense expense) {
    expenseRepository.insert(expense);

  }

  public List<Expense> getAllExpense() {
    return expenseRepository.findAll();
  }

  public void updateExpense(Expense expense) {
    Expense savedExpense = expenseRepository.findById(expense.getId())
        .orElseThrow(() -> new RuntimeException
            (String.format("Cannot found expense of id %s", expense.getId())));

    savedExpense.setExpenseAmount(expense.getExpenseAmount());
    savedExpense.setExpenseDiscription(expense.getExpenseDiscription());
    savedExpense.setExpenseCategory(expense.getExpenseCategory());
    savedExpense.setExpenseName(expense.getExpenseName());

    expenseRepository.save(expense);
  }

  public void deleteExpense(String id) {
    expenseRepository.deleteById(id);
  }

  public Expense getExpenseByName(String name) {
    return expenseRepository.findByName(name)
        .orElseThrow(()-> new RuntimeException(String.format("Cannot find expense by name %s",name)));
  }

  public List<Expense> getExpenseByCategory(ExpenseCategory category){
    return expenseRepository.findByCategory(category.name())
        .orElseThrow(()->new RuntimeException(String.format("No data available for category %s",category)));
  }
}

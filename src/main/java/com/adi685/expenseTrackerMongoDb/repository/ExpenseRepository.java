package com.adi685.expenseTrackerMongoDb.repository;

import com.adi685.expenseTrackerMongoDb.model.Expense;
import com.adi685.expenseTrackerMongoDb.model.ExpenseCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

  @Query("{'name' : ?0}")
  Optional<Expense> findByName(String name);

  @Query("{category':?0")
  Optional<List<Expense>> findByCategory(String category);

//  @Query("{'name' : ?0, 'amount' : ?1")
//  Optional<Expense> findByName(String name, BigDecimal amount);

}

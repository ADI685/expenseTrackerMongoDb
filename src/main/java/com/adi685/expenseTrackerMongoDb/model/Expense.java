package com.adi685.expenseTrackerMongoDb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Document("expense")
public class Expense {

  @Id
  private String id;

  @Field("name")
  @Indexed(unique = true )
  private String expenseName;

  @Field("category")
  @Indexed
  private ExpenseCategory expenseCategory;

  @Field("discription")
  private String expenseDiscription;

  @Field("amount")
   private BigDecimal expenseAmount;
}

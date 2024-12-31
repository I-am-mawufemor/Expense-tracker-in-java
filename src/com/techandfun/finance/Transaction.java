package com.techandfun.finance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private String transactionId;
    private LocalDate date;
    private double amount;
    private Category category;
    private String description;
    public static double oldAmount = 0.0; // Stores old amount 
   private static double deletedAmount = 0.0;
   
    // Static storage for all transactions (simulating a database)
    private static List<Transaction> transactions = new ArrayList<>();

    // Constructor for creating a transaction with all details
    public Transaction(String transactionId, LocalDate date, double amount, Category category, String description) {
        this.transactionId = transactionId;
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
        
    }

    // Constructor for operations like delete (using only transactionId)
    public Transaction(String transactionId) {
        this.transactionId = transactionId;
    }
    

    // Getter methods
    public String getTransactionId() {
        return transactionId;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    } 

    // Method to add a transaction
    public static void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        System.out.println("Transaction added successfully.");
    }
    
    public static boolean updatedTransaction(String transactionId, Transaction updatedTransaction) {
        boolean found = false;
        for (int i = 0; i < transactions.size(); i++) {
            Transaction currentTransaction = transactions.get(i);
            if (currentTransaction.getTransactionId().equals(transactionId)) {
            	 oldAmount = currentTransaction.getAmount();
                // Replace the transaction
                transactions.set(i, updatedTransaction);
                System.out.println("Transaction updated successfully. New amount: " + updatedTransaction.getAmount() + "\nOld Amount : "+ oldAmount);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Transaction with ID " + transactionId + " not found");
        }
        return found;
    }
    
    	public void updateAmount(String transactionId, double newAmount, Transaction updatedTransaction) {
        boolean worked = Transaction.updatedTransaction(transactionId, updatedTransaction);
        if (worked) {
            this.amount = newAmount;
        } else {
            System.out.println("Amount failed to update");
        }
    }



    // Method to delete a transaction
    public static void deleteTransaction(String transactionId) {
        boolean found = false;
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getTransactionId().equals(transactionId)) {
            	Transaction currentTransaction = transactions.get(i);
            	deletedAmount = currentTransaction.getAmount();
                transactions.remove(i);
                System.out.println("Transaction deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Transaction with ID " + transactionId + " not found.");
        }
    }

    // Method to return transaction details as a formatted string
    public String getTransactionDetails() {
        return "Transaction ID: " + transactionId + "\n" +
               "Date: " + (date != null ? date.toString() : "N/A") + "\n" +
               "Amount: $" + amount + "\n" +
               "Category: " + (category != null ? category.getCategoryName() : "None") +"\n"+
               "Description: " + description + "\n";
    }

    // Getter for all transactions (for debugging or viewing purposes)
    public static List<Transaction> getAllTransactions() {
        return transactions;
    }
//method for to get old amount 
    public double getOldAmount() {
    	return oldAmount;
    }
    
//    method for deleted amount 
    public double deletedAmount() {
    	return deletedAmount ;
    }

    // Setter methods (optional, based on use case)
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory1(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}

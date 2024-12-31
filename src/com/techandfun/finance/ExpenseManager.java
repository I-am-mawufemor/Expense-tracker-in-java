package com.techandfun.finance;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
//**ExpenseManager Class**
//	   - Handles adding, updating, and deleting transactions.
//	   - Methods: `generateReport()`, `viewExpensesByCategory()`.	

	private List<Transaction> transactions = new ArrayList<>();
    private double totalIncome = 0.0;
    private double totalExpenses = 0.0;

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);

        if (transaction.getCategory().getCategoryName().equalsIgnoreCase("Income")) {
            totalIncome =totalIncome + transaction.getAmount() - transaction.getOldAmount();
        } else if (transaction.getCategory().getCategoryName().equalsIgnoreCase("Expenses")) {
            totalExpenses = totalExpenses + transaction.getAmount() - transaction.getOldAmount();
        }
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }
	
    
 // Method to display totals
    public void displayIncomeAndExpenseTotals() {
        double  incomeTotal= getTotalIncome();
        double expenseTotal = getTotalExpenses();

        System.out.println("\nIncome and Expense Summary:");
        System.out.println("Total Income: " + incomeTotal);
        System.out.println("Total Expenses: " + expenseTotal);
        System.out.println("Net Balance: " + (incomeTotal - expenseTotal));
    }
     
    
	
	
	/*	private List<Transaction>transaction = new ArrayList<>();

        	
    
    public void viewExpenseByCategory(String categoryName) {
    	System.out.println("\nExpenses for category: " + categoryName);
        for (Transaction transaction : transaction) {
            if (transaction.getCategory().getCategoryName().equalsIgnoreCase(categoryName)) {
                System.out.println(transaction.getTransactionDetails());
            }
        }
    }
    
    public void listAllTransactions() {
        System.out.println("\nAll Transactions:");
        for (Transaction transaction : Transaction.getAllTransactions()) {
            System.out.println(transaction.getTransactionDetails());
            
        }
    }*/
}




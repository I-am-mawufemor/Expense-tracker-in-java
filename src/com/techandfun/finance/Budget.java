package com.techandfun.finance;
import java.util.HashMap;
import java.util.Map; 

public class Budget {
//**BudgetManager Class**
//	   - Sets and manages budget for each category.
//	   - Methods: `setBudget()`, `checkBudgetStatus()`, `notifyBudgetExceed()`.

	//	Attributes 
	private Map<String, Double> budgets;
	private Map<String, Double>expenses;
	
	//constructor
	public Budget() {
		this.budgets = new HashMap<>();
		this.expenses = new HashMap<>();
	}
	
//	Method to the budget for a category
	public void setBudget(String categoryName, double amount) {
		
	
			if(amount < 1) {
				System.out.println("Budget Amount can not be a negative number");
				return;
			}
			budgets.put(categoryName, amount);
			System.out.println("Budget set for category: " + categoryName + " with amount: " + amount);
		}
		
	public void checkBudgetStatus() {
		
	}
}


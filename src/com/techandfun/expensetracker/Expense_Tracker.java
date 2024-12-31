package com.techandfun.expensetracker;
import java.util.Scanner;

import com.techandfun.finance.Category;
import com.techandfun.finance.Transaction;
import com.techandfun.finance.ExpenseManager;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException ;

public class Expense_Tracker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		 // Create an instance of ExpenseManager
        ExpenseManager manager = new ExpenseManager();	
	
		System.out.println("Fun and Tech Expense Tracker\n");
		int choice = -1;
		
		while (choice != 0) {
			    System.out.println("\nChoose an action:\n1. Add new transaction \n2. Update transaction \n3. Delete Transaction \n4. Genereate all transation \n5. Display total income, expenses and net expenses\n0. Exit ");
			    try {
			        choice = scanner.nextInt();
			        scanner.nextLine(); // Consume newline
			    } catch (InputMismatchException e) {
			        System.out.println("Invalid input. Please enter a number.");
			        scanner.nextLine(); // Clear invalid input
			        continue;
			    }

			    switch (choice) {
			        case 1:
			            // Add new transaction logic
//			        	prompt user to enter transaction Id;
						System.out.print("Enter transaction ID: ");
						String transactionId = scanner.nextLine();
						
						double amount = 0; 
						boolean validInput = false;
						while(!validInput) {
							//prompt user to enter amount
						System.out.print("Enter amount: ");
							try {
									amount = scanner.nextDouble();
									scanner.nextLine(); // Consume leftover newline
									validInput = true; // Input is valid, exit the loop			
								}catch(InputMismatchException e){
									System.out.println("Invalid input. Please enter a valid amount");
									scanner.nextLine();
								}
						}
						
//						Date prompt 
						LocalDate date = null;

						while (date == null) {
						    System.out.print("Enter date (yyyy-MM-dd): ");
						    String dateString = scanner.nextLine();  // Read the input as a string

						    try {
						        // Convert the input string to LocalDate
						        date = LocalDate.parse(dateString);  // Parse the string to LocalDate
						        System.out.println("Entered date: " + date);
						    } catch (DateTimeParseException e) {
						        System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
						        // The loop will continue, allowing the user to try again
						    }
						}
						
//				        prompt user to enter category
						System.out.print("Enter Category: ");
						String category = scanner.nextLine();
						Category cat = new Category(category, "100");
						
//						prompt user to enter description
						System.out.print("Enter description: ");
						String description = scanner.nextLine();
						
						// Create a transaction object
						 Transaction  transaction1 = new  Transaction (transactionId, date, amount, cat, description);
						 Transaction.addTransaction(transaction1);
						 manager.addTransaction(transaction1);
			            break;
			        
			        case 2:
			            // Update transaction logic
//						Update transaction 
						System.out.println("Enter ID of transaction you want to update: ");
						transactionId = scanner.nextLine();

//						define amount
						double newAmount = 0; 
//						set invalidInput to false 
						boolean invalidInput = false;
						
//						use while loop to iterate till invalidIput is true
						while(!invalidInput) {
//							prompt user to enter amount
							System.out.print("Enter new amount: ");
							try {
								newAmount = scanner.nextDouble();
								scanner.nextLine(); // Consume leftover newline
								invalidInput = true; // Input is valid, exit the loop
							}catch(InputMismatchException e) {
								System.out.println("Invalid Input. Enter valid new amount");
								scanner.nextLine();
							}
						}
					
//						Date prompt 
						LocalDate newDate = null;

						while (newDate == null) {
						    System.out.print("Enter date (yyyy-MM-dd): ");
						    String dateString = scanner.nextLine();  // Read the input as a string

						    try {
						        // Convert the input string to LocalDate
						        newDate = LocalDate.parse(dateString);  // Parse the string to LocalDate
						        System.out.println("Entered date: " + newDate);
						    } catch (DateTimeParseException e) {
						        System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
						        // The loop will continue, allowing the user to try again
						    }
						}
//				        prompt user to enter category
						System.out.print("Enter new Category: ");
						String newCategory = scanner.nextLine();
						Category newCat = new Category( newCategory, "100");
						
//						prompt user to enter description
						System.out.print("Enter description: ");
						String newDescription = scanner.nextLine();
						
//						call update method from Transaction class
						Transaction updateTransaction = new Transaction (transactionId, newDate, newAmount, newCat, newDescription );
						boolean isUpdated = Transaction.updatedTransaction(transactionId, updateTransaction);
//						verify if update has been successfull then updateTransaction to addTransaction
						if (isUpdated) {
						    manager.addTransaction(updateTransaction); // Add the updated transaction to the manager
						} else {
						    System.out.println("Failed to update transaction.");
						}
			            break;
			        
			        case 3:
			            // Delete transaction logic
			        	System.out.println("Enter ID of transaction you want to delete: ");
						transactionId = scanner.nextLine();
						Transaction.deleteTransaction(transactionId);
			            break;
			        case 4:
			        	// View all transaction
						System.out.println("\n\nAll Transactions:");
						for (Transaction t : Transaction.getAllTransactions()) {
						    System.out.println(t.getTransactionDetails()+ "\n");
						}
			            break;
			        case 5:
			            // View report
			            System.out.println("\n\nGenerate Report");
			            
			            // Generate a report for all transactions
			            manager.displayIncomeAndExpenseTotals();;

			            // Viewing expenses by category
			            
//			            manager.viewExpenseByCategory("");

			            // Listing all transactions
//			            manager.listAllTransactions();
			            
			            //List income 
//			            System.out.println("Total Income: "+manager.getTotalIncome() + "\n");
//			            total expense
//			            System.out.println("Total Expenses: "+manager.getTotalExpenses());
			            break;

			        case 0:
			            System.out.println("Exiting program.");
			            break;
			        default:
			            System.out.println("Wrong choice. Please try again.");
			    }
			}

			scanner.close(); // Close scanner at the end

			
		}
					
}	
			
//				 
//	
	


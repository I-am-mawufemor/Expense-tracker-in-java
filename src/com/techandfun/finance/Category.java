package com.techandfun.finance;
import java.util.ArrayList;
public class Category {
//**Category Class**
//	   - Attributes: `categoryId`, `categoryName`.
//	   - Methods: `addCategory()`, `deleteCategory()`, `getCategoryDetails()`.
	
	private String categoryName;
	private String categoryId;
	
//	static list to manage category
	private static  ArrayList<Category>categories = new ArrayList<>();

//	category constructor
	public Category(String categoryName, String categoryId){
		this.categoryName = categoryName;
		this.categoryId = categoryId;
	}
	
//	getters
	public String getCategoryName() {
		return categoryName;
	}
	public String getCategoryId() {
		return categoryId;
	}
//setters 

public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public void setCategoryId(String categoryId) {
	this.categoryId = categoryId;
}


//add categories method
public static void addCategory(Category category) {
	categories.add(category);
	System.out.println("Category add" + category.getCategoryDetails());
}

//delete categories method
public static void deleteCategory(String categoryId) {
	Category toDelete  = null;
	for(Category category : categories) {
		if(category.getCategoryId().equals(categoryId)) {
			toDelete = category;
			break;
		}
	}
	if(toDelete !=null) {
		categories.remove(toDelete);
		System.out.println("Category deleted: " + toDelete.getCategoryDetails());
	}else {
		System.out.println("Category not found with ID: "+ categoryId);
	}
}

//category details method
public String getCategoryDetails() {
return "Category ID: " + categoryId + ", Category Name: " + categoryName;
}

//Display all categories 
public static void displayAllCategories() {
	System.out.println("All Categories: ");
	for(Category category : categories) {
		System.out.println(category.getCategoryDetails());
	}
}

}

package model;

import views.ErrorDialog;

//class that contains the book and quantity number
public class CartItem {

	private Book book;
	private Integer quantity;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		if(quantity>book.getNoOfCopies())
		{
			new ErrorDialog().invoke("Not enough books! Only "+book.getNoOfCopies().toString()+" are left!");
			return;
		}
		this.quantity = quantity;
	}
	
}

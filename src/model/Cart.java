package model;

import java.util.ArrayList;

//This class contains all aspects related to the functioning of the cart
public class Cart {
//As cart is a session-bases setup and is not to be saved as such, it is not persisted to database
	
	ArrayList<Book> bookList=new ArrayList<Book>();
	
	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

	public void addBook(Book book)
	{
		bookList.add(book);
	}
	public void generateBill()
	{
		//		TODO
		// GENERATE PDF
	}
	public void deleteBook(Book book)
	{
		bookList.remove(book);
	}
	
	public void clearCart()
	{
		bookList.clear();
	}
	
	
	
}

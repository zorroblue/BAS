package model;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class SalesDay {
	//this class stores the details related to the books sold on a particular day
	//used for sales statistics
	
	//TODO : persisted to the database
	Integer salesId;
	List<Book> booksSold=new ArrayList<Book>();
	Date date;
	
	
	public Integer getSalesId() {
		return salesId;
	}
	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<Book> getBooksSold() {
		return booksSold;
	}
	public void setBooksSold(List<Book> booksSold) {
		this.booksSold = booksSold;
	}

}

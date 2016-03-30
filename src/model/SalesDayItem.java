package model;

import views.ErrorDialog;

//class that contains the book and quantity number 

//has to be persisted
public class SalesDayItem {

	private Integer salesItemId;
	private Book book;
	private Integer copiesSold;
	
	public Integer getSalesItemId() {
		return salesItemId;
	}
	
	SalesDayItem()
	{
		
	}
	
	SalesDayItem(Book book,Integer copiesSold)
	{
		this.book=book;
		this.copiesSold=copiesSold;
	}
	
	public void setSalesItemId(Integer salesItemId) {
		this.salesItemId = salesItemId;
	}
	
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getCopiesSold() {
		return copiesSold;
	}
	public void setCopiesSold(Integer copiesSold) {
		this.copiesSold = copiesSold;
	}
	
	
}

package model;

import java.io.File;

public class Book {

	private String bookTitle,authorName;
	private Publisher publisher;
	private Integer price;
	private Integer ISBN;
	private Integer noOfCopies=1;
	private Integer rackNo;
	private Integer noOfRequests;
	private Integer averageDays; //average number of days to procure the book
	private String imageFileName; //stores the location of the bitmap (additional and optional feaature to enhance UI)
	private Integer threshold; //stores the threshold of book required.1
	
	public Integer getThreshold() {
		return threshold;
	}

	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}

	public Book()
	{
		noOfRequests=0;
		imageFileName=new String("default.jpg");
	}
	
	public Integer getAverageDays() {
		return averageDays;
	}
	public void setAverageDays(Integer averageDays) {
		this.averageDays = averageDays;
	}
	
	
	
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle.toUpperCase();
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getISBN() {
		return ISBN;
	}
	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}
	public Integer getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	public Integer getRackNo() {
		return rackNo;
	}
	public void setRackNo(Integer rackNo) {
		this.rackNo = rackNo;
	}
	public Integer getNoOfRequests() {
		return noOfRequests;
	}
	public void setNoOfRequests(Integer noOfRequests) {
		this.noOfRequests = noOfRequests;
	}

	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	
	
	
}

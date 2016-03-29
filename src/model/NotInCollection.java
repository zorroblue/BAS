package model;

//this class contains "requests" for books that are not sold in the shop

public class NotInCollection
{
	//needs to be persisted.
	private Integer noOfRequests;
	private String bookTitle,authorName,publisherName;
	private Integer ISBNCode;
	public Integer getNoOfRequests() {
		return noOfRequests;
	}
	public void setNoOfRequests(Integer noOfRequests) {
		this.noOfRequests = noOfRequests;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public Integer getISBNCode() {
		return ISBNCode;
	}
	public void setISBNCode(Integer iSBNCode) {
		ISBNCode = iSBNCode;
	}
	
}

package model;

import java.util.Date;

public class Transaction {

	private Integer transactionId;
	private Date dateOfTransaction;
	private Integer bookISBN;
	private Integer noOfCopies;

	
	public Transaction()
	{
		noOfCopies=1;
	}
	
	public Transaction(Date dateOfTransaction,Integer bookISBN,Integer noOfCopies)
	{
		this.dateOfTransaction=dateOfTransaction;
		this.bookISBN=bookISBN;
		this.noOfCopies=noOfCopies;
	}


	public Integer getTransactionId() {
		return transactionId;
	}



	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}



	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public Integer getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(Integer bookISBN) {
		this.bookISBN = bookISBN;
	}

	public Integer getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
}

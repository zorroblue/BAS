package pdfwriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import model.Cart;
import model.CartItem;
import views.ErrorDialog;

public class ReportWriter {

 private BaseFont bfBold;
 private BaseFont bf;
 private int pageNumber = 0;


	public void createPDF (Cart cart){

	 String pdfFilename = "receipts/invoice.pdf";
	  
  Document doc = new Document();
  PdfWriter docWriter = null;
  initializeFonts();
  
  if(cart.getCart().isEmpty())
  {
	  new ErrorDialog().invoke("Items haven't been selected yet!");
	  return;
  }

  try {
   String path = "" + pdfFilename;
   docWriter = PdfWriter.getInstance(doc , new FileOutputStream(path));
   doc.addAuthor("Sales Clerk");
   doc.addCreationDate();
   doc.addProducer();
   doc.addCreator("ABC Book Stores");
   doc.addTitle("Invoice");
   doc.setPageSize(PageSize.LETTER);

   doc.open();
   PdfContentByte cb = docWriter.getDirectContent();
   
   boolean beginPage = true;
   int y = 0;
   Integer price=0;
   
   //writing the content
   int i=0;
   for(CartItem c: cart.getCart() ){
    if(beginPage){
     beginPage = false;
     generateLayout(doc, cb); 
     generateHeader(doc, cb);
     y = 615; 
    }
    price=price+c.getBook().getPrice()*c.getQuantity();
    generateDetail(doc, cb,i, c, y);
    y = y - 15;
    i++;
    if(y < 50){
     printPageNumber(cb);
     doc.newPage();
     beginPage = true;
    }
   }
   printPageNumber(cb);
   printTotalPrice(cb,price);
  }
  catch (DocumentException dex)
  {
   dex.printStackTrace();
  }
  catch (Exception ex)
  {
   ex.printStackTrace();
  }
  finally
  {
   if (doc != null)
   {
    doc.close();
   }
   if (docWriter != null)
   {
    docWriter.close();
   }
  }
 }

	private void printTotalPrice(PdfContentByte cb,Integer price)
	{
		 cb.beginText();
		  cb.setFontAndSize(bfBold, 12);
		  cb.showTextAligned(PdfContentByte.ALIGN_CENTER,new String("Total price= Rs."+price.toString()), 300 , 25, 0);
		  cb.endText();
	}
	
 private void generateLayout(Document doc, PdfContentByte cb)  {

  try {

   cb.setLineWidth(1f);

   // Invoice Header box layout
   cb.rectangle(420,700,150,60);
   cb.moveTo(420,720);
   cb.lineTo(570,720);
   cb.moveTo(420,740);
   cb.lineTo(570,740);
   cb.moveTo(480,700);
   cb.lineTo(480,760);
   cb.stroke();

   // Invoice Header box Text Headings 
   createHeadings(cb,422,743,"Employee");
   createHeadings(cb,422,723,"Invoice Date");
   createHeadings(cb,422,703,"Other details");

   // Invoice Detail box layout 
   cb.rectangle(20,50,550,600);
   cb.moveTo(20,630);
   cb.lineTo(570,630);
   cb.moveTo(50,50);
   cb.lineTo(50,650);
   cb.moveTo(150,50);
   cb.lineTo(150,650);
   cb.moveTo(430,50);
   cb.lineTo(430,650);
   cb.moveTo(500,50);
   cb.lineTo(500,650);
   cb.stroke();

   // Invoice Detail box Text Headings 
   createHeadings(cb,22,633,"S.No");
   createHeadings(cb,52,633,"Quantity");
   createHeadings(cb,152,633,"Book Name");
   createHeadings(cb,432,633,"Price");
   createHeadings(cb,502,633,"Total Price");

   //add the images
   Image companyLogo = Image.getInstance("images/image.jpg");
   companyLogo.setAbsolutePosition(25,700);
   companyLogo.scalePercent(25);
   doc.add(companyLogo);

  }

  catch (Exception dex){
   dex.printStackTrace();
  }
  

 }
 
 private void generateHeader(Document doc, PdfContentByte cb)  {

  try {

   createHeadings(cb,200,750,"ABC BOOK STORES");
   createHeadings(cb,200,735,"12,KK ROAD");
   createHeadings(cb,200,720,"MYLAPORE");
   createHeadings(cb,200,705,"CHENNAI, TAMIL NADU - 600028");
   createHeadings(cb,200,690,"INDIA");
   
   createHeadings(cb,482,743,"Ram");
   createHeadings(cb,482,723,new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
   createHeadings(cb,482,703,"-");

  }

  catch (Exception ex){
   ex.printStackTrace();
  }

 }
 
 private void generateDetail(Document doc, PdfContentByte cb,int index, CartItem c, int y)  {
  DecimalFormat df = new DecimalFormat("0.00");
  
  try {

   createContent(cb,48,y,String.valueOf(index+1),PdfContentByte.ALIGN_RIGHT);
   createContent(cb,52,y, String.valueOf(c.getQuantity()),PdfContentByte.ALIGN_LEFT);
   createContent(cb,152,y, c.getBook().getBookTitle(),PdfContentByte.ALIGN_LEFT);
   
   double price = Double.valueOf(df.format(Math.random() * 10));
   double extPrice = price * (index+1) ;
   createContent(cb,498,y, df.format(c.getBook().getPrice()),PdfContentByte.ALIGN_RIGHT);
   createContent(cb,568,y, df.format(c.getBook().getPrice()*c.getQuantity()),PdfContentByte.ALIGN_RIGHT);
   
  }

  catch (Exception ex){
   ex.printStackTrace();
  }

 }

 private void createHeadings(PdfContentByte cb, float x, float y, String text){


  cb.beginText();
  cb.setFontAndSize(bfBold, 8);
  cb.setTextMatrix(x,y);
  cb.showText(text.trim());
  cb.endText(); 

 }
 
 private void printPageNumber(PdfContentByte cb){


  cb.beginText();
  cb.setFontAndSize(bfBold, 8);
  cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, "Page No. " + (pageNumber+1), 570 , 25, 0);
  cb.endText(); 
  
  pageNumber++;
  
 }
 
 private void createContent(PdfContentByte cb, float x, float y, String text, int align){


  cb.beginText();
  cb.setFontAndSize(bf, 8);
  cb.showTextAligned(align, text.trim(), x , y, 0);
  cb.endText(); 

 }

 private void initializeFonts(){


  try {
   bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
   bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

  } catch (DocumentException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  }


 }

}
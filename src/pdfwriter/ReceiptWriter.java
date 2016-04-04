package pdfwriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.Cart;
import model.CartItem;
 

public class ReceiptWriter {
 
    public static final String DEST = "receipts/receipt.pdf";
 
    public void generatePdf(Cart cart) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ReceiptWriter().createPdf(DEST,cart);
    }
 
    public void createPdf(String dest,Cart cart) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100);
        List<List<String>> dataset = getData(cart);
        for (List<String> record : dataset) {
            for (String field : record) {
                table.addCell(field);
            }
        }
        document.add(table);
        document.close();
    }
 
    public List<List<String>> getData(Cart cart) {
        List<List<String>> data = new ArrayList<List<String>>();
       /* String[] tableTitleList = {" Title", " (Re)set", " Obs", " Mean", " Std.Dev", " Min", " Max", "Unit"};
        data.add(Arrays.asList(tableTitleList));
        for (int i = 0; i < 10; ) {
            List<String> dataLine = new ArrayList<String>();
            i++;
            for (int j = 0; j < tableTitleList.length; j++) {
                dataLine.add(tableTitleList[j] + " " + i);
            }
            data.add(dataLine);
        }*/
        
        ArrayList<CartItem> items=cart.getCart();
        //List<List<String>> data=new ArrayList<List<String>>();
        //
        for(CartItem c: items)
        {
        	
        }
        return data;
    }
}
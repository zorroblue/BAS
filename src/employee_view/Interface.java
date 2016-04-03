package employee_view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import dao.BookDao;
import model.Book;
import views.ErrorDialog;
import views.SuccessDialog;
import views.ToastMessage;

public class Interface {
	private static JTextField txtUsername;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JPasswordField passwordField;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTable table;
	private static JTextField txtISBN_sc;
	private static JTextField textField_6;
	private static JTextField txtBookTitle;
	private static JTextField txtAuthorName;
	private static JTextField txtPublisher;
	private static JTextField textField_10;
	private static JTextField textField_11;
	private static JTextField textField_12;
	private static JTextField textField_13;
	private static JTextField txtnoOfCopies;
	private static JTextField textField_15;
	private static JTextField textField_16;
	private static JTextField txtNoOfCopies;

	public static void application() {
		JFrame window = new JFrame("Book Shop Automation");
		window.setVisible(true);

		window.setSize(700, 500);
		//window.setResizable(false);

		window.getContentPane().setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		window.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel Customer = new JPanel();
		tabbedPane.addTab("Customer", null, Customer, null);
		Customer.setLayout(new CardLayout(0, 0));

		JPanel Query = new JPanel();
		Customer.add(Query, "name_22829458616742");
		Query.setLayout(null);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(408, 40, 89, 23);
		Query.add(btnSearch);

		textField = new JTextField();
		textField.setBounds(163, 41, 235, 20);
		Query.add(textField);
		textField.setColumns(10);

		JLabel lblSearchByBook = new JLabel("Search by Book title");
		lblSearchByBook.setBounds(39, 44, 114, 14);
		Query.add(lblSearchByBook);

		JLabel lblSearchByAuthor = new JLabel("Search by author");
		lblSearchByAuthor.setBounds(39, 81, 114, 14);
		Query.add(lblSearchByAuthor);

		textField_1 = new JTextField();
		textField_1.setBounds(163, 78, 235, 20);
		Query.add(textField_1);
		textField_1.setColumns(10);

		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.setBounds(408, 77, 89, 23);
		Query.add(btnSearch_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 123, 354, 259);
		Query.add(scrollPane);

		
		
		/*
		 *
		 JLabel lblMyCart = new JLabel("My Cart");
		lblMyCart.setBounds(557, 117, 46, 20);
		Query.add(lblMyCart);

		JList list = new JList();
		list.setBounds(493, 136, 164, 246);
		Query.add(list);

		  JButton btnEditCart = new JButton("Edit Cart");
		btnEditCart.setBounds(486, 382, 75, 23);
		Query.add(btnEditCart);

		JButton btnDeleteCart = new JButton("Delete Cart");
		btnDeleteCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDeleteCart.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDeleteCart.setBounds(590, 382, 89, 23);
		Query.add(btnDeleteCart);

		JButton btnFinaliseCart = new JButton("Finalise Cart");
		btnFinaliseCart.setBounds(527, 409, 103, 23);
		Query.add(btnFinaliseCart);
*/
		JButton btnViewSelectedBook = new JButton("View selected book");
		btnViewSelectedBook.setBounds(169, 409, 164, 23);
		Query.add(btnViewSelectedBook);

		
		
		
		JPanel viewBook = new JPanel();
		Customer.add(viewBook, "name_25346409520612");
		viewBook.setLayout(null);

		JLabel lblNewLabel = new JLabel("IMG");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(280, 22, 118, 141);
		viewBook.add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setBounds(58, 127, 46, 14);
		viewBook.add(label);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(190, 184, 289, 14);
		viewBook.add(lblNewLabel_1);

		JLabel lblAuthorName = new JLabel("Author Name : ");
		lblAuthorName.setBounds(190, 232, 133, 14);
		viewBook.add(lblAuthorName);

		JLabel lblPrice = new JLabel("Price : ");
		lblPrice.setBounds(190, 267, 110, 14);
		viewBook.add(lblPrice);

		JLabel lblNoOfCopies = new JLabel("Number of copies : ");
		lblNoOfCopies.setBounds(190, 336, 133, 14);
		viewBook.add(lblNoOfCopies);

		JLabel lblIsbn = new JLabel("ISBN : ");
		lblIsbn.setBounds(190, 372, 110, 14);
		viewBook.add(lblIsbn);

		JLabel mlblAName = new JLabel("New label");
		mlblAName.setBounds(414, 232, 101, 14);
		viewBook.add(mlblAName);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(414, 267, 110, 14);
		viewBook.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(414, 336, 89, 14);
		viewBook.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(414, 372, 89, 14);
		viewBook.add(lblNewLabel_4);

		JButton button = new JButton("< Back");
		button.setBounds(44, 409, 82, 23);
		viewBook.add(button);

		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.setBounds(280, 409, 118, 23);
		viewBook.add(btnAddToCart);

		JLabel lblRackNumber = new JLabel("Rack Number : ");
		lblRackNumber.setBounds(190, 304, 110, 14);
		viewBook.add(lblRackNumber);

		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(414, 304, 46, 14);
		viewBook.add(lblNewLabel_5);

		JPanel paymentPanel = new JPanel();
		Customer.add(paymentPanel, "name_110213687162882");
		paymentPanel.setLayout(null);

		JLabel lblListOf = new JLabel("The list of books you wish to buy : ");
		lblListOf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblListOf.setBounds(225, 45, 239, 14);
		paymentPanel.add(lblListOf);

		JLabel lblNetAmount = new JLabel("Net amount  : ");
		lblNetAmount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNetAmount.setBounds(225, 361, 178, 14);
		paymentPanel.add(lblNetAmount);

		JButton button_1 = new JButton("< Back ");
		button_1.setBounds(20, 409, 89, 23);
		paymentPanel.add(button_1);

		JButton btnProceedToPayment = new JButton("Proceed to payment");
		btnProceedToPayment.setBounds(470, 409, 145, 23);
		paymentPanel.add(btnProceedToPayment);

		table = new JTable();
		table.setBounds(185, 83, 331, 259);
		paymentPanel.add(table);

		JPanel orderBookPanel = new JPanel();
		Customer.add(orderBookPanel, "name_117790567923386");
		orderBookPanel.setLayout(null);

		JLabel lblBookTitle = new JLabel("Book Title : ");
		lblBookTitle.setBounds(154, 112, 82, 14);
		orderBookPanel.add(lblBookTitle);

		textField_2 = new JTextField();
		textField_2.setBounds(288, 109, 159, 20);
		orderBookPanel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblAuthorName_1 = new JLabel("Author Name : ");
		lblAuthorName_1.setBounds(153, 157, 83, 14);
		orderBookPanel.add(lblAuthorName_1);

		textField_3 = new JTextField();
		textField_3.setBounds(288, 154, 159, 20);
		orderBookPanel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblPublisher = new JLabel("Publisher : ");
		lblPublisher.setBounds(154, 210, 97, 14);
		orderBookPanel.add(lblPublisher);

		textField_4 = new JTextField();
		textField_4.setBounds(288, 207, 159, 20);
		orderBookPanel.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblFillInThese = new JLabel("Fill in these details for the procurement of the book");
		lblFillInThese.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFillInThese.setBounds(166, 34, 340, 14);
		orderBookPanel.add(lblFillInThese);

		JButton btnPlaceOrder = new JButton("Place order");
		btnPlaceOrder.setBounds(259, 312, 104, 23);
		orderBookPanel.add(btnPlaceOrder);

		JLabel lblIsbn_3 = new JLabel("ISBN : ");
		lblIsbn_3.setBounds(154, 266, 46, 14);
		orderBookPanel.add(lblIsbn_3);

		textField_16 = new JTextField();
		textField_16.setBounds(288, 263, 159, 20);
		orderBookPanel.add(textField_16);
		textField_16.setColumns(10);

		
		JPanel Employee = new JPanel();
		tabbedPane.addTab("Employee", null, Employee, null);
		Employee.setLayout(new CardLayout(0, 0));

		JPanel loginPanel = new JPanel();
		Employee.add(loginPanel, "name_22371360198077");
		loginPanel.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(209, 133, 94, 14);
		loginPanel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(208, 187, 79, 14);
		loginPanel.add(lblPassword);

		txtUsername = new JTextField();
		txtUsername.setBounds(364, 130, 130, 20);
		loginPanel.add(txtUsername);
		txtUsername.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnLogin.setBounds(293, 263, 89, 35);
		loginPanel.add(btnLogin);

		passwordField = new JPasswordField();
		passwordField.setBounds(364, 183, 130, 23);
		loginPanel.add(passwordField);
		
		

		JPanel statisticsPanel = new JPanel();
		Employee.add(statisticsPanel, "name_177266559159994");
		statisticsPanel.setLayout(null);

		JButton btnVisualData = new JButton("Visual data");
		btnVisualData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVisualData.setBounds(569, 27, 97, 23);
		statisticsPanel.add(btnVisualData);

		JTextArea statisticsArea = new JTextArea();
		statisticsArea.setBounds(117, 61, 483, 360);
		statisticsPanel.add(statisticsArea);

		JLabel lblStartDate = new JLabel("Start Date : ");
		lblStartDate.setBounds(54, 27, 89, 14);
		statisticsPanel.add(lblStartDate);

		JLabel lblLastDate = new JLabel("Last Date : ");
		lblLastDate.setBounds(256, 27, 89, 14);
		statisticsPanel.add(lblLastDate);

		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(153, 27, 46, 14);
		statisticsPanel.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(367, 27, 46, 14);
		statisticsPanel.add(lblNewLabel_10);

		JPanel ownerPanel = new JPanel();
		Employee.add(ownerPanel, "name_110106080647965");
		ownerPanel.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("View Sales Statistics");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(263, 49, 135, 14);
		ownerPanel.add(lblNewLabel_8);

		JLabel lblEnterStartDate = new JLabel("Start date : ");
		lblEnterStartDate.setBounds(131, 168, 101, 14);
		ownerPanel.add(lblEnterStartDate);

		JButton button_2 = new JButton("Get statistics");
		button_2.setBounds(263, 320, 112, 38);
		ownerPanel.add(button_2);

		JLabel lblEnterLastDate = new JLabel("Last date : ");
		lblEnterLastDate.setBounds(131, 229, 101, 14);
		ownerPanel.add(lblEnterLastDate);

		JLabel lblEnterTheDates = new JLabel("Enter the dates for which sales statistics have to be shown :");
		lblEnterTheDates.setBounds(131, 116, 327, 14);
		ownerPanel.add(lblEnterTheDates);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(220, 168, 155, 20);
		ownerPanel.add(dateChooser);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(220, 229, 155, 20);
		ownerPanel.add(dateChooser_1);

		JPanel generalPanel = new JPanel();
		Employee.add(generalPanel, "name_23515077757223");
		generalPanel.setLayout(null);

		JLabel lblUpdateTheDatabase = new JLabel("Update the database : ");
		lblUpdateTheDatabase.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUpdateTheDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateTheDatabase.setBounds(255, 72, 142, 14);
		generalPanel.add(lblUpdateTheDatabase);

		JLabel lblIsbn_2 = new JLabel("ISBN :");
		lblIsbn_2.setBounds(100, 120, 46, 14);
		generalPanel.add(lblIsbn_2);

		textField_6 = new JTextField();
		textField_6.setBounds(207, 117, 208, 20);
		generalPanel.add(textField_6);
		textField_6.setColumns(10);

		JButton btnFind = new JButton("Find");
		btnFind.setBounds(439, 116, 89, 23);
		generalPanel.add(btnFind);

		JPanel panel = new JPanel();
		panel.setBounds(79, 161, 541, 255);
		generalPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel(
				"This book is not already a part of a database. Fill out these details to add the book : ");
		lblNewLabel_11.setBounds(55, 11, 425, 14);
		panel.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("Book title");
		lblNewLabel_12.setBounds(29, 36, 61, 14);
		panel.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Author Name");
		lblNewLabel_13.setBounds(29, 72, 73, 14);
		panel.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("Publisher");
		lblNewLabel_14.setBounds(29, 114, 46, 14);
		panel.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("Price");
		lblNewLabel_15.setBounds(29, 192, 46, 14);
		panel.add(lblNewLabel_15);

		JLabel lblNewLabel_16 = new JLabel("Image file location");
		lblNewLabel_16.setBounds(29, 153, 101, 14);
		panel.add(lblNewLabel_16);

		JLabel lblNewLabel_18 = new JLabel("Inventory Level");
		lblNewLabel_18.setBounds(359, 192, 89, 14);
		panel.add(lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel("Rack number ");
		lblNewLabel_19.setBounds(359, 114, 73, 14);
		panel.add(lblNewLabel_19);

		JLabel lblNewLabel_20 = new JLabel("Number of copies");
		lblNewLabel_20.setBounds(359, 150, 89, 14);
		panel.add(lblNewLabel_20);

		txtBookTitle = new JTextField();
		txtBookTitle.setBounds(141, 36, 194, 20);
		panel.add(txtBookTitle);
		txtBookTitle.setColumns(10);

		txtAuthorName = new JTextField();
		txtAuthorName.setBounds(141, 69, 194, 20);
		panel.add(txtAuthorName);
		txtAuthorName.setColumns(10);

		txtPublisher = new JTextField();
		txtPublisher.setBounds(141, 111, 187, 20);
		panel.add(txtPublisher);
		txtPublisher.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setBounds(141, 189, 38, 20);
		panel.add(textField_10);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setBounds(140, 150, 86, 20);
		panel.add(textField_11);
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setBounds(464, 111, 46, 20);
		panel.add(textField_12);
		textField_12.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setBounds(464, 147, 46, 20);
		panel.add(textField_13);
		textField_13.setColumns(10);

		txtnoOfCopies = new JTextField();
		txtnoOfCopies.setBounds(464, 189, 46, 20);
		panel.add(txtnoOfCopies);
		txtnoOfCopies.setColumns(10);

		JLabel lblNumberOfCopies = new JLabel("Number of copies");
		lblNumberOfCopies.setBounds(71, 61, 129, 14);
		panel.add(lblNumberOfCopies);

		textField_15 = new JTextField();
		textField_15.setBounds(236, 58, 46, 20);
		panel.add(textField_15);
		textField_15.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(33, 189, 619, 142);
		generalPanel.add(panel_1);
		panel_1.setLayout(null);

		JPanel managerPanel = new JPanel();
		Employee.add(managerPanel, "name_23429361542622");
		managerPanel.setLayout(null);

		JButton btnViewRequests = new JButton("View requests");
		btnViewRequests.setBounds(266, 229, 129, 23);
		managerPanel.add(btnViewRequests);

		JButton btnUpdateDatabase = new JButton("Update database");
		btnUpdateDatabase.setBounds(266, 179, 129, 23);
		managerPanel.add(btnUpdateDatabase);
		// Owner.setLayout(null);

		JPanel salesclerkPanel = new JPanel();
		Employee.add(salesclerkPanel, "name_23371904062736");
		salesclerkPanel.setLayout(null);

		txtISBN_sc = new JTextField();
		txtISBN_sc.setBounds(351, 154, 168, 20);
		salesclerkPanel.add(txtISBN_sc);
		txtISBN_sc.setColumns(10);

		JLabel lblIsbn_1 = new JLabel("ISBN : ");
		lblIsbn_1.setBounds(251, 157, 59, 14);
		salesclerkPanel.add(lblIsbn_1);

		JLabel lblEnterTheIsbn = new JLabel("Enter the ISBN number of the following book :");
		lblEnterTheIsbn.setBounds(230, 84, 302, 14);
		salesclerkPanel.add(lblEnterTheIsbn);

		JLabel lblNewLabel_6 = new JLabel("Book title : ");
		lblNewLabel_6.setBounds(251, 119, 59, 14);
		salesclerkPanel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(351, 119, 223, 14);
		salesclerkPanel.add(lblNewLabel_7);

		JButton btnNext = new JButton("Next book ->");
		btnNext.setBounds(478, 318, 153, 23);
		salesclerkPanel.add(btnNext);
		
		JLabel lblNoOfCopies_1 = new JLabel("No Of copies");
		lblNoOfCopies_1.setBounds(251, 193, 70, 15);
		salesclerkPanel.add(lblNoOfCopies_1);
		
		txtNoOfCopies = new JTextField();
		txtNoOfCopies.setBounds(351, 186, 168, 19);
		salesclerkPanel.add(txtNoOfCopies);
		txtNoOfCopies.setColumns(10);
		
		JButton btnGenerateReceipt = new JButton("GENERATE RECEIPT");
		btnGenerateReceipt.setBounds(265, 370, 139, 25);
		salesclerkPanel.add(btnGenerateReceipt);
		
		
		managerPanel.setVisible(false);
		generalPanel.setVisible(false);
		salesclerkPanel.setVisible(false);
		loginPanel.setVisible(true);
		ownerPanel.setVisible(false);
		
		Query.setVisible(true);
		viewBook.setVisible(false);
		
		
		// all button listeners are here
		//added by rameshwar
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//hardcoding the login for now
				System.out.println(txtUsername.getText()+" "+passwordField.getText());
				if(txtUsername.getText().equals("manager")&&passwordField.getText().equals("manager123"))
				{
					
					//new SuccessDialog().invoke("Successful login as manager");
					new ToastMessage("Successful login", 1000).setVisible(true);;
					loginPanel.setVisible(false);
					managerPanel.setVisible(true);
				}
				else if(txtUsername.getText().equals("salesclerk") && passwordField.getText().equals("salesclerk123"))
				{
					new SuccessDialog().invoke("Successful login as sales clerk");
					loginPanel.setVisible(false);
					salesclerkPanel.setVisible(true);
				}
				else if(passwordField.getText().equals("emp123") && (txtUsername.getText().equals("emp1") || txtUsername.getText().equals("emp2") || txtUsername.getText().equals("emp3")))
				{
					new SuccessDialog().invoke("Successful login as employee");
					loginPanel.setVisible(false);
					generalPanel.setVisible(true);
				}
				else if(passwordField.getText().equals("owner123") && txtUsername.getText().equals("owner"))
				{
					new SuccessDialog().invoke("Successful login as owner");
					loginPanel.setVisible(false);
					ownerPanel.setVisible(true);
				}
				else
				{
					new ErrorDialog().invoke("Incorrect credentials");
					passwordField.setText("");
				}
			}
		});
		
		btnUpdateDatabase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				managerPanel.setVisible(false);
				generalPanel.setVisible(true);
			}
		});
		
	
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				viewBook.setVisible(false);
				Query.setVisible(true);
			}
		});
		
		//find of isbn in update database
		btnFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					Integer ISBN=Integer.valueOf(textField_6.getText().toString());
					if(new BookDao().doesBookExist(ISBN))
					{
						new SuccessDialog().invoke("Book exists");
						
						//TODO fill details now
						//LATEST TODO
						txtBookTitle.setText(new BookDao().getBookByISBN(ISBN).getBookTitle());
					}
					else
					{
						new ErrorDialog().invoke("This book isn't registered in database! Please register");
					}
				}
				catch(Exception e1)
				{
					new ErrorDialog().invoke("Your request could not be processed");
				}
				
			}
		});
		
	//next button of sales clerk	
	btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//validate existing book
				//TODO : CHECK IF ALL COLUMNS ARE FILLED
				
				try
				{
					Integer ISBN=Integer.valueOf(txtISBN_sc.getText());
					if(!new BookDao().doesBookExist(ISBN))
					{
						new ErrorDialog().invoke("Book does not exist in database");
						return;
					}
					else
					{
						Book thebook=new BookDao().getBookByISBN(ISBN);
						if(thebook.getNoOfCopies()< Integer.valueOf(txtNoOfCopies.getText()))
						{
							//not enough books to sell
							new ErrorDialog().invoke("Sorry! There are only "+thebook.getNoOfCopies()+" copies left!");
						}
					}	
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
	
	//search button of query by title
	btnSearch.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String title=textField.getText();
			try
			{
				if(title==null || title.equals(""))
				{
					new ErrorDialog().invoke("Please enter the book title");
					return;
				}
				List<Book> bookList=new BookDao().getBooksByTitle(title);
				if(bookList==null || bookList.isEmpty())
				{
					JDialog.setDefaultLookAndFeelDecorated(true);
					int response=JOptionPane.showConfirmDialog(Query, "No such book in database! Do you want to request for it?", "Not in database", JOptionPane.INFORMATION_MESSAGE);
					if(response==JOptionPane.YES_OPTION)
					{
						Query.setVisible(false);
						orderBookPanel.setVisible(true);
					}
					//TODO ADD TO LIST
					
					
				}
			}
			catch(Exception e)
			{
				return;
			}
		}
	});

	btnSearch_1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String title=textField_1.getText();
			try
			{
				List<Book> bookList=new BookDao().getBooksByAuthorName(title);
				if(title==null || title.equals(""))
				{
					new ErrorDialog().invoke("Please enter the author name");
					return;
				}
				if(bookList==null || bookList.isEmpty())
				{
					JDialog.setDefaultLookAndFeelDecorated(true);
					int response=JOptionPane.showConfirmDialog(Query, "No such book in database! Do you want to request for it?", "Not in database", JOptionPane.INFORMATION_MESSAGE);
					if(response==JOptionPane.YES_OPTION)
					{
						Query.setVisible(false);
						orderBookPanel.setVisible(true);
				}
					//TODO ADD TO LIST
					
					
				}
			}
			catch(Exception e)
			{
				return;
			}
		}
	});

	
	

	}
	public static void main(String[] args) 
	{
		application();
	}
}

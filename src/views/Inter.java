package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Inter {
	private static JTextField txtUsername;
	private static JTextField txtPassword;
	private static JTextField textField;
	private static JTextField textField_1;

	public static void application() {
		JFrame window = new JFrame("Book Shop Automation");
		window.setVisible(true);

		window.setSize(1000, 1500);
		//window.setResizable(false);

		window.getContentPane().setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		window.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel Customer = new JPanel();
		tabbedPane.addTab("Customer", null, Customer, null);
		Customer.setLayout(new CardLayout(0, 0));

		JPanel viewBook = new JPanel();
		Customer.add(viewBook, "name_25346409520612");
		viewBook.setLayout(null);

		JLabel lblNewLabel = new JLabel("IMG");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(281, 31, 118, 158);
		viewBook.add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setBounds(58, 127, 46, 14);
		viewBook.add(label);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(200, 200, 289, 14);
		viewBook.add(lblNewLabel_1);

		JLabel lblAuthorName = new JLabel("Author Name : ");
		lblAuthorName.setBounds(190, 265, 93, 14);
		viewBook.add(lblAuthorName);

		JLabel lblPrice = new JLabel("Price : ");
		lblPrice.setBounds(190, 298, 46, 14);
		viewBook.add(lblPrice);

		JLabel lblNoOfCopies = new JLabel("Number of copies : ");
		lblNoOfCopies.setBounds(190, 334, 93, 14);
		viewBook.add(lblNoOfCopies);

		JLabel lblIsbn = new JLabel("ISBN : ");
		lblIsbn.setBounds(190, 372, 46, 14);
		viewBook.add(lblIsbn);

		JLabel mlblAName = new JLabel("New label");
		mlblAName.setBounds(414, 265, 46, 14);
		viewBook.add(mlblAName);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(414, 298, 46, 14);
		viewBook.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(414, 334, 46, 14);
		viewBook.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(414, 372, 46, 14);
		viewBook.add(lblNewLabel_4);

		JButton button = new JButton("< Back");
		button.setBounds(190, 409, 89, 23);
		viewBook.add(button);

		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.setBounds(371, 409, 89, 23);
		viewBook.add(btnAddToCart);

		JPanel Query = new JPanel();
		Customer.add(Query, "name_22829458616742");
		Query.setLayout(null);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
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
		btnDeleteCart.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDeleteCart.setBounds(590, 382, 89, 23);
		Query.add(btnDeleteCart);

		JButton btnFinaliseCart = new JButton("Finalise Cart");
		btnFinaliseCart.setBounds(527, 409, 103, 23);
		Query.add(btnFinaliseCart);

		JPanel Employee = new JPanel();
		tabbedPane.addTab("Employee", null, Employee, null);
		Employee.setLayout(new CardLayout(0, 0));

		JPanel Login = new JPanel();
		Employee.add(Login, "name_22371360198077");
		Login.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(139, 133, 100, 14);
		Login.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(139, 160, 46, 14);
		Login.add(lblPassword);

		txtUsername = new JTextField();
		txtUsername.setBounds(233, 130, 130, 20);
		Login.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setBounds(233, 158, 130, 20);
		Login.add(txtPassword);
		txtPassword.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(203, 245, 89, 23);
		Login.add(btnLogin);

		JPanel General = new JPanel();
		Employee.add(General, "name_23515077757223");
		General.setLayout(null);

		JButton btnNewButton = new JButton("Edit database");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(236, 139, 115, 23);
		General.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(236, 196, 115, 23);
		General.add(btnNewButton_1);

		JPanel Manager = new JPanel();
		Employee.add(Manager, "name_23429361542622");
		Manager.setLayout(null);

		JButton btnViewRequests = new JButton("View requests");
		btnViewRequests.setBounds(241, 228, 109, 23);
		Manager.add(btnViewRequests);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(241, 178, 89, 23);
		Manager.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(241, 128, 89, 23);
		Manager.add(btnNewButton_3);

		JPanel Owner = new JPanel();
		Employee.add(Owner, "name_23466116106047");
		Owner.setLayout(null);

		JButton btnViewStatistics = new JButton("View statistics");
		btnViewStatistics.setBounds(256, 229, 124, 23);
		Owner.add(btnViewStatistics);

		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(255, 195, 89, 23);
		Owner.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(256, 161, 89, 23);
		Owner.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(256, 127, 89, 23);
		Owner.add(btnNewButton_6);

		JPanel SalesClerk = new JPanel();
		Employee.add(SalesClerk, "name_23371904062736");
		SalesClerk.setLayout(null);

		JButton btnGenerateReceipt = new JButton("Generate Receipt");
		btnGenerateReceipt.setBounds(259, 153, 117, 23);
		SalesClerk.add(btnGenerateReceipt);

	}

	public static void main(String[] args) {
		application();
	}
	
}
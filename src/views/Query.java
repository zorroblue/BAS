package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Insets;
import javax.swing.JButton;

public class Query {

	private static JFrame frame;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query window = new Query();
				
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					window.frame.setVisible(true);
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Query() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblBookAutomationSoftware = new JLabel("BOOK AUTOMATION SOFTWARE");
		GridBagConstraints gbc_lblBookAutomationSoftware = new GridBagConstraints();

		gbc_lblBookAutomationSoftware.insets = new Insets(0, 0, 5, 5);
		gbc_lblBookAutomationSoftware.gridx = 1;
		gbc_lblBookAutomationSoftware.gridy = 0;
		panel_1.add(lblBookAutomationSoftware, gbc_lblBookAutomationSoftware);
		
		JLabel lblEnterBookName = new JLabel("Enter book name");
		GridBagConstraints gbc_lblEnterBookName = new GridBagConstraints();
		gbc_lblEnterBookName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterBookName.gridx = 0;
		gbc_lblEnterBookName.gridy = 8;
		panel_1.add(lblEnterBookName, gbc_lblEnterBookName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 8;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 2;
		gbc_btnSubmit.gridy = 12;
		panel_1.add(btnSubmit, gbc_btnSubmit);
		btnSubmit.setBackground(Color.BLUE);
	}

}

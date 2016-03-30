package views;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SuccessDialog {

	public void invoke(String successMessage)
	{
		JOptionPane.showMessageDialog(new JFrame(), successMessage,"Dialog",JOptionPane.INFORMATION_MESSAGE);
	}
	
}

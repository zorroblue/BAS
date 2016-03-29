package views;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorDialog {

	public void invoke(String errorMessage)
	{
		JOptionPane.showMessageDialog(new JFrame(), errorMessage,"Dialog",JOptionPane.ERROR_MESSAGE);
	}
	
}

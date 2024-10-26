import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
class SearchOption extends JFrame{
	private JLabel lblTitle;
	private JButton btnSearchcustomer;
	private JButton btnSearchorder;
	private JButton btnCancel;
	
	SearchOption(){

		JFrame f = new JFrame();
        String[] options = {"Search Customer", "Search Order" , "Cancel"};
        int selectedOption = JOptionPane.showOptionDialog(
                f,
               "Please Select the option",
                "Search Option",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0] 
        );
        
        if (selectedOption == 0) {
            new SearchCustomer().setVisible(true);
            dispose();
        } else if (selectedOption == 1) {
			new SearchOrder().setVisible(true);
			dispose();
         } else if (selectedOption == 2) {
			 new Homepage().setVisible(true);
            dispose();
        }
	
	}
}



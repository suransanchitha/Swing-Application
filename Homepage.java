import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Homepage extends JFrame{
	private JLabel lblTitle;
	private JButton btnSearch;
	private JButton btnStatus;
	private JButton btnReports;
	private JButton btnDelete;
	private JButton btnPlaceOrder;
	
	Homepage(){
		setSize(400,450);
		setTitle("Fashion Shop");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel buttonPanel=new JPanel(new GridLayout(5,1));
		lblTitle=new JLabel("Fashion Shop");
		lblTitle.setFont(new Font("",1,30));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		add("North",lblTitle);
		
		btnSearch=new JButton("Search");
		btnSearch.setFont(new Font("",1,15));
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new SearchOption().setVisible(true);
				dispose();
			}
		});
		
		buttonPanel.add(btnSearch);
		add("West",buttonPanel);
		
		btnStatus=new JButton("Status");
		btnStatus.setFont(new Font("",1,15));
		btnStatus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new OrderStatus().setVisible(true);
				dispose();
			}
		});
		
		buttonPanel.add(btnStatus);
		add("West",buttonPanel);
		
		btnReports=new JButton("Reports");
		btnReports.setFont(new Font("",1,15));
		btnReports.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new ViewReports().setVisible(true);
				dispose();
			}
		});
		
		buttonPanel.add(btnReports);
		add("West",buttonPanel);
		
		btnDelete=new JButton("Delete");
		btnDelete.setFont(new Font("",1,15));
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new DeleteOrder().setVisible(true);
				dispose();
			}
		});
		
		buttonPanel.add(btnDelete);
		
		add("Center",buttonPanel);
		
		btnPlaceOrder=new JButton("PlaceOrder");
		btnPlaceOrder.setFont(new Font("",1,30));
		btnPlaceOrder.setBackground(Color.GREEN);
		btnPlaceOrder.setForeground(Color.BLACK);
		btnPlaceOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new Placeorder().setVisible(true);
				dispose();
			}
		});
		buttonPanel.add(btnPlaceOrder);
		add("West",buttonPanel);
		
  
	}
	
	
}


import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
class ViewReports extends JFrame{
	
	private JButton btnBack;
	private JButton btnViewCustomers;
	private JButton btnBestCustomers;
	private JButton btnAllCustomers;
	private JButton btnCategByQty;
	private JButton btnCategByAmount;
	private JButton btnOrdersAmount;
	private JButton btnAllOrders;
	
	ViewReports(){
		
		setSize(600,300);
		setTitle("View Reports");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));	
		btnBack=new JButton("Back");
		btnBack.setFont(new Font("",1,15));
		btnBack.setBackground(Color.RED);
		btnBack.setForeground(Color.WHITE);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new Homepage().setVisible(true);
				dispose();
			}
				});
				
		buttonPanel.add(btnBack);
		add("North",buttonPanel);
		
		JPanel buttonPanel2=new JPanel(new GridLayout(3,1)); 	
		btnViewCustomers=new JButton("View Customers");
		btnViewCustomers.setFont(new Font("",1,15));
		btnViewCustomers.setBackground(Color.GREEN);
		btnViewCustomers.setForeground(Color.WHITE);
		btnViewCustomers.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new CustomerReports().setVisible(true);
				dispose();
			}
				});
				
		buttonPanel2.add(btnViewCustomers);
		
		btnBestCustomers=new JButton("Best in Customers");
		btnBestCustomers.setFont(new Font("",1,15));
		btnBestCustomers.setBackground(Color.GREEN);
		btnBestCustomers.setForeground(Color.WHITE);
		btnBestCustomers.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new BestCustomerReports().setVisible(true);
				dispose();
			}
				});
				
		buttonPanel2.add(btnBestCustomers);
		
		btnAllCustomers=new JButton("All Customers");
		btnAllCustomers.setFont(new Font("",1,15));
		btnAllCustomers.setBackground(Color.GREEN);
		btnAllCustomers.setForeground(Color.WHITE);
		btnAllCustomers.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new AllCustomerReports().setVisible(true);
				dispose();
			}
				});
				
		buttonPanel2.add(btnAllCustomers);
		add("West",buttonPanel2);
		
		JPanel buttonPanel3=new JPanel(new GridLayout(2,1)); 	
		btnCategByQty=new JButton("Categorized By Qty");
		btnCategByQty.setFont(new Font("",1,15));
		btnCategByQty.setBackground(Color.BLUE);
		btnCategByQty.setForeground(Color.WHITE);
		btnCategByQty.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
				new SortByQty().setVisible(true);
				dispose();
			}
				});
		
		buttonPanel3.add(btnCategByQty);
		
		btnCategByAmount=new JButton("Categorized By Amount");
		btnCategByAmount.setFont(new Font("",1,15));
		btnCategByAmount.setBackground(Color.BLUE);
		btnCategByAmount.setForeground(Color.WHITE);
		btnCategByAmount.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
				new SortByAmount().setVisible(true);
				dispose();
			}
				});
				
		buttonPanel3.add(btnCategByAmount);
		add("Center",buttonPanel3);
		
		JPanel buttonPanel4=new JPanel(new GridLayout(2,1)); 
		btnOrdersAmount=new JButton("Orders By Amount");
		btnOrdersAmount.setFont(new Font("",1,15));
		btnOrdersAmount.setBackground(Color.BLACK);
		btnOrdersAmount.setForeground(Color.WHITE);
		btnOrdersAmount.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
				new OrderByAmount().setVisible(true);
				dispose();
			}
				});
				
		buttonPanel4.add(btnOrdersAmount);
		
		btnAllOrders=new JButton("All Orders");
		btnAllOrders.setFont(new Font("",1,15));
		btnAllOrders.setBackground(Color.BLACK);
		btnAllOrders.setForeground(Color.WHITE);
		btnAllOrders.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
				new AllOrders().setVisible(true);
				dispose();
			}
				});
				
		buttonPanel4.add(btnAllOrders);
		add("East",buttonPanel4);
		
		}
	
	
	}


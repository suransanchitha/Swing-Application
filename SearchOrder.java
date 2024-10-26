import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
class SearchOrder extends JFrame{
	private JButton btnBack;
	private JLabel lblOrderid;
	private JLabel lblCustomerid;
	private JLabel lblSize;
	private JLabel lblQty;
	private JLabel lblAmount;
	private JLabel lblStatus;
	private JTextField txtId;
	private JTextField txtCustId;
	private JTextField txtSize;
	private JTextField txtQty;
	private JTextField txtAmount;
	private JTextField txtStatus;
	private JButton btnSearch;
	
	Datastore d1=new Datastore();

	SearchOrder(){
		setSize(500,400);
		setTitle("Search Order");
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
		
		JPanel labelPanel=new JPanel(new GridLayout(8,1));
	
		lblOrderid=new JLabel("      Enter Order ID :   ");
		lblOrderid.setFont(new Font("",1,15));
		labelPanel.add(lblOrderid);

		lblCustomerid=new JLabel("      Customer ID :   ");
		lblCustomerid.setFont(new Font("",1,15));
		labelPanel.add(lblCustomerid);
		
		lblSize=new JLabel("      Size :   ");
		lblSize.setFont(new Font("",1,15));
		labelPanel.add(lblSize);
		
		lblQty=new JLabel("      Qty :   ");
		lblQty.setFont(new Font("",1,15));
		labelPanel.add(lblQty);
		
		lblAmount=new JLabel("      Amount :   ");
		lblAmount.setFont(new Font("",1,15));
		labelPanel.add(lblAmount);
		
		lblStatus=new JLabel("      Status :   ");
		lblStatus.setFont(new Font("",1,15));
		labelPanel.add(lblStatus);
	
		add("West",labelPanel);
		
		JPanel textPanel=new JPanel(new GridLayout(8,1));
		
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtId=new JTextField(10);
		txtId.setFont(new Font("",1,15));
		idTextPanel.add(txtId);
		textPanel.add(idTextPanel);
		
		JPanel CustIdTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtCustId=new JTextField(10);
		txtCustId.setFont(new Font("",1,15));
		CustIdTextPanel.add(txtCustId);
		textPanel.add(CustIdTextPanel);
		
		JPanel SizeTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtSize=new JTextField(10);
		txtSize.setFont(new Font("",1,15));
		SizeTextPanel.add(txtSize);
		textPanel.add(SizeTextPanel);
		
		JPanel QtyTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtQty=new JTextField(10);
		txtQty.setFont(new Font("",1,15));
		QtyTextPanel.add(txtQty);
		textPanel.add(QtyTextPanel);
		
		JPanel AmountTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtAmount=new JTextField(10);
		txtAmount.setFont(new Font("",1,15));
		AmountTextPanel.add(txtAmount);
		textPanel.add(AmountTextPanel);
		
		JPanel StatusTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtStatus=new JTextField(10);
		txtStatus.setFont(new Font("",1,15));
		StatusTextPanel.add(txtStatus);
		textPanel.add(StatusTextPanel);
		
		add("Center",textPanel);
		
		JPanel buttonPanel2=new JPanel(new FlowLayout(FlowLayout.RIGHT));	
		btnSearch=new JButton("Search");
		btnSearch.setFont(new Font("",1,15));
		btnSearch.setBackground(Color.GREEN);
		btnSearch.setForeground(Color.BLACK);
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				int index=d1.SearchByOrderId(txtId.getText());
				if(index!=-1){
					Customers c1=Datastore.customerArray[index];
					txtCustId.setText(c1.getPhonenumber());
					txtSize.setText(c1.getSize());
					txtQty.setText(c1.getQty()+"");
					txtAmount.setText(c1.getAmount()+"");
					txtStatus.setText(c1.getStatus()==0 ? "Processing" : c1.getStatus()==1 ? "Delivering" : "Delivered" );
					
					}else{
						JFrame f;   
							f=new JFrame();  
						JOptionPane.showMessageDialog(f,"Customer Not Found... Try Again..."); 
						dispose();
						new SearchOrder().setVisible(true);  
						}
			}
				});
				
		buttonPanel2.add(btnSearch);
		add("East",buttonPanel2);
	}
}

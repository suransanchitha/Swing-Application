import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Placeorder extends JFrame{
	
	private JButton btnBack;
	private JButton btnPlace;
	
	private JLabel lblOrderid;
	private JLabel lblCustomerid;
	private JLabel lblSize;
	private JLabel lblQty;
	private JLabel lblAmount;
	private JLabel lblSizeNames;
	
	private JTextField txtId;
	private JTextField txtCustId;
	private JTextField txtSize;
	private JTextField txtQty;
	private JTextField txtAmount;
	
	Datastore d1=new Datastore();
	
	Placeorder(){
		setSize(400,300);
		setTitle("Place order");
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
		
		JPanel buttonPanel2=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnPlace=new JButton("Place");
		btnPlace.setFont(new Font("",1,15));
		btnPlace.setBackground(Color.GREEN);
		btnPlace.setForeground(Color.BLACK);
		btnPlace.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=d1.generateId();
				String number=txtCustId.getText();
				String size=txtSize.getText();
				int qty=Integer.parseInt(txtQty.getText());
				double amount=0;
                if (size.equals("XS")) {
                    amount = qty * 600;
                } else if (size.equals("S")) {
                    amount = qty * 800;
                } else if (size.equals("M")) {
                    amount = qty * 900;
                } else if (size.equals("L")) {
                    amount = qty * 1000;
                } else if (size.equals("XL")) {
                    amount = qty * 1100;
                } else if (size.equals("XXL")) {
                    amount = qty * 1200;
                }
				Customers customer = new Customers(id,number,size,qty,amount,0);
				//Datastore d1=new Datastore();
				d1.PlaceOrder(customer);
				
				JFrame f; 
				f=new JFrame();  
				JOptionPane.showMessageDialog(f,"Order Placed...");
				new Placeorder().setVisible(true);
				dispose();
				
			}
				});
				
		buttonPanel2.add(btnPlace);
		add("South",buttonPanel2);
		
		JPanel labelPanel=new JPanel(new GridLayout(5,1));
		lblOrderid=new JLabel("Order ID : ");
		lblOrderid.setFont(new Font("",1,15));
		labelPanel.add(lblOrderid);	
		
		lblCustomerid=new JLabel("Customer ID : ");
		lblCustomerid.setFont(new Font("",1,15));
		labelPanel.add(lblCustomerid);
		
		lblSize=new JLabel("Size : ");
		lblSize.setFont(new Font("",1,15));
		labelPanel.add(lblSize);
		
		lblQty=new JLabel("Qty : ");
		lblQty.setFont(new Font("",1,15));
		labelPanel.add(lblQty);
		
		lblAmount=new JLabel("Amount : " );
		lblAmount.setFont(new Font("",1,15));
		labelPanel.add(lblAmount);
		
		add("West",labelPanel);

		JPanel textPanel=new JPanel(new GridLayout(5,1));
		
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtId=new JTextField(d1.generateId());
		txtId.setFont(new Font("",1,15));
		idTextPanel.add(txtId);
		textPanel.add(idTextPanel);
		
		JPanel custidTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtCustId=new JTextField(10);
		txtCustId.setFont(new Font("",1,15));
		custidTextPanel.add(txtCustId);
		textPanel.add(custidTextPanel);
		
		JPanel sizeTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtSize=new JTextField(10);
		txtSize.setFont(new Font("",1,15));
		sizeTextPanel.add(txtSize);
		textPanel.add(sizeTextPanel);
		
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
		
		add("Center",textPanel);
		
		JPanel labelPanel3=new JPanel(new GridLayout(1,1));
		lblSizeNames=new JLabel("(XS/S/M/L/XL/XXL)");
		lblSizeNames.setFont(new Font("",1,14));
		labelPanel3.add(lblSizeNames);
		
		add("East",labelPanel3);
		
		}
	
}


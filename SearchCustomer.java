import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
class SearchCustomer extends JFrame{
	private JButton btnBack;
	private JButton btnSearch;
	private JLabel lblCustomerid;
	private JLabel lblTotal;
	private JTextField txtId;
	
	private JTable tblCustomer;
	private DefaultTableModel dtm;
	
	Datastore d1= new Datastore();
	
	double total=0;
	
	SearchCustomer(){
		
		setSize(500,570);
		setTitle("Search Customer");
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
		
		JPanel labelPanel=new JPanel(new GridLayout(1,1));
	
		lblCustomerid=new JLabel("      Enter Customer ID :   ");
		lblCustomerid.setFont(new Font("",1,15));
		labelPanel.add(lblCustomerid);
	
		add("West",labelPanel);
		
		JPanel textPanel=new JPanel(new GridLayout(1,1));
		
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		txtId=new JTextField(10);
		txtId.setFont(new Font("",1,15));
		idTextPanel.add(txtId);
		textPanel.add(idTextPanel);
		
		add("Center",textPanel);
		
		String[] columnName={"Size","QTY","Amount"};
		dtm=new DefaultTableModel(columnName,0); //0->row count
		tblCustomer=new JTable(dtm);
	
		Object[] rowData={"-","-","-",};
		dtm.addRow(rowData);
		
		JPanel buttonPanel2=new JPanel(new FlowLayout(FlowLayout.RIGHT));	
		btnSearch=new JButton("Search");
		btnSearch.setFont(new Font("",1,15));
		btnSearch.setBackground(Color.GREEN);
		btnSearch.setForeground(Color.BLACK);
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dtm.setRowCount(0);
				int index=d1.SearchByCustomerId(txtId.getText());
				if(index!=-1){
					Customers c1=Datastore.customerArray[index];
					Object[] rowData={c1.getSize(),c1.getQty(),c1.getAmount()};
					total+=c1.getAmount();
					dtm.addRow(rowData); 
					}else{
						JFrame f;   
							f=new JFrame();  
						JOptionPane.showMessageDialog(f,"Customer Not Found... Try Again...");  
						dispose();
						new SearchCustomer().setVisible(true);   
						}
			}
				});
				
		buttonPanel2.add(btnSearch);
		add("East",buttonPanel2);
		
		JScrollPane tablePane=new JScrollPane(tblCustomer);
		JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));  
        lblTotal = new JLabel("Total  :                                                                               "+total);
        lblTotal.setFont(new Font("", 1, 15));
        totalPanel.add(lblTotal);
        
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());  

        southPanel.add(tablePane, BorderLayout.CENTER);  
        southPanel.add(totalPanel, BorderLayout.SOUTH);  

        add(southPanel, BorderLayout.SOUTH);

		}
	
	
	}


	

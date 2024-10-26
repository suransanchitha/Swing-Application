import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class CustomerReports extends JFrame {
	private JButton btnBack;
	private JLabel lblTitle;
	
	private JTable tblCustomer;
	private DefaultTableModel dtm;
	
	CustomerReports(){
		
		setSize(400,300);
		setTitle("View Customers");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));	
		btnBack=new JButton("Back");
		btnBack.setFont(new Font("",1,15));
		btnBack.setBackground(Color.RED);
		btnBack.setForeground(Color.WHITE);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new ViewReports().setVisible(true);
				dispose();
			}
				});
				
		buttonPanel.add(btnBack);
		add("North",buttonPanel);
		
		String[] columnName={"Custmer ID","QTY","Amount"};
		dtm=new DefaultTableModel(columnName,0); //0->row count
		tblCustomer=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(tblCustomer);
		add("Center",tablePane);
		
		for(int i=0; i<Datastore.customerArray.length; i++){
					Customers c1=Datastore.customerArray[i];
					Object[] rowData={c1.getPhonenumber(),c1.getQty(),c1.getAmount()};
					dtm.addRow(rowData); 
				}
		
		
		}
	
	}

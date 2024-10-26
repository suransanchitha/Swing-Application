import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class OrderByAmount extends JFrame{
	private JButton btnBack;
	private JLabel lblTitle;
	
	private JTable tblCustomer;
	private DefaultTableModel dtm;
	
	OrderByAmount(){
		setSize(600,300);
		setTitle("Orders By Amount");
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
		
		Customers[] tempArray=new Customers[Datastore.customerArray.length];
		
		 for (int i = 0; i < Datastore.customerArray.length; i++) {
			 tempArray[i]=Datastore.customerArray[i];
        }
        Customers[] tempSortArray=new Customers[tempArray.length];
        
        for (int i = 0; i < tempSortArray.length; i++){
			tempSortArray[i]=tempArray[i];
		}
		for (int j = 1; j < tempSortArray.length; j++) {
            for (int i = 0; i < tempSortArray.length - j; i++) {
                if (tempSortArray[i].getAmount() < tempSortArray[i+1].getAmount()) {

                    Customers[] temp=new Customers[1];
                    temp[0]=tempSortArray[i];
                    tempSortArray[i]=tempSortArray[i+1];
                    tempSortArray[i+1]=temp[0];
                }
            }
        }
		
		String[] columnName={"Orders ID","Customer ID","Size","QTY","Amount","Status"};
		dtm=new DefaultTableModel(columnName,0); //0->row count
		tblCustomer=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(tblCustomer);
		add("Center",tablePane);
		
		for(int i=0; i<tempSortArray.length; i++){
					Customers c1=tempSortArray[i];
					Object[] rowData={c1.getOrderid(),c1.getPhonenumber(),c1.getSize(),c1.getQty(),c1.getAmount(),
						tempSortArray[i].getStatus() == 0 ? "Processing" : tempSortArray[i].getStatus() == 1 ? "Delivering" : "Delivered"};
					dtm.addRow(rowData); 
				}
		
		}
	}


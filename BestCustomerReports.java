import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
class BestCustomerReports extends JFrame{
	private JButton btnBack;
	private JLabel lblTitle;
	
	private JTable tblCustomer;
	private DefaultTableModel dtm;
	
	BestCustomerReports(){
		setSize(400,300);
		setTitle("Best in Customers");
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

		Customers[] tempArray=new Customers[0];
		
		L1: for (int i = 0; i < Datastore.customerArray.length; i++) {
            for (int j = 0; j < tempArray.length; j++) {
                if (Datastore.customerArray[i].getPhonenumber().equals(tempArray[j].getPhonenumber())) {
                    tempArray[j].setQty(Datastore.customerArray[i].getQty()+tempArray[j].getQty());
                    tempArray[j].setAmount(Datastore.customerArray[i].getAmount()+tempArray[j].getAmount());

                    continue L1;

                }

            }
            Customers[] tempExtend=new Customers[tempArray.length+1];
            
            for (int k = 0; k < tempArray.length; k++) {

                tempExtend[k]=tempArray[k];
            }
            
            tempArray=tempExtend;
            tempArray[tempArray.length - 1]=Datastore.customerArray[i];
		}
		Customers[] tempSortArray=new Customers[tempArray.length];
		
		for (int i = 0; i < tempArray.length; i++){
			tempSortArray[i]=tempArray[i];
		}
		
		
		for (int i = 1; i < tempSortArray.length; i++) {
            for (int j = 0; j < tempSortArray.length - i; j++) {
                if (tempSortArray[j].getAmount() < tempSortArray[j+1].getAmount()) {
                    Customers[] temp=new Customers[1];
                    temp[0]=tempSortArray[j+1];
                    tempSortArray[j+1]=tempSortArray[j];
                    tempSortArray[j]=temp[0];
                }

            }

        }
		
		String[] columnName={"Custmer ID","QTY","Amount"};
		dtm=new DefaultTableModel(columnName,0); //0->row count
		tblCustomer=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(tblCustomer);
		add("Center",tablePane);
		
		for(int i=0; i<tempSortArray.length; i++){
					Customers c1=tempSortArray[i];
					Object[] rowData={c1.getPhonenumber(),c1.getQty(),c1.getAmount()};
					dtm.addRow(rowData); 
				}
	
	}
}



import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class SortByAmount extends JFrame{
	private JButton btnBack;
	private JLabel lblTitle;
	
	private JTable tblCustomer;
	private DefaultTableModel dtm;
	
	SortByAmount(){
		setSize(400,300);
		setTitle("Items By Amount");
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
		
		Customers[] tempArray=new Customers[6];
		String[] sizes = {"XS", "S", "M", "L", "XL", "XXL"};

		for (int i = 0; i < sizes.length; i++) {
				tempArray[i] = new Customers();
				tempArray[i].setSize(sizes[i]);
		}
		
		for (int i = 0; i < Datastore.customerArray.length; i++){
			for (int j = 0; j < tempArray.length; j++){
				if(Datastore.customerArray[i].getSize().equals(tempArray[j].getSize())){
					tempArray[j].setQty(Datastore.customerArray[i].getQty()+tempArray[j].getQty());
					tempArray[j].setAmount(Datastore.customerArray[i].getAmount()+tempArray[j].getAmount());
				}else{
					continue;
				}
			}
			
		}
		
		Customers[] tempSortArray=new Customers[6];
		
		for (int i = 0; i < 6; i++){
			tempSortArray[i]=tempArray[i];
		}
		
		 for (int j = 1; j < tempArray.length; j++) {
            for (int i = 0; i < tempArray.length - j; i++) {
                if (tempSortArray[i].getAmount() < tempSortArray[i+1].getAmount()) {

                    Customers[] temp=new Customers [1];
                    temp[0]=tempSortArray[i];
                    tempSortArray[i]=tempSortArray[i+1];
                    tempSortArray[i+1]=temp[0];
                }
            }
        }
		
		String[] columnName={"Size","QTY","Amount"};
		dtm=new DefaultTableModel(columnName,0); //0->row count
		tblCustomer=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(tblCustomer);
		add("Center",tablePane);
		
		for(int i=0; i<tempSortArray.length; i++){
					Customers c1=tempSortArray[i];
					Object[] rowData={c1.getSize(),c1.getQty(),c1.getAmount()};
					dtm.addRow(rowData); 
				}
		
		
		}
		
	}


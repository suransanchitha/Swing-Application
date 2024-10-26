import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class AllCustomerReports extends JFrame{
	private JButton btnBack;
	private JLabel lblTitle;
	
	private JTable tblCustomer;
	private DefaultTableModel dtm;
	
	AllCustomerReports(){
		setSize(700,300);
		setTitle(" All Customer Reports");
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
		
		Customers[] tempArrays=new Customers[0];
		
		L1: for (int i = 0; i < Datastore.customerArray.length; i++) {
            for (int j = 0; j < tempArrays.length; j++) {
                if ( Datastore.customerArray[i].getPhonenumber().equals(tempArrays[j].getPhonenumber())) {
                    tempArrays[j].setQty( Datastore.customerArray[i].getQty()+tempArrays[j].getQty());
                    tempArrays[j].setAmount( Datastore.customerArray[i].getAmount()+tempArrays[j].getAmount());

                    continue L1;

                }

            }
            Customers[] tempExtend=new Customers[tempArrays.length+1];
            
            for (int k = 0; k < tempArrays.length; k++) {

                tempExtend[k]=tempArrays[k];
            }
            
            tempArrays=tempExtend;
            tempArrays[tempArrays.length - 1]= Datastore.customerArray[i];
		}
		
		int[] xs = new int[tempArrays.length];
		int[] s = new int[tempArrays.length];
		int[] m = new int[tempArrays.length];
		int[] l = new int[tempArrays.length];
		int[] xl = new int[tempArrays.length];
		int[] xxl = new int[tempArrays.length];
		double[] total = new double[tempArrays.length];
		
		for (int i = 0; i < tempArrays.length; i++) {
            for (int j = 0; j <  Datastore.customerArray.length; j++) {
                if (tempArrays[i].getPhonenumber().equals( Datastore.customerArray[j].getPhonenumber())) {
                    if ( Datastore.customerArray[j].getSize().equals("XS")) {
                        xs[i] +=  Datastore.customerArray[j].getQty();
                        total[i] +=  Datastore.customerArray[j].getAmount();
                    } else if ( Datastore.customerArray[j].getSize().equals("S")) {
                        s[i] +=  Datastore.customerArray[j].getQty();
                        total[i] +=  Datastore.customerArray[j].getAmount();
                    } else if ( Datastore.customerArray[j].getSize().equals("M")) {
                        m[i] +=  Datastore.customerArray[j].getQty();
                        total[i] +=  Datastore.customerArray[j].getAmount();
                    } else if ( Datastore.customerArray[j].getSize().equals("L")) {
                        l[i] +=  Datastore.customerArray[j].getQty();
                        total[i] +=  Datastore.customerArray[j].getAmount();
                    } else if ( Datastore.customerArray[j].getSize().equals("XL")) {
                        xl[i] +=  Datastore.customerArray[j].getQty();
                        total[i] +=  Datastore.customerArray[j].getAmount();
                    } else if ( Datastore.customerArray[j].getSize().equals("XXL")) {
                        xxl[i] +=  Datastore.customerArray[j].getQty();
                        total[i] +=  Datastore.customerArray[j].getAmount();
                    }
                }
            }

        }
        
		String[] columnName={"Custmer ID","XS","S","M","L","XL","XXL","Amount"};
		dtm=new DefaultTableModel(columnName,0); //0->row count
		tblCustomer=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(tblCustomer);
		add("Center",tablePane);
		
		for(int i=0; i<tempArrays.length; i++){
					Customers c1=tempArrays[i];
					Object[] rowData={ c1.getPhonenumber(), xs[i], s[i], m[i], l[i], xl[i], xxl[i], total[i]};
					dtm.addRow(rowData); 
				}
		
		}
	
	
	}


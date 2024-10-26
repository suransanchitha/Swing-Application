class Datastore{
	public static Customers[] customerArray=new Customers[0];
	
	public static final int PROCESSING = 0;
    public static final int DELIVERING = 1;
    public static final int DELIVERED = 2;
    
    public void PlaceOrder(Customers customer){
		ExtendArray();
		customerArray[customerArray.length-1]=customer;
		
		}
    
     public  void ExtendArray() {
        Customers[] tempArray = new Customers[customerArray.length + 1];

        for (int i = 0; i < customerArray.length; i++) {
            tempArray[i] = customerArray[i];
        }
        customerArray = tempArray;
    }
    
     public  String generateId() {
        int id1;
        if (customerArray.length > 0) {
            id1 = Integer.parseInt(customerArray[customerArray.length - 1].getOrderid().split("[#]")[1]);
            id1++;
        } else {
            return "ODR#00001";
        }
        return String.format("ODR#%05d", id1);
    }
    
     public  int SearchByCustomerId(String customerId) {
        for (int i = 0; i < customerArray.length; i++) {
            if (customerArray[i].getPhonenumber().equals(customerId)) {
                return i;

            }
        }
        return -1;

    }
    public int SearchByOrderId(String orderId){
		 for (int i = 0; i < customerArray.length; i++) {
            if (customerArray[i].getOrderid().equals(orderId)) {
                return i;

            }
        }
        return -1;
		
		
		}
		public void ChangeStatus(String orderId,int index){
			for (int i = 0; i < customerArray.length; i++){
				if(customerArray[i].getOrderid().equals(orderId)){
					customerArray[i].setStatus(index);
					}
			}
			
			
			}
			
		public boolean Deleteorder(String orderId){
		 Customers[] tempArray=new Customers[customerArray.length-1];
		 
		 for (int i = 0; i < customerArray.length; i++){
			 if(orderId.equals(customerArray[i].getOrderid())){
				 continue;
				 }
				 tempArray[i]=customerArray[i];
		 }
				customerArray=tempArray;
		 
			return true;
			
			
			}
	
	
	}



class Customers{
	private String orderid;
    private String phonenumber;
    private String size;
    private int qty;
    private double amount;
    private int status;
    
    Customers(){}
    
    Customers(String orderid, String phonenumber, String size, int qty, double amount, int status) {
        this.orderid = orderid;
        this.phonenumber = phonenumber;
        this.size = size;
        this.qty = qty;
        this.amount = amount;
        this.status = status;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrderid() {
        return orderid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getSize() {
        return size;
    }

    public int getQty() {
        return qty;
    }

    public double getAmount() {
        return amount;
    }

    public int getStatus() {
        return status;
    }
}


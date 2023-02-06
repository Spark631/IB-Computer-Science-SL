class stock {
    private String name;
    private int quantity;
    private double price;
    private double total;
    private int marketCap;
    private int high;
    private int low;

    public stock(String name, int quantity, double price, int marketCap, int high, int low) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.total = quantity * price;
        this.marketCap = marketCap;
        this.high = high;
        this.low = low;
    }
    
    //getting methods
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return total;
    }

    public int getMarketCap() {
        return marketCap;
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
    }

    //setting methods
    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setMarketCap(int marketCap) {
        this.marketCap = marketCap;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
        System.out.println("Total: " + total);
    }
    public static void main(String args[]) {
        stock s1 = new stock("Apple", 10, 100, 1000, 200, 50);
        s1.display();
    }

}
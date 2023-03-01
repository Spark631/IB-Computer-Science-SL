class Stock {
    private String name;
    private String ticker;
    private int quantity;
    private double price;
    private double total;
    private int marketCap;
    private int high;
    private int low;
    private String sector ;

    public Stock(String name, String ticker, int quantity, double price, int marketCap, int high, int low, String sector ) {
        this.name = name;
        this.ticker = ticker;
        this.quantity = quantity;
        this.price = price;
        this.total = quantity * price;
        this.marketCap = marketCap;
        this.high = high;
        this.low = low;
        this.sector = sector;
    }
    
    //getting methods
    public String getName() {
        return name;
    }

    public String getTicker() {
        return ticker;
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

    public String getSector() {
        return sector;
    }

    //setting methods
    public void setName(String name) {
        this.name = name;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
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

    public void setSector(String sector) {
        this.sector  = sector ;
    }

    public String display() {
        return(name + "," + ticker + "," + quantity + "," + price + "," + marketCap + "," + high + "," + low + "," + sector);
    }


}

// class StockCalculations extends Stock {
//     public StockCalculations(String name, String ticker, int quantity, double price, int marketCap, int high, int low, String sector) {
//         super(name, ticker, quantity, price, marketCap, high, low, sector);
//     }
// }
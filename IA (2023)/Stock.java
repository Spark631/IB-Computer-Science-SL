class Stock {
    private String name;
    private String ticker;
    private int amountOfShares;
    private double price;
    private double total;
    private double net;
    private double totalMoneySpent;
    private double totalMoneyGained;
    private String sector;

    public Stock(String name, String ticker, int amountOfShares, double price, double net, double totalMoneySpent,
            double totalMoneyGained, String sector) {
        this.name = name;
        this.ticker = ticker;
        this.amountOfShares = amountOfShares;
        this.price = price;
        this.total = amountOfShares * price;
        this.net = net;
        this.totalMoneySpent = totalMoneySpent;
        this.totalMoneyGained = totalMoneyGained;
        this.sector = sector;
    }

    // getting methods
    public String getName() {
        return name;
    }

    public String getTicker() {
        return ticker;
    }

    public int getAmountOfShares() {
        return amountOfShares;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return total;
    }

    public double getNet() {
        return net;
    }

    public double getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public double getTotalMoneyGained() {
        return totalMoneyGained;
    }

    public String getSector() {
        return sector;
    }

    // setting methods
    public void setName(String name) {
        this.name = name;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setAmountOfShares(int amountOfShares) {
        this.amountOfShares = amountOfShares;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setNet(double net) {
        this.net = net;
    }

    public void setTotalMoneySpent(double totalMoneySpent) {
        this.totalMoneySpent = totalMoneySpent;
    }

    public void setTotalMoneyGained(double totalMoneyGained) {
        this.totalMoneyGained = totalMoneyGained;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

}

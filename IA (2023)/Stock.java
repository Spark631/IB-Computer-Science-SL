class Stock {
    private String name;
    private String ticker;
    private int amountOfShares;
    private double price;
    private double total;
    private double net;
    private double totalOfMoneySpent;
    private double totalOfMoneyGained;
    private String sector;

    public Stock(String name, String ticker, int amountOfShares, double price, double net, double totalOfMoneySpent,
            double totalOfMoneyGained, String sector) {
        this.name = name;
        this.ticker = ticker;
        this.amountOfShares = amountOfShares;
        this.price = price;
        this.total = amountOfShares * price;
        this.net = net;
        this.totalOfMoneySpent = totalOfMoneySpent;
        this.totalOfMoneyGained = totalOfMoneyGained;
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

    public double getTotalOfMoneySpent() {
        return totalOfMoneySpent;
    }

    public double getTotalOfMoneyGained() {
        return totalOfMoneyGained;
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

    public void setTotalOfMoneySpent(double totalOfMoneySpent) {
        this.totalOfMoneySpent = totalOfMoneySpent;
    }

    public void setTotalOfMoneyGained(double totalOfMoneyGained) {
        this.totalOfMoneyGained = totalOfMoneyGained;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    // public String display() {
    // return (name + "," + ticker + "," + amountOfShares + "," + price + "," + net
    // + "," + totalOfMoneySpent
    // + "," + totalOfMoneyGained + "," + sector);
    // }

}

// class StockCalculations extends Stock {
// public StockCalculations(String name, String ticker, int amountOfShares,
// double price, int net, int totalOfMoneySpent, int totalOfMoneyGained,
// String sector) {
// super(name, ticker, amountOfShares, price, net, totalOfMoneySpent,
// totalOfMoneyGained, sector);
// }
// }
public class WatchList {
    private String ticker;
    private double beforePrice;
    private double targetPrice;
    private double currentPrice;

    public WatchList(String ticker, double beforePrice, double targetPrice, double currentPrice) {
        this.ticker = ticker;
        this.beforePrice = beforePrice;
        this.targetPrice = targetPrice;
        this.currentPrice = currentPrice;
    }

    // getting methods
    public String getTicker() {
        return ticker;
    }

    public double getBeforePrice() {
        return beforePrice;
    }

    public double getTargetPrice() {
        return targetPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    // setting methods
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setBeforePrice(Double beforePrice) {
        this.beforePrice = beforePrice;
    }

    public void setTargetPrice(double targetPrice) {
        this.targetPrice = targetPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}

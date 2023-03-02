import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class scraper {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://finance.yahoo.com/quote/META?p=AAPL&.tsrc=fin-srch").get();
        log(doc.title());

        //get the last fin-streamer element which contains the price of the selected stock
        Element price = doc.select("fin-streamer[data-field=regularMarketPrice]").last();
        log("Price: %s", price.text());

    }

    
    public String findStock(String stockName) throws IOException {
        Document doc = Jsoup.connect("https://finance.yahoo.com/quote/" + stockName + "?p=" + stockName + "&.tsrc=fin-srch").get();
        
        //get the last fin-streamer element which contains the price of the selected stock
        Element price = doc.select("fin-streamer[data-field=regularMarketPrice]").last();
        String stock = log("Price: %s", price.text());
        return stock;
    }

    private static String log(String msg, String... vals) {
        // System.out.println(String.format(msg, vals));
        return String.format(msg, vals);
    }
}
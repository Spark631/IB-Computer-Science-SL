import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

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
        
        //Gets the last fin-streamer element which contains the price of the selected stock
        // Element price = doc.select("fin-streamer[data-field=regularMarketPrice]").last();
        Element price = doc.select("fin-streamer[data-field=regularMarketPrice]").last();

        //Gets the last fin-streamer element which contains the price of the selected stock
        Element title = doc.select("h1[class=D(ib) Fz(18px)]").first();

        // String scrapedPrice = log("Price: %s", price.text());
        // String scrapedTitle = log("Title: %s", title.text());

        String scrapedPrice = price.text();
        String scrapedTitle = title.text();


        return scrapedPrice + "\n" + scrapedTitle;

    }

    public Map<Integer, String> createHashMap(String stockName) {
        Map<Integer, String> data = new HashMap<>();
        
        try {
            Document doc = Jsoup.connect("https://finance.yahoo.com/quote/" + stockName + "/history?p=" + stockName).get();
            // Elements row = doc.select("tr[class=BdT Bdc($seperatorColor) Ta(end) Fz(s) Whs(nw)]");
            // Elements row = doc.select("tr[class=BdT Bdc($seperatorColor) Ta(end) Fz(s) Whs(nw)]");

            // Elements row = doc.select("td[class=Py(10px) Ta(start) Pend(10px)]");
            // for(int i = 0; i < row.size(); i++) {
            //     System.out.println(row.get(i).text());
            // }

            // Elements closePrice = doc.select("td[class=Py(10px) Pstart(10px)]");

            // for(int i = 0; i < closePrice.size(); i++) {
            //     System.out.println(closePrice.get(i).text());
            // }

            Element closePrice = doc.select("td[class=Py(10px) Pstart(10px)]");

            System.out.println(closePrice.text());


            // Element element = doc.selectFirst("td[class=Py(10px) Ta(start) Pend(10px)]");
            // System.out.println("This is: " + element);
            // if (element != null) {
            //     System.out.println(element);
            // }     

            // Elements col = row.select("td[class=Ta(end) Fw(600) Lh(14px)]");
            // Elements col2 = row.select("td[class=Ta(end) Fw(600) Lh(14px) Pend(10px)]");



            data.put(1, "Apple");
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error" + e);
        }
        return data;
        
    }

    private static String log(String msg, String... vals) {
        //formats the string with the given values
        return String.format(msg, vals);
    }
}
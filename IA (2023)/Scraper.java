import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Scraper {

    public String findStockName(String stockName) {

        String scrapedTitle = "";
        try {
            Document doc = Jsoup
                    .connect("https://finance.yahoo.com/quote/" + stockName + "?p=" + stockName + "&.tsrc=fin-srch")
                    .get();

            // Gets the last fin-streamer element which contains the price of the selected
            Element title = doc.select("h1[class=D(ib) Fz(18px)]").first();

            scrapedTitle = title.text();
            return scrapedTitle;

        } catch (Exception e) {
            System.out.println("Please Try Again" + e);
        }
        return null;

    }

    public double findStockPrice(String stockName) {
        double price = 0;
        try {
            Document doc = Jsoup
                    .connect("https://finance.yahoo.com/quote/" + stockName + "?p=" + stockName + "&.tsrc=fin-srch")
                    .get();

            // Gets the last fin-streamer element which contains the price of the selected
            Element priceElement = doc.select("fin-streamer[data-field=regularMarketPrice]").last();

            String scrapedPrice = priceElement.text();

            price = (double) Double.parseDouble(scrapedPrice);

        } catch (Exception e) {
            System.out.println("Error" + e);
        }

        return price;
    }

    public String findSector(String stockName) {
        try {
            Document doc = Jsoup.connect("https://finance.yahoo.com/quote/" + stockName + "/profile?p=" + stockName)
                    .get();
            Element sector = doc.select("span[class=Fw(600)]").first();
            return sector.text();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return null;
    }

    public Map<String, Double> createHashMap(String stockName) {
        LinkedHashMap<String, Double> data = new LinkedHashMap<String, Double>();
        LinkedHashMap<String, Double> reversedData = new LinkedHashMap<>();

        try {
            Document doc = Jsoup.connect("https://finance.yahoo.com/quote/" + stockName + "/history?p=" + stockName)
                    .get();

            Elements rows = doc.select("table tbody tr");
            for (Element row : rows) {
                String date = row.select("td:nth-child(1) span").text();
                String closePrice = row.select("td:nth-child(5) span").text();
                double closePriceDouble = Double.parseDouble(closePrice);

                data.put(date, closePriceDouble);
            }

            List<String> keys = new ArrayList<>(data.keySet());
            Collections.reverse(keys);
            for (String key : keys) {
                reversedData.put(key, data.get(key));
            }

            DrawGraph draw = new DrawGraph(reversedData);
            draw.graph(reversedData);

        } catch (Exception e) {
            System.out.println("Error" + e);
        }

        return reversedData;
        // return data;

    }

    // private static String log(String msg, String... vals) {
    // //formats the string with the given values
    // return String.format(msg, vals);
    // }
}
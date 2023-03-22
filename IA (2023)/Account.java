import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.File;
import java.util.Scanner;
import java.util.LinkedList;

public class Account {
    private static final String ACCOUNT_FILE = "account.xml";

    public void createAccount() {
        try {
            Scanner infoInput = new Scanner(System.in);

            System.out.println("\nWhat is your first name?\n ");
            String firstName = infoInput.nextLine();

            // infoInput.close();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("Account");
            doc.appendChild(rootElement);

            // user element
            Element user = doc.createElement("user");
            rootElement.appendChild(user);

            Element watchList = doc.createElement("watchList");
            rootElement.appendChild(watchList);

            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(firstName));
            user.appendChild(name);

            // Starting wallet
            Element wallet = doc.createElement("wallet");
            wallet.appendChild(doc.createTextNode("500.00"));
            user.appendChild(wallet);

            Element accountActivatedDate = doc.createElement("accountActivatedDate");
            accountActivatedDate.appendChild(doc.createTextNode(java.time.LocalDate.now().toString()));
            user.appendChild(accountActivatedDate);

            writeDocument(doc, "yes");

            // Output to console for testing
            // StreamResult consoleResult = new StreamResult(System.out);
            // transformer.transform(source, consoleResult);

        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public String getUser() {
        try {
            Document doc = getDocument();

            NodeList userList = doc.getElementsByTagName("user");
            Element user = (Element) userList.item(0);
            String name = user.getElementsByTagName("name").item(0).getTextContent();

            return name;
        } catch (Exception e) {
            System.out.println("user does not exist");
        }
        return null;
    }

    public double getWallet() {
        try {
            Document doc = getDocument();

            NodeList userList = doc.getElementsByTagName("user");
            Element user = (Element) userList.item(0);
            String wallet = user.getElementsByTagName("wallet").item(0).getTextContent();

            return Double.parseDouble(wallet);
        } catch (Exception e) {
            System.out.println("user does not exist");
        }
        return 0;
    }

    public LinkedList<Stock> getStock() {
        try {
            Document doc = getDocument();
            NodeList stockList = doc.getElementsByTagName("Stock");

            LinkedList<Stock> stockLists = new LinkedList<Stock>();

            for (int i = 0; i < stockList.getLength(); i++) {
                Element stocks = (Element) stockList.item(i);
                String name = stocks.getElementsByTagName("name").item(0).getTextContent();
                String ticker = stocks.getElementsByTagName("ticker").item(0).getTextContent();
                int amountOfShares = Integer
                        .parseInt(stocks.getElementsByTagName("amountOfShares").item(0).getTextContent());
                Double stockPrice = Double
                        .parseDouble(stocks.getElementsByTagName("stockPrice").item(0).getTextContent());
                Double net = Double.parseDouble(stocks.getElementsByTagName("net").item(0).getTextContent());
                Double total = Double.parseDouble(stocks.getElementsByTagName("total").item(0).getTextContent());
                Double totalGained = Double
                        .parseDouble(stocks.getElementsByTagName("totalGained").item(0).getTextContent());
                String sector = stocks.getElementsByTagName("sector").item(0).getTextContent();

                Stock stock = new Stock(name, ticker, amountOfShares, stockPrice, net, total, totalGained, sector);
                stockLists.add(stock);
            }
            return stockLists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public WatchList[] getWatchList() {
        try {
            System.out.println("Getting watchlist. . . ");
            Document doc = getDocument();
            NodeList watchList = doc.getElementsByTagName("watchList").item(0).getChildNodes();

            Scraper scraper = new Scraper();
            int watchListLength = (watchList.getLength());
            WatchList[] watchListArray = new WatchList[watchListLength / 2];
            int tracker = 0;
            for (int i = 0; i < watchList.getLength(); i++) {
                Node ticker = watchList.item(i);
                if (ticker.getNodeType() == Node.ELEMENT_NODE && tracker < watchListLength / 2) {
                    Element tickerElement = (Element) ticker;
                    String tickerName = tickerElement.getElementsByTagName("name").item(0).getTextContent();

                    double tickerPrice = Double
                            .parseDouble(tickerElement.getElementsByTagName("price").item(0).getTextContent());

                    double tickerTargetPrice = Double
                            .parseDouble(tickerElement.getElementsByTagName("targetPrice").item(0).getTextContent());
                    double tickerCurrentPrice = (scraper.findStockPrice(tickerName));

                    WatchList watchListObject = new WatchList(tickerName, tickerPrice, tickerTargetPrice,
                            tickerCurrentPrice);

                    watchListArray[tracker] = watchListObject;

                    tracker += 1;
                }
            }
            return watchListArray;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public void removeWatchList(String ticker) {

        try {
            Document doc = getDocument();
            NodeList watchList = doc.getElementsByTagName("watchList").item(0).getChildNodes();

            for (int i = 0; i < watchList.getLength(); i++) {
                Node tickerNode = watchList.item(i);
                if (tickerNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element tickerElement = (Element) tickerNode;
                    String tickerName = tickerElement.getElementsByTagName("name").item(0).getTextContent();
                    if (tickerName.equals(ticker)) {
                        tickerElement.getParentNode().removeChild(tickerElement);
                    }
                }
            }
            writeDocument(doc, "no");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public String checkUser() {
        try {
            Document doc = getDocument();

            NodeList userList = doc.getElementsByTagName("user");
            Element user = (Element) userList.item(0);
            String name = user.getElementsByTagName("name").item(0).getTextContent();

            return name;
        } catch (Exception e) {
            System.out.println("\033[1m" + "  _________________________________________  " + "\033[0m");
            System.out.println("\033[1m" + " /                                         \\" + "\033[0m");
            System.out.println("\033[1m" + "|   \033[32mHello there Investor!" + "\033[0m" + "\033[1m"
                    + "                   |" + "\033[0m");
            System.out.println("\033[1m" + "|                                           |" + "\033[0m");
            System.out.println("\033[1m" + "|   \033[33mLooks like you are new here.\033[0m" + "\033[1m"
                    + "            |" + "\033[0m");
            System.out.println("\033[1m" + "|                                           |" + "\033[0m");
            System.out.println("\033[1m" + "|   \033[36mLet's get you started with a \033[0m" + "\033[1m"
                    + "           |" + "\033[0m");
            System.out.println("\033[1m" + "|   \033[36mnew account!\033[0m" + "\033[1m"
                    + "                            |" + "\033[0m");
            System.out.println("\033[1m" + " \\_________________________________________/ " + "\033[0m");
            createAccount();
        }
        return null;
    }

    public double checkBalance() {
        try {
            Document doc = getDocument();

            NodeList userList = doc.getElementsByTagName("user");
            Element user = (Element) userList.item(0);
            double balance = Double.parseDouble(user.getElementsByTagName("wallet").item(0).getTextContent());
            return balance;
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return 0;
    }

    public void updateBalance(double money) {
        try {
            Document doc = getDocument();

            NodeList userList = doc.getElementsByTagName("user");
            Element user = (Element) userList.item(0);
            double balance = Double.parseDouble(user.getElementsByTagName("wallet").item(0).getTextContent());
            balance = Math.round((balance + money) * 100.00) / 100.00;
            user.getElementsByTagName("wallet").item(0).setTextContent(Double.toString(balance));
            writeDocument(doc, "no");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void addStock(Stock stockInfo) {
        try {
            Document doc = getDocument();

            Element user = (Element) doc.getElementsByTagName("user").item(0);

            // Get the existing <Account> element
            Element account = (Element) doc.getElementsByTagName("Account").item(0);

            NodeList stockList = doc.getElementsByTagName("Stock");

            // check if the stock already exists
            for (int i = 0; i < stockList.getLength(); i++) {
                Element stocks = (Element) stockList.item(i);
                String tickers = stocks.getElementsByTagName("ticker").item(0).getTextContent();
                Integer amountOfShares = Integer
                        .parseInt(stocks.getElementsByTagName("amountOfShares").item(0).getTextContent());

                if (tickers.equals(stockInfo.getTicker())) {
                    stocks.getElementsByTagName("amountOfShares").item(0)
                            .setTextContent(Integer.toString(stockInfo.getAmountOfShares() + amountOfShares));
                    stocks.getElementsByTagName("stockPrice").item(0)
                            .setTextContent(Double.toString(stockInfo.getPrice()));

                    stocks.getElementsByTagName("net").item(0).setTextContent(Double.toString(stockInfo.getNet()));
                    stocks.getElementsByTagName("total").item(0).setTextContent(Double.toString(stockInfo.getTotal()));
                    removeWhiteSpace(doc);
                    writeDocument(doc, "yes");
                    return;
                }
            }

            // Create a new <Stock> element if the stock does not exist
            Element stock = doc.createElement("Stock");

            // Create child elements for the stock information
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(stockInfo.getName()));
            stock.appendChild(name);

            Element ticker = doc.createElement("ticker");
            ticker.appendChild(doc.createTextNode(stockInfo.getTicker()));
            stock.appendChild(ticker);

            Element amountOfShares = doc.createElement("amountOfShares");
            amountOfShares.appendChild(doc.createTextNode(Integer.toString(stockInfo.getAmountOfShares())));
            stock.appendChild(amountOfShares);

            Element stockPrice = doc.createElement("stockPrice");
            stockPrice.appendChild(doc.createTextNode(Double.toString(stockInfo.getPrice())));
            stock.appendChild(stockPrice);

            Element net = doc.createElement("net");
            net.appendChild(doc.createTextNode(Double.toString(stockInfo.getNet())));
            stock.appendChild(net);

            Element total = doc.createElement("total");
            total.appendChild(doc.createTextNode(Double.toString(stockInfo.getTotal())));
            stock.appendChild(total);

            Element totalSpent = doc.createElement("totalSpent");
            totalSpent.appendChild(doc.createTextNode(Double.toString(stockInfo.getTotalMoneySpent())));
            stock.appendChild(totalSpent);

            Element totalGained = doc.createElement("totalGained");
            totalGained.appendChild(doc.createTextNode(Double.toString(stockInfo.getTotalMoneyGained())));
            stock.appendChild(totalGained);

            Element sector = doc.createElement("sector");
            sector.appendChild(doc.createTextNode(stockInfo.getSector()));
            stock.appendChild(sector);

            // Append the new <Stock> element to the existing <Account> element
            account.appendChild(doc.createTextNode("\n"));
            account.appendChild(stock);

            // Set the indent and indent amount properties on the transformer
            // preserveElement(doc);
            removeWhiteSpace(doc);
            writeDocument(doc, "yes");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public boolean sellStock(String stock, int shares) {
        try {
            Document doc = getDocument();

            double total = 0;

            NodeList stockList = doc.getElementsByTagName("Stock");
            for (int i = 0; i < stockList.getLength(); i++) {
                Element stockElement = (Element) stockList.item(i);
                if (stockElement.getElementsByTagName("ticker").item(0).getTextContent().equals(stock.toUpperCase())) {
                    int amountOfShares = Integer
                            .parseInt(stockElement.getElementsByTagName("amountOfShares").item(0).getTextContent());
                    if (amountOfShares >= shares) {
                        amountOfShares -= shares;
                        stockElement.getElementsByTagName("amountOfShares").item(0)
                                .setTextContent(Integer.toString(amountOfShares));

                        Scraper scraper = new Scraper();
                        double price = scraper.findStockPrice(stock);
                        total = price * shares;

                        Double totalGained = Double
                                .parseDouble(stockElement.getElementsByTagName("totalGained").item(0).getTextContent());
                        totalGained += total;
                        stockElement.getElementsByTagName("totalGained").item(0)
                                .setTextContent(Double.toString(totalGained));

                        Double totalSpent = Double
                                .parseDouble(stockElement.getElementsByTagName("totalSpent").item(0).getTextContent());

                        Double netPrice = Double
                                .parseDouble(stockElement.getElementsByTagName("net").item(0).getTextContent());

                        netPrice = totalGained - totalSpent;

                        stockElement.getElementsByTagName("net").item(0)
                                .setTextContent(Double.toString(netPrice));
                        break;
                    } else {
                        System.out.println("You do not have enough shares to sell");
                        return false;
                    }
                }
            }

            writeDocument(doc, "no");
            updateBalance(total);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return true;
    }

    public void addToWatchList(String ticker, double price, double targetPrice) {
        try {
            Document doc = getDocument();
            // parent node
            Element watchList = (Element) doc.getElementsByTagName("watchList").item(0);
            Element tickerElement = doc.createElement("ticker");

            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(ticker));
            tickerElement.appendChild(name);

            Element priceElement = doc.createElement("price");
            priceElement.appendChild(doc.createTextNode(Double.toString(price)));
            tickerElement.appendChild(priceElement);

            Element targetPriceElement = doc.createElement("targetPrice");
            targetPriceElement.appendChild(doc.createTextNode(Double.toString(targetPrice)));
            tickerElement.appendChild(targetPriceElement);

            watchList.appendChild(tickerElement);

            removeWhiteSpace(doc);
            writeDocument(doc, "yes");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static Document getDocument() throws Exception {
        File inputFile = new File(ACCOUNT_FILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        return doc;
    }

    private static void writeDocument(Document doc, String option) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, option);
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(ACCOUNT_FILE));
        transformer.transform(source, result);
    }

    public static void removeWhiteSpace(Document doc) {
        NodeList parentElements = doc.getElementsByTagName("*");

        // Iterate through each parent element
        for (int i = 0; i < parentElements.getLength(); i++) {
            Element parentElement = (Element) parentElements.item(i);

            // Remove whitespace text nodes
            NodeList childNodes = parentElement.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node node = childNodes.item(j);
                if (node.getNodeType() == Node.TEXT_NODE && node.getTextContent().trim().isEmpty()) {
                    parentElement.removeChild(node);
                }
            }
        }
    }
}

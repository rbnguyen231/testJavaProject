package stockquoteservice;

import java.util.List;


/**
 * Basic example of use of StockQuoteWS web service in Java
 *
 * @author David.Squire@monash.edu
 * Created 20180409
 *
 */
public class TestStockQuoteService {

    public static void main(String[] args) throws Exception {

        StockQuoteWS SQservice = new StockQuoteWS();
        StockQuoteWSPortType SQPort = SQservice.getStockQuoteWSSOAP11PortHttp();

        String[] testStocks = {"CBA", "NAB", "BHP"}; // Array of stock symbols to test with

        List<String> fieldNames = SQPort.getFieldNames().getReturn();
        while (true) {
            for (String stock : testStocks) {
                List quoteData = SQPort.getQuote(stock);
                int i = 0;
                for (String fieldName : fieldNames) {
                    System.out.println(fieldName + ": " + quoteData.get(i++));
                }
                System.out.println();
            }
            System.out.println("######################");
            long SleepTime = 60 * 1000L;
            Thread.sleep(SleepTime);
        }
    }

}

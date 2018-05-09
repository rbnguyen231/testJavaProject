

public class StockQuoteMonitorApp {

    public static void main(String[] args) {

        Runnable newApp = new MonitorController();
        new Thread(newApp).start();

    }
}

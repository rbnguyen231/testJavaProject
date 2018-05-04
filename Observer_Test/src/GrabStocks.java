public class GrabStocks {

    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();

        StockObserver observer1 = new StockObserver(stockGrabber);
        stockGrabber.setIBMPrice(197.00);
        stockGrabber.setApplPrice(677.60);
        stockGrabber.setGoogPrice(676.40);

        StockObserver observer2 = new StockObserver(stockGrabber);
        stockGrabber.setIBMPrice(197.00);
        stockGrabber.setApplPrice(677.60);
        stockGrabber.setGoogPrice(676.40);

        stockGrabber.unregister(observer1);

        stockGrabber.setIBMPrice(197.00);
        stockGrabber.setApplPrice(677.60);
        stockGrabber.setGoogPrice(676.40);

        Runnable getIBM = new GetTheStock(stockGrabber, 2, "IBM", 197.00);
        Runnable getAppl = new GetTheStock(stockGrabber, 2, "APPL", 677.60);
        Runnable getGoog = new GetTheStock(stockGrabber, 2, "GOOG", 676.40);

        new Thread(getIBM).start();
        new Thread(getAppl).start();
        new Thread(getGoog).start();


    }
}

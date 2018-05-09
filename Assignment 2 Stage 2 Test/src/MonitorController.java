import java.awt.event.*;
import java.util.ArrayList;

public class MonitorController implements Monitor, Runnable {

    private MonitorInput StockMonitor;
    private StockCollection stockList;

    public void update(Stock newStock) {
        //Updates current list of stock
        ArrayList<Stock> currentStockList = stockList.retrieveStockList();
        for (Stock stockItem : currentStockList) {

            //If the symbols are the same and the stock has been altered
            if (stockItem.getSymbol().equalsIgnoreCase(newStock.getSymbol()) && stockItem.retrieveStockState()) {
                int indexOfStock = currentStockList.indexOf(newStock);
                currentStockList.set(indexOfStock, newStock);
            }
        }

    }

    public MonitorController() {
        //Initialises list for all stocks and object to allow for user input
        this.stockList = new StockCollection();
        this.StockMonitor = new MonitorInput();

        //Object for button click
        this.StockMonitor.addMonitorListener(new MonitorListener());

        this.StockMonitor.addMonitorListener(new MonitorListener());

    }

    //Handles creating the monitor and stock
    class MonitorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            //Retrieves stock symbol from user input
            String currentStockSymbol = StockMonitor.getStockSymbol();

            //Creates new stock based on symbol
            Stock newStock = new StockAdapter(currentStockSymbol);

            //If stock doesn't exist, add a new monitor to the new stock and attach monitor to it
            if(!stockList.checkForStock(currentStockSymbol)){
                DisplayMonitor newMonitor = new DisplayMonitor(newStock);
                newStock.attach(newMonitor);
                stockList.retrieveStockList().add(newStock);
                newMonitor.setVisible(true);
            }else{
                stockList.updateStockMonitors(currentStockSymbol);  //Otherwise if stock already exists, add new monitor to that stock
            }


        }

    }


    public void run() {
        //Show input UI to the user
        StockMonitor.setVisible(true);


        while(true){
            try{
                Thread.sleep(5*60000); //Delay stock update (only updates once every five minutes)
            }catch(InterruptedException e){}

            //If there are Stocks in the list already
            if(!this.stockList.retrieveStockList().isEmpty()){
                //Update all stocks and their values
                for(Stock currentStock: this.stockList.retrieveStockList()){
                    currentStock.setDate();
                    currentStock.setTime();
                    currentStock.setValue();
                    update(currentStock);
                }
            }


        }




    }
}

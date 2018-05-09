

import java.util.ArrayList;

public class StockCollection{
    private ArrayList<Stock> StockList;

    public StockCollection() {
        //Initialises a list to hold all the stocks
        this.StockList = new ArrayList<Stock>();
    }

    public ArrayList<Stock> retrieveStockList() {
        //Retruns the stock list
        return StockList;
    }


    public void updateStockMonitors(String stockSymbol){
        //Update the monitors given the stock symbol
        for(Stock stock : StockList){
            if(stock.getSymbol().equals(stockSymbol)){
                DisplayMonitor newMonitor = new DisplayMonitor(stock);
                newMonitor.setVisible(true);
                stock.attach(newMonitor);
            }
        }

    }

    public boolean checkForStock(String stockSymbol){
        //Checks to see if stock exists
        for(Stock stock: StockList){
            if(stock.getSymbol().equals(stockSymbol)){
                return true;
            }
        }
        return false;
    }


}

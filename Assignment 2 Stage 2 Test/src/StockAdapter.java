
import stockquoteservice.StockQuoteWS;
import stockquoteservice.StockQuoteWSPortType;
import java.util.ArrayList;
import java.util.List;

public class StockAdapter extends Stock{

    private String Symbol;
    private String Value;
    private String Date;
    private String Time;
    private ArrayList<Monitor> monitorList;
    private boolean stockState;
    private StockQuoteWS stockService = new StockQuoteWS();


    public StockAdapter(String stockSymbol) {
        this.Symbol = stockSymbol;
        this.monitorList = new ArrayList<Monitor>();
        this.stockState = false; //Assume stock data has not been changed yet

        //Retrieve initial values from web service
        List queryData = getData();
        this.Value = queryData.get(1).toString();
        this.Date = queryData.get(2).toString();
        this.Time = queryData.get(3).toString();


    }

    private List getData(){
        StockQuoteWSPortType SQPort = stockService.getStockQuoteWSSOAP11PortHttp();
        return SQPort.getQuote(this.Symbol);
    }

    public String getDate() {
        return this.Date;
    }

    public String getSymbol() {
        return this.Symbol;
    }


    public String getValue() {
        return this.Value;
    }

    public String getTime(){ return this.Time; }

    public void setValue() {
        this.Value = getData().get(1).toString();
        this.updateStockState(true);
        notifyMonitor();

    }

    public void setDate() {
        this.Date = getData().get(2).toString();
        this.updateStockState(true);
        notifyMonitor();
    }

    public void setTime(){
        this.Time = getData().get(3).toString();
        this.updateStockState(true);
        notifyMonitor();
    }

    public void attach(Monitor addNewMonitor) {
        this.monitorList.add(addNewMonitor);
    }

    public void detatch(Monitor deleteMonitor) {
        int monitorIndex = this.monitorList.indexOf(deleteMonitor);
        this.monitorList.remove(monitorIndex);

    }

    public void notifyMonitor() {
        for(Monitor monitor : this.monitorList){
            monitor.update(this);
        }
    }

    public boolean retrieveStockState() {
        return this.stockState;
    }

    public void updateStockState(boolean newStockState) {
        this.stockState = newStockState;

    }
}

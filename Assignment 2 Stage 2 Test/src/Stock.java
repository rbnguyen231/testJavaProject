


public abstract class Stock {

    public abstract String getDate();

    public abstract String getSymbol();

    public abstract String getValue();

    public abstract String getTime();

    public abstract void setValue();

    public abstract void setDate();

    public abstract void setTime();

    public abstract void attach(Monitor addNewMonitor);

    public abstract void detatch(Monitor deleteMonitor);

    public abstract void notifyMonitor();

    public abstract void updateStockState(boolean newStockState);

    public abstract boolean retrieveStockState();

}
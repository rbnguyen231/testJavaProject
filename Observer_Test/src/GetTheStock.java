import java.text.DecimalFormat;

public class GetTheStock implements Runnable{

    private int startTime;
    private String stock;
    private double price;

    private Subject stockGrabber;

    public GetTheStock(Subject stockGrabber, int newStartTime, String newStock, double newPrice){
        this.stockGrabber = stockGrabber;
        startTime = newStartTime;
        stock = newStock;
        price = newPrice;
    }

    @Override
    public void run() {
        //Changes price 20 times
        for(int i=1; i<=20; i++){
            try {
                Thread.sleep(2000); //Pause for two seconds before it executes code below
            }catch(InterruptedException e){}

            double randNum = (Math.random()*(0.06))- 0.03;
            DecimalFormat df = new DecimalFormat("#.##"); //Requires only two decimal places
            price = Double.valueOf(df.format(price+randNum));

            if(stock == "IBM"){
                ((StockGrabber)stockGrabber).setIBMPrice(price);
            }

            if(stock == "APPL"){
                ((StockGrabber)stockGrabber).setApplPrice(price);
            }

            if(stock == "GOOG"){
                ((StockGrabber)stockGrabber).setGoogPrice(price);
            }

            System.out.println(stock + ": " + df.format((price+randNum)) + " " + df.format(randNum));

        }
    }
}

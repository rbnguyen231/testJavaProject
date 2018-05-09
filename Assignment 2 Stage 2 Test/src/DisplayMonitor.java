

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DisplayMonitor extends JFrame implements Monitor {

    //Placeholders of where text and stock values will go
    private JLabel textStockSymbol = new JLabel("Stock Symbol: ");
    private JLabel displayStockSymbol = new JLabel();

    private JLabel textStockValue = new JLabel("Stock Value of Last Trade: ");
    private JLabel displayStockValue = new JLabel();

    private JLabel textStockDate = new JLabel("Date of Trade: ");
    private JLabel displayStockDate = new JLabel();

    private JLabel textStockTime = new JLabel("Time of Trade: ");
    private JLabel displayStockTime = new JLabel();

    private Stock currentStock;

    DisplayMonitor(Stock inputStock) {

        //New panel to display values
        JPanel displayText = new JPanel();

        //Stores its stock
        this.currentStock = inputStock;

        //Create header for stock display
        String stockSymbol = currentStock.getSymbol();
        String monitorTitle = "Monitor for: " + stockSymbol;

        //Format the values
        displayText.setLayout(new BoxLayout(displayText, BoxLayout.Y_AXIS));
        displayText.setBorder(BorderFactory.createEmptyBorder(10,10,10,50));

        //Set the header to a specific title
        TitledBorder border = BorderFactory.createTitledBorder(monitorTitle);
        displayText.setBorder(border);

        //Detatches monitor as soon as screen has closed
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                DisplayMonitor.this.currentStock.detatch(DisplayMonitor.this);
            }
        });

        //Sets size of the UI
        this.setSize(300,300);

        //Places the stock values in placeholders
        displayStockSymbol.setText(currentStock.getSymbol());
        displayStockValue.setText(currentStock.getValue());
        displayStockDate.setText(currentStock.getDate());
        displayStockTime.setText(currentStock.getTime());

        //Adds elements to the panel
        displayText.add(textStockSymbol);
        displayText.add(displayStockSymbol);

        displayText.add(textStockValue);
        displayText.add(displayStockValue);

        displayText.add(textStockDate);
        displayText.add(displayStockDate);

        displayText.add(textStockTime);
        displayText.add(displayStockTime);

        //Display the panel to the user
        this.add(displayText);

    }

    public void update(Stock newStock) {
        //Update the display monitor with its new values
        displayStockValue.setText(newStock.getValue());
        displayStockDate.setText(newStock.getDate());
        displayStockTime.setText(newStock.getTime());
    }




}


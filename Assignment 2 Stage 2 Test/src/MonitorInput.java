import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class MonitorInput extends JFrame{

    //Placeholders of where text and input for user will go
    private JTextField inputStockSymbol = new JTextField(20);
    private JButton displayButton = new JButton("Display Stock");
    private JToggleButton serviceToggle = new JToggleButton("StockQuoteWS");

    public MonitorInput() {

        //New panel is created
        JPanel buttonPanel = new JPanel();
        JPanel textPanel = new JPanel();


        //Create a title for the program
        TitledBorder border = BorderFactory.createTitledBorder("Stock Quote Monitor Application");


        //Set the program to exit when program is closed
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Determine size of the panel
        this.setSize(700,400);

        //Realign the input and button
        buttonPanel.setAlignmentY(SwingConstants.CENTER);
        textPanel.setAlignmentY(SwingConstants.CENTER);


        //Place the placeholders onto the panel
        textPanel.add(inputStockSymbol);
        buttonPanel.add(displayButton);

        //Panel to add the button and text on
        JPanel wholePanel = new JPanel();
        wholePanel.add(textPanel);
        wholePanel.add(buttonPanel);
        wholePanel.add(serviceToggle);

        setLayout(new GridBagLayout());
        wholePanel.setBorder(border);   //Add the title border
        add(wholePanel);

    }

    public String getStockSymbol(){
        //Retrieves symbol entered by the user
        return inputStockSymbol.getText();
    }

    //When button is clicked, calls Controller to handle it
    void addMonitorListener(ActionListener listenForDisplayButton){
        displayButton.addActionListener(listenForDisplayButton);

    }


}

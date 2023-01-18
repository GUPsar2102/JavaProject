package com.FORMS;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class FrontEnd extends WindowAdapter implements WindowListener, ActionListener {

    Frame Frame = new Frame();

    /*variables to fetch all the details*/
    public String firstname, lastname, pin;
    public long user_phone_number;

    Panel main_panel = new Panel(null);
    ScrollPane scp = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);

    /*Creating the text filed for first name*/
    TextField first_name_text = new TextField();

    /*Creating the text filed for last name*/
    TextField last_name_text = new TextField();

    /*Creating the text field for email*/
    TextField user_pin = new TextField();

    /*main method*/
    public static void main(String[] args) {
        FrontEnd obj = new FrontEnd();
        try {
            obj.FormMethod();
        } catch (IOException e) {
        }
    }

    public void FormMethod() throws IOException {

        /*setting icon image*/
        Image icon = Toolkit.getDefaultToolkit().getImage("R:\\icon.jpg");

        /*for creating the scroll bar facility firstly create panel, in that panel add all the components, then create a scroll pane, add the panel to the scroll pane then finally add
        the scroll pane to the main frame
        * */

        main_panel.setBounds(10, 0, 260, 380);
        main_panel.setBackground(Color.PINK);

        scp.setSize(390, 250);
        scp.setWheelScrollingEnabled(false);


        Frame.setIconImage(icon);
        Frame.setTitle("Customer Details");
        Frame.setSize(400, 260);
        Frame.setVisible(true);
        Frame.setLayout(new BorderLayout(7, 7));
        Frame.setLocationRelativeTo(null);
        Frame.setResizable(false);
        Frame.setFont(new Font("Serif", Font.BOLD, 13));


        first_name_text.setBounds(90, 40, 170, 20);

        /*creating the first name label*/
        Label label_for_first_name_text = new Label("First Name : ");
        label_for_first_name_text.setBounds(20, 40, 65, 20);


        last_name_text.setBounds(90, 100, 170, 20);

        /*creating the last name label*/
        Label label_for_last_name_text = new Label("Last Name : ");
        label_for_last_name_text.setBounds(20, 100, 65, 20);

        /*Creating the text field for personal identification number*/

        user_pin.setBounds(90, 160, 170, 20);

        /*Creating the label for the pin*/
        Label pin_label = new Label("PIN : ");
        pin_label.setBounds(20, 160, 65, 20);

      

       

        

        main_panel.add(first_name_text);
        main_panel.add(label_for_first_name_text);
        main_panel.add(last_name_text);
        main_panel.add(label_for_last_name_text);
        main_panel.add(user_pin);
        main_panel.add(pin_label);
        
      

        scp.add(main_panel);

        Frame.add(scp);
        Frame.addWindowListener(this);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Frame.dispose();
    }

    /*method for handling the button clicked event*/
    @Override
    public void actionPerformed(ActionEvent e) {
        /*extract all the details of the user entered in the form*/
        firstname = first_name_text.getText();
        lastname = last_name_text.getText();
        pin = user_pin.getText();
      
        // after this open the MAIN QUIZ WINDOW
        Frame.dispose();

        Front obj2 = new Front(firstname, lastname, pin);
        obj2.Stage(obj2.i);
    }
}
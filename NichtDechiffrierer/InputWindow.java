
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 public class InputWindow{
    JFrame mainFrame;
    JTextField textField, outputField;
    static JButton start;
    JLabel input, output;
    public static RoboterWelt context;
    public static InputWindow instance  = null;
    public  InputWindow(RoboterWelt con){      
        instance = this;
        
        context = con;
        mainFrame = new JFrame("Chiffrieren");
        mainFrame.setSize(250,200);
        FlowLayout layout = new FlowLayout();
        mainFrame.setLayout(layout);
        
        
        
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        textField = new JTextField("",20);
        textField.setSize(2000,2000);
        
        start = new JButton("chiffiffrieren");
       
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(int i = 0;i<100;i++){
                   System.out.println("Machs doch selber!!!");
                }              
            }
        });
        
        input = new JLabel("Input: ");
        output = new JLabel("Output: ");
        outputField = new JTextField(" Man fängt bei 1 an zu zählen :P ",40);
                           
        mainFrame.add(input);
        mainFrame.add(textField);
        mainFrame.add(start);
        mainFrame.add(output);
        mainFrame.add(outputField);
                         
        mainFrame.setVisible(true);
    }
    
    public void setResult(String res){
          outputField.setText(res);
          start.setEnabled(true);
    }
}



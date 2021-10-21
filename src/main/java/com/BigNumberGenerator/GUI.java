package com.BigNumberGenerator;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class GUI extends JFrame implements ActionListener {
    JPanel functionPanel = new JPanel();
    JRadioButton[] functions = new JRadioButton[4];
    ButtonGroup functionGroup = new ButtonGroup();
    
    JTextArea textArea = new JTextArea(16, 58);
    
    JTextArea finalResultTextArea = new JTextArea(16,58);
    
    JButton start = new JButton("Start");
    
    public GUI () {
        super("Big Number Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //function
        JLabel functionLabel = new JLabel("Choose program function.");
        functions[0] = new JRadioButton("Power");
        functions[1] = new JRadioButton("Just a Number");
        functions[2] = new JRadioButton("Start Counting Powers");
        functions[3] = new JRadioButton("Start Counting");

        
        functionPanel.add(functionLabel);

        functionPanel.add(functionLabel);
        ButtonGroup functionGroup = new ButtonGroup();
        for (JRadioButton function : functions) {
            functionGroup.add(function);
            functionPanel.add(function);
        }
        
        
        //text area
        
        JScrollPane textAreaScroll = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setText("Enter the number you wish to convert.");
        
        //start
        start.addActionListener(this);
        JPanel startPanel = new JPanel();
        startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.X_AXIS));
        startPanel.add(Box.createHorizontalGlue());
        startPanel.add(start);
        startPanel.add(Box.createHorizontalGlue());
        
        //final result
        finalResultTextArea.setEditable(false);
        finalResultTextArea.setLineWrap(true);
        finalResultTextArea.setText("Result will go here");
        
        JScrollPane scroll = new JScrollPane(finalResultTextArea);

        
        //master
        
        setLayout(new GridLayout(4, 0));
        add(functionPanel);
        add(textAreaScroll);
        add(startPanel);
        add(scroll);

        pack();
        setSize(700,300);
        setVisible(true);
    }
    
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.SystemLookAndFeel"
            );
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(functions[0].isSelected()) {
            PowerCreator pc = new PowerCreator(textArea.getText());
            pc.calculate();
            finalResultTextArea.setText(pc.getResult());
            repaint();
        } else if(functions[1].isSelected()) {
            JustANumberCreator janc = new JustANumberCreator(textArea.getText());
            janc.calculate();
            finalResultTextArea.setText("");
            for(int i = 0; i < janc.numberSplit.length; i++) {
                finalResultTextArea.append(janc.getResult(i));
                finalResultTextArea.append(System.lineSeparator());
            }
        } else if(functions[2].isSelected()) {
            int i = 0;
            BigDecimal power = new BigDecimal(-1);
            PowerCreator pc;
            while(i == 0) {
                power.add(new BigDecimal(1));
                pc = new PowerCreator(power.toPlainString());
                finalResultTextArea.append(pc.getResult());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        } else if(functions[3].isSelected()) {
            
        }
    }
    
    public static void main(String[] args) {
        setLookAndFeel();
        GUI gui = new GUI();
    }

}
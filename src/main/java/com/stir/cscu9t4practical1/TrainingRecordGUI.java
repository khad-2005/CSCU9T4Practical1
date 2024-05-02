// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField distanceTextField = new JTextField(4);
    private JTextField terrainTextField = new JTextField(10);
    private JTextField tempoTextField = new JTextField(10);
    private JTextField repetitionsTextField = new JTextField(10);
    private JTextField recoveryTextField = new JTextField(10);
    private JTextField whereTextField = new JTextField(10);
    private List<TrainingSession> tr = new ArrayList<>();
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find All By Date");
    private JComboBox<String> typeComboBox = new JComboBox<String>(new String[]{"Run", "Cycle", "Swim"});

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic= new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(outputArea);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        outputArea.setEditable(false);
        add(new JLabel("Terrain:"));
        add(terrainTextField);
        add(new JLabel("Tempo:"));
        add(tempoTextField);
        add(new JLabel("Repetitions:"));
        add(repetitionsTextField);
        add(new JLabel("Recovery:"));
        add(recoveryTextField);
        add(new JLabel("Where:"));
        add(whereTextField);
        add(typeComboBox);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
            message = findAllEntriesByDate();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String type = (String) typeComboBox.getSelectedItem();
        int d = Integer.parseInt(day.getText());
        int m = Integer.parseInt(month.getText());
        int y = Integer.parseInt(year.getText());
        int h = Integer.parseInt(hours.getText());
        int min = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        float dist = Float.parseFloat(distanceTextField.getText());
        String terrain = terrainTextField.getText();
        String tempo = tempoTextField.getText();
        int repetitions = Integer.parseInt(repetitionsTextField.getText());
        int recovery = Integer.parseInt(recoveryTextField.getText());
        String where = whereTextField.getText();
    
        if (type.equals("Run")) {
            tr.add(new Run(what, d, m, y, h, min, s, dist, repetitions, recovery));
        } else if (type.equals("Cycle")) {
            tr.add(new Cycle(what, d, m, y, h, min, s, dist, terrain, tempo));
        } else if (type.equals("Swim")) {
            tr.add(new Swim(what, d, m, y, h, min, s, dist, where));
        }
        return "Training session added successfully";
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public String findAllEntriesByDate() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        String message = myAthletes.findAllEntriesByDate(d, m, y);
        return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(TrainingSession ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));

        if (ent instanceof Cycle) {
            Cycle c = (Cycle) ent;
            terrainTextField.setText(c.getTerrain());
            tempoTextField.setText(c.getTempo());
        } else if (ent instanceof Run) {
            Run r = (Run) ent;
            repetitionsTextField.setText(String.valueOf(r.getRepetitions()));
            recoveryTextField.setText(String.valueOf(r.getRecovery()));
        } else if (ent instanceof Swim) {
            Swim s = (Swim) ent;
            whereTextField.setText(s.getWhere());
        }
    }

} // TrainingRecordGUI


package thenobrainerknight.main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {

    JPanel mainPanel = new JPanel();
    StartingMenu StartingMenu = new StartingMenu();

    MainMenu MainMenu = new MainMenu();

    public static void main(String[] args) {
        new Main();

    }

    public Main() {
        setVisible(true);
        setSize(500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        mainPanel.setLayout(new GridLayout());
        StartingMenu.setLayout(null);

        mainPanel.add(StartingMenu, BorderLayout.CENTER);
        add(mainPanel);
    }

    public void menupanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridLayout());
        MainMenu.setLayout(null);
        MainMenu.setSize(getSize());
        mainPanel.add(MainMenu, BorderLayout.CENTER);
        repaint();
    }
}

class StartingMenu extends JPanel {
    int Visuzlise = 0;

    JLabel ValueVisualizer = new JLabel(String.valueOf(Visuzlise));
    JButton UpButton = new JButton("˄");
    JButton DownButton = new JButton("˅");
    JButton ContinueButton = new JButton("Continue");

    public StartingMenu() {
        ValueVisualizer.setBounds(200, 50, 100, 100);
        add(ValueVisualizer);

        UpButton.setBounds(50, 50, 100, 50);
        UpButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Up");
                        Visuzlise++;
                        ValueVisualizer.setText(String.valueOf(Visuzlise));
                    }
                });
        add(UpButton);

        DownButton.setBounds(50, 100, 100, 50);
        DownButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Down");
                        Visuzlise--;
                        ValueVisualizer.setText(String.valueOf(Visuzlise));
                    }
                });
        add(DownButton);

        ContinueButton.setBounds(200, 500, 100, 50);
        ContinueButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Switch Page");
                    }
                });
        add(ContinueButton);
    }
}

class MainMenu extends JPanel {
    JLabel menuLabel = new JLabel("Menu");

    public MainMenu() {
        menuLabel.setBounds(100, 100, 100, 100);
        add(menuLabel);
        repaint();
    }
}

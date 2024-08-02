package Latiahan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomTitleBarExample extends JFrame {
    public CustomTitleBarExample() {
        // Set JFrame properties
        setUndecorated(true); // Remove the default title bar
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);

        // Create a panel for the custom title bar
        JPanel titleBar = new JPanel();
        titleBar.setBackground(Color.DARK_GRAY);
        titleBar.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Create buttons for close, minimize, and maximize
        JButton btnClose = new JButton("X");
        JButton btnMinimize = new JButton("_");
        JButton btnMaximize = new JButton("□");

        // Set button properties
        btnClose.setPreferredSize(new Dimension(45, 30));
        btnMinimize.setPreferredSize(new Dimension(45, 30));
        btnMaximize.setPreferredSize(new Dimension(45, 30));

        // Add action listeners to the buttons
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnMinimize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setState(Frame.ICONIFIED);
            }
        });

        btnMaximize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getExtendedState() == Frame.MAXIMIZED_BOTH) {
                    setExtendedState(Frame.NORMAL);
                } else {
                    setExtendedState(Frame.MAXIMIZED_BOTH);
                }
            }
        });

        // Add buttons to the title bar panel
        titleBar.add(btnMinimize);
        titleBar.add(btnMaximize);
        titleBar.add(btnClose);

        // Add the custom title bar to the JFrame
        add(titleBar, BorderLayout.NORTH);

        // Add a main panel for content
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY);
        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CustomTitleBarExample frame = new CustomTitleBarExample();
                frame.setVisible(true);
            }
        });
    }
}

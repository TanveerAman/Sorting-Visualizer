import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    JPanel MainPanel;
    JLabel title;
    JButton bubbleSortButton;
    JButton insertionSortButton;
    JButton selectionSortButton;
    JButton quickSortButton;
    JButton mergeSortButton;
    JLabel bubbleDescription;
    JLabel selectionDescription;
    JLabel insertionDescription;
    JLabel quickDescription;
    JLabel mergeDescription;

    public MainMenu() {
        bubbleSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Bubble Sort");
                bubble sort1 = new bubble();
                frame.setResizable(false);
                frame.setContentPane(sort1);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        insertionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertion sort2 = new insertion();
                JFrame frame = new JFrame("Insertion Sort");
                frame.setResizable(false);
                frame.setContentPane(sort2);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        selectionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selection sort3 = new selection();
                JFrame frame = new JFrame("Selection Sort");
                frame.setResizable(false);
                frame.setContentPane(sort3);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        quickSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quicksort sort4 = new quicksort();
                JFrame frame = new JFrame("Quicksort Sort");
                frame.setResizable(false);
                frame.setContentPane(sort4);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        mergeSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mergesort sort5 = new mergesort();
                JFrame frame = new JFrame("Merge Sort");
                frame.setResizable(false);
                frame.setContentPane(sort5);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame("Sorting Algorithm Visualizer");
        frame.setContentPane(new MainMenu().MainPanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(10, 10, 400, 500);
        frame.setResizable(false);
    }
}
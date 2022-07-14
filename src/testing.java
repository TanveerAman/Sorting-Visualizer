import javax.swing.*;
import java.awt.*;
import java.util.Random;

/*class addGUI extends JFrame {
    public addGUI() {

        JTextField t1 = new JTextField(20);
        JTextField t2 = new JTextField(20);
        JButton b = new JButton("add");
        JLabel l = new JLabel("Result");

        add(t1);
        add(t2);
        add(b);
        add(l);

        //this.pack();
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}*/

public class testing {
    static int size = 20;
    static int [] bar_height = new int[size];

    static void setHeight() {
        for(int i=0; i<size; i++){
            bar_height [i] = (i+1);
            //bar_height [i] = i * scale;
        }
    }

    static void print(){
        for (int i=0; i<size; i++){
            System.out.print(bar_height[i]+" ");
        }
        System.out.println();
    }

    static void shuffle() {
        for(int i=0; i<size; i++) {
            int random_i = new Random().nextInt(size);
            swap(i, random_i);
        }
    }

    static void swap(int a, int b) {
        int temp = bar_height[a];
        bar_height[a]=bar_height[b];
        bar_height[b]=temp;
    }

    static int partition(int lower, int upper) {
        int pivot = bar_height[upper];
        int i = (lower-1); // index of smaller element
        for (int j=lower; j<upper; j++) {
            if (bar_height[j] <= pivot) {
                i++;
                swap(i, j);
            }
       }
        swap(i+1, upper);
        return i+1;
    }

    /* The main function that implements QuickSort()
      bar_height[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void quickSort(int low, int high) {
        if (low < high) {
            int pivot = partition(low, high);

            quickSort(low, pivot-1);
            quickSort(pivot+1, high);
        }
    }


    public static void main (String[] args) {
        setHeight();
        shuffle();
        print();
        quickSort(0, size-1);
        print();

    }
}

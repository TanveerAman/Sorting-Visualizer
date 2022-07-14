import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class quicksort extends JPanel{
    int size = 600, width=1200, height=600, bar_width = width/size;
    int delay = 10;
    int [] bar_height = new int[size];
    int LOW, HIGH, pivot=size-1;

    public quicksort() {
        setBackground(Color.BLACK);
        Dimension d = new Dimension(width, height);
        setPreferredSize(d);
        setBar_height();
        shuffle();
        quickSort(0, size-1);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        for(int i=0; i<size; i++) {
            g.fillRect(i*bar_width,height-bar_height[i], bar_width, bar_height [i]);
        }

        try{
            g.setColor(Color.GREEN);
            g.fillRect((LOW)*bar_width,height-bar_height[LOW], bar_width, bar_height [LOW]);
        }catch (Exception ignored){}

        try{
            g.setColor(Color.BLUE);
            g.fillRect((HIGH)*bar_width,height-bar_height[HIGH], bar_width, bar_height [HIGH]);
        } catch (Exception ignored){}

        try{
            g.setColor(Color.RED);
            g.fillRect((pivot)*bar_width,height-bar_height[pivot], bar_width, bar_height [pivot]);
        } catch (Exception ignored){}
    }

    void setBar_height() {
        int scale = height/size;
        for(int i=0; i<size; i++){
            bar_height [i] = (i+1) * scale;
            //bar_height [i] = i * scale;
        }
    }

    /*public int partition(int l, int h) throws InterruptedException {
        int x = bar_height[h];
        int i = (l - 1);

        for (int j = l; j <= h - 1; j++) {
            if (bar_height[j] <= x) {
                i++;
                swap(i, j);
                Thread.sleep(delay);
                repaint();
            }
        }
        swap(i + 1, h);
        return (i + 1);
    }*/

    /*public void quickSort() {
        SwingWorker<Void, Void> sorter = new SwingWorker<>() {
            @Override
            public Void doInBackground() throws InterruptedException {
                lower=0;
                upper=size-1;
                int [] stack = new int[upper - lower + 1];

                top = -1;

                stack[++top] = lower;
                stack[++top] = upper;

                while (top >= 0) {
                    upper = stack[top--];
                    lower = stack[top--];

                    pivot = partition(lower, upper);

                    Thread.sleep(delay);
                    repaint();

                    if (pivot - 1 > lower) {
                        stack[++top] = lower;
                        stack[++top] = pivot - 1;
                    }

                    if (pivot + 1 < upper) {
                        stack[++top] = pivot + 1;
                        stack[++top] = upper;
                    }
                }
                //i=j=0;
                return null;
            }
            @Override
            public void done() {
                super.done();
            }
        };
        sorter.execute();
    }*/

    int partition(int lower, int upper) throws InterruptedException{
        int pivot = bar_height[upper];

        int i = (lower-1);
        for (int j=lower; j<upper; j++) {
            if (bar_height[j] <= pivot) {
                i++;
                swap(i, j);
                LOW=i;
                HIGH=j;
            }
            //this.pivot=pivot;
            Thread.sleep(delay);
            repaint();
        }
        swap(i+1, upper);
        LOW=i+1;
        HIGH=upper;
        return i+1;
    }

    public void quickSort(int low, int high) {
        SwingWorker<Void, Void> sorter = new SwingWorker<>() {
            @Override
            public Void doInBackground() throws InterruptedException {
                //if (low<size) {LOW = low;}
                LOW=low;
                HIGH=high;
                if (low < high) {
                    int pivot = partition(low, high);
                    quicksort.this.pivot =high;
                    Thread.sleep(delay);
                    repaint();
                    quickSort(low, pivot-1);
                    Thread.sleep(delay);
                    repaint();
                    quickSort(pivot+1, high);
                    Thread.sleep(delay);
                    repaint();
                }
                return null;
            }
            @Override
            public void done() {
                super.done();
            }
        };
        sorter.execute();
    }

    void shuffle() {
        for(int i=0; i<size; i++) {
            int random_i = new Random().nextInt(size);
            swap(i, random_i);
        }
    }

    void swap(int a, int b) {
        int temp = bar_height[a];
        bar_height[a]=bar_height[b];
        bar_height[b]=temp;
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame("Quicksort Sort");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new quicksort());
        frame.validate();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
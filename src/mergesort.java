import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class mergesort extends JPanel{
    int size = 600, width=1200, height=600, bar_width = width/size;
    int delay = 10;
    int [] bar_height = new int[size];
    int CURR, LEFT, MID, RIGHT;


    public mergesort() {
        setBackground(Color.BLACK);
        Dimension d = new Dimension(width, height);
        setPreferredSize(d);
        setBar_height();
        shuffle();
        mergeSort();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        //g.fillRect(5,0,5,10);
        for(int i=0; i<size; i++) {
            g.fillRect(i*bar_width,height-bar_height[i], bar_width, bar_height [i]);
            //g.setColor(Color.WHITE);
            //g.drawRect(i*bar_width,0, bar_width, bar_height[i]);
        }

        try {
            g.setColor(Color.YELLOW);
            g.fillRect(LEFT *bar_width,height-bar_height[LEFT], bar_width, bar_height [LEFT]);
        }catch (Exception ignored){}

        try {
            g.setColor(Color.BLUE);
            g.fillRect(MID *bar_width,height-bar_height[MID], bar_width, bar_height [MID]);
        }catch (Exception ignored){}

        try {
            g.setColor(Color.RED);
            g.fillRect(RIGHT *bar_width,height-bar_height[RIGHT], bar_width, bar_height [RIGHT]);
        }catch (Exception ignored){}g.setColor(Color.BLUE);
    }

    void setBar_height() {
        int scale = height/size;
        for(int i=0; i<size; i++){
            bar_height [i] = (i+1) * scale;
            //bar_height [i] = i * scale;
        }
    }

    void merge(int l, int m, int r) throws InterruptedException {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        int [] L = new int[n1];
        int [] R = new int[n2];

        for (i = 0; i < n1; i++)
            L[i] = bar_height[l + i];
        for (j = 0; j < n2; j++)
            R[j] = bar_height[m + 1+ j];
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                bar_height[k] = L[i];
                i++;
            }
            else {
                bar_height[k] = R[j];
                j++;
            }
            k++;
            Thread.sleep(delay);
            repaint();
        }
        while (i < n1) {
            bar_height[k] = L[i];
            i++;
            k++;
            Thread.sleep(delay);
            repaint();
        }
        while (j < n2) {
            bar_height[k] = R[j];
            j++;
            k++;
            Thread.sleep(delay);
            repaint();
        }
    }

    /*public void merge(int l, int m, int r) {
        SwingWorker<Void, Void> sorterHelp = new SwingWorker<>() {
            @Override
            public Void doInBackground() throws InterruptedException {
                int i, j, k;
                int n1 = m - l + 1;
                int n2 = r - m;

                int [] L = new int[n1];
                int [] R = new int[n2];

                for (i = 0; i < n1; i++)
                    L[i] = bar_height[l + i];
                for (j = 0; j < n2; j++)
                    R[j] = bar_height[m + 1+ j];
                i = 0;
                j = 0;
                k = l;
                while (i < n1 && j < n2) {
                    if (L[i] <= R[j]) {
                        bar_height[k] = L[i];
                        i++;
                    } else {
                        bar_height[k] = R[j];
                        j++;
                    }
                    k++;
                    Thread.sleep(delay);
                    repaint();
                }
                while (i < n1) {
                    bar_height[k] = L[i];
                    i++;
                    k++;
                    Thread.sleep(delay);
                    repaint();
                }
                while (j < n2) {
                    bar_height[k] = R[j];
                    j++;
                    k++;
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
        sorterHelp.execute();
    }*/

    public void mergeSort() {
        SwingWorker<Void, Void> sorter = new SwingWorker<>() {
            @Override
            public Void doInBackground() throws InterruptedException {
                int curr, left, mid, right;
                for (curr =1; curr<=size-1; curr=2*curr) {
                    CURR=curr;
                    for (left=0; left<size-1; left += 2*curr) {
                        LEFT = left;
                        MID = mid = Math.min(left + curr - 1, size-1);
                        RIGHT = right = Math.min(left + 2*curr - 1, size-1);
                        merge(left, mid, right);
                        Thread.sleep(delay);
                        repaint();
                    }
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
        JFrame frame = new JFrame("Merge Sort");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new mergesort());
        frame.validate();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class selection extends JPanel{
    int size = 600, width=1200, height=600, bar_width = width/size;
    int delay = 1;
    int [] bar_height = new int[size];
    int i, j, min;

    public selection() {
        setBackground(Color.BLACK);
        Dimension d = new Dimension(width, height);
        setPreferredSize(d);
        setBar_height();
        shuffle();
        selectionSort();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        for(int i=0; i<size; i++) {
            g.fillRect(i*bar_width,height-bar_height[i], bar_width, bar_height [i]);
        }
        try {
            g.setColor(Color.RED);
            g.fillRect((j) * bar_width, height - bar_height[j], bar_width, bar_height[j]);
        }catch (Exception ignored){}

        try {
            g.setColor(Color.BLUE);
            g.fillRect((min) * bar_width, height - bar_height[min], bar_width, bar_height[min]);
        }catch (Exception ignored){}

        try {
            g.setColor(Color.GREEN);
            g.fillRect((i) * bar_width, height - bar_height[i], bar_width, bar_height[i]);
        }catch (Exception ignored){}
    }

    void setBar_height() {
        int scale = height/size;
        for(int i=0; i<size; i++){
            bar_height [i] = (i+1) * scale;
            //bar_height [i] = i * scale;
        }
    }

    public void selectionSort() {
        SwingWorker<Void, Void> sorter = new SwingWorker<>() {
            @Override
            public Void doInBackground() throws InterruptedException {
                for (i = 0; i < size-1; i++) {
                    min = i;
                    for (j = i+1; j < size; j++) {
                        if (bar_height[j] < bar_height[min]) {
                            min = j;
                        }
                        Thread.sleep(delay);
                        repaint();
                    }
                    swap(min, i);
                }
                i=j=min=0;
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
        JFrame frame = new JFrame("Selection Sort");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new selection());
        frame.validate();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
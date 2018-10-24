package runner;

import flyweight.FlyweightFactory;
import flyweight.circle.FlyweightCircle;
import flyweight.rect.FlyweightRectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Application that actually uses Flyweight Pattern.
 *
 * @author Ziang Lu
 */
public class FlyweightPatternTest extends JFrame {

    /**
     * Width of the window.
     */
    private static final int WINDOW_WIDTH = 1500;
    /**
     * Height of the window.
     */
    private static final int WINDOW_HEIGHT = 1000;
    /**
     * Candidate colors.
     */
    private static final Color[] COLORS = {Color.BLACK, Color.BLUE, Color. CYAN, Color.GRAY, Color.MAGENTA,
            Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};

    /**
     * Random number generator to use.
     */
    private Random random = new Random();

    /**
     * Default constructor.
     */
    private FlyweightPatternTest() {
        // Set the basic information for this frame
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Flyweight Pattern Demo");

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        JPanel drawingPanel = new JPanel();
        contentPane.add(drawingPanel, BorderLayout.CENTER);

        JButton startDrawing = new JButton("Start drawing!");
        startDrawing.addActionListener((e) -> {
            Graphics g = drawingPanel.getGraphics();
            FlyweightFactory flyweightFactory = FlyweightFactory.getInstance();
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000; ++i) {
                if (random.nextBoolean()) {
                    FlyweightCircle circle = flyweightFactory.getColoredCircle(getRandomColor());
                    circle.setX(getRandomX());
                    circle.setY(getRandomY());
                    circle.setRadius(getRandomY());
                    circle.draw(g);
                } else {
                    FlyweightRectangle rect = flyweightFactory.getColoredRectangle(getRandomColor());
                    rect.setTopLeftX(getRandomX());
                    rect.setTopLeftY(getRandomY());
                    rect.setWidth(getRandomX());
                    rect.setHeight(getRandomY());
                    rect.draw(g);
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("It took " + (end - start) + " ms to draw 100000 circles/rectangles.");
        });
        contentPane.add(startDrawing, BorderLayout.SOUTH);

        add(contentPane);

        // Display the frame
        setVisible(true);
    }

    /**
     * Private helper method to get a random color.
     * @return random color
     */
    private Color getRandomColor() {
        return COLORS[random.nextInt(COLORS.length)];
    }

    /**
     * Private helper method to get a random fraction of the window width.
     * @return random fraction of the window width
     */
    private int getRandomX() {
        return (int) (random.nextDouble() * WINDOW_WIDTH);
    }

    /**
     * Private helper method to get a random fraction of the window height.
     * @return random fraction of the window height
     */
    private int getRandomY() {
        return (int) (random.nextDouble() * WINDOW_HEIGHT);
    }

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        new FlyweightPatternTest();
    }

}

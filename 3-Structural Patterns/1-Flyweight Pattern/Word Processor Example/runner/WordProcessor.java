package runner;

import flyweight.FlyweightLetterFactory;
import flyweight.Letter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.util.Random;
import java.util.Scanner;

/**
 * Application that actually uses Flyweight Pattern.
 *
 * @author Ziang Lu
 */
public class WordProcessor extends JFrame {

    /**
     * Width of the window.
     */
    private static final int WINDOW_WIDTH = 1500;
    /**
     * Height of the window.
     */
    private static final int WINDOW_HEIGHT = 1000;
    /**
     * Line height of the window.
     */
    private static final int LINE_HEIGHT = 100;
    /**
     * Candidate font family names.
     */
    private static final String[] FONT_FAMILY_NAMES = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    /**
     * Candidate colors.
     */
    private static final Color[] COLORS = {Color.BLACK, Color.BLUE, Color. CYAN, Color.GRAY, Color.MAGENTA,
            Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};

    /**
     * Text to render.
     */
    private String text = "";
    /**
     * Random number generator to use.
     */
    private Random random = new Random();
    /**
     * Width of the current line.
     */
    private int currLineWidth = 0;
    /**
     * Height of the current line.
     */
    private int currLineHeight = LINE_HEIGHT;

    /**
     * Default constructor.
     */
    private WordProcessor() {
        // Get the text
        getText();

        // Set the basic information for this frame
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Flyweight Pattern Demo");

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        JPanel renderPanel = new JPanel();
        contentPane.add(renderPanel, BorderLayout.CENTER);

        JButton startRender = new JButton("Start render!");
        startRender.addActionListener((e) -> {
            Graphics g = contentPane.getGraphics();
            FlyweightLetterFactory flyweightLetterFactory = FlyweightLetterFactory.getInstance();
            for (char c : text.toCharArray()) {
                Letter letter = flyweightLetterFactory.getLetter(c);
                randomSetLetter(letter);
                letter.draw(g);
            }
        });
        contentPane.add(startRender, BorderLayout.SOUTH);

        add(contentPane);

        // Display the frame
        setVisible(true);
    }

    /**
     * Private helper method to get the input text.
     */
    private void getText() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            text = scanner.nextLine();
        }
    }

    /**
     * Private helper method to randomly set the given letter.
     * @param letter letter to set
     */
    private void randomSetLetter(Letter letter) {
        int letterSize = getRandomLetterSize();
        letter.setHorizontalPos(currLineWidth + letterSize / 2);
        letter.setVerticalPos(currLineHeight);
        letter.setFont(new Font(getRandomFontFamilyName(), Font.PLAIN, (int) (letterSize * 0.9)));
        letter.setColor(getRandomColor());
        if ((currLineWidth + letterSize) <= WINDOW_WIDTH) {
            currLineWidth += letterSize;
        } else {
            currLineHeight += LINE_HEIGHT;
            currLineWidth = 0;
        }
    }

    /**
     * Helper method get a random letter size.
     * @return random letter size
     */
    private int getRandomLetterSize() {
        return random.nextInt(100) + 50;
    }

    /**
     * Helper method to get a random font family name.
     * @return random font family name
     */
    private String getRandomFontFamilyName() {
        return FONT_FAMILY_NAMES[random.nextInt(FONT_FAMILY_NAMES.length)];
    }

    /**
     * Helper method to get a random color.
     * @return random color
     */
    private Color getRandomColor() {
        return COLORS[random.nextInt(COLORS.length)];
    }

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        new WordProcessor();
    }

}

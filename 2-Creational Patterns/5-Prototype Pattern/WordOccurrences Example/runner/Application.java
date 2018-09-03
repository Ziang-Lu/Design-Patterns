package runner;

import prototype.WordOccurrences;

/**
 * Application that actually uses WordOccurrences objects to perform some tasks.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        String text = "The prototype pattern is a creational design pattern in software development first described in the book Design Patterns.";
        String word = "pattern";
        WordOccurrences prototype = new WordOccurrences(text, word);

        try {
            WordOccurrences product = prototype.clone();
            System.out.println(product.getNthOccurrence(1));
            WordOccurrences anotherProduct = prototype.clone();
            System.out.println(anotherProduct.getNthOccurrence(1));
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
    }

}

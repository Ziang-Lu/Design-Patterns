package prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to buffer the positions of occurrences for a word within some text.
 *
 * Recall that one of the applicabilities of Prototype Pattern is:
 * Avoid the inherent cost of creating a new object in the standard way (using
 * the 'new' operator), when it us prohibitively expensive for a given
 * application.
 *
 * This is exactly the case.
 * The construction of one object is expensive since it performs expensive
 * searching operations in the initialization process. Thus if we want to get a
 * new instance with the same attributes using the standard way (using the
 * 'new') operator, we have to do the expensive searching operations again.
 * Thus, we simply use Prototype Pattern, and clones a copy of the prototype
 * every time we need a new instance.
 *
 * @author Ziang Lu
 */
public class WordOccurrences extends Prototype {

    /**
     * Background text.
     */
    private final String text;
    /**
     * Word to search.
     */
    private final String word;
    /**
     * Positions of all the occurrences of word in text.
     */
    private final List<Integer> occurrences;

    /**
     * Constructor with parameter.
     * @param text background text
     * @param word word to search
     */
    public WordOccurrences(String text, String word) {
        this.text = text;
        this.word = word;
        occurrences = new ArrayList<>();

        int idx = 0;
        while (idx < text.length()) {
            int parseEnd = Math.min(idx + word.length(), text.length());
            String wordInText = text.substring(idx, parseEnd);
            if (wordInText.compareToIgnoreCase(word) == 0) {
                occurrences.add(idx);
                idx = parseEnd;
            } else {
                ++idx;
            }
        }
    }

    /**
     * Returns the position of word's n-th occurrence in text (zero-based).
     * @param n zero-based n-th appearance to get
     * @return position of the n-th occurrence in text
     */
    public int getNthOccurrence(int n) {
        // Check whether the input index is valid
        if ((n < 0) || (n >= occurrences.size())) {
            return -1;
        }
        return occurrences.get(n);
    }

    @Override
    public WordOccurrences clone() throws CloneNotSupportedException {
        WordOccurrences cloned = (WordOccurrences) super.clone();
        cloned.occurrences = new ArrayList<>(occurrences); // Make sure to deep copy
        return cloned;
    }

}

package runner;

import model.Lecture;
import model.Topic;
import model.Video;

/**
 * Application that actually uses Composite Pattern.
 *
 * @author Ziang Lu
 */
public class CompositePatternTest {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Topic designPatterns = new Topic("Design Patterns");

        Lecture patternsIntro = new Lecture("Intro to Design Patterns");
        designPatterns.addModule(patternsIntro);

        Topic composite = new Topic("Composite Pattern");
        designPatterns.addModule(composite);

        Lecture compositeIntro = new Lecture("Intro to Composite Pattern");
        composite.addModule(compositeIntro);
        Video compositeVideo = new Video("Let's compose!");
        composite.addModule(compositeVideo);

        Topic observer = new Topic("Observer Pattern");
        designPatterns.addModule(observer);

        Lecture observerIntro = new Lecture("Intro to Observer Pattern");
        observer.addModule(observerIntro);

        designPatterns.display("\t");

        /*
         * Output:
         * 	   Topic - Design Patterns
         * 	       Lecture - Intro to Design Patterns
         * 	       Topic - Composite Pattern
         * 	               Lecture - Intro to Composite Pattern
         * 	               Video - Let's compose!
         * 	       Topic - Observer Pattern
         * 	               Lecture - Intro to Observer Pattern
         */
    }

}

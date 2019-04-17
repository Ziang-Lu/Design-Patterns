package subject;

import java.time.Instant;

/**
 * Tweet class.
 *
 * @author Ziang Lu
 */
public class Tweet {

    /**
     * Timestamp that this tweet is created.
     */
    private final Instant timestamp;
    /**
     * Content of this tweet.
     */
    private final String content;

    /**
     * Constructor with parameter.
     * @param content content of the tweet
     */
    Tweet(String content) {
        timestamp = Instant.now();
        this.content = content;
    }

    /**
     * Accessor of content.
     * @return content
     */
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return timestamp.toString() + " -> " + content;
    }

}

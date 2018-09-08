package game;

import scouting.ScoutingFacade;

/**
 * Application that actually uses Facade Pattern.
 * Note that by using Facade Pattern, the application now doesn't necessarily to
 * know the complex logic and implementation details in the sub-components, but
 * only need to interact with the Facade.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        ScoutingFacade scouting = new ScoutingFacade("Medieval");
        scouting.startScouting("Northeast");
        scouting.stopScouting();
        scouting.getScoutingReport();
    }

}

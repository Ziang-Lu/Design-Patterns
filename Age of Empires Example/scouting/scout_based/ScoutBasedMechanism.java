package scouting.scout_based;

import scouting.ScoutingMechanism;
import scouting.scouting_model.Scout;

/**
 * Concrete ScoutBasedMechanism to perform the scouting tasks (solve the
 * scouting problems) based on scouts.
 *
 * @author Ziang Lu
 */
public class ScoutBasedMechanism implements ScoutingMechanism {

    @Override
    public void startScouting(String startDirection) {
        Scout scout = new Scout("Jack");
        Paladin paladin = new Paladin();
        paladin.follow(scout);

        scout.explore(startDirection);
    }

    @Override
    public void stopScouting() {
        System.out.println("Scout stops scouting.");
    }

}

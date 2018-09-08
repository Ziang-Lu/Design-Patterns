package scouting.scout_based;

import scouting.scouting_model.Scout;

/**
 * Paladin class that guards scouts.
 *
 * @author Ziang Lu
 */
class Paladin {

    /**
     * Guards the given scout.
     * @param scout scout to guard
     */
    void follow(Scout scout) {
        System.out.println("Start following " + scout.getName());
    }

}

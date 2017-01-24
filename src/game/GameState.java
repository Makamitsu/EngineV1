package game;

/**
 * Here, there is all the possible state of our game according to our Workflow gameState chart.
 * Each item symbolized a state that represents the progression done by the player during the
 * playthrough.
 */
public enum GameState {
    /**
     * The game just begin and the player has to speak to the unicorn go forward.
     *
     * ROOM reachable: tower
     * KEY NPC : unicorn
     */
    INIT,

    /**
     * The player spoke to the unicorn and now has to find the pass A38 in the banquetHall
     * given by one of the guest
     *
     * ROOM reachable: SAME + courtyard, kitchen, banquet, vestibule
     * KEY NPC : villager2 -> Bored man
     */
    START,

    /**
     * The player get the pass A38 and can now go to the throneHall to speak to the
     * queen's adviser.
     *
     * ROOM reachable: SAME + throneHall
     */
    GETPASS,

    /**
     * The player has now speak to the queen advisor, and now he has to speak to the
     * commis or the chief.
     *
     * ROOM reachable: SAME
     */
    SPEACKADVISER,

    /**
     * Now the player know he has to go the basement to find out all the ingredients
     * for a muffins to the queen.
     *
     * ROOM reachable: SAME + basement
     */
    FINDMUFFIN,

    /**
     * Now the player did the right muffin and give it to the queen. The queen give back
     * the stables key in exchange.
     *
     * ROOM reachable: SAME + stables
     */
    FINDTHIEF,

    /**
     * The game is OVER
     */
    GAMEOVER}

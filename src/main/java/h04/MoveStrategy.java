package h04;

import fopbot.Field;
import fopbot.Robot;

public interface MoveStrategy {

    /**
     * Moves a Robot to a specific field
     * @param robot to be move
     * @param field to the specific field
     */
    public void start(Robot robot, Field field);
}

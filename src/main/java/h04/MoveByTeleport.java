package h04;

import fopbot.Field;
import fopbot.Robot;

public class MoveByTeleport implements MoveStrategy {

    @Override
    public void start(Robot robot, Field field) {
        robot.setField(field.getX(), field.getY());
    }
}

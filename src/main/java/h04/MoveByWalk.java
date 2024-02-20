package h04;

import fopbot.Direction;
import fopbot.Field;
import fopbot.Robot;

public class MoveByWalk implements MoveStrategyWithCounter {
    private int moveCounter;


    @Override
    public void start(Robot robot, Field field) {
        int goalX = field.getX();
        int goalY = field.getY();

        while (robot.getX() != goalX || robot.getY() != goalY) {
            if (robot.getX() < goalX) {
                while (robot.getDirection() != Direction.RIGHT) {
                    robot.turnLeft();
                }
                robot.move();
                moveCounter++;
            }
            else if (goalX < robot.getX()) {
                while (robot.getDirection() != Direction.LEFT) {
                    robot.turnLeft();
                }
                robot.move();
                moveCounter++;
            }
            if (robot.getY() < goalY) {
                while (robot.getDirection() != Direction.UP) {
                    robot.turnLeft();
                }
                robot.move();
                moveCounter++;
            }
            else if (goalY < robot.getY()) {
                while (robot.getDirection() != Direction.DOWN) {
                    robot.turnLeft();
                }
                robot.move();
                moveCounter++;
            }
        }
    }

    @Override
    public int getMoveCount() {
        return moveCounter;
    }
}

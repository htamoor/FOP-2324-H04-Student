package h04;

import fopbot.Field;
import fopbot.Robot;

public class RobotMover implements FieldSelectionListener {
    private MoveStrategy moveStrategy;
    private Robot[] robots = new Robot[10];
    private int numberOfRobots;

    public RobotMover(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    @Override
    public void onFieldSelection(Field selectedField) {
        for (Robot robot : robots) {
            moveStrategy.start(robot, selectedField);
        }
    }

    /**
     * Adds a robot to the RobotMover.
     *
     * @param robot The robot to add.
     */
    public void addRobot(Robot robot) {
        robots[numberOfRobots] = robot;
        numberOfRobots++;
    }
}

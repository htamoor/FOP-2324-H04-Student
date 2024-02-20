package h04;

import fopbot.*;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * Main entry point in executing the program.
 */
public class Main {
    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {
        World.setVisible(true);
        main01();
        main02();
    }

    public static void main01() {
        MouseFieldSelector mouseFieldSelector = new MouseFieldSelector();
        MoveByWalk move = new MoveByWalk();
        RobotMover mover = new RobotMover(move);
        mouseFieldSelector.setFieldSelectionListener(mover);
        Robot r1 = new Robot(0, 3, RobotFamily.SQUARE_RED);
        Robot r2 = new Robot(4, 4, RobotFamily.SQUARE_GREEN);
        Robot r3 = new Robot(2, 2, RobotFamily.SQUARE_BLUE);
        mover.addRobot(r1);
        mover.addRobot(r2);
        mover.addRobot(r3);

    }

    public static void main02() {
        KeyboardFieldSelector keyboardFieldSelector = new KeyboardFieldSelector();
        MoveByTeleport moveByTeleport = new MoveByTeleport();
        MoveableRobot moveableRobot = new MoveableRobot(moveByTeleport);
        keyboardFieldSelector.setFieldSelectionListener(moveableRobot);
    }
}

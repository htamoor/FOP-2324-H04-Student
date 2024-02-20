package h04;

import fopbot.Field;
import fopbot.Robot;

import java.awt.*;

public class MoveableRobot extends Robot implements FieldSelectionListener {

    private final MoveStrategy moveStrategy;
    private int moveCounter;

    public MoveableRobot(MoveStrategy moveStrategy) {
        super(0, 0);
        this.moveStrategy = moveStrategy;
    }

    @Override
    public void onFieldSelection(Field field) {
        moveStrategy.start(this, field);
        if (moveStrategy instanceof MoveStrategyWithCounter) {
            moveCounter = ((MoveStrategyWithCounter) moveStrategy).getMoveCount();
        }
        for (int i = 0; i < moveCounter; i++) {
            this.turnLeft();
        }
    }
}

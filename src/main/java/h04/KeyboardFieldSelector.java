package h04;

import fopbot.Field;
import fopbot.Key;
import fopbot.KeyPressEvent;
import fopbot.KeyPressListener;

import java.awt.*;

public class KeyboardFieldSelector implements FieldSelector, KeyPressListener {

    private FieldSelectionListener listener;
    private Field markedField;

    @Override
    public void setFieldSelectionListener(FieldSelectionListener listener) {
        this.listener = listener;
    }

    @Override
    public void onKeyPress(KeyPressEvent event) {
        var world = event.getWorld();
        var key = event.getKey();
        if (markedField == null) {
            markedField = world.getField(0, 0);
            markedField.setFieldColor(Color.RED);
            return;
        }
        if (key != Key.LEFT && key != Key.RIGHT && key != Key.UP && key != Key.DOWN && key != Key.SPACE) {
            return;
        }
        int dX = key == Key.LEFT ? -1 : key == Key.RIGHT ? 1 : 0;
        int dY = key == Key.UP ? 1 : key == Key.DOWN ? -1 : 0;

        int w = world.getWidth();
        int h = world.getHeight();

        int x = markedField.getX();
        int y = markedField.getY();

        // Update x and y based on the direction
        x = Math.floorMod(x + dX, w);
        y = Math.floorMod(y + dY, h);

        // Get the field in the new position
        Field newField = world.getField(x, y);

        // If newField is null, stay in the current position
        if (newField == null) {
            return;
        }

        // Unmark the previous field
        markedField.setFieldColor(null);

        // Mark the new field
        newField.setFieldColor(Color.RED);

        // If space is pressed, call onFieldSelection
        if (key == Key.SPACE) {
            listener.onFieldSelection(newField);
        }

        // Update markedField
        markedField = newField;
    }
}


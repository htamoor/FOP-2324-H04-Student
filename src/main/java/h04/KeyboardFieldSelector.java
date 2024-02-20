package h04;

import fopbot.Field;
import fopbot.Key;
import fopbot.KeyPressEvent;
import fopbot.KeyPressListener;

import java.awt.*;

public class KeyboardFieldSelector implements FieldSelector, KeyPressListener {

    private FieldSelectionListener listener; // FieldSelectionListener-Objekt
    private boolean firstKeyPress = true; // Flag, um zu prüfen, ob dies der erste Tastendruck ist
    private Field markedField; // Das aktuell markierte Feld

    @Override
    public void setFieldSelectionListener(FieldSelectionListener listener) {
        this.listener = listener;
    }

    @Override
    public void onKeyPress(KeyPressEvent event) {
        if (firstKeyPress) { // Wenn dies der erste Tastendruck ist
            markedField = event.getWorld().getField(0, 0); // Markiere das Feld an (0,0)
            markedField.setFieldColor(Color.RED); // Setze die Farbe des markierten Feldes auf Rot
            firstKeyPress = false; // Setze das Flag auf false
        } else {
            int x = markedField.getX(); // X-Koordinate des markierten Feldes
            int y = markedField.getY(); // Y-Koordinate des markierten Feldes

            // Wenn der gedrückte Schlüssel einer der Pfeiltasten entspricht
            if (event.getKey() == Key.UP || event.getKey() == Key.LEFT ||
                event.getKey() == Key.DOWN || event.getKey() == Key.RIGHT) {
                // Entmarkiere das bisherige Feld
                markedField.setFieldColor(null);

                // Bewege die Markierung entsprechend der Richtung der gedrückten Taste
                switch (event.getKey()) {
                    case UP:
                        y--;
                        break;
                    case LEFT:
                        x--;
                        break;
                    case DOWN:
                        y++;
                        break;
                    case RIGHT:
                        x++;
                        break;
                }

                // Überprüfen, ob das neue Feld gültig ist
                Field newField = event.getWorld().getField(x, y);
                if (newField == null) { // Wenn kein weiteres Feld in die gewünschte Richtung vorhanden ist
                    // Gehe zur letzten Position in die entgegengesetzte Richtung
                    switch (event.getKey()) {
                        case UP:
                            y++;
                            break;
                        case LEFT:
                            x++;
                            break;
                        case DOWN:
                            y--;
                            break;
                        case RIGHT:
                            x--;
                            break;
                    }
                }

                // Markiere das neue Feld
                markedField = event.getWorld().getField(x, y);
                markedField.setFieldColor(Color.RED);
            } else if (event.getKey() == Key.SPACE) { // Wenn die Leertaste gedrückt wurde
                // Rufe die Methode onFieldSelection des FieldSelectionListeners auf
                listener.onFieldSelection(markedField);
            }
        }
    }
}

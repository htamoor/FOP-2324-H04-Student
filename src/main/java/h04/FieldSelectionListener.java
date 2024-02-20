package h04;

import fopbot.Field;

public interface FieldSelectionListener {

    /**
     * Called when a field is selected.
     *
     * @param selectedField The selected field.
     */
    public void onFieldSelection(Field selectedField);
}

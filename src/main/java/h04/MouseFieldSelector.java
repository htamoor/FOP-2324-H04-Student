package h04;

import fopbot.Field;
import fopbot.FieldClickEvent;
import fopbot.FieldClickListener;
import fopbot.World;

public class MouseFieldSelector implements FieldSelector, FieldClickListener {
    private FieldSelectionListener listener;
    private Field lastField;

    public MouseFieldSelector() {
        World.addFieldClickListener(this);
    }

    @Override
    public void setFieldSelectionListener(FieldSelectionListener listener) {
        this.listener = listener;
    }

    @Override
    public void onFieldClick(FieldClickEvent event) {
        Field newField = event.getField();
        if (lastField == newField) {
            listener.onFieldSelection(newField);
        }
        lastField = newField;
    }
}

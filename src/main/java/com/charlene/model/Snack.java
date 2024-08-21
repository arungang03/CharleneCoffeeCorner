package com.charlene.model;

import com.charlene.enums.SnackType;

import java.util.ArrayList;
import java.util.List;

public class Snack extends Item {
    private List<Extra> extras;

    public Snack(SnackType type) {
        super(type.getName(), type.getPrice());
        this.extras = new ArrayList<>();
    }
    public void addExtra(Extra extra) {
        extras.add(extra);
    }

    @Override
    public String getItemType() {
        return "Snack";
    }

    public List<Extra> getExtras() {
        return extras;
    }

    @Override
    public String toString() {
        StringBuilder extrasDescription = new StringBuilder();
        if (!extras.isEmpty()) {
            extrasDescription.append(" with extras: ");
            for (Extra extra : extras) {
                extrasDescription.append(extra.getName()).append(", ");
            }
            extrasDescription.setLength(extrasDescription.length() - 2); // Remove trailing comma
        }

        return getName() + " - " + getPrice() + " CHF" + extrasDescription;
    }

}

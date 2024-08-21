package com.charlene.model;

import com.charlene.enums.BeverageType;

import java.util.ArrayList;
import java.util.List;

public class Beverage extends Item {
    private List<Extra> extras;

    public Beverage(BeverageType type) {
        super(type.getName(), type.getPrice());
        this.extras = new ArrayList<>();
    }

    @Override
    public String getItemType() {
        return "Beverage";
    }

    public void addExtra(Extra extra) {
        extras.add(extra);
    }

    public List<Extra> getExtras() {
        return extras;
    }
}

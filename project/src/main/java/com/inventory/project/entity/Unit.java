package com.inventory.project.entity;

public enum Unit {
    NUMBER("Number"),
    PIECES("Pieces"),
    KG("Kilogram"),
    LITRE("Litre"),
    BOX("Box"),
    PACKET("Packet");

    private final String displayName;

    Unit(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

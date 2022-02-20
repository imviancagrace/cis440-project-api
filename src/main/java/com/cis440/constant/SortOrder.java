package com.cis440.constant;

public enum SortOrder {
    ASCENDING("ascending"),
    DESCENDING("descending");

    private final String text;

    /**
     * @param text text value for enum
     */
    SortOrder(final String text) {
        this.text = text;
    }
}

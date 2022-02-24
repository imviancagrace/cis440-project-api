package com.cis440.constant;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Department {
    IT("it"),
    FINANCE("finance"),
    MARKETING("marketing"),
    OPERATIONS("operations"),
    HR("hr");

    private final String text;

    /**
     * @param text text value for enum
     */
    Department(final String text) {
        this.text = text;
    }
}

package com.gmail.llemaxiss.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ExpandedForm {
    @NotNull(message = "The input must be filled")
    @Pattern(regexp = "\\d+", message = "Only whole numbers greater than 0")
    private String numberAsString;

    public String getNumberAsString() {
        return numberAsString;
    }

    public void setNumberAsString(String numberAsString) {
        this.numberAsString = numberAsString;
    }
}

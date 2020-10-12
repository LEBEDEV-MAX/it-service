package com.gmail.llemaxiss.forms;

import javax.validation.constraints.NotNull;

public class TwoArraysForm {
    private String[] array_1, array_2;

    public String[] getArray_1() {
        return array_1;
    }

    public String[] getArray_2() {
        return array_2;
    }

    public void setArray_1(@NotNull(message = "The first array must be filled") String array_1) {
        this.array_1 = array_1.trim().split(" ");
    }

    public void setArray_2(@NotNull(message = "The second array must be filled") String array_2) {
        this.array_2 = array_2.trim().split(" ");
    }
}

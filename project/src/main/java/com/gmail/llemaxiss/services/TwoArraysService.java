package com.gmail.llemaxiss.services;

import com.gmail.llemaxiss.forms.TwoArraysForm;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
public class TwoArraysService {
    public Set<String> getResult(TwoArraysForm form) {
        Set<String> result = new TreeSet<>();
        String[] array_1 = form.getArray_1();
        String[] array_2 = form.getArray_2();

        for (String word_1: array_1) {
            for (String word_2: array_2) {
                if (word_2.contains(word_1)) {
                    result.add(word_1);
                }
            }
        }

        return result;
    }
}

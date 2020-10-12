package com.gmail.llemaxiss.services;

import com.gmail.llemaxiss.forms.ExpandedForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpandedFormService {
    public List<String> getResult(ExpandedForm form) {
        String number = form.getNumberAsString();
        List<String> result = new ArrayList<>();

        if (number.equals("0")) {
            result.add("0");
        } else {
            int numeralsLength = number.length();

            for (int i = 0; i < numeralsLength; i++) {
                char numeral = number.charAt(i);

                if (numeral != '0') {
                    result.add(createAddendum(numeral, i, numeralsLength));
                }
            }
        }

        return result;
    }

    private String createAddendum(char numeral, int index, int length) {
        StringBuilder builder = new StringBuilder();
        int numberOfZero = length - index - 1;

        builder.append(numeral);

        for(int i=0; i<numberOfZero; i++) {
            builder.append("0");
        }

        return builder.toString();
    }
}

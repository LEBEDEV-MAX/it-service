package com.gmail.llemaxiss.controllers;

import com.gmail.llemaxiss.forms.ExpandedForm;
import com.gmail.llemaxiss.forms.TwoArraysForm;
import com.gmail.llemaxiss.services.ExpandedFormService;
import com.gmail.llemaxiss.services.TwoArraysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Controller
public class ExercisesController {
    private TwoArraysService twoArraysService;
    private ExpandedFormService expandedFormService;

    @Autowired
    public ExercisesController(TwoArraysService tas, ExpandedFormService efs) {
        twoArraysService = tas;
        expandedFormService = efs;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("twoArraysForm", new TwoArraysForm());
        model.addAttribute("expandedForm", new ExpandedForm());

        return "index";
    }

    @PostMapping("/two-arrays")
    public String getTwoArraysResult(@Valid @ModelAttribute(name = "twoArraysForm") TwoArraysForm twoArraysForm, Model model) {
        Set<String> result = twoArraysService.getResult(twoArraysForm);
        model.addAttribute("form", twoArraysForm);
        model.addAttribute("result", result);

        return "two-arrays-result";
    }

    @PostMapping("/expanded-form")
    public String getExpandedFormResult(@Valid @ModelAttribute(name = "expandedForm") ExpandedForm expandedForm, Model model) {
        List<String> result = expandedFormService.getResult(expandedForm);
        model.addAttribute("form", expandedForm);
        model.addAttribute("result", result);

        return "expanded-form-result";
    }

    @PostMapping("/save")
    @ResponseBody
    public String saveFile(HttpServletRequest request) throws IOException {
        String fileName = "appParameters.txt";
        String filePath = request.getServletContext().getRealPath("/WEB-INF/static/") + fileName;
        String task = request.getParameter("task");

        try(FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(task + "\n");

            if (task.equals("twoArrays")) {
                writer.write(request.getParameter("input[array_1]") + "\n");
                writer.write(request.getParameter("input[array_2]"));
            } else if (task.equals("expandedForm")) {
                writer.write(request.getParameter("input"));
            }

            writer.flush();
            return fileName;

        } catch (IOException e) {
            throw e;
        }
    }

    @PostMapping("/load")
    public String load(@RequestParam("file") MultipartFile file, Model model, HttpServletRequest request) {
        try {
            String fileName = "appParameters.txt";
            String filePath = request.getServletContext().getRealPath("/WEB-INF/static/") + fileName;
            byte[]bytes = file.getBytes();
            Path path = Paths.get(filePath);
            Files.write(path, bytes);

            return resultAfterLoad(filePath, model);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index";
    }

    private String resultAfterLoad(String filePath, Model model) throws Exception {
        FileReader reader = new FileReader(filePath);
        Scanner scanner = new Scanner(reader);

        String task = scanner.nextLine();

        if (task.equals("twoArrays")) {
            String array_1 = scanner.nextLine();
            String array_2 = scanner.nextLine();
            TwoArraysForm twoArraysForm = new TwoArraysForm();
            twoArraysForm.setArray_1(array_1);
            twoArraysForm.setArray_2(array_2);

            return getTwoArraysResult(twoArraysForm, model);

        } else if (task.equals("expandedForm")) {
            String number = scanner.nextLine();

            if (number.matches("\\d+")) {
                ExpandedForm expandedForm = new ExpandedForm();
                expandedForm.setNumberAsString(number);

                return getExpandedFormResult(expandedForm, model);
            } else {
                throw new NumberFormatException();
            }
        }

        return "index";
    }
}

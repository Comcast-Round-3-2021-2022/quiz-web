package org.launchcode.quiz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QuizController {

    private static List<Map<String, String>> questions = new ArrayList<>();

    public QuizController() {
        Map<String, String> q1 = new HashMap<>();
        q1.put("q", "What is the best animal?");
        q1.put("a", "walrus");

        questions.add(q1);
    }

    @GetMapping
    public String displayQuiz(Model model) {
        model.addAttribute("questions", questions);
        return "quiz";
    }

    @PostMapping
    public String gradeQuiz(@RequestParam String q1, Model model) {
        String correctAnswer = questions.get(0).get("a");
        boolean isCorrect = q1.toLowerCase().equals(correctAnswer.toLowerCase());
        model.addAttribute("isCorrect", isCorrect);
        return "results";
    }


}

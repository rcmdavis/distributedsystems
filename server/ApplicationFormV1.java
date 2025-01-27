package server;

import interfaces.ApplicationForm;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import exceptions.InvalidQuestionNumberException;

public class ApplicationFormV1 implements ApplicationForm, Serializable {
    private static final long serialVersionUID = 1L;
    
    private Map<Integer, String> questions;
    private Map<Integer, String> answers;

    public ApplicationFormV1() {
        questions = new HashMap<>();
        answers = new HashMap<>();
        questions.put(1, "What is your name?");
        questions.put(2, "What is your address?");
        questions.put(3, "What is your email?");
        questions.put(4, "What is your contact number?");
        questions.put(5, "Please provide a personal statement.");
    }

    @Override
    public int numberOfQuestions() {
        return questions.size();
    }

    @Override
    public void setAnswer(int questionNumber, String answer) throws InvalidQuestionNumberException {
        if (questions.containsKey(questionNumber)) {
            answers.put(questionNumber, answer);
        } else {
            throw new InvalidQuestionNumberException("Invalid question number: " + questionNumber);
        }
    }

    @Override
    public String getQuestion(int questionNumber) throws InvalidQuestionNumberException {
        if (questions.containsKey(questionNumber)) {
            return questions.get(questionNumber);
        } else {
            throw new InvalidQuestionNumberException("Invalid question number: " + questionNumber);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= questions.size(); i++) {
            sb.append(questions.get(i) + ": " + answers.get(i) + "\n");
        }
        return sb.toString();
    }
}
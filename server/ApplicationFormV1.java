package server;

import interfaces.ApplicationForm;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import exceptions.InvalidQuestionNumberException;

// Implementation of ApplicationForm (which is Serializable so that it can be carried over RMI)
public class ApplicationFormV1 implements ApplicationForm, Serializable {
    private static final long serialVersionUID = 1L;
    
    // Keep questions and answers as maps
    private Map<Integer, String> questions;
    private Map<Integer, String> answers;

    // Constructor to initialize hashmaps and questions
    public ApplicationFormV1() {
        questions = new HashMap<>();
        answers = new HashMap<>();
        questions.put(1, "What is your name?");
        questions.put(2, "What is your address?");
        questions.put(3, "What is your email?");
        questions.put(4, "What is your contact number?");
        questions.put(5, "Please provide a personal statement.");
    }

    // Implementation of generalInformation method - providing general information about the application forms
    @Override
    public String getGeneralInformation() {
        return "This is an application form for CT414 - the coolest module in the world!";
    }

    // Implementation of numberOfQuestions method - returning the number of questions in the form
    @Override
    public int numberOfQuestions() {
        return questions.size();
    }

    // Implementation of setAnswer method - setting the answer to a given question
    @Override
    public void setAnswer(int questionNumber, String answer) throws InvalidQuestionNumberException {
        // Check the questions map for the question
        if (questions.containsKey(questionNumber)) {
            // Update the answers map with the answer
            answers.put(questionNumber, answer);
        } else {
            // If the question is invalid, throw an exception
            throw new InvalidQuestionNumberException("Invalid question number: " + questionNumber);
        }
    }

    // Implementation of getAnswer method - getting the answer to a given question
    @Override
    public String getQuestion(int questionNumber) throws InvalidQuestionNumberException {
        // Check the questions map for the question
        if (questions.containsKey(questionNumber)) {
            // Return the question at the given question number location
            return questions.get(questionNumber);
        } else {
            // If the question is invalid, throw an exception
            throw new InvalidQuestionNumberException("Invalid question number: " + questionNumber);
        }
    }

    // ToString method to print the questions and answers as seen in the txt file
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= questions.size(); i++) {
            sb.append(questions.get(i) + ": " + answers.get(i) + "\n");
        }
        return sb.toString();
    }
}
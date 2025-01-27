package interfaces;

import exceptions.InvalidQuestionNumberException;

public interface ApplicationForm {
    int numberOfQuestions();
    String getQuestion(int questionNumber) throws InvalidQuestionNumberException;
    void setAnswer(int questionNumber, String answer) throws InvalidQuestionNumberException; 
}

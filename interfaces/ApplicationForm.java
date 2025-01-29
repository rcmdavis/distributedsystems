package interfaces;

import exceptions.InvalidQuestionNumberException;

// Represents an application form that can be filled out by a user
public interface ApplicationForm {
    // General informatio about the form
    String getGeneralInformation();

    // Number of questions in the form
    int numberOfQuestions();

    // Get the question at the specified question number
    // Throws InvalidQuestionNumberException if the question number is invalid
    String getQuestion(int questionNumber) throws InvalidQuestionNumberException;

    // Set the answer to the question at the specified question number
    void setAnswer(int questionNumber, String answer) throws InvalidQuestionNumberException; 
}

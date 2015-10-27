/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;

import java.util.ArrayList;

/**
 *
 * @author kellyshiptoski
 */
public class TrueFalseQuestion extends Question{
    private String question;
    private TrueFalseAnswer correctAnswer;
    private ArrayList<TrueFalseAnswer> possibleAnswers;
    private TrueFalseAnswer userAnswer;
    
    public TrueFalseQuestion(String question, 
                             TrueFalseAnswer correctAnswer, 
                             ArrayList<TrueFalseAnswer> possibleAnswers, 
                             TrueFalseAnswer userAnswer)
    {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.possibleAnswers = possibleAnswers;
        this.userAnswer = userAnswer;
    }
    public void addUserAnswer(TrueFalseAnswer a)
    {
        this.userAnswer = a;
    }
    
    public void addCorrectAnswer(TrueFalseAnswer a)
    {
        this.correctAnswer = a;
    }
    
    public Boolean gradeQuestion()
    {
        return this.userAnswer == this.correctAnswer;
    }
    
    public void addPotentialAnswer(TrueFalseAnswer a)
    {
        this.possibleAnswers.add(a);
    }
    
    @Override
    public void getAnswerFromUser()
    {
    }
    
    @Override
    public void displayQuestion()
    {
        System.out.println(this.question);
        System.out.println("True/False");
        if (this.correctAnswer != null)
            System.out.println("The correct answer is" + this.correctAnswer);
    }
}

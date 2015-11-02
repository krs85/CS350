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
public class MatchingQuestion extends Question{
    protected String question;
    protected MatchingAnswer correctAnswer;
    protected MatchingAnswer userAnswer;
    protected MatchingAnswer possibleAnswers;
    
    public MatchingQuestion (String question,
                             MatchingAnswer correctAnswer,
                             MatchingAnswer userAnswer,
                             MatchingAnswer possibleAnswers)
    {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.userAnswer = userAnswer;
        this.possibleAnswers = possibleAnswers;
    }
    
    public void addUserAnswer(MatchingAnswer a)
    {
        this.userAnswer = a;
    }
    
    public void addCorrectAnswer(MatchingAnswer a)
    {
        this.correctAnswer = a;
    }
    
    public Boolean gradeQuestion()
    {
        return this.correctAnswer == this.userAnswer;
    }
    
    public void addPossibleAnswers(MatchingAnswer possibleAnswers)
    {
        this.possibleAnswers = possibleAnswers;
    }
    public void getAnswerFromUser()
    {
        
    }
    
    @Override
    public void displayQuestion()
    {
        System.out.println(this.question);
        System.out.println(this.possibleAnswers.toString());
        if (this.correctAnswer != null)
        {
            System.out.println("The correct answer is: ");
            System.out.println(this.correctAnswer.toString());
        }
    }
}

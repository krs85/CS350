/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;

import java.util.HashMap;

/**
 *
 * @author kellyshiptoski
 */
public class MultipleChoiceQuestion extends Question{
    private String question;
    private HashMap<String, MultipleChoiceAnswer> correctAnswer;
    private HashMap<String, MultipleChoiceAnswer> possibleAnswers;
    private HashMap<String, MultipleChoiceAnswer> userAnswer;
    
    public MultipleChoiceQuestion (String question,
                                   HashMap<String,MultipleChoiceAnswer> correctAnswer,
                                   HashMap<String,MultipleChoiceAnswer> possibleAnswers,
                                   HashMap<String,MultipleChoiceAnswer> userAnswer)
    {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.possibleAnswers = possibleAnswers;
        this.userAnswer = userAnswer;
    }
    
    public void addUserAnswer(String letter, MultipleChoiceAnswer a)
    {
        this.userAnswer.put(letter, a);
    }
    
    public void addCorrectAnswer(String letter, MultipleChoiceAnswer a)
    {
        this.correctAnswer.put(letter, a);
    }
    
    public Boolean gradeQuestion()
    {
        return this.correctAnswer == this.userAnswer;
    }
    
    public void addPotentialAnswer(String letter, MultipleChoiceAnswer a)
    {
        this.possibleAnswers.put(letter, a);
    }

    @Override
    public void getAnswerFromUser()
    {
        
    }
    
    @Override
    public void displayQuestion()
    {
        System.out.println(this.question);
        for (String m : this.possibleAnswers.keySet())
        {
            String key = m;
            String value = this.possibleAnswers.get(key).toString();
            System.out.print(key + ") " + value + "  ");
        }
        if (correctAnswer != null)
        {
            for(String m : this.correctAnswer.keySet())
            {
                String key = m;
                System.out.println("The correct answer is " + key);
            }
        }
    }
}

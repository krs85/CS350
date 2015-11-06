/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;

import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author kellyshiptoski
 */
public class MultipleChoiceQuestion extends Question{
    private String question;
    private ArrayList<String> correctAnswers;
    private HashMap<String, MultipleChoiceAnswer> possibleAnswers;
    private HashMap<String, MultipleChoiceAnswer> userAnswer;
    
    public MultipleChoiceQuestion (String question,
                                   ArrayList<String> correctAnswers,
                                   HashMap<String,MultipleChoiceAnswer> possibleAnswers,
                                   HashMap<String,MultipleChoiceAnswer> userAnswer)
    {
        this.question = question;
        this.correctAnswers = correctAnswers;
        this.possibleAnswers = possibleAnswers;
        this.userAnswer = userAnswer;
    }
    
    public void addUserAnswer(String letter, MultipleChoiceAnswer a)
    {
        this.userAnswer.put(letter, a);
    }
    
    public void addCorrectAnswer(String letter)
    {
        this.correctAnswers.add(letter);
    }
    
	 @Override
	 public String getQuestion()
	 {
		 return this.question;
	 }
   /* public Boolean gradeQuestion()
    {
		  for (String m : this.userAnswer.
		  for (String m : this.correctAnswers.keySet())
		  {
			  String key = m;
			  String value = this.correctAnswers.get(key).toString();
		  }
        return this.correctAnswer == this.userAnswer;
    }*/
    
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
		  System.out.println();
        if (correctAnswers != null)
        {
			  	System.out.println("The correct answers are");
            for(int i = 0; i < correctAnswers.size(); i++)
            {
                System.out.println(correctAnswers.get(i));
            }
        }
    }

	 @Override
	 public void modifyQuestion()
	 {
	 }
}

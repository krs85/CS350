/*`
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author kellyshiptoski
 */
public class TrueFalseQuestion extends Question{
    private String question;
    private TrueFalseAnswer correctAnswer;
    private ArrayList<TrueFalseAnswer> possibleAnswers;
    private ArrayList<Answer> userAnswers;
    
    public TrueFalseQuestion(String question, 
                             TrueFalseAnswer correctAnswer, 
                             ArrayList<TrueFalseAnswer> possibleAnswers, 
                             ArrayList<Answer> userAnswers)
    {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.possibleAnswers = possibleAnswers;
        this.userAnswers = userAnswers;
    }
    public void addUserAnswer(Answer a)
    {
        this.userAnswers.add(a);
    }

    public ArrayList<Answer> getUserAnswers()
    {
        return this.userAnswers;
    }
    @Override
    public String toString()
    {
        String s = this.question;
        s += "\n";
        s += "True/False";
        return s;
    }
    
    public void addCorrectAnswer(TrueFalseAnswer a)
    {
        this.correctAnswer = a;
    }
    
    public int gradeQuestion(int indexOfUser)
    {
        if(this.userAnswers.get(indexOfUser).equals(this.correctAnswer))
            return 1;
        return 0;

    }

	 @Override
	 public String getQuestion()
	 {
		 return this.question;
	 }	 
    public void addPotentialAnswer(TrueFalseAnswer a)
    {
        this.possibleAnswers.add(a);
    }
    
    @Override
    public void getAnswerFromUser()
    {
        System.out.println("Please enter 'true' or 'false'");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        boolean a;
        if (answer.equals("true"))
            a = true;
        else
            a = false;
        TrueFalseAnswer userAnswer = new TrueFalseAnswer(a);
        addUserAnswer(userAnswer);
    }
    
    @Override
    public void displayQuestion()
    {
        System.out.println(this.question);
        System.out.println("True/False");
        if (this.correctAnswer != null)
            System.out.println("The correct answer is " + this.correctAnswer);
    }

	 @Override
    public void modifyQuestion()
	 {
		 Scanner in = new Scanner(System.in);
		 System.out.println("Do you wish to modify the prompt?");
		 System.out.println(this.question);
		 String choice = in.nextLine();
		 String newPrompt = "";
		 if(choice.equals("yes") || choice.equals("Yes"))
		 {
			 String questionNumber = this.question.substring(0,1);
			 System.out.println(this.question);
			 System.out.println("Please enter a new prompt");
			 newPrompt = in.nextLine();
			 this.question = questionNumber + ") " + newPrompt;
		 }
		 if(correctAnswer != null)
		 {
	    	 System.out.println("Do you want to modify the correct answer?");
			 System.out.println("The current correct answer is " + correctAnswer);
			 String correctChoice = in.nextLine();
			 if(correctAnswer.getAnswer() == true)
			 {
			 	correctAnswer = new TrueFalseAnswer(false);
				System.out.println("The correct answer is now false");
			 }
			 else if (correctAnswer.getAnswer()  == false)
			 {
			 	correctAnswer = new TrueFalseAnswer(true);
				System.out.println("The correct answer is now true");
			 }
		 }
	 }
}

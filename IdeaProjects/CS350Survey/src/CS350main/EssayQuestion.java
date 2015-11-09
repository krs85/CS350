/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author kellyshiptoski
 */
public class EssayQuestion extends Question {
    protected String question;
    protected ArrayList<Answer> userAnswers;
    
    public EssayQuestion (String question,
						  ArrayList<Answer> userAnswers)
    {
        this.question = question;
        this.userAnswers = userAnswers;
    }

	public ArrayList<Answer> getUserAnswers()
	{
		return this.userAnswers;
	}

	public int gradeQuestion(int indexOfUser)
	{
		return -1;
	}

	@Override
	public String toString()
	{
		String a = this.question;
		return a;
	}
    public void addUserAnswer(Answer a)
	{
		this.userAnswers.add(a);
	}
		
	 @Override
	 public String getQuestion()
	 {
		  return this.question;
	 }	 

	@Override
    public void getAnswerFromUser()
    {
        Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		EssayAnswer userA = new EssayAnswer(a);
		addUserAnswer(userA);
    }
     
    @Override
    public void displayQuestion()
    {
        System.out.println(this.question);
    }

	 @Override
	 public void modifyQuestion()
	 {
		  Scanner in = new Scanner(System.in);
	 	  System.out.println("Do you wish to modify the prompt?");
		  String choice = in.nextLine();
		  String newPrompt = "";
		  if (choice.equals("yes") || choice.equals("Yes"))
		  {
			  String questionNumber = this.question.substring(0,1);
			  System.out.println(this.question);
			  System.out.println("Please enter a new prompt");
			  newPrompt = in.nextLine();
			  this.question = questionNumber + ") " + newPrompt;
		  }		  
	 }
}

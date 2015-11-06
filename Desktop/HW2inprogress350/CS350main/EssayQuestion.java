/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;
import java.util.Scanner;
/**
 *
 * @author kellyshiptoski
 */
public class EssayQuestion extends Question {
    protected String question;
    protected EssayAnswer userAnswer;
    
    public EssayQuestion (String question, 
                          EssayAnswer userAnswer)
    {
        this.question = question;
        this.userAnswer = userAnswer;
    }
    
    public void addUserAnswer(EssayAnswer a)
    {
        this.userAnswer = userAnswer;
    }
		
	 @Override
	 public String getQuestion()
	 {
		  return this.question;
	 }	 
    @Override
    public void getAnswerFromUser()
    {
        
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

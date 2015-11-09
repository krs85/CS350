/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.jar.Pack200;

/**
 *
 * @author kellyshiptoski
 */
public class ShortAnswerQuestion extends EssayQuestion {
	
	private ArrayList<ShortAnswerAnswer> correctAnswers;
	
	public ShortAnswerQuestion(String question, 
										ArrayList<Answer> userAnswers,
										ArrayList<ShortAnswerAnswer> correctAnswers)
	{
		super(question, userAnswers);
		this.correctAnswers = correctAnswers;
	}

	public void addUserAnswer(Answer a)
	{
		this.userAnswers.add(a);
	}

	@Override
	public int gradeQuestion(int indexOfUser)
	{
		for(int i = 0; i < this.correctAnswers.size(); i++)
		{
			if(this.correctAnswers.get(i).equals(this.userAnswers.get(indexOfUser)))
				return 1;
		}
		return 0;
	}
	@Override
	public void getAnswerFromUser()
	{
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		ShortAnswerAnswer userA = new ShortAnswerAnswer(a);
		addUserAnswer(userA);
	}

	@Override public void displayQuestion()
	{
		System.out.println(question);
		if (correctAnswers != null)
		{
			for(int i = 0; i < correctAnswers.size(); i++)
			{
				System.out.println(correctAnswers.get(i));
			}
		}
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

		  if (this.correctAnswers != null)
		  {
			  System.out.println("Do you wish to modify the correct answer(s)?");
			  String correctChoice = in.nextLine();
			  String answerNum = "";
			  if (correctChoice.equals("yes") || correctChoice.equals("Yes"))
			  {
				  do 
				  {
					  for(int i = 0; i < this.correctAnswers.size(); i++)
					  {
						  int number = i + 1;
						  System.out.println(number + ") " + this.correctAnswers.get(i).toString());
					  }

					  System.out.println("Please enter the number of the correct answer you wish to modify or type exit to move on"); 
					  answerNum = in.nextLine();
					  if(!answerNum.equals("exit"))
					  {
							System.out.println("Please enter the new answer");
							String answer = in.nextLine();
							int num = Integer.parseInt(answerNum);
							num--;
							ShortAnswerAnswer newA = new ShortAnswerAnswer(answer);
							this.correctAnswers.set(num, newA);
					  }
				  } while(!answerNum.equals("exit"));
			  }
		  }	
    }
}


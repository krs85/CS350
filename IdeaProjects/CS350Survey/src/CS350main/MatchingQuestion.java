/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author kellyshiptoski
 */
public class MatchingQuestion extends Question{
    protected String question;
    protected MatchingAnswer correctAnswer;
    protected ArrayList<Answer> userAnswers;
    protected MatchingAnswer possibleAnswers;
    
    public MatchingQuestion (String question,
							 MatchingAnswer correctAnswer,
							 ArrayList<Answer> userAnswers,
							 MatchingAnswer possibleAnswers)
    {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.userAnswers = userAnswers;
        this.possibleAnswers = possibleAnswers;
    }

	@Override
	public String toString()
	{
		String a = this.question;
		a += "\n";
		a += this.possibleAnswers.toString();
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

	public void addCorrectAnswer(MatchingAnswer a)
    {
        this.correctAnswer = a;
    }
    
    public void addPossibleAnswers(MatchingAnswer possibleAnswers)
    {
        this.possibleAnswers = possibleAnswers;
    }

    public void getAnswerFromUser()
    {
		Scanner in = new Scanner(System.in);
		String left = "";
		String right = "";
		ArrayList<String> leftA = new ArrayList<String>();
		ArrayList<String> rightA = new ArrayList<String>();

		for (int i = 0; i < this.possibleAnswers.getLeftAnswers().size(); i++)
		{
			System.out.println("Please enter the left match");
			left = in.nextLine();
			System.out.println("Please enter the right match");
			right = in.nextLine();
			leftA.add(left);
			rightA.add(right);
		}
		MatchingAnswer userAnswer = new MatchingAnswer(leftA, rightA);
		addUserAnswer(userAnswer);
    }

	@Override
	public int gradeQuestion(int indexOfUser)
	{
		if (this.correctAnswer.equals(this.userAnswers.get(indexOfUser)))
			return 1;
		return 0;
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

	public ArrayList<Answer> getUserAnswers()
	{
		return this.userAnswers;
	}
	 @Override
	 public void modifyQuestion()
	 {
		 Scanner in = new Scanner(System.in);
		 System.out.println("Do you wish to modify the prompt?");
		 String choice = in.nextLine();
		 if (choice.equals("yes") || choice.equals("Yes"))
		 {
		 		String questionNumber = this.question.substring(0,1);
				System.out.println("Please enter a new prompt");
				String newPrompt = in.nextLine();
				this.question = questionNumber + ") " + newPrompt;
		 }

		 System.out.println("Do you wish to modify the choices?");
		 String modifyChoices = in.nextLine();
		 if(modifyChoices.equals("yes") || modifyChoices.equals("Yes"))
		 {
		 		String changeLeft = "";
				String newLeft = "";
				String newRight = "";
				do
				{
					System.out.println("What choice do you wish to modify? Please enter the choice or type exit to move on");

					changeLeft = in.nextLine();
					int changeL = Integer.parseInt(changeLeft);

					if(!changeLeft.equals("exit"))
					{
						System.out.println("What do you wish to change the choice to?");
						newLeft = in.nextLine();
						System.out.println("What do you wish to change the choice's match to?");
						newRight = in.nextLine();
						this.possibleAnswers.getLeftAnswers().set(changeL, newLeft);
						this.possibleAnswers.getRightAnswers().set(changeL, newRight);
					}
				} while(!changeLeft.equals("exit"));
		 }

		 System.out.println("Do you wish to modify the correct answer?");
		 String modifyCorrect = in.nextLine();

		 if(modifyCorrect.equals("yes") || modifyCorrect.equals("Yes"))
		 {
			 System.out.println(this.correctAnswer.toString());

			 String changeCorrect = "";
			 do {
				 System.out.println("Enter the number of the choice you wish to change or type exit to move on");
				 changeCorrect = in.nextLine();
				 String changeLeft = "";
				 String changeRight = "";

				 if (!changeCorrect.equals("exit")) {
					 System.out.println("What do you wish to change the choice to?");
					 changeLeft = in.nextLine();
					 System.out.println("What should your new choice be matched to?");
					 changeRight = in.nextLine();

					 int changeL = Integer.parseInt(changeLeft);
					 changeL--;

					 this.correctAnswer.getLeftAnswers().set(changeL, changeLeft);
					 this.correctAnswer.getRightAnswers().set(changeL, changeRight);
				 }
			 } while (!changeCorrect.equals("exit"));
		 }
	 }
}

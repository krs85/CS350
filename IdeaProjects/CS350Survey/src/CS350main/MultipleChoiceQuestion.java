/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author kellyshiptoski
 */
public class MultipleChoiceQuestion extends Question{
    private String question;
    private ArrayList<String> correctAnswers;
    private HashMap<String, MultipleChoiceAnswer> possibleAnswers;
    private ArrayList<Answer> userAnswers;
    
    public MultipleChoiceQuestion (String question,
                                   ArrayList<String> correctAnswers,
                                   HashMap<String,MultipleChoiceAnswer> possibleAnswers,
                                   ArrayList<Answer> userAnswers)
    {
        this.question = question;
        this.correctAnswers = correctAnswers;
        this.possibleAnswers = possibleAnswers;
        this.userAnswers = userAnswers;
    }

	@Override
	public String toString()
	{
		String a = this.question + "\n";
		for (String m : this.possibleAnswers.keySet())
		{
			String key = m;
			String value = this.possibleAnswers.get(key).toString();
			a += key + ") " + value;
			a += "\n";
		}
		return a;
	}

	public ArrayList<Answer> getUserAnswers()
	{
		return this.userAnswers;
	}

    public void addUserAnswer(Answer a)
    {
        this.userAnswers.add(a);
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

   	public int gradeQuestion(int indexOfUser)
    {
		if (correctAnswers.contains(userAnswers.get(indexOfUser).toString()))
			return 1;

		return 0;
    }

    public void addPotentialAnswer(String letter, MultipleChoiceAnswer a)
    {
        this.possibleAnswers.put(letter, a);
    }

    @Override
    public void getAnswerFromUser()
    {
		Scanner in = new Scanner(System.in);
		String letter = in.next();

		MultipleChoiceAnswer userAnswer = new MultipleChoiceAnswer(letter);
		addUserAnswer(userAnswer);
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

		 System.out.println("Do you wish to modify the choices?");
		 String modifyChoices = in.nextLine();
		 if (modifyChoices.equals("yes") || modifyChoices.equals("Yes"))
		 {
				String changeLetter = "";	
				String newAnswer = "";
				do 
				{
					System.out.println("Which choice do you wish to modify? Type the choice or type to exit to continue");
					for (String m : this.possibleAnswers.keySet())
					{
						String key = m;
						String value = this.possibleAnswers.get(key).toString();
						System.out.print(key + ") " + value + " ");
					}
					changeLetter = in.nextLine();
					if (!changeLetter.equals("exit"))
					{
						System.out.println("What would you like to change the answer to?");
						newAnswer = in.nextLine();
						MultipleChoiceAnswer newA = new MultipleChoiceAnswer(newAnswer);
						this.possibleAnswers.put(changeLetter, newA);
					}
				} while(!changeLetter.equals("exit"));
		 }

		 if (correctAnswers != null)
		 {
		 		System.out.println("Do you wish to modify the correct answer(s)?");
				for (int i = 0; i < correctAnswers.size(); i++)
				{
					System.out.print(correctAnswers.get(i));
					System.out.print(" ");
				}
				System.out.println();
				String correctChoice = in.nextLine();
				if(correctChoice.equals("yes") || correctChoice.equals("Yes"))
				{	
					String correctMod = "";
					do
					{
						System.out.println("Please enter the correct answer you wish to modify or type exit to move on");
						correctMod = in.nextLine();
						if (!correctMod.equals("exit"))
						{
							System.out.println("Please enter what the answer should be changed to");
							String newCorrect = in.nextLine();
							correctAnswers.remove(correctMod);
							correctAnswers.add(newCorrect);
						}
					} while(!correctMod.equals("exit"));
				}
		 }
	 }
}

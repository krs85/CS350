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
public class ShortAnswerQuestion extends EssayQuestion {
	
	private ArrayList<ShortAnswerAnswer> correctAnswers;
	
	public ShortAnswerQuestion(String question, 
										ShortAnswerAnswer userAnswer,
										ArrayList<ShortAnswerAnswer> correctAnswers)
	{
		super(question, userAnswer);
		this.correctAnswers = correctAnswers;
	}

	@Override public void displayQuestion()
	{
		System.out.println(question);
		for(int i = 0; i < correctAnswers.size(); i++)
		{
			System.out.println(correctAnswers.get(i));
		}
	}
}


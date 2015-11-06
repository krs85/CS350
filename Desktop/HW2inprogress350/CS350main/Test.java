/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author kellyshiptoski
 */
public class Test extends Survey{
    public Test (ArrayList<Question> questions, String path, String name)
    {
        super(questions, path, name);
    }
    
    public Test()
    {
        
    }
    
    public static Test makeNew()
    {
        int userChoice;
        Test test = new Test();
        System.out.println("Please enter a name for the test");
        Scanner in_ = new Scanner(System.in);
        String name = in_.nextLine();
        test.setName(name);
        do 
        {
            System.out.println("1) Add a new T/F question");
            System.out.println("2) Add a new multiple choice question");
            System.out.println("3) Add a new short answer question");
            System.out.println("4) Add a new essay question");
            System.out.println("5) Add a new ranking question");
            System.out.println("6) Add a new matching question");
            System.out.println("7) Return to test menu");
            Scanner in = new Scanner(System.in);
            userChoice = in.nextInt();
            in.nextLine();
            
            if (userChoice == 1) // T/F question (no correct answer)
                addTrueFalseQuestion(test, in);
            else if (userChoice == 2) // Multiple choice question (no correct answer)
                addMultipleChoiceQuestion(test, in);
            else if (userChoice == 3) //Short answer (no correct answer)
                addEssayQuestion(test, in, userChoice);
            else if (userChoice == 4) //Essay question (no correct answer)
                addEssayQuestion(test, in, userChoice);
            else if (userChoice == 5) //Ranking question (no correct answer)
                addMatchingQuestion(test, in, userChoice);
            else if (userChoice == 6) //Matching question (no correct answer)
                addMatchingQuestion(test, in, userChoice);
        } while(userChoice != 7); 
        return test;
    }
        
    public static void addTrueFalseQuestion(Survey survey, Scanner in) 
    {
        System.out.println("Enter your prompt for the T/F question");   
        String question = in.nextLine();
        
        ArrayList<TrueFalseAnswer> possibleAnswers = new ArrayList<TrueFalseAnswer>();
        possibleAnswers.add(new TrueFalseAnswer(true));
        possibleAnswers.add(new TrueFalseAnswer(false));
        
        System.out.println("Enter the correct answer for the T/F question");
        String correct = in.nextLine();
        TrueFalseAnswer correctAnswer = new TrueFalseAnswer(Boolean.valueOf(correct));
        TrueFalseQuestion tfQuestion = new TrueFalseQuestion(question, correctAnswer, possibleAnswers, null);
        survey.getQuestions().add(tfQuestion);
    }
    
    public static void addMultipleChoiceQuestion(Survey survey, Scanner in) //question, correct, possible, user
    {
        System.out.println("Enter your prompt for the multiple choice question");
        String question = in.nextLine();
        HashMap<String, MultipleChoiceAnswer> possibleAnswers = new HashMap<String, MultipleChoiceAnswer>();
        String possibleAnswer;
        String letter;
        do 
        {
            System.out.println("Please enter a letter or type exit to move on");
            letter = in.next();
            in.nextLine();
            if(!letter.equals("exit"))
            {
                System.out.println("Please enter the corresponding potential answer");
                possibleAnswer = in.nextLine();
                MultipleChoiceAnswer a = new MultipleChoiceAnswer(possibleAnswer);
                possibleAnswers.put(letter, a);
            }
        } while(!letter.equals("exit"));

		  String correctLetter;
		  String correctAnswer;
		  ArrayList<String> correctAnswers = new ArrayList<String>();
		  do
		  {
			  System.out.println("Please enter a letter for a correct answer or type exit to move on");
			  correctLetter = in.next();
			  correctAnswers.add(correctLetter);
		  } while(!correctLetter.equals("exit"));
        MultipleChoiceQuestion multChQuestion = new MultipleChoiceQuestion(question, correctAnswers, possibleAnswers, null);
        survey.getQuestions().add(multChQuestion);
    }

    public static void addEssayQuestion(Survey survey, Scanner in, Integer userChoice) //question, correct, user
    {
        if (userChoice == 4)
		  		System.out.println("Enter your prompt for the essay question");
		  else if (userChoice == 3)
			   System.out.println("Enter your prompt for the short answer question");
        String question = in.nextLine();
        if (userChoice == 4) //essay question
        {
            EssayQuestion essayQuestion = new EssayQuestion(question, null);
            survey.getQuestions().add(essayQuestion);
        }
        else 
        {
		  		ArrayList<ShortAnswerAnswer> correctAnswers = new ArrayList<ShortAnswerAnswer>();
				String answer = "";
		 		do 
				{
					System.out.println("Enter a correct answer for the short answer question or type exit to move on");
					answer = in.nextLine();
					if (!answer.equals("exit"))
					{
						ShortAnswerAnswer correctAnswer = new ShortAnswerAnswer(answer);
						correctAnswers.add(correctAnswer);
					}
				} while (!answer.equals("exit"));
            ShortAnswerQuestion shortQuestion = new ShortAnswerQuestion(question, null,
					correctAnswers);
            survey.getQuestions().add(shortQuestion);
        }      
    }

    public static void addMatchingQuestion(Survey survey, Scanner in, int userChoice)//question,correct,user,possible
    {
		  if (userChoice == 6)
        		System.out.println("Enter your prompt for the matching question");
		  else if (userChoice == 5)
			  	System.out.println("Enter your prompt for the ranking question");
        String question = in.nextLine();

        String leftAnswer;
        String rightAnswer;
        HashMap<String,String> possibleAnswers = new HashMap<String,String>();
        String correctLeftAnswer;
        String correctRightAnswer;
        HashMap<String,String> correctAnswer = new HashMap<String,String>();

        do
        {
            System.out.println("Please enter a matching option or type exit to move on");
            leftAnswer = in.nextLine();
            if (!leftAnswer.equals("exit"))
            {
                System.out.println("Please enter what the option should be initially matched to");
                rightAnswer = in.nextLine();
                possibleAnswers.put(leftAnswer, rightAnswer);
            }

        } while(!leftAnswer.equals("exit"));

        do
        {
            System.out.println("Please enter a matching option or type exit to move on (for the correct answer)");
            correctLeftAnswer = in.nextLine();
            if(!correctLeftAnswer.equals("exit"))
            {
                System.out.println("Please enter what the option should be initially matched to (for the correct answer)");
                correctRightAnswer = in.nextLine();
                correctAnswer.put(correctLeftAnswer, correctRightAnswer);
            }
        } while(!correctLeftAnswer.equals("exit"));
        
        if (userChoice == 6) //matching
        {
            MatchingAnswer a = new MatchingAnswer(possibleAnswers);
            MatchingAnswer correctA = new MatchingAnswer(correctAnswer);
            MatchingQuestion matchQuestion = new MatchingQuestion(question, correctA, null, a);
            survey.getQuestions().add(matchQuestion);
        }
        else
        {
            RankingAnswer a = new RankingAnswer(possibleAnswers);
            RankingAnswer correctA = new RankingAnswer(correctAnswer);
            RankingQuestion rankQuestion = new RankingQuestion(question, correctA , null, a);
            survey.getQuestions().add(rankQuestion);
        }
    }
    
    public static Test load(String path)
    {
        Test t;
        try
        {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            t = (Test) in.readObject();
            in.close();
            fileIn.close();
            return t;
        } catch (IOException i)
        {
            System.out.println("IOException");
            return null;
        } catch (ClassNotFoundException c)
        {
            System.out.println("Test class not found");
            return null;
        }
    }
    
    public static void save(Test test)
    {
        System.out.println("Please enter the file path where you wish to save the survey");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        test.setPath(path);
        try
        {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(test);
            out.close();
            fileOut.close();
        } catch(IOException i)
        {
            System.out.println("IO Exception");
        }
    }
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author kellyshiptoski
 */
public class Survey implements Serializable {

    protected ArrayList<Question> questions;
    protected String path;
    protected String name;

    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public ArrayList<Question> getQuestions()
    {
        return this.questions;
    }
    
    public String getPath()
    {
        return this.path;
    }
    
    public void setPath(String path)
    {
        this.path = path;
    }
    
    public Survey ()
    {
        this.questions = new ArrayList<Question>();
    }
    
    public Survey (ArrayList<Question> questions, String path, String name)
    {
        this.questions = questions;
        this.path = path;
        this.name = name;
    }
    
    public static Survey makeNew()
    {
        int userChoice;
        Survey survey = new Survey();
        System.out.println("Please enter a name for the survey");
        Scanner in_ = new Scanner(System.in);
        String name = in_.nextLine();
        survey.setName(name);
        do 
        {
            System.out.println("1) Add a new T/F question");
            System.out.println("2) Add a new multiple choice question");
            System.out.println("3) Add a new short answer question");
            System.out.println("4) Add a new essay question");
            System.out.println("5) Add a new ranking question");
            System.out.println("6) Add a new matching question");
            System.out.println("7) Return to survey menu");
            Scanner in = new Scanner(System.in);
            userChoice = in.nextInt();
            in.nextLine();
        
            if (userChoice == 1) // T/F question (no correct answer)
                addTrueFalseQuestion(survey, in);
            else if (userChoice == 2) // Multiple choice question (no correct answer)
                addMultipleChoiceQuestion(survey, in);
            else if (userChoice == 3) //Short answer (no correct answer)
                addEssayQuestion(survey, in, userChoice);
            else if (userChoice == 4) //Essay question (no correct answer)
                addEssayQuestion(survey, in, userChoice);
            else if (userChoice == 5) //Ranking question (no correct answer)
                addMatchingQuestion(survey, in, userChoice);
            else if (userChoice == 6) //Matching question (no correct answer)
                addMatchingQuestion(survey, in, userChoice);
        } while(userChoice != 7); 

        return survey;
    }
    
    public static void addTrueFalseQuestion(Survey survey, Scanner in)
    {
        System.out.println("Enter your prompt for the T/F question");  
		  String prompt = in.nextLine();
		  int questionNumber = survey.getQuestions().size();
		  questionNumber++;
        String question = questionNumber + ") " + prompt;
        ArrayList<TrueFalseAnswer> possibleAnswers = new ArrayList<TrueFalseAnswer>();
        ArrayList<Answer> userAnswers = new ArrayList<Answer>();
        possibleAnswers.add(new TrueFalseAnswer(true));
        possibleAnswers.add(new TrueFalseAnswer(false));
        TrueFalseQuestion tfQuestion = new TrueFalseQuestion(question, null, possibleAnswers, userAnswers);
        survey.getQuestions().add(tfQuestion);
    }
    public static void addMultipleChoiceQuestion(Survey survey, Scanner in)
    {
        System.out.println("Enter your prompt for the multiple choice question");
		  String prompt = in.nextLine();
		  int questionNumber = survey.getQuestions().size();
		  questionNumber++;
        String question = questionNumber + ") " + prompt;
        HashMap<String,MultipleChoiceAnswer> possibleAnswers = new HashMap<String,MultipleChoiceAnswer>();
        ArrayList<Answer> userAnswers = new ArrayList<Answer>();
        String possibleAnswer;
        String letter;

        do 
        {
            System.out.println("Please enter a letter or type exit to move on");
            letter = in.next();
            in.nextLine();
            if (!letter.equals("exit"))
            {
                System.out.println("Please enter the corresponding potential answer");
                possibleAnswer = in.nextLine();
                MultipleChoiceAnswer a = new MultipleChoiceAnswer(possibleAnswer);
                possibleAnswers.put(letter, a);
            }
        } while(!letter.equals("exit"));

        System.out.println("Calling the contructor");
        MultipleChoiceQuestion multChQuestion = new MultipleChoiceQuestion(question, null, possibleAnswers, userAnswers);
        multChQuestion.displayQuestion();
        survey.getQuestions().add(multChQuestion);
    }

    public static void addEssayQuestion(Survey survey, Scanner in, Integer userChoice)
    {
        if (userChoice == 4)
		  		System.out.println("Enter your prompt for the essay question");
		  else if (userChoice == 3)
			   System.out.println("Enter your prompt for the short answer question"); 
		  String prompt = in.nextLine();
        int questionNumber = survey.getQuestions().size();
		  questionNumber++;
		  String question = questionNumber + ") " + prompt;
        ArrayList<Answer> userAnswers = new ArrayList<Answer>();

        if (userChoice == 4)
        {
            EssayQuestion essayQuestion = new EssayQuestion(question, userAnswers);
            survey.getQuestions().add(essayQuestion);
        }
        else 
        {
            ShortAnswerQuestion shortQuestion = new ShortAnswerQuestion(question, userAnswers, null);
            survey.getQuestions().add(shortQuestion);
        }
        
    }

    public static void addMatchingQuestion(Survey survey, Scanner in, int userChoice)
    {
		  if (userChoice == 6)
        		System.out.println("Enter your prompt for the matching question");
		  else if (userChoice == 5)
			  	System.out.println("Enter your prompt for the ranking question");
		  String prompt = in.nextLine();
		  int questionNumber = survey.getQuestions().size();
		  questionNumber++;
        ArrayList<Answer> userAnswers = new ArrayList<Answer>();

        String question = questionNumber + ") " + prompt;
        String leftAnswer;
        String rightAnswer;
        ArrayList<String> leftAnswers = new ArrayList<String>();
        ArrayList<String> rightAnswers = new ArrayList<String>();

        do
        {
            System.out.println("Please enter a possible answer or type exit to move on");
            leftAnswer = in.nextLine();
            if (!leftAnswer.equals("exit"))
            {
                System.out.println("Please enter what the answer should be matched to");
                rightAnswer = in.nextLine();
                leftAnswers.add(leftAnswer);
                rightAnswers.add(rightAnswer);
            }

        }while(!leftAnswer.equals("exit"));
        
        if (userChoice == 6) //matching
        {
            MatchingAnswer a = new MatchingAnswer(leftAnswers, rightAnswers);
            MatchingQuestion matchQuestion = new MatchingQuestion(question, null, userAnswers, a);
            survey.getQuestions().add(matchQuestion);
        }
        else
        {
            RankingAnswer a = new RankingAnswer(leftAnswers, rightAnswers);
            RankingQuestion rankQuestion = new RankingQuestion(question, null, userAnswers, a);
            survey.getQuestions().add(rankQuestion);
        }
    }
    
    public static void display(Survey survey)
    {
        for (int i = 0; i < survey.getQuestions().size(); i++)
        {
            survey.getQuestions().get(i).displayQuestion();
            System.out.println();
        }
    }
    
    public static Survey load(String path)
    {
        Survey s;
        try
        {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            s = (Survey) in.readObject();
            in.close();
            fileIn.close();
            return s;
        } catch (IOException i)
        {
            System.out.println("IOException");
            return null;
        } catch (ClassNotFoundException c)
        {
            System.out.println("Survey class not found");
            return null;
        }
    }

    public static void save(Survey survey)
    {
        System.out.println("Please enter the file path where you wish to save the survey");
        Scanner in = new Scanner(System.in);
        String path = in.next();
        survey.setPath(path);
        try
        {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(survey);
            out.close();
            fileOut.close();
        } catch(IOException i)
        {
            System.out.println("IO Exception");
            i.printStackTrace();
        }
    }

	 public void modify()
	 {
		 System.out.println("What question do you wish to modify?");
		 Scanner in = new Scanner(System.in);
		 String questionNumber = in.nextLine();
		 for (int i = 0; i < this.getQuestions().size(); i++)
		 {
			 	if(this.getQuestions().get(i).getQuestion().substring(0, 1).equals(questionNumber))
					this.getQuestions().get(i).modifyQuestion();
		 }
	 }

    public Survey takeSurvey()
    {
        for (int i = 0; i < this.getQuestions().size(); i++)
        {
            Scanner in = new Scanner(System.in);
            System.out.println(this.getQuestions().get(i).toString());
            System.out.println("Please enter your answer now");
            this.getQuestions().get(i).getAnswerFromUser();
        }
        return this;
    }

    public void tabulate()
    {
        for(int i = 0; i < this.questions.size(); i++)
        {
            System.out.println(this.questions.get(i).getQuestion());
            HashMap<Answer, Integer> map = new HashMap<Answer, Integer>();

            ArrayList<Answer> userAnswers = this.questions.get(i).getUserAnswers();
            for (int j = 0; j < userAnswers.size(); j++)
            {
                Answer currentAnswer = userAnswers.get(j);
                if (map.containsKey(currentAnswer)) {
                    map.put(currentAnswer, map.get(currentAnswer) + 1);
                } else {
                    map.put(currentAnswer, 1);
                }
            }

            for (Answer key : map.keySet())
            {
                System.out.println("Number of users who answered \n" + key.toString() + ": " + map.get(key) + "\n");
            }
        }


    }
}

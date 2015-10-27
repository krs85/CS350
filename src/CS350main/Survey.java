/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author kellyshiptoski
 */
public class Survey {

    protected ArrayList<Question> questions;
    
    public ArrayList<Question> getQuestions()
    {
        return this.questions;
    }
    
    public Survey (ArrayList<Question> questions)
    {
        this.questions = questions;
    }
    public void makeNew()
    {
        int userChoice;
        do 
        {
            System.out.println("1) Add a new T/F question");
            System.out.println("2) Add a new multiple choice question");
            System.out.println("3) Add a new short answer question");
            System.out.println("4) Add a new essay question");
            System.out.println("5) Add a new ranking question");
            System.out.println("6) Add a new matching question");
            System.out.println("7) Quit");
            Scanner in = new Scanner(System.in);
            userChoice = in.nextInt();
        
            ArrayList<Question> surveyQuestions = new ArrayList<Question>();
            Survey survey = new Survey(surveyQuestions);
        
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
    }
    
    public void addTrueFalseQuestion(Survey survey, Scanner in)
    {
        System.out.println("Please enter what you want the question to be");   
        String question = in.next();
        ArrayList<TrueFalseAnswer> possibleAnswers = new ArrayList<TrueFalseAnswer>();
        possibleAnswers.add(new TrueFalseAnswer(true));
        possibleAnswers.add(new TrueFalseAnswer(false));
        TrueFalseQuestion tfQuestion = new TrueFalseQuestion(question, null, possibleAnswers, null);
        survey.getQuestions().add(tfQuestion);
    }
    public void addMultipleChoiceQuestion(Survey survey, Scanner in)
    {
        System.out.println("Please enter your prompt for the multiple choice question");
        String question = in.next();
        HashMap<String,MultipleChoiceAnswer> possibleAnswers = new HashMap<String,MultipleChoiceAnswer>();
        String possibleAnswer;
        String letter;
        do 
        {
            System.out.println("Please enter a letter or type exit to move on");
            letter = in.next();
            System.out.println("Please enter the corresponding potential answer");
            possibleAnswer = in.next();
            MultipleChoiceAnswer a = new MultipleChoiceAnswer(possibleAnswer);
            possibleAnswers.put(letter, a);
        } while(!possibleAnswer.equals("exit"));

        MultipleChoiceQuestion multChQuestion = new MultipleChoiceQuestion(question, null, possibleAnswers, null);
        survey.getQuestions().add(multChQuestion);
    }

    public void addEssayQuestion(Survey survey, Scanner in, Integer userChoice)
    {
        System.out.println("Please enter what you wnat the question to be");
        String question = in.next();
        if (userChoice == 4)
        {
            EssayQuestion essayQuestion = new EssayQuestion(question, null, null);
            survey.getQuestions().add(essayQuestion);
        }
        else 
        {
            ShortAnswerQuestion shortQuestion = new ShortAnswerQuestion(question, null, null);
            survey.getQuestions().add(shortQuestion);
        }
        
    }

    public void addMatchingQuestion(Survey survey, Scanner in, int userChoice)
    {
        System.out.println("Please enter what you want the question to be");
        String question = in.next();
        String leftAnswer;
        String rightAnswer;
        HashMap<String,String> possibleAnswers = new HashMap<String,String>();
        do
        {
            System.out.println("Please enter a possible answer or type exit to move on");
            leftAnswer = in.next();
            if (!leftAnswer.equals("exit"));
            {
                System.out.println("Please enter what the answer should be matched to");
                rightAnswer = in.next();
                possibleAnswers.put(leftAnswer, rightAnswer);
            }

        }while(!leftAnswer.equals("exit"));
        
        if (userChoice == 6) //matching
        {
            MatchingAnswer a = new MatchingAnswer(possibleAnswers);
            MatchingQuestion matchQuestion = new MatchingQuestion(question, null, null, a);
            survey.getQuestions().add(matchQuestion);
        }
        else
        {
            RankingAnswer a = new RankingAnswer(possibleAnswers);
            RankingQuestion rankQuestion = new RankingQuestion(question, null, null, a);
            survey.getQuestions().add(rankQuestion);
        }
    }
    
    public void display(Survey survey)
    {
        for (int i = 0; i < survey.getQuestions().size(); i++)
        {
            survey.getQuestions().get(i).displayQuestion();
            System.out.println();
        }
    }
    
}

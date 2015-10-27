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
public class Test extends Survey{
    public Test (ArrayList<Question> questions)
    {
        super(questions);
    }
    
    @Override
    public void addTrueFalseQuestion(Survey survey, Scanner in) 
    {
        System.out.println("Enter your prompt for the T/F question");   
        String question = in.next();
        
        ArrayList<TrueFalseAnswer> possibleAnswers = new ArrayList<TrueFalseAnswer>();
        possibleAnswers.add(new TrueFalseAnswer(true));
        possibleAnswers.add(new TrueFalseAnswer(false));
        
        System.out.println("Enter the correct answer for the T/F question");
        String correct = in.next();
        TrueFalseAnswer correctAnswer = new TrueFalseAnswer(Boolean.valueOf(correct));
        TrueFalseQuestion tfQuestion = new TrueFalseQuestion(question, correctAnswer, possibleAnswers, null);
        survey.getQuestions().add(tfQuestion);
    }
    
    public void addMultipleChoiceQuestion(Survey survey, Scanner in) //question, correct, possible, user
    {
        System.out.println("Enter your prompt for the multiple choice question");
        String question = in.next();
        HashMap<String, MultipleChoiceAnswer> possibleAnswers = new HashMap<String, MultipleChoiceAnswer>();
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

        System.out.println("Enter the correct letter for the multiple choice question");
        String correctLetter = in.next();
        System.out.println("Enter the correct answer for the multiple choice question");
        String correctA = in.next();
        MultipleChoiceAnswer correctAnswer = new MultipleChoiceAnswer(correctA);
        HashMap<String, MultipleChoiceAnswer> correct = new HashMap<String, MultipleChoiceAnswer>();
        correct.put(correctLetter, correctAnswer);
        MultipleChoiceQuestion multChQuestion = new MultipleChoiceQuestion(question, correct, possibleAnswers, null);
        survey.getQuestions().add(multChQuestion);
    }

    public void addEssayQuestion(Survey survey, Scanner in, Integer userChoice) //question, correct, user
    {
        System.out.println("Enter your prompt for the essay/short answer question");
        String question = in.next();
        System.out.println("Enter the correct answer for the essay/short answer question");
        String correct = in.next();
        if (userChoice == 4)
        {
            EssayAnswer correctAnswer = new EssayAnswer(correct);
            EssayQuestion essayQuestion = new EssayQuestion(question, correctAnswer, null);
            survey.getQuestions().add(essayQuestion);
        }
        else 
        {
            ShortAnswerAnswer correctAnswer = new ShortAnswerAnswer(correct);
            ShortAnswerQuestion shortQuestion = new ShortAnswerQuestion(question, correctAnswer, null);
            survey.getQuestions().add(shortQuestion);
        }      
    }

    public void addMatchingQuestion(Survey survey, Scanner in, int userChoice)//question,correct,user,possible
    {
        System.out.println("Enter your prompt for the matching/ranking question");
        String question = in.next();

        String leftAnswer;
        String rightAnswer;
        HashMap<String,String> possibleAnswers = new HashMap<String,String>();
        String correctLeftAnswer;
        String correctRightAnswer;
        HashMap<String,String> correctAnswer = new HashMap<String,String>();
        do
        {
            do
            {
                System.out.println("Please enter a matching option or type exit to move on");
                leftAnswer = in.next();
                if (!leftAnswer.equals("exit"))
                {
                    System.out.println("Please enter what the option should be initially matched to");
                    rightAnswer = in.next();
                    possibleAnswers.put(leftAnswer, rightAnswer);
                }

            } while(!leftAnswer.equals("exit"));

            do
            {
                System.out.println("Please enter a matching option or type exit to move on");
                correctLeftAnswer = in.next();
                if(!correctLeftAnswer.equals("exit"))
                {
                    System.out.println("Please enter what the option should be initially matched to");
                    correctRightAnswer = in.next();
                    correctAnswer.put(correctLeftAnswer, correctRightAnswer);
                }
            } while(!correctLeftAnswer.equals("exit"));
        } while(correctAnswer.size() != possibleAnswers.size());
        
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
}

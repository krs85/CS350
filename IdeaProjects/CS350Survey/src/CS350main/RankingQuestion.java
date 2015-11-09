/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author kellyshiptoski
 */
public class RankingQuestion extends MatchingQuestion{
    public RankingQuestion(String question, 
                           RankingAnswer correctAnswer,
                           ArrayList<Answer> userAnswers,
                           RankingAnswer possibleAnswers)
    {
        super(question, correctAnswer, userAnswers, possibleAnswers);
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
       if(modifyChoices.equals("yes") || modifyChoices.equals("Yes")) {
           String changeNum = "";
           String newLeft = "";
           String newRight = "";
           do {
               System.out.println("What choice do you wish to modify? Please enter the choice or type exit to move on");
               System.out.println(this.possibleAnswers.toString());

               changeNum = in.nextLine();

               if (!changeNum.equals("exit")) {
                   int changeN = Integer.parseInt(changeNum);
                   System.out.println("What do you wish to change the choice's match to?");
                   newRight = in.nextLine();
                   this.possibleAnswers.getLeftAnswers().set(changeN, newLeft);
                   this.possibleAnswers.getRightAnswers().set(changeN, newRight);
               }
           } while (!changeNum.equals("exit"));
       }
           System.out.println("Do you wish to modify the correct answer?");
           String modifyCorrect = in.nextLine();

           if(modifyCorrect.equals("yes") || modifyCorrect.equals("Yes")) {
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



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
public class Cs350Main {

    private static Survey currentSurvey;
    private static Test currentTest;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice1 = Menu1();
        while (choice1 != 3)
        {
            if (choice1 == 1)
            {
                currentSurvey = new Survey();
                int surveyChoice = SurveyMenu();
                int num = 0;
                while (num != 1)
                {
                    num = surveyMenuChoice(surveyChoice);
                    if (num != 1)
                    {
                        surveyChoice = SurveyMenu();
                    }
                }
            }
            else if (choice1 == 2)
            {
                currentTest = new Test();
                int testChoice = TestMenu();
                int num = 0;
                while (num != 1)
                {
                    num = testMenuChoice(testChoice);
                    if (num != 1)
                    {
                        testChoice = TestMenu();
                    }
                }
            }
            
            choice1 = Menu1();
        }
    }
    
    public static Integer Menu1()
    {
        System.out.println("Please choose from the following options: ");
		  System.out.println("1) Survey menu");
		  System.out.println("2) Test menu");
		  System.out.println("3) Quit");
        Scanner in = new Scanner(System.in);
        int userChoice = in.nextInt();
        return userChoice;
    }
    
    public static Integer SurveyMenu()
    {
        System.out.println("Please choose from the following options: ");
        System.out.println("1) Create a new survey");
        System.out.println("2) Display a survey");
        System.out.println("3) Load a survey");
        System.out.println("4) Save a survey");
		  System.out.println("5) Modify an existing survey");
		  System.out.println("6) Take a survey");
		  System.out.println("7) Tabulate a survey");
        System.out.println("8) Return to main menu");
        Scanner in = new Scanner(System.in);
        int userChoice = in.nextInt();
        return userChoice;
    }
    
    public static Integer surveyMenuChoice(Integer userChoice)
    {
        if (userChoice == 1)
        {
            currentSurvey = Survey.makeNew();
            return 0;
        }
        else if (userChoice == 2)
        {
            Survey.display(currentSurvey);
            return 0;
        }
        else if (userChoice == 3)
        {
            System.out.println("Please enter the file path of the survey you want to load");
            Scanner in = new Scanner(System.in);
            String path = in.next();
            currentSurvey = Survey.load(path);
            while(currentSurvey == null)
            {
                System.out.println("Please enter the file path of the survey you want to load");
                path = in.next();
                currentSurvey = Survey.load(path);
            }
            return 0;
        }
        else if (userChoice == 4)
        {
            Survey.save(currentSurvey);
            return 0;
        }
		  else if (userChoice == 5) // modify existing survey
		  {
		  		Scanner in = new Scanner(System.in);
			   System.out.println("What survey do you wish to modify? (enter the path)");
				String modify = in.nextLine();
				currentSurvey = Survey.load(modify);
				currentSurvey.modify();
				Survey.save(currentSurvey);
			   return 0;
		  }
		  else if (userChoice == 6) // take a survey
		  {
			  return 0;
		  }
		  else if (userChoice == 7) // tabulate a survey
		  {
			  return 0;
		  }
        else
        {
            return 1;
        }
    }
    
    public static Integer TestMenu()
    {
        System.out.println("Please choose from the following options: ");
        System.out.println("1) Create a new test");
        System.out.println("2) Display a test");
        System.out.println("3) Load a test");
        System.out.println("4) Save a test");
        System.out.println("5) Return to main menu");
        Scanner in = new Scanner(System.in);
        int userChoice = in.nextInt();
        return userChoice;
    }
    
    public static Integer testMenuChoice(Integer userChoice)
    {
        if (userChoice == 1)
        {
            currentTest = Test.makeNew();
            return 0;
        }
        else if (userChoice == 2)
        {
            Survey.display(currentTest);
            return 0;
        }
        else if (userChoice == 3)
        {
            System.out.println("Please enter the file path of the survey you want to load");
            Scanner in = new Scanner(System.in);
            String path = in.next();
            currentTest = Test.load(path);
            while(currentTest == null)
            {
                System.out.println("Please enter the file path of the survey you want to display");
                path = in.next();
                currentTest = Test.load(path);
            }
            return 0;
        }
        else if (userChoice == 4)
        {
            Test.save(currentTest);
            return 0;
        }
        else
        {
            return 1;
        }
    }
}

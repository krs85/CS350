/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;
import java.util.Scanner;
/**
 *
 * @author kellyshiptoski
 */
public class Cs350Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    public Integer Menu1()
    {
        System.out.println("Please choose between a survey and and test. Enter 1 for survey, and 2 for test.");
        Scanner in = new Scanner(System.in);
        int userChoice = in.nextInt();
        return userChoice;
    }
    
    public Integer SurveyMenu()
    {
        System.out.println("Please choose from the following options: ");
        System.out.println("1) Create a new survey");
        System.out.println("2) Display a survey");
        System.out.println("3) Load a survey");
        System.out.println("4) Save a survey");
        System.out.println("Quit");
        Scanner in = new Scanner(System.in);
        int userChoice = in.nextInt();
        return userChoice;
    }
    
    public Integer TestMenu()
    {
        System.out.println("Please choose from the following options: ");
        System.out.println("1) Create a new test");
        System.out.println("2) Display a test");
        System.out.println("3) Load a test");
        System.out.println("4) Save a test");
        System.out.println("Quit");
        Scanner in = new Scanner(System.in);
        int userChoice = in.nextInt();
        return userChoice;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;

/**
 *
 * @author kellyshiptoski
 */
public class EssayQuestion extends Question {
    private String question;
    private EssayAnswer correctAnswer;
    private EssayAnswer userAnswer;
    
    public EssayQuestion (String question, 
                          EssayAnswer correctAnswer, 
                          EssayAnswer userAnswer)
    {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.userAnswer = userAnswer;
    }
    
    public void addUserAnswer(EssayAnswer a)
    {
        this.userAnswer = userAnswer;
    }
    
    public void addCorrectAnswer(EssayAnswer a)
    {
        this.correctAnswer = correctAnswer;
    }
    
    public Boolean gradeQuestion()
    {
        return this.userAnswer == this.correctAnswer;
    }
    
    @Override
    public void getAnswerFromUser()
    {
        
    }
    
    @Override
    public void displayQuestion()
    {
        System.out.println(this.question);
        if (this.correctAnswer != null)
            System.out.println("The correct answer is " + this.correctAnswer.toString());
    }
}

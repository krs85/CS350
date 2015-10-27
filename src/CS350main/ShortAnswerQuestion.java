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
public class ShortAnswerQuestion extends EssayQuestion {
    public ShortAnswerQuestion(String question,
                               ShortAnswerAnswer correctAnswer,
                               ShortAnswerAnswer userAnswer)
    {
        super(question, correctAnswer, userAnswer);
    }
}

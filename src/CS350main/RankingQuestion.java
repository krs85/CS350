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
public class RankingQuestion extends MatchingQuestion{
    public RankingQuestion(String question, 
                           RankingAnswer correctAnswer,
                           RankingAnswer userAnswer,
                           RankingAnswer possibleAnswers)
    {
        super(question, correctAnswer, userAnswer, possibleAnswers);
    }
}

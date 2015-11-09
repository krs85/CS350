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
public class RankingAnswer extends MatchingAnswer{
    public RankingAnswer(ArrayList<String> leftAnswers, ArrayList<String> rightAnswers)
    {
        super(leftAnswers, rightAnswers);
    }

    @Override
    public String toString()
    {
        String answer = "";
        for (int i = 0; i < leftAnswers.size(); i++)
        {
            String left = leftAnswers.get(i);
            String right = rightAnswers.get(i);
            answer += left + " " + right + "\n";
        }
        return answer;
    }
}

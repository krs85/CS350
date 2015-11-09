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
public class MatchingAnswer implements Answer {
    protected ArrayList<String> leftAnswers;
    protected ArrayList<String> rightAnswers;
    
    public MatchingAnswer(ArrayList<String> leftAnswers, ArrayList<String> rightAnswers)
    {
        this.leftAnswers = leftAnswers;
        this.rightAnswers = rightAnswers;
    }

    public ArrayList<String> getLeftAnswers()
    {
        return this.leftAnswers;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof MatchingAnswer)) return false;

        MatchingAnswer that = (MatchingAnswer) o;

        if (!leftAnswers.equals(that.leftAnswers)) return false;
        return rightAnswers.equals(that.rightAnswers);

    }

    @Override
    public int hashCode()
    {
        int result = leftAnswers.hashCode();
        result = 31 * result + rightAnswers.hashCode();
        return result;
    }

    public ArrayList<String> getRightAnswers()
    {
        return this.rightAnswers;
    }

    @Override
    public String toString()
    {
        String answer = "";
        char letter = 'A';
        int num = 1;

        for (int i = 0; i < leftAnswers.size(); i++)
        {
            String left = leftAnswers.get(i);
            String right = rightAnswers.get(i);
            answer += letter + ") " + left + " " + num + ") " + right + "\n";

            letter++;
            num++;
        }
        return answer;
    }
}

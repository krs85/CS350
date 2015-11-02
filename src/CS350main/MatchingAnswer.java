/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;

import java.util.HashMap;

/**
 *
 * @author kellyshiptoski
 */
public class MatchingAnswer implements Answer {
    protected HashMap<String,String> answer;
    
    public MatchingAnswer(HashMap<String,String> answer)
    {
        this.answer = answer;
    }
    
    @Override
    public String toString()
    {
        String answer = "";
        for (String m: this.answer.keySet())
        {
            String key = m;
            String value = this.answer.get(key);
            answer += key;
            answer += " ";
            answer += value;
            answer += "/n";
        }
        return answer;
    }
}

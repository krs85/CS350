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
public class TrueFalseAnswer implements Answer {
    private Boolean answer;
    
    public TrueFalseAnswer (Boolean answer)
    {
        this.answer = answer;
    }
    
    @Override
    public String toString()
    {
        if (this.answer == true)
            return "true";
        else
            return "false";
    }
}

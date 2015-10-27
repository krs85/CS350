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
public class MultipleChoiceAnswer {
    private String answer;
    
    public MultipleChoiceAnswer (String answer)
    {
        this.answer = answer;
    }
    
    @Override
    public String toString()
    {
        return this.answer;
    }
}

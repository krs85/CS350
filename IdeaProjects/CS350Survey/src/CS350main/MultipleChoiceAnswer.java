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
public class MultipleChoiceAnswer implements Answer {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MultipleChoiceAnswer that = (MultipleChoiceAnswer) o;

        return answer.equals(that.answer);

    }

    @Override
    public int hashCode() {
        return answer.hashCode();
    }
}

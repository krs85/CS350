/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS350main;

import java.io.Serializable;

/**
 *
 * @author kellyshiptoski
 */
public abstract class Question implements Serializable {
    
    abstract public void displayQuestion();

    abstract public void getAnswerFromUser();
    
}

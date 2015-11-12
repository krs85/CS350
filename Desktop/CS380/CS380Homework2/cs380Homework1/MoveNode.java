/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs380Homework1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kellyshiptoski
 */
public class MoveNode {
    
    public void addNodeAndMove(Moves move)
    {
        MoveNode newChild = new MoveNode(Moves.applyMoveCloning(this.state, move), this, new ArrayList<MoveNode>(), move);
        this.children.add(newChild);       
    }

    public void addNode(MoveNode child)
    {
        this.children.add(child);
    }
        private ArrayList<ArrayList<Integer>> state;
        private MoveNode parent;
        private ArrayList<MoveNode> children;
        private Moves move;
        
        public MoveNode ()
        {
            
        }
        public MoveNode (ArrayList<ArrayList<Integer>> state, MoveNode parent, ArrayList<MoveNode> children, Moves move)
        {
            this.state = state;
            this.parent = parent;
            this.children = children;
            this.move = move;
        }
        
        public ArrayList<ArrayList<Integer>> getState()
        {
            return this.state;
        }
        
        public MoveNode getParent()
        {
            return this.parent;
        }
        
        public Moves getMove()
        {
            return this.move;
        }

}

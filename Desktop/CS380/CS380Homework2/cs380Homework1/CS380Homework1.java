/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs380Homework1;

import java.util.List;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author kellyshiptoski
 */
public class CS380Homework1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
 
        if (args.length < 2)
        {
            System.out.println("Please include a filename and number of iterations.");
            return;
        }

		  System.out.println(args[0]);

        if (args[0].equals("depth"))
        {
            ArrayList<ArrayList<Integer>> state = loadGameState(args[1]);
            MoveNode node = new MoveNode(state, null, new ArrayList<MoveNode>(), null);
            depthFirstSearch(node, new HashSet<ArrayList<ArrayList<Integer>>>());
        }
        else if (args[0].equals("breadth"))
        {
            ArrayList<ArrayList<Integer>> state = loadGameState(args[1]);
            MoveNode node = new MoveNode(state, null, new ArrayList<MoveNode>(), null);
            breadthFirstSearch(node, new HashSet<ArrayList<ArrayList<Integer>>>());
        }
        
        else if (args[0].equals("iterative"))
        {
            ArrayList<ArrayList<Integer>> state = loadGameState(args[1]);
            iterativeDeepeningSearch(state, Integer.parseInt(args[2]));
        }
    }
    
    static ArrayList<ArrayList<Integer>> loadGameState(String filename) throws IOException
    {
        FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        String line;
        int numLines = 0;
        int i = 0;
        String firstline = textReader.readLine();

        ArrayList<ArrayList<Integer>> gameBoard = new ArrayList<ArrayList<Integer>>();
        while((line = textReader.readLine()) != null)
        {
            gameBoard.add(new ArrayList<Integer>());
            String[] noCommas = line.split(",");
            for(String number: noCommas)
            {
                int num = Character.getNumericValue(number.charAt(0));
                gameBoard.get(i).add(num);
            }
            i++;
            
        }
        textReader.close();
        return gameBoard;
    } 
    
    static void showGameState(ArrayList<ArrayList<Integer>> gameState) throws IOException
    {   
        System.out.println(gameState.size() + "," + gameState.get(0).size() + ",");
        for(int i = 0; i < gameState.size(); i++)
        {
            for (int j = 0; j < gameState.get(0).size(); j++)
            {
                System.out.print(gameState.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    
    static ArrayList<ArrayList<Integer>> cloneGameState (ArrayList<ArrayList<Integer>> gameState)
    {
        ArrayList<ArrayList<Integer>> clonedGameState = new ArrayList<ArrayList<Integer>>();
    
        for(int i = 0; i < gameState.size(); i++)
        {
            clonedGameState.add(new ArrayList<Integer>());
            for (int j = 0; j < gameState.get(0).size(); j++)
            {
                clonedGameState.get(i).add(gameState.get(i).get(j));
            }
        } 
        return clonedGameState;
    }
    
    static boolean puzzleCompleteCheck(ArrayList<ArrayList<Integer>> gameState)
    {
        for(int i = 0; i < gameState.size(); i++)
        {
            for(int j = 0; j < gameState.get(0).size(); j++)
            {
                int num = gameState.get(i).get(j);
                if (num == -1)
                    return false;
            }
        }
        return true;
    }
    
    static boolean stateComparison (ArrayList<ArrayList<Integer>> firstState, ArrayList<ArrayList<Integer>> secondState)
    {
        if (firstState.size() != secondState.size())
            return false;
        if (firstState.get(0).size() != secondState.get(0).size())
            return false;
        
        for(int i = 0; i < firstState.size(); i++)
        {
            for(int j = 0; j < firstState.get(0).size(); j++)
            {
                if(firstState.get(i).get(j) != secondState.get(i).get(j))
                    return false;
            }
        }
        return true;
    }
    
    static void swapIndex (int idx1, int idx2, int height, int width, ArrayList<ArrayList<Integer>> matrix)
    {
        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                if(matrix.get(i).get(j) == idx1)
                {
                    matrix.get(i).set(j, idx2);
                }
                else if (matrix.get(i).get(j) == idx2)
                {
                    matrix.get(i).set(j, idx1);
                }
            }
        }
    }
    
    static void normalize(int height, int width, ArrayList<ArrayList<Integer>> matrix)
    {
        int nextIdx = 3;
        for (int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                if(matrix.get(i).get(j) == nextIdx)
                    nextIdx++;
                else if(matrix.get(i).get(j) > nextIdx)
                {
                    swapIndex(nextIdx, matrix.get(i).get(j), height, width, matrix);
                    nextIdx++;
                }
            }
        }
    }
    
    static void randomWalk(ArrayList<ArrayList<Integer>> state, int number) throws IOException
    {
        int i = 0;
        Random rand = new Random();
        showGameState(state);
        while(!puzzleCompleteCheck(state) && i < number )
        {
            ArrayList<Moves> allMoves = Moves.allMoves(state);
            int index = rand.nextInt(allMoves.size());
            System.out.println();
            System.out.println("(" + allMoves.get(index).getIntIdentifier() + "," + allMoves.get(index).getDirection().toString() + ")");
            System.out.println();
            Moves.applyMove(state, allMoves.get(index));
            normalize(state.size(), state.get(0).size(), state);
            showGameState(state);
            i++;
        }
    }
    
    static Boolean depthFirstSearch(MoveNode node, HashSet<ArrayList<ArrayList<Integer>>> seenStates) throws IOException 
    {
        if (puzzleCompleteCheck(node.getState()))
        {
            ArrayList<ArrayList<Integer>> finalState = node.getState();
            Stack<Moves> solutionStack = new Stack<Moves>();
            while(node.getParent() != null)
            {
                solutionStack.add(node.getMove());
                node = node.getParent();
            }
            
            while (!solutionStack.empty())
            {
                Moves move = solutionStack.pop();
                System.out.println("(" + move.getIntIdentifier() + "," + move.getDirection().toString() + ")");
            }
            
            showGameState(finalState);
            return true;
        }
        ArrayList<Moves> initialMoves = Moves.allMoves(node.getState());
        for (Moves move : initialMoves)
        {
            MoveNode child = new MoveNode(Moves.applyMoveCloning(node.getState(), move), node, new ArrayList<MoveNode>(), move);
            if (!seenStates.contains(child.getState()))
            {
                node.addNode(child);
                seenStates.add(child.getState());
                if (depthFirstSearch(child, seenStates))
                    return true;
            }
        }
        
        return false;
    }
    
    static Boolean breadthFirstSearch(MoveNode node, HashSet<ArrayList<ArrayList<Integer>>> seenStates) throws IOException
    {
        if (puzzleCompleteCheck(node.getState()))
        {
            ArrayList<ArrayList<Integer>> finalState = node.getState();
            Stack<Moves> solutionStack = new Stack<Moves>();
            while(node.getParent() != null)
            {
                solutionStack.add(node.getMove());
                node = node.getParent();
            }
            
            while (!solutionStack.empty())
            {
                Moves move = solutionStack.pop();
                System.out.println("(" + move.getIntIdentifier() + "," + move.getDirection().toString() + ")");
            }
            
            showGameState(finalState);
            return true;
        }
        
        Queue<MoveNode> nodeQueue = new LinkedList<MoveNode>();
        nodeQueue.add(node);
        HashSet<ArrayList<ArrayList<Integer>>> statesSeen = new HashSet<ArrayList<ArrayList<Integer>>> (); ;
        while (!nodeQueue.isEmpty())
        {
            MoveNode newNode = nodeQueue.remove();
            ArrayList<Moves> allMoves = Moves.allMoves(newNode.getState());
            for (Moves move : allMoves)
            {
                MoveNode child = new MoveNode(Moves.applyMoveCloning(newNode.getState(), move), newNode, new ArrayList<MoveNode>(), move);
                
                if(!statesSeen.contains(child.getState()))
                {
                    newNode.addNode(child);
                    if(puzzleCompleteCheck(child.getState()))
                    {
                        ArrayList<ArrayList<Integer>> finalState = node.getState();
                        Stack<Moves> solutionStack = new Stack<Moves>();
                        MoveNode currentNode = child;
                        while(currentNode.getParent() != null)
                        {
                            solutionStack.add(currentNode.getMove());
                            currentNode = currentNode .getParent();
                        }

                        while (!solutionStack.empty())
                        {
                            Moves move2 = solutionStack.pop();
                            System.out.println("(" + move2.getIntIdentifier() + "," + move2.getDirection().toString() + ")");
                        }

                        showGameState(finalState);
                        return true;
                    }
                    
                    statesSeen.add(child.getState());
                    nodeQueue.add(child);
                }
                
                
            }
        }
    return false;
    }
    
    static Boolean depthLimitedSearch (MoveNode node, int limit) throws IOException 
    {
        if (puzzleCompleteCheck(node.getState()))
        {
            ArrayList<ArrayList<Integer>> finalState = node.getState();
            Stack<Moves> solutionStack = new Stack<Moves>();
            while(node.getParent() != null)
            {
                solutionStack.add(node.getMove());
                node = node.getParent();
            }
            
            while (!solutionStack.empty())
            {
                Moves move = solutionStack.pop();
                System.out.println("(" + move.getIntIdentifier() + "," + move.getDirection().toString() + ")");
            }
            
            showGameState(finalState);
            return true;
        }
        
        if (limit == 0)
        {
            return false;
        }
        
        ArrayList<Moves> initialMoves = Moves.allMoves(node.getState());
        for (Moves move : initialMoves)
        {
            MoveNode child = new MoveNode(Moves.applyMoveCloning(node.getState(), move), node, new ArrayList<MoveNode>(), move);
            node.addNode(child);
            if (depthLimitedSearch(child, limit - 1))
                return true;
        }
        
        return false;
    }
    
    public static Boolean iterativeDeepeningSearch(ArrayList<ArrayList<Integer>> state, int maxDepth) throws IOException
    {
        for(int i = 0; i < maxDepth; i++)
        {
            MoveNode root = new MoveNode(state, null, new ArrayList<MoveNode>(), null);
            if (depthLimitedSearch(root, i))
                return true;
        }
        
        return false;
    }
    
}


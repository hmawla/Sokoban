/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.util.stream.IntStream;

/**
 *
 * @author pedro
 */
public class SokobanLevel {
    enum blockTypes {
        OUT("Out",0),
        EMPTY("Empty",1),
        BOX("Box",2),
        STORAGE("Storage",3),
        PLAYER("Player",4);
        
        private String val;
        private int numVal;
        blockTypes(String theType, int numVal){
            this.val = theType;
            this.numVal = numVal;
        }
        public String val(){
            return val;
        }
    }
    String[][] playGround = new String[12][12];
    int[] difficulties = new int[]{0,1,2,3};
    int difficulty;
    
    SokobanLevel(int difficulty){
        if(IntStream.of(difficulties).anyMatch(diff -> diff == difficulty)){
            this.difficulty = difficulty;
            System.out.println("new level created with diff of: " + difficulty);
        }else{
            System.out.println("new level created with normal diff");
        }
    }
    void build(){
        if(difficulty == 0){
            for(int i=0 ; i< 12 ; i++){
                for(int j=0 ; j<12 ; j++){
                    if(i == 0 || i == 11 || j == 0 || j == 11){
                        playGround[i][j] = blockTypes.OUT.val;
                    }else if(i == 5 && j == 5){
                        playGround[i][j] = blockTypes.PLAYER.val;
                    }else
                        playGround[i][j] = blockTypes.EMPTY.val;
                }
            }
        }
        
    }
    void Display(){
        for(int i=0 ; i< 12 ; i++){
            for(int j=0 ; j<12 ; j++){
                System.out.print(playGround[i][j]);
            }
            System.out.println("");
        }
    }
}

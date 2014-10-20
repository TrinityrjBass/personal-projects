/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.battle.aid;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Trinity Bass
 */
public class PrintToFile {
    private final PrintWriter file;
    public String heading = "";

    PrintToFile(String fileName) 
            throws FileNotFoundException, IOException {
        file = new PrintWriter(new FileWriter(heading + ".txt"));
         
    }
    public void setHeading(String s){
        if(heading != null){
            heading = s;
        }
            
    }
    public void close(){
        file.close();
    }
    public void printLine(String s){
        file.println(s);
    }
    public void print (String s){
        file.print(s);
    }
    /*use printWriter pg 325
     * 
     */
    
}

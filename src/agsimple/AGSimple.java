/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agsimple;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.math.*;
/**
 *
 * @author karl
 */
public class AGSimple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        for (String s: args){
            
        }
        /*
        floatPrecision=0.0001f;
        floatXMin=0.0f; floatXMax=20.0f;
        floatTasaDeCruces=0.40f;
        floatTasaDeMutaciones=0.01f;
        intTamanioPob=300;
        intNumGeneraciones=30;
         */
        getConfigParameterFromFile("./AGConfig");
        float tempo= 1.0f + (floatXMax-floatXMin) / floatPrecision;
        
        intLargoCromosoma = (int) (Math.log((double) tempo) / Math.log(2.0)) + 1;
        //int _tam_pob, int _lcrom, int _num_max_gen, float _prob_cruce, float _prob_mutacion
        //AlgoritmoGeneticoSimple Sim = new AlgoritmoGeneticoSimple(30, 18, 10, 0.4f, 0.01f); 
        AlgoritmoGeneticoSimple Sim = 
                new AlgoritmoGeneticoSimple(intTamanioPob, intLargoCromosoma, floatPrecision, intNumGeneraciones, 
                                            floatTasaDeCruces, floatTasaDeMutaciones); 
        
        Sim.run();
        
    }
    
    private static PrintStream getPrintStream(String filename) {
        PrintStream out=null;
        try {
            out = new PrintStream( new File(filename));
        } catch(FileNotFoundException e) {
            System.out.println("Error with file "+filename+":"+e.getMessage());
            System.exit(-1);
        } 
        return out;
    }

    private static void getConfigParameterFromFile(String FileName) {
        try {
            String[] token;
            Scanner scan = new Scanner(new File(FileName));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                token = line.split(" ");
                if ("Precision".equals(token[0]))
                    floatPrecision= Float.parseFloat(token[1]);
                else if ("XMin".equals(token[0]))
                    floatXMin=Float.parseFloat(token[1]);
                else if ("XMax".equals(token[0]))
                    floatXMax=Float.parseFloat(token[1]);
                else if ("TasaDeCruces".equals(token[0]))
                    floatTasaDeCruces=Float.parseFloat(token[1]);
                else if ("TasaDeMutaciones".equals(token[0]))
                    floatTasaDeMutaciones=Float.parseFloat(token[1]);
                else if ("TamanioPob".equals(token[0]))
                    intTamanioPob=Integer.parseInt(token[1]);
                else if ("NumGeneraciones".equals(token[0]))
                    intNumGeneraciones=Integer.parseInt(token[1]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error with file "+FileName+":"+ex.getMessage());
            System.exit(-1);
        }
    }
  
  
    private static float floatPrecision;
    private static float floatXMin, floatXMax;
    private static float floatTasaDeCruces;
    private static float floatTasaDeMutaciones;
    private static int intTamanioPob;
    private static int intNumGeneraciones;
    private static int intLargoCromosoma;
    
  
}

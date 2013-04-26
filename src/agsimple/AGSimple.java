/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agsimple;

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
        float floatPrecision=0.0001f;
        float floatXMin=0.0f, floatXMax=20.0f;
        float floatTasaDeCruces=0.40f;
        float floatTasaDeMutaciones=0.01f;
        int intTamanioPob=30;
        int intNumGeneraciones=30;
        int intLargoCromosoma;
        float temp= 1.0f + (floatXMax-floatXMin) / floatPrecision;
        
        intLargoCromosoma = (int) (Math.log((double) temp) / Math.log(2.0)) + 1;
        
        //int _tam_pob, int _lcrom, int _num_max_gen, float _prob_cruce, float _prob_mutacion
        //AlgoritmoGeneticoSimple Sim = new AlgoritmoGeneticoSimple(30, 18, 10, 0.4f, 0.01f); 
        AlgoritmoGeneticoSimple Sim = 
                new AlgoritmoGeneticoSimple(intTamanioPob, intLargoCromosoma, floatPrecision, intNumGeneraciones, 
                                            floatTasaDeCruces, floatTasaDeMutaciones); 
        
        Sim.run();
        
    }
    

}

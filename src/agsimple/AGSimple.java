/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agsimple;

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
        AlgoritmoGeneticoSimple Sim = new AlgoritmoGeneticoSimple(10, 8, 20, 0.5f, 0.01f); 
        
        Sim.run();
        
    }
    

}

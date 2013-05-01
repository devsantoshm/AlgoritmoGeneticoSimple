/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agsimple;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author karl
 */
public class EvolveLog {
    public EvolveLog(String filename) {
        try {
            outPoblacion            = new PrintStream( new File(filename+"Poblacion"));
            outPoblacionResume      = new PrintStream( new File(filename+"PoblacionResume"));
            outSelecciones          = new PrintStream( new File(filename+"Selecciones"));
        } catch (FileNotFoundException e) {
            System.out.println("Error with file "+filename+":"+e.getMessage());
            System.exit(-1);
        }
    } 
    public void writeReproducciones(){
        
    } 
    public void writePoblacionResumeHeader() {
        outPoblacionResume.println("Campeon de");
        outPoblacionResume.println("cada generacion\t| Cromosoma\t\t| x\t\t\t| adaptacion\t| adaptacion media");
    }
    public void writePoblacionResume(TIndividuo[] Pob, int pos_mejor){
        float AdaptacionMedia=0;
        for (int i=0; i<Pob.length; i++) 
            AdaptacionMedia += Pob[i].GetAdaptacion();
        AdaptacionMedia = AdaptacionMedia / Pob.length;
        outPoblacionResume.println(pos_mejor + "\t\t| " + Pob[pos_mejor].VerCromosoma() + "\t| " + Pob[pos_mejor].ValueCromosoma() 
                + "\t\t|" + Pob[pos_mejor].GetAdaptacion() + "\t| " + AdaptacionMedia);
        
    }
    public void writePoblacionHeader(int Generacion, String Archivo) {
        if ("Poblacion".equals(Archivo))
            outPoblacion.println("Individuo\t|Cromosoma\t|ValueCromosoma\t|Adaptacion");
        else if ("Seleccion".equals(Archivo))
            outSelecciones.println("Individuo\t|Cromosoma\t|ValueCromosoma\t|Adaptacion");
    }
    public void writeIndividuo(TIndividuo Indiv, int i, String Archivo) {
        if ("Poblacion".equals(Archivo)){
            outPoblacion.println(i + "\t|" + Indiv.VerCromosoma() + "\t|" + Indiv.ValueCromosoma() + "\t|" + Indiv.GetAdaptacion());
        }else if ("Seleccion".equals(Archivo))
            outSelecciones.println(i + "\t|" + Indiv.VerCromosoma() + "\t|" + Indiv.ValueCromosoma() + "\t|" + Indiv.GetAdaptacion());
    }
    public void writePoblacionEnd(int Generacion, String Archivo){
        if ("Poblacion".equals(Archivo))
            outPoblacion.println(Generacion + "\n");
        else if ("Seleccion".equals(Archivo))
            outSelecciones.println(Generacion + "\n");
    }
    private PrintStream outPoblacion;
    private PrintStream outPoblacionResume;
    private PrintStream outSelecciones    ;
    private PrintStream outReproducciones ;
}

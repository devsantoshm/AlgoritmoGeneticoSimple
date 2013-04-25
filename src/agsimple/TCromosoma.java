/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agsimple;

import java.util.*;

/**
 *
 * @author karl
 */
public class TCromosoma {
    public TCromosoma(int _lcrom) {
        lcrom=_lcrom;
        rnd = new Random();
        Genotipo=new boolean[lcrom];
        for (int i = 0; i < lcrom; i++)
            Genotipo[i] = rnd.nextBoolean();
    }
    public TCromosoma(TCromosoma Padre, TCromosoma Madre, int _lcrom, int _punto_cruce) {
        lcrom=_lcrom;
        Genotipo=new boolean[lcrom];
        for (int i = 0; i < _punto_cruce; i++) {
            Genotipo[i] = Padre.GetGen(i);
        }
        for (int i=_punto_cruce; i < lcrom; i++) {
            Genotipo[i] = Madre.GetGen(i);
        }
    }
    
    public float decod(){
        return (float) bin_int(Genotipo);
    }
    public boolean mutar(float prob_mutar) {
        boolean mutado=false;
        int i, j;
        float prob; 
        
        for (i=0; i< lcrom; i++) {
            prob = rnd.nextFloat();
            if (prob < prob_mutar) 
                Genotipo[i] = !(Genotipo[i]);
            mutado=true;
        }
        return mutado;
            
    }
    private int bin_int(boolean[] _Genotipo ) {
        int d=0, pot=1;
        for (int i = 0; i < lcrom; i++) {
            if (_Genotipo[lcrom - i - 1])
                d = d + pot;
            pot=pot * 2;
        }
        return d;
    }
    
    public boolean GetGen(int locus) {
            return Genotipo[locus];
    } 
    
    public boolean[] GetCromosoma() {
        return Genotipo;
    }
    public String RepresentacionBinaria(){
        String stringCadena = "";
        for (int i=0; i < lcrom; i++) {
            if (Genotipo[i])
                stringCadena += "1";
            else
                stringCadena += "0";
        }
        return stringCadena;
    }
    private int lcrom;
    private boolean[] Genotipo;
    Random rnd;
}

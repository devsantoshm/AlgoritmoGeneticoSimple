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
        Random rnd = new Random();
        //int[] temp = null;
        Genotipo=new boolean[lcrom];
        for (int i = 0; i < lcrom; i++)
            Genotipo[i] = rnd.nextBoolean();
    }
    
    public float decod(){
        return (float) bin_int(Genotipo);
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
    
    private int lcrom;
    private boolean[] Genotipo;
    
}

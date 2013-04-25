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
public class AlgoritmoGeneticoSimple {
    public AlgoritmoGeneticoSimple (int a_tam_pob, int a_lcrom){
        lcrom=a_lcrom;
        tam_pob=a_tam_pob;
        Pob = new TIndividuo [tam_pob];
        for (int i = 0; i < tam_pob; i++) 
            Pob[i]=new TIndividuo(lcrom);
        
    }
    public void run() {
        evaluacion();
        seleccion();
    }
    private void evaluacion() {
        float punt_acu = 0;
        float adap_mejor = 0;
        int i;
        sumadaptacion=0;
        for (i = 0; i < tam_pob; i++) {
            sumadaptacion+=Pob[i].GetAdaptacion();
            if (Pob[i].GetAdaptacion() > adap_mejor) {
                pos_mejor=i;
                adap_mejor=Pob[i].GetAdaptacion();
            }
        }
        for (i=0; i < tam_pob; i++) {
            Pob[i].SetPuntuacion(Pob[i].GetAdaptacion() / sumadaptacion);
            Pob[i].SetPuntuacionAcumulada(Pob[i].GetAdaptacion() + punt_acu);
            punt_acu += Pob[i].GetPuntuacion();
        }
    }
    
    private void seleccion () {
        int [] sel_super = new int[tam_pob];
        float prob;
        int pos_super;
        int i;
        Random rnd = new Random();
        for (i=0; i<tam_pob; i++) {
            prob=rnd.nextFloat();
            pos_super=0;
            while ((prob > Pob[pos_super].GetPuntuacionAcumulada()) && (pos_super < tam_pob)) {
                pos_super++;
            }
            sel_super[i] = pos_super;
        }
        TIndividuo indiv=new TIndividuo(lcrom); 
        TIndividuo[] PobAux=new TIndividuo[tam_pob];
        for (i=0; i < tam_pob; i++) {
            //indiv = Pob[sel_super[i]];
            System.arraycopy(Pob, sel_super[i], PobAux, i, 1);
            //PobAux[i] = Pob[sel_super[i]];
        }
        for (i=0; i< tam_pob; i++) {
            Pob[i] = PobAux[i];
        }
    }
    
    
    private int tam_pob;
    private int lcrom;
    private int pos_mejor;
    private float sumadaptacion, prob_cruce, prob_mut;
    private TIndividuo[] Pob;
}

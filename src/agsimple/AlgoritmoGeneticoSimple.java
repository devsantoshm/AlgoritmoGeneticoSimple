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
    public AlgoritmoGeneticoSimple (int _tam_pob, int _lcrom, float _precision, int _num_max_gen, float _prob_cruce, float _prob_mutacion){
        log=new EvolveLog("./AGLog");
        prob_mut=_prob_mutacion;
        lcrom=_lcrom;
        tam_pob=_tam_pob;
        num_max_gen=_num_max_gen;
        precision=_precision;
        prob_cruce=_prob_cruce;
        Pob = new TIndividuo [tam_pob];
        rnd = new Random();
        for (int i = 0; i < tam_pob; i++) 
            Pob[i]=new TIndividuo(lcrom, precision);
        
    }
    public void run() {
        log.writePoblacionResumeHeader();
        log.writePoblacionHeader(0, "Poblacion");
        log.writePoblacionHeader(0, "Seleccion");
        evaluacion(0);
        for (int generacion = 0; generacion < num_max_gen; generacion++){
            log.writePoblacionResume(Pob, pos_mejor);
            seleccion(generacion);
            reproduccion();
            mutacion();
            evaluacion(generacion);
        }
    }
    

    
    private void evaluacion(int generacion) {
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
            Pob[i].SetPuntuacionAcumulada(Pob[i].GetPuntuacion() + punt_acu);
            punt_acu += Pob[i].GetPuntuacion();
            log.writeIndividuo(Pob[i], i, "Poblacion");
        }
        log.writePoblacionEnd(generacion, "Poblacion");
    }
    
    private void seleccion (int generacion) {
        int [] sel_super = new int[tam_pob];
        float prob;
        int pos_super;
        int i;
        //Ruleta
        for (i=0; i<tam_pob; i++) {
            prob=rnd.nextFloat();
            pos_super=0;
            while ((prob > Pob[pos_super].GetPuntuacionAcumulada()) && (pos_super < tam_pob - 1)) {
                pos_super++;
            }
            sel_super[i] = pos_super;
        }
        //Poblacion auxiliar 
        TIndividuo[] PobAux=new TIndividuo[tam_pob];
        for (i=0; i < tam_pob; i++) {
            //indiv = Pob[sel_super[i]];
            //System.arraycopy(Pob, sel_super[i], PobAux, i, 1);
            PobAux[i] = Pob[sel_super[i]];
            log.writeIndividuo(PobAux[i], sel_super[i], "Seleccion");
        }
        for (i=0; i< tam_pob; i++) {
            Pob[i] = PobAux[i];
        }
        log.writePoblacionEnd(generacion, "Seleccion");
    }
    
    private void reproduccion() {
        int sel_cruce[] = new int[tam_pob];
        int num_sel_cruce=0;
        float prob;
        int punto_cruce;
        TIndividuo hijo1 ;
        TIndividuo hijo2 ;
        int i;
        for (i = 0; i<tam_pob; i++) {
            prob=rnd.nextFloat();
            if (prob < prob_cruce) {
                sel_cruce[num_sel_cruce] = i;
                num_sel_cruce++;
            }
        }
        
        if ((num_sel_cruce % 2) == 1)
            num_sel_cruce--;
        punto_cruce=rnd.nextInt(lcrom);
        for (i = 0; i<num_sel_cruce; i++) {
            hijo1 = new TIndividuo(Pob[sel_cruce[i]], Pob[sel_cruce[i+1]], lcrom, precision, punto_cruce);
            hijo2 = new TIndividuo(Pob[sel_cruce[i+1]], Pob[sel_cruce[i]], lcrom, precision, punto_cruce);
            Pob[sel_cruce[i]] = hijo1;
            Pob[sel_cruce[i+1]] = hijo2;
        }
    }
    private void mutacion() {
        for (int i=0; i< tam_pob; i++) 
            Pob[i].Mutar(prob_mut);
        
    }
    private EvolveLog log;
    private int tam_pob;
    private float precision;
    private int lcrom;
    private int pos_mejor;
    private int num_max_gen;
    private float sumadaptacion, prob_cruce, prob_mut;
    private TIndividuo[] Pob;
    private Random rnd;
}

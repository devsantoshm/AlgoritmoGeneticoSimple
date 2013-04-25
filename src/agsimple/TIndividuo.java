/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agsimple;

/**
 *
 * @author karl
 */
public class TIndividuo implements Cloneable {
    //TIndividuo es una clase final!!!
    public TIndividuo (int lcrom) {
        Cromosoma = new TCromosoma(lcrom);
        SetAdaptacion();
    }
    
    private void SetAdaptacion() {
        float f;
        x=Cromosoma.decod();
        //Aqui se coloca la funcion de adaptacion
        f=(x / (1 + (x*x)));
        adaptacion=f;
    } 
    
    public float GetAdaptacion(){
        return adaptacion;
    }
    public void SetPuntuacion(float _puntuacion) {
        puntuacion=_puntuacion;
    }
    public void SetPuntuacionAcumulada(float _punt_acu) {
        punt_acu=_punt_acu;
    }
    public float GetPuntuacion(){
        return puntuacion;
    }
    public float GetPuntuacionAcumulada() {
        return punt_acu;
    }
    private float x;
    private float adaptacion;
    private float puntuacion;
    private float punt_acu;
    private TCromosoma Cromosoma;
    private boolean[] cromosoma;
    
    

}

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
    public TIndividuo (int lcrom, float _precision) {
        precision=_precision;
        Cromosoma = new TCromosoma(lcrom);
        SetAdaptacion();
    }
    public TIndividuo (TIndividuo Padre, TIndividuo Madre, int lcrom, float _precision, int punto_cruce) {
        //Cromosoma = new TCro
        precision=_precision;
        Cromosoma = new TCromosoma(Padre.GetCromosoma(), Madre.GetCromosoma(), lcrom, punto_cruce);
        SetAdaptacion();
    }
    private void SetAdaptacion() {
        float f;
        //XXX Funcion de adaptacion, aqui esta el meollo del asunto, en esta funcion se calcula "que tan bueno es el individuo"
        x=Cromosoma.decod() * precision;
        //Aqui se coloca la funcion de adaptacion sugerida en el libro
        //f=(x / (1 + (x*x))); 
        //Esta es la funcion de adaptacion sugerida por mi: f(x) = -((x-5)(x-15))
        //f=-(x*x) + (20.0f*x) - 75.0f;
        //f(x) = -(x(x-25))
        //f=-x*x + 25*x;
        
        
        
        //f=(float) Math.sin(Math.PI);
        //f= (float) (2 + Math.sin(30.0*((double) x))); //-x*x + 25*x;
        f= (float) (2 + Math.sin((double)(x*Math.PI)/6.0)); //-x*x + 25*x;
        adaptacion=f;
    } 
    public float ValueCromosoma() {
        return x;
    }
    public String VerCromosoma() {
        return Cromosoma.RepresentacionBinaria();
    }
    public void Mutar(float prob_mutacion) {
        if (Cromosoma.mutar(prob_mutacion))
            SetAdaptacion();
    }
    public float GetAdaptacion(){
        return adaptacion;
    }
    public TCromosoma GetCromosoma () {
        return Cromosoma;
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
    private float precision;
    private float adaptacion;
    private float puntuacion;
    private float punt_acu;
    private TCromosoma Cromosoma;
    //private boolean[] cromosoma;
    
    

}

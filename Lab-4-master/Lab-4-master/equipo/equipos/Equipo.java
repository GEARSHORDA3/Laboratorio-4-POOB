import java.util.ArrayList;
import java.util.*;
import java.lang.Object;
public class Equipo{
    private ArrayList<Persona> personas;
    
    /**
     * Crea un equipo dado el nombre de sus miembros
     * @param nombres nombres de los miembros del equipo
     */    
    public Equipo(String [] nombres){
        personas= new ArrayList<Persona>();
        for (int i=0; i< nombres.length;i++){
            personas.add(new Persona(nombres[i]));
        }  
    }

    /**
     * Calcula el valor hora de un equipo
     */
    public int valorHora() throws EquipoExcepcion{
        int valor  = 0;
        if(personas.size()>0){
            for(Persona p: personas ){
                try{
                    valor += p.valorHora();   
                }
                catch(EquipoExcepcion e){
                    throw e;
                }
            }
            return valor;
        }
        else {
            throw new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);
        }                    
    }
    /**
     * Calcula el valor hora estimado de un equipo.
     * Más del 50% del equipo debe tener valores conocidos 
     * El valor de las personas a las que se desconoce su valor es el promedio entre el mínimo y el máximo de las conocidas
     * @return el valor hora del equipo
     * @throws EquipoException si no es posible calcular el valor o existe una persona desconocida
     */
    public int valorHoraEstimado() throws EquipoExcepcion{
        int mitadEquipo=0;
        int lenghtList= personas.size();
        ArrayList<Integer> equipoHoras = new ArrayList<Integer>();
        for (int i=0; i<personas.size(); i++){
            try{
            String a =(personas.get(i).getNombre());
            equipoHoras.add (personas.get(i).valorHora());
            mitadEquipo+=1;
            }catch (EquipoExcepcion e){
                if (e.toString() == "La persona no es conocida") throw new EquipoExcepcion(EquipoExcepcion.PERSONA_DESCONOCIDA);
            }
        }
        int porcentaje=(personas.size()*50)/100;
        if (mitadEquipo<=porcentaje) throw new EquipoExcepcion(EquipoExcepcion.VALOR_IMPOSIBLE);
        int max = Collections.max(equipoHoras);
        int min = Collections.min(equipoHoras);
        int promedio=(max+min)/2;
        for (int i=0; i<personas.size(); i++){
            try{
            personas.get(i).valorHora();
            }catch (EquipoExcepcion e){
                equipoHoras.add (promedio);
            }
        }
        int suma=0;
        for (int i=0; i<personas.size(); i++){
                suma+=equipoHoras.get(i);
        }
        return suma;
    }   
    
    /**
     * Calcula el valor hora estimado de un equipo.
     * El valor hora de los desconocidos es el valor de la primera persona conocida
     * El valor hora de los que no se conoce su valor es el valor de la última persona conocida
     * @return el valor hora del equipo
     * @throws EquipoException si no es posible calcular el valor 
     */
    public int valorHoraAsumido() throws EquipoExcepcion {
        int suma=0;
        int lenghtList= personas.size();
        ArrayList<Integer> equipoHoras = new ArrayList<Integer>();
        for (int i=0; i<personas.size(); i++){
            try {
            String a =(personas.get(i).getNombre());
            equipoHoras.add (personas.get(i).valorHora());
            } catch (EquipoExcepcion e){}
        }
        if (equipoHoras.size() == 0) throw new EquipoExcepcion(EquipoExcepcion.PERSONA_DESCONOCIDA);
        int primerValor=equipoHoras.get(0);int ultimoValor=equipoHoras.get(equipoHoras.size()-1);
        for (int i=0; i<personas.size(); i++){
            try {
            String a =(personas.get(i).getNombre());
            personas.get(i).valorHora();
            } catch (EquipoExcepcion e){ 
                String a =e.getMessage();
                if( a =="La persona no es conocida"){
                   equipoHoras.add(primerValor);}
                else if (a =="El valor no es conocido"){
                   equipoHoras.add(ultimoValor);}
            }
        }
        for (int i=0; i<personas.size(); i++){
            suma+=equipoHoras.get(i);}
        return suma;
    }   
    
    
    
}
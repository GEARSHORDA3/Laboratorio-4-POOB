package aplicacion; 
import excepcion.*;
import java.util.*;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.ArrayList;


/**
 * @version ECI 2019-1
 */

public class Seleccion{
    private LinkedList <Jugador> jugadores;

    public Seleccion(){
        jugadores = new LinkedList<Jugador>();
    }
    
    /**
     * Adiciona algunos jugadores
     */
    public void adicione(){
        Jugador ejemplos[] = {
            new Jugador("James David","Rodriguez Rubio", "181","Mediocampista",
            "Recibio en 2009, 2012 y 2014 el premio de jugador revelacion de la Primera Division de Argentina y en la Primeira Liga de Portugal"),        
            new Jugador("Radamel Falcao","Garcia Zarate", "177","Delantero",
            "(11º) mejor jugador del mundo, segun la votacion del FIFA Balon de Oro 2013"),                            
            new Jugador("David","Ospina Ramirez", "183","Arquero",
            "Jugador del partido contra Estados Unidos en la Copa America Centenario 2016"),   
        };
        for(Jugador informacion : ejemplos) {
            adicione(informacion);
        }
    }
    
   
    
    /**
     * Consulta la información de un jugador
     */
    public Jugador getInformacion(String nombres,String apellidos){
        Jugador c=null;
        for(int i=0;i<jugadores.size() && c == null;i++){
            if (jugadores.get(i).getNombres().compareToIgnoreCase(nombres)==0 &&
                   (jugadores.get(i).getApellidos().compareToIgnoreCase(apellidos)==0)){
                   c=jugadores.get(i);
                }
        }
        return c;
    }

    private void mostrarMensaje(String string)
    {
       Toolkit.getDefaultToolkit().beep();
       JOptionPane p = new JOptionPane(string);
       JFrame frame= new JFrame();
       frame.setContentPane(p);
       frame.setVisible(true);
       frame.pack();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       try{ 
           Thread.sleep(2000);
        } catch (InterruptedException e){}
       frame.setVisible(false);
    }
    
    /**
     * Adiciona un nuevo jugador
     */
    public void adicione(String nombres, String apellidos, String  estatura, String posicion,  String premios) throws SeleccionExcepcion{        
        if (apellidos.isEmpty()){ 
            // Toolkit.getDefaultToolkit().beep();
            // mostrarMensaje("No existe un edificio al cual"); 
            // System.out.println(222);
            throw new SeleccionExcepcion(SeleccionExcepcion.APELLIDO_DESCONOCIDO); 
        }
        else if (estatura.isEmpty()){
            throw new SeleccionExcepcion(SeleccionExcepcion.ESTATURA_DESCONOCIDA); 
        }
        else if (posicion.isEmpty()){
            throw new SeleccionExcepcion(SeleccionExcepcion.POSICION_VACIO); 
        }
        else{
            adicione(new Jugador(nombres, apellidos, estatura, posicion, premios));
        }
    }

    /**
     * Adiciona un nuevos jugadores
     */
    public void adicione(Jugador informacion){
        int i=0;
        while ((i<jugadores.size()) && (jugadores.get(i).getApellidos().compareToIgnoreCase(informacion.getApellidos())<0)){
            i++;
        }
        jugadores.add(i,informacion);
    }
    
    /**
     * Consulta las jugadores que inican con un prefijo
     * @param prefijo El prefijo a buscar
     * @return 
     */
    public ArrayList<Jugador> busque(String prefijo){
        ArrayList<Jugador> resultados=null;
        prefijo=prefijo.toUpperCase();
        for(int i=0;i<jugadores.size();i++){
            if(jugadores.get(i).getNombres().toUpperCase().startsWith(prefijo)){
               resultados.add(jugadores.get(i));
            }   
        }
        return resultados;
    }

    /**
     * Consulta el numero de jugadores
     * @return 
     */
    public int numeroJugadores(){
        return jugadores.size();
    }


    /**
     * Consulta todos los jugadores
     * @return 
     */
    public String toString(){
    StringBuffer allEntries=new StringBuffer();
        for(Jugador informacion : jugadores) {
            allEntries.append(informacion.toString().length()<=150? informacion: informacion.toString().substring(0,140)+"...");
            allEntries.append('\n');
            allEntries.append('\n');
        }
        return allEntries.toString();
    }
}

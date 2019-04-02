package aplicacion; 
 
/**
 * @version ECI 2019-1
 */

public class Jugador{
    private String nombres;
    private String apellidos;
    private Integer estatura;    
    private String posicion;
    private String premios;  

 
    public Jugador(String nombres, String apellidos,  String  estatura, String posicion,  String premios){
        this.nombres = nombres.trim();
        this.apellidos = apellidos.trim();
        try{
            this.estatura = Integer.parseInt(estatura.trim());
        } catch (NumberFormatException n){
            this.estatura = Integer.parseInt("976345");
        }
        this.posicion = posicion.trim();
        this.premios = premios.trim();        
    }
    
    /**
     * @return 
     */
    public String getNombres(){
        return nombres;
    }

    /**
     * @return 
     */
    public String getApellidos(){
        return apellidos;
    }

    /**
     * @return 
     */
    public Integer getEstatura(){
        return estatura;
    }    

    /**
     * @return 
     */
    public String getPosicion(){
        return posicion;
    }
    
    /**
     * @return 
     */
    public String getPremios(){
        return premios;
    }
    
    /**
     * @return 
     */
    public String toString(){
        return nombres +" "+apellidos+ " (" + posicion + ")" + "\n" + estatura + "\n" + premios  ;
    }
    
    /**
     * Revisa que el objeto actual sea diferente al nuevo
     * @ param objeto a comparar
     * @ return si es o no igual
     */
    public boolean equal(Jugador m) {
    	if(nombres.equals(m.getNombres()) &&
    		apellidos.equals(m.getApellidos()) && 
    		estatura.equals(m.getEstatura()) &&
    		posicion.equals(m.getPosicion()) &&
    		premios.equals(m.getPremios())){
            return true;
        }
        else return false;
     }
}

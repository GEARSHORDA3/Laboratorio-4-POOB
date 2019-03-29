package excepcion;



public class SeleccionExcepcion extends Exception{

    public static final String  APELLIDO_DESCONOCIDO= "El jugador debe tener un apellido";
    public static final String  ESTATURA_DESCONOCIDA="El jugador debe tener una estatura";
    public static final String  POSICION_VACIO="El jugador debe tener una posicion";
    
    public SeleccionExcepcion(String message){
        super(message);
    }

}
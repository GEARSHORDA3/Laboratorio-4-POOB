package excepcion;

public class SeleccionExcepcion extends Exception{

    public static final String  NOMBRE_APELLIDO_DESCONOCIDO= "El jugador debe tener un apellido y un nombre";
    public static final String  ESTATURA_DESCONOCIDA="El jugador debe tener una estatura";
    public static final String  POSICION_VACIO="El jugador debe tener una posicion";
    public static final String  JUGADOR_YA_EXISTE ="El jugador ya se agrego";
    public static final String  FORMATO_MAL_ESTATURA= "El jugador no puede debe tener una estatura como numero";
    public static final String  POSICION_INCORRECTA= "Posicion incorrecta";
    public static final String  ESTATURA_ALTA= "El jugador debe tener una estatura real";
    public SeleccionExcepcion(String message){
        super(message);
    }

}

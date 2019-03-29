package pruebas;

import java.lang.Object;
import registro.*;
import aplicacion.*;
import java.util.*;
import excepcion.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SeleccionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SeleccionTest
{
    /**
     * Default constructor for test class SeleccionTest
     */
    public SeleccionTest()
    {
    }

    @Test
    public void deberiaAdicionar() throws SeleccionExcepcion{
        Seleccion player = new Seleccion();
        int sizePlayers=player.numeroJugadores();
        player.adicione("Yerry","Mina","195","Defensa","Nominado al FIFA/FIFPro World XI 2018");
        int NewSizePlayers=player.numeroJugadores();
        assertTrue(sizePlayers+1== NewSizePlayers);
    }
    
    @Test
    public void deberiaListar() throws SeleccionExcepcion{
        Seleccion player = new Seleccion();
        String consulta = player.toString();
        player.adicione("Yerry","Mina","195","Defensa","Nominado al FIFA/FIFPro World XI 2018");
        assertTrue(player.toString()!=consulta);
    }
    
    @Test
    public void NoDeberiaAdicionarSinApellidos() throws SeleccionExcepcion{
        Seleccion player = new Seleccion();
        int sizePlayers=player.numeroJugadores();
        try {
            player.adicione("Yerry","","195","Defensa","Nominado al FIFA/FIFPro World XI 2018");
        }catch (SeleccionExcepcion e){
            assertTrue(sizePlayers==player.numeroJugadores());
        }
    }
    
    // @Test
    // public void deberia
}

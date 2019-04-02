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
    
    @Test
    public void NoDeberiaDejarAgregar() throws SeleccionExcepcion{
        Seleccion player = new Seleccion();
        int sizePlayers=player.numeroJugadores();    
        try{
            player.adicione("Yerry","Mina","195","otra cosa","Nominado al FIFA/FIFPro World XI 2018");
        } catch(SeleccionExcepcion e){
        assertTrue(sizePlayers==0);}
    }
    
    @Test
    public void DeberiaInformar() throws SeleccionExcepcion{
        Seleccion player = new Seleccion();
        player.adicione("Yerry","Mina","195","Defensa","Nominado al FIFA/FIFPro World XI 2018");
        Object c =player.getInformacion("Yerry","Mina");
        assertTrue(c!=null);
    }

    @Test
    public void NoDeberiaInformar() throws SeleccionExcepcion{
        Seleccion player = new Seleccion();
        player.adicione("Yerry","Mina","195","Defensa","Nominado al FIFA/FIFPro World XI 2018");
        Object c = player.getInformacion("","");
        assertTrue(c==null);
    }
    
    @Test
    public void NoDeberiaEncontrar() throws SeleccionExcepcion{
        Seleccion player = new Seleccion();
        player.adicione("Yerry","Mina","195","Defensa","Nominado al FIFA/FIFPro World XI 2018");
        ArrayList<Jugador> algo = new ArrayList<Jugador>();
        algo =player.busque("2r");
        assertTrue(algo.size()==0);
    }
    
    @Test
    public void DeberiaEncontrar() throws SeleccionExcepcion{
        Seleccion player = new Seleccion();
        player.adicione("Yerry","Mina","195","Defensa","Nominado al FIFA/FIFPro World XI 2018");
        ArrayList<Jugador> algo = new ArrayList<Jugador>();
        algo =player.busque("Y");
        assertTrue(algo.size()!=0);
    }    
    
    @Test
    public void DeberiaTenerJugadores() throws SeleccionExcepcion{
        Seleccion player = new Seleccion();
        player.adicione("Yerry","Mina","195","Defensa","Nominado al FIFA/FIFPro World XI 2018");
        assertTrue(player.numeroJugadores()!=0);
    }    
}

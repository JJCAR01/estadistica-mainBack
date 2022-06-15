package com.juan.estadistica.dominio.servicio.jugador;

import com.juan.estadistica.dominio.puerto.RepositorioJugador;
import com.juan.estadistica.dominio.puerto.RepositorioUsuario;
import com.juan.estadistica.dominio.servicio.Jugador.ServicioGuardarJugador;
import com.juan.estadistica.dominio.servicio.Jugador.ServicioModificarJugador;
import com.juan.estadistica.dominio.servicio.Usuario.ServicioModificarUsuario;
import com.juan.estadistica.dominio.testdatabuilder.JugadorTestDataBuilder;
import com.juan.estadistica.dominio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioModificarJugadorTest {

    @Test
    void verificarNoExistaJugador()
    {
        var jugador = new JugadorTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioJugador.class);
        var servicio = new ServicioModificarJugador(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("No existe el jugador con los datos ingresados",
                Assertions.assertThrows(IllegalStateException.class, () ->
                        servicio.ejecutar(jugador,1l)).getMessage());
    }

}

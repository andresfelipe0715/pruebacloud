package com.example.primer_parcial7.Data;
import com.example.primer_parcial7.models.Usuario;

import java.util.Date;

public class FactoryUsuarioTestData {

    public static Usuario mockUsuario() {
        Usuario user = new Usuario();
        user.setId(1L);
        user.setNombre("pepe");
        user.setApellidos("Rios");
        user.setFechaNacimiento(new Date(2004, 7, 14));
        user.setCorreo("pepe@gmail.com");
        user.setPassword("1234");
        user.setDireccion("kdx.010-310");
        user.setDocumento("1064836389");
        user.setTelefono("3144454761");

        return user;
    }
    public static Usuario mockUsuarioAct() {
        Usuario user = new Usuario();
        user.setId(1L);
        user.setNombre("Andres");
        user.setApellidos("meneses");
        user.setFechaNacimiento(new Date(2004, 7, 14));
        user.setCorreo("carlosandres@gmail.com");
        user.setPassword("1234578");
        user.setDireccion("kdx.010-310 tabachines");
        user.setDocumento("1064836389");
        user.setTelefono("3144454761");

        return user;
    }
}

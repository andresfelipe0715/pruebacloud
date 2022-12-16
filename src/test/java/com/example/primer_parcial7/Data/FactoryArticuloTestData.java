package com.example.primer_parcial7.Data;
import com.example.primer_parcial7.models.Articulo;

import java.util.Date;

public class FactoryArticuloTestData {
    public static Articulo mockArticulo() {
        Articulo articulo = new Articulo();
        articulo.setId(1L);
        articulo.setCodigo("H003");
        articulo.setNombre("Jabon");
        articulo.setDescripcion("Jabon azul");
        articulo.setFechaRegistro(new Date(2004, 7, 14));
        articulo.setCategoria(FactoryCategoriaTestData.mockCategoria());
        articulo.setUsuario(FactoryUsuarioTestData.mockUsuario());
        articulo.setStock(32);
        articulo.setPrecioCompra(1.200);
        articulo.setPrecioVenta(1.500);

        return articulo;
    }
    public static Articulo mockArticuloAct() {

        Articulo articulo = new Articulo();

        articulo.setId(1L);
        articulo.setCodigo("H003");
        articulo.setNombre("JEAN");
        articulo.setDescripcion("TALLA M");
        articulo.setFechaRegistro(new Date(2004, 7, 14));
        articulo.setCategoria(FactoryCategoriaTestData.mockCategoria());
        articulo.setUsuario(FactoryUsuarioTestData.mockUsuario());
        articulo.setStock(32);
        articulo.setPrecioCompra(1.200);
        articulo.setPrecioVenta(1.500);

        return articulo;
    }
}

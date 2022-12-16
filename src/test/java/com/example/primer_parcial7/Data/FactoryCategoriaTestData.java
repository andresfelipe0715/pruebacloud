package com.example.primer_parcial7.Data;
import com.example.primer_parcial7.models.Categoria;
public class FactoryCategoriaTestData {


    public static Categoria mockCategoria() {

        Categoria categoria = new Categoria();
        categoria.setId_cat(1l);
        categoria.setNombre("Aseo");
        categoria.setDescripcion("articulos para el aseo");

        return categoria;
    }
}

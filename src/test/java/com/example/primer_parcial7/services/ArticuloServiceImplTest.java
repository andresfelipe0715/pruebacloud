package com.example.primer_parcial7.services;
import com.example.primer_parcial7.Data.FactoryArticuloTestData;
import com.example.primer_parcial7.models.Articulo;
import com.example.primer_parcial7.models.Categoria;
import com.example.primer_parcial7.repository.ArticuloRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
class ArticuloServiceImplTest {
    @InjectMocks
    private  ArticuloServiceImpl articuloServiceImpl;
    @InjectMocks
    private Articulo articulo;
    @Mock
    private ArticuloRepository articuloRepository;
    @InjectMocks
    private Categoria categoria;


    @Test
    void listArticulos() {

//        Articulo articulo = new Articulo();
//        Categoria categoria = new Categoria();
//        categoria.setId_cat(1l);
//        categoria.setNombre("Comida");
//        categoria.setDescripcion("contiene 300g");
//        articulo.setId(1L);
//        articulo.setCodigo("H003");
//        articulo.setNombre("Arroz");
//        articulo.setDescripcion("contiene 300g");
//        articulo.setFechaRegistro(new Date(2015, 12, 8));
//        articulo.setCategoria(categoria);
//        articulo.setStock(50);
//        articulo.setPrecioCompra(2.800);
//        articulo.setPrecioVenta(3.500);
        Articulo articulo = FactoryArticuloTestData.mockArticulo();
        when(articuloRepository.findAll()).thenReturn(List.of(articulo));


        ResponseEntity<List<Articulo>> articulo1 = articuloServiceImpl.allArticles();

        Assertions.assertNotNull(articulo1);
    }
    @Test
    void findArticuloByCode() {
        //Given
        Articulo articulo = new Articulo();
        Categoria categoria = new Categoria();
        categoria.setId_cat(1l);
        categoria.setNombre("Comida");
        categoria.setDescripcion("granos y cereales");

        articulo.setId(1L);
        articulo.setCodigo("H003");
        articulo.setNombre("Arroz");
        articulo.setDescripcion("contiene 300g");
        articulo.setFechaRegistro(new Date(2015, 12, 8));
        articulo.setCategoria(categoria);

        articulo.setStock(50);
        articulo.setPrecioCompra(2.800);
        articulo.setPrecioVenta(3.500);

        when(articuloRepository.findByCodigo("H003")).thenReturn(Optional.of(articulo));
        ResponseEntity<Articulo> articulo1 = articuloServiceImpl.getArticleFindBycodigo("H003");

        Assertions.assertNotNull(articulo1);
    }
    @Test
    void articleByCodigoIsNotFound() {
        Articulo articulo = null;

        when(articuloRepository.findByCodigo("H003")).thenReturn(Optional.ofNullable(articulo));

        Articulo articulo1 = articuloServiceImpl.getArticleFindBycodigo("H003").getBody();

        Assertions.assertEquals(null, articulo1);

    }

    @Test
    void articuloNotFound() {
        Articulo articulo = null;

        when(articuloRepository.findAll()).thenReturn(Collections.emptyList());

        List<Articulo> articulo1 = articuloServiceImpl.allArticles().getBody();

        Assertions.assertEquals(null, articulo1);

    }


    @Test
    void crearArticuloTest() {
        //Given
        Articulo articulo = FactoryArticuloTestData.mockArticulo();
        given(articuloRepository.findByCodigo(articulo.getCodigo())).willReturn(Optional.of(articulo));
        given(articuloRepository.save(articulo)).willReturn(articulo);
        //When

        ResponseEntity<Articulo> articuloGuardado = articuloServiceImpl.createArticle(articulo);

        //Then
        Assertions.assertNotNull(articuloGuardado);
    }

    @Test
    void UpdateUnArticulo() {
        // Given
        Articulo articulo = FactoryArticuloTestData.mockArticulo();
        Articulo articuloAct = FactoryArticuloTestData.mockArticuloAct();
        given(articuloRepository.findByCodigo(anyString())).willReturn(Optional.of(articulo));
        given(articuloRepository.save(articuloAct)).willReturn(articuloAct);

        //when
        ResponseEntity<Articulo> articleSave = articuloServiceImpl.editArticle(articulo.getCodigo(), articuloAct);

        //Then
        Assertions.assertNotNull(articleSave);
    }

    @Test
    void seDebeEliminarUnArticulo() {
        //Given
        Articulo articulo = FactoryArticuloTestData.mockArticulo();

        given(articuloRepository.findByCodigo(anyString())).willReturn(null);

        //when
        articuloRepository.delete(articulo);
        Optional<Articulo> articleDelete = articuloRepository.findByCodigo(anyString());

        //Then
        assertThat(articleDelete).isNull();
    }

}
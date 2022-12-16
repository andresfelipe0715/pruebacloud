package com.example.primer_parcial7.services;
import com.example.primer_parcial7.Data.FactoryCategoriaTestData;
import com.example.primer_parcial7.models.Categoria;
import com.example.primer_parcial7.repository.CategoriaRepository;
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
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CategoriaServiceImplTest {

    @InjectMocks
    private CategoriaServiceImpl categoriaServiceImpl;

    @InjectMocks
    private Categoria categoria;

    @Mock
    private CategoriaRepository categoriaRepository;
    @Test
    void listCategorias() {

//       Categoria categoria = new Categoria();
//       categoria.setId_cat(1l);
//       categoria.setNombre("Comida");
//        categoria.setDescripcion("granos y cereales");
        Categoria categoria = FactoryCategoriaTestData.mockCategoria();

        when(categoriaRepository.findAll()).thenReturn(List.of(categoria));

        ResponseEntity<List<Categoria>> categoria1 = categoriaServiceImpl.allCategory();

        Assertions.assertNotNull(categoria1);
    }
    @Test
    void categoriaNotFound() {
        Categoria categoria = null;

        when(categoriaRepository.findAll()).thenReturn(Collections.emptyList());

        List<Categoria> categoria1 = categoriaServiceImpl.allCategory().getBody();

        Assertions.assertEquals(null, categoria1);

    }

    @Test
    void saveCategoria() {
        //Given
        Categoria categoria = FactoryCategoriaTestData.mockCategoria();

        given(categoriaRepository.findById(anyLong())).willReturn(Optional.of(categoria));

        given(categoriaRepository.save(categoria)).willReturn(categoria);
        //When

        ResponseEntity<Categoria> categorySave = categoriaServiceImpl.createCategory(categoria);

        //Then
        Assertions.assertNotNull(categorySave);
    }

}
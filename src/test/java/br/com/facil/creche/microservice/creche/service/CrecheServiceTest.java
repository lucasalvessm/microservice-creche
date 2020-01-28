package br.com.facil.creche.microservice.creche.service;


import br.com.facil.creche.microservice.creche.dto.CreateRequest;
import br.com.facil.creche.microservice.creche.dto.UpdateRequest;
import br.com.facil.creche.microservice.creche.po.Creche;
import br.com.facil.creche.microservice.creche.repository.CrecheRepository;
import br.com.facil.creche.microservice.creche.service.impl.CrecheServiceImpl;
import br.com.facil.creche.microservice.creche.util.ClassMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CrecheServiceTest {


    public Creche creche = Creche
            .builder()
            .id(1L)
            .activities("Swimming")
            .fantasyName("Easy Creche")
            .openingHours("09 until 19")
            .price(1250.0)
            .teachingMethod("Constructivist")
            .build();
    @Mock
    private CrecheRepository crecheRepository;

    @InjectMocks
    private CrecheService crecheService = new CrecheServiceImpl();

    @Test
    public void createSuccessfullyTest() {
        when(crecheRepository.save(any())).thenReturn(creche);

        var request = new CreateRequest();
        var crecheResponse = crecheService.create((CreateRequest) ClassMapper.copyProperties(request, creche));

        assertEquals(request.getActivities(), crecheResponse.getActivities());
        assertEquals(request.getFantasyName(), crecheResponse.getFantasyName());
        assertEquals(request.getOpeningHours(), crecheResponse.getOpeningHours());
        assertEquals(request.getPrice(), crecheResponse.getPrice());
        assertEquals(request.getTeachingMethod(), crecheResponse.getTeachingMethod());
    }

    @Test
    public void updateSuccessfullyTest() {
        when(crecheRepository.save(any())).thenReturn(creche);
        when(crecheRepository.existsById(creche.getId())).thenReturn(true);

        var request = new UpdateRequest();
        var crecheResponse = crecheService.update((UpdateRequest) ClassMapper.copyProperties(request, creche));

        assertEquals(request.getId(), crecheResponse.getId());
        assertEquals(request.getActivities(), crecheResponse.getActivities());
        assertEquals(request.getFantasyName(), crecheResponse.getFantasyName());
        assertEquals(request.getOpeningHours(), crecheResponse.getOpeningHours());
        assertEquals(request.getPrice(), crecheResponse.getPrice());
        assertEquals(request.getTeachingMethod(), crecheResponse.getTeachingMethod());
    }

    @Test
    public void resourceNotFoundOnUpdateTest() {
        var crecheToUpdate = (UpdateRequest) ClassMapper.copyProperties(new UpdateRequest(), this.creche);
        crecheToUpdate.setId(2L);
        when(crecheRepository.existsById(2L)).thenReturn(false);
        assertThrows(NoSuchElementException.class, () -> crecheService.update(crecheToUpdate), "Expect error because the resource was not found");
    }

    @Test
    public void listSuccessfullyTest() {
        when(crecheRepository.findAll()).thenReturn(Arrays.asList(creche, creche, creche));

        var crecheList = crecheService.listAll();

        assertEquals(3, crecheList.size());
        assertEquals(crecheList.get(0).getId(), creche.getId());
    }

    @Test
    public void getDetailSuccessfullyTest() {
        when(crecheRepository.findById(creche.getId())).thenReturn(Optional.of(creche));

        var crecheDetail = crecheService.getDetail(1L);

        assertEquals(creche.getId(), crecheDetail.getId());
    }

    @Test
    public void resourceNotFoundOnGetDetailTest() {
        when(crecheRepository.findById(creche.getId())).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> crecheService.getDetail(1L), "Expect error because the resource was not found");
    }

    @Test
    public void deleteSuccessfullyTest() {
        when(crecheRepository.existsById(creche.getId())).thenReturn(true);
        doNothing().when(crecheRepository).deleteById(creche.getId());
        crecheService.delete(1L);
        verify(crecheRepository, atLeastOnce()).deleteById(creche.getId());
    }

    @Test
    public void resourceNotFoundOnDeleteTest() {
        when(crecheRepository.existsById(creche.getId())).thenReturn(false);
        assertThrows(NoSuchElementException.class, () -> crecheService.delete(1L), "Expect error because the resource was not found");
    }

}

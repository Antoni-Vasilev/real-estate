package com.aacademy.realestate.service.impl;

import com.aacademy.realestate.exception.DuplicateRecordException;
import com.aacademy.realestate.exception.ResourceNotFoundException;
import com.aacademy.realestate.model.Floor;
import com.aacademy.realestate.repository.FloorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class FloorServiceTest {

    @Mock
    private FloorRepository floorRepository;

    @InjectMocks
    private FloorServiceImpl floorServiceImpl;

    @Test
    public void verifyFindAll() {
        when(floorRepository.findAll()).thenReturn(Collections.singletonList(Floor.builder().build()));
        floorServiceImpl.findAll();
        verify(floorRepository, times(1)).findAll();
    }

    @Test
    public void verifySave() {
        Floor floorSave = Floor.builder().build();
        when(floorRepository.save(any(Floor.class))).thenReturn(floorSave);
        floorServiceImpl.save(floorSave);
        verify(floorRepository, times(1)).save(floorSave);
    }

    @Test(expected = DuplicateRecordException.class)
    public void verifySaveDuplicateException() {
        when(floorRepository.save(any(Floor.class))).thenThrow(DataIntegrityViolationException.class);

        floorServiceImpl.save(Floor.builder().build());
    }

    @Test
    public void verifyFindByNumber() {
        when(floorRepository.findByNumber(any(Integer.class)))
                .thenReturn(Optional.of(Floor.builder().build()));

        floorServiceImpl.findByNumber(1);
        verify(floorRepository, times(1)).findByNumber(1);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void verifyFindByNumberException() {
        when(floorRepository.findByNumber(any(Integer.class)))
                .thenReturn(Optional.empty());

        floorServiceImpl.findByNumber(1);
    }

    @Test
    public void verifyFindById() {
        when(floorRepository.findById(any(Long.class)))
                .thenReturn(Optional.of(Floor.builder().build()));

        floorServiceImpl.findById(1L);
        verify(floorRepository, times(1)).findById(1L);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void verifyFindByIdException() {
        when(floorRepository.findById(any(Long.class)))
                .thenReturn(Optional.empty());

        floorServiceImpl.findById(1L);
    }

    @Test
    public void verifyDelete() {
        doNothing().when(floorRepository).deleteById(any(Long.class));

        floorServiceImpl.delete(1L);

        verify(floorRepository, times(1)).deleteById(1L);
    }
}

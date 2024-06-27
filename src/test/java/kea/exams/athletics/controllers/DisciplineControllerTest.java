package kea.exams.athletics.controllers;

import kea.exams.athletics.models.Discipline;
import kea.exams.athletics.services.DisciplineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DisciplineControllerTest {

    @InjectMocks
    DisciplineController disciplineController;

    @Mock
    DisciplineService disciplineService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllDisciplines() {
        Discipline discipline = new Discipline();
        when(disciplineService.findAllDisciplines()).thenReturn(Arrays.asList(discipline));

        List<Discipline> disciplines = disciplineController.getAllDisciplines();

        assertEquals(1, disciplines.size());
        verify(disciplineService, times(1)).findAllDisciplines();
    }

    @Test
    public void testGetDisciplineById() {
        Discipline discipline = new Discipline();
        when(disciplineService.findDisciplineById(1)).thenReturn(java.util.Optional.of(discipline));

        Discipline foundDiscipline = disciplineController.getDisciplineById(1);

        assertEquals(discipline, foundDiscipline);
        verify(disciplineService, times(1)).findDisciplineById(1);
    }

    @Test
    public void testCreateDiscipline() {
        Discipline discipline = new Discipline();
        when(disciplineService.saveDiscipline(any(Discipline.class))).thenReturn(discipline);

        Discipline createdDiscipline = disciplineController.createDiscipline(discipline);

        assertEquals(discipline, createdDiscipline);
        verify(disciplineService, times(1)).saveDiscipline(discipline);
    }

    @Test
    public void testUpdateDiscipline() {
        Discipline discipline = new Discipline();
        when(disciplineService.updateDiscipline(anyInt(), any(Discipline.class))).thenReturn(discipline);

        Discipline updatedDiscipline = disciplineController.updateDiscipline(1, discipline);

        assertEquals(discipline, updatedDiscipline);
        verify(disciplineService, times(1)).updateDiscipline(1, discipline);
    }

    @Test
    public void testDeleteDiscipline() {
        doNothing().when(disciplineService).deleteDiscipline(anyInt());

        disciplineController.deleteDiscipline(1);

        verify(disciplineService, times(1)).deleteDiscipline(1);
    }
}
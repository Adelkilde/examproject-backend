package kea.exams.athletics.controllers;

import kea.exams.athletics.models.Result;
import kea.exams.athletics.services.ResultService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ResultControllerTest {

    @InjectMocks
    ResultController resultController;

    @Mock
    ResultService resultService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllResults() {
        Result result = new Result();
        when(resultService.findAllResults()).thenReturn(Arrays.asList(result));

        List<Result> results = resultController.getAllResults();

        assertEquals(1, results.size());
        verify(resultService, times(1)).findAllResults();
    }

    @Test
    public void testGetByDiscipline() {
        Result result = new Result();
        when(resultService.findResultByDiscipline(1)).thenReturn(Arrays.asList(result));

        List<Result> results = resultController.getByDiscipline(1);

        assertEquals(1, results.size());
        verify(resultService, times(1)).findResultByDiscipline(1);
    }

    @Test
    public void testCreateResult() {
        Result result = new Result();
        when(resultService.saveResult(any(Result.class))).thenReturn(result);

        Result createdResult = resultController.create(result);

        assertEquals(result, createdResult);
        verify(resultService, times(1)).saveResult(result);
    }

    @Test
    public void testUpdateResult() {
        Result result = new Result();
        when(resultService.updateResult(anyInt(), any(Result.class))).thenReturn(result);

        Result updatedResult = resultController.update(1, result);

        assertEquals(result, updatedResult);
        verify(resultService, times(1)).updateResult(1, result);
    }

    @Test
    public void testDeleteResult() {
        doNothing().when(resultService).deleteResult(anyInt());

        ResponseEntity<String> response = resultController.delete(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(resultService, times(1)).deleteResult(1);
    }
}
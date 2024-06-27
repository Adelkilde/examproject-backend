package kea.exams.athletics.controllers;

import kea.exams.athletics.models.Participant;
import kea.exams.athletics.services.ParticipantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ParticipantControllerTest {

    @InjectMocks
    ParticipantController participantController;

    @Mock
    ParticipantService participantService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllParticipants() {
        Participant participant = new Participant();
        when(participantService.findAllParticipants()).thenReturn(Arrays.asList(participant));

        List<Participant> result = participantController.getAllParticipants();

        assertEquals(1, result.size());
        verify(participantService, times(1)).findAllParticipants();
    }

    @Test
    public void testGetParticipantById() {
        Participant participant = new Participant();
        when(participantService.findParticipantById(1)).thenReturn(Optional.of(participant));

        Participant result = participantController.getParticipantById(1);

        assertEquals(participant, result);
        verify(participantService, times(1)).findParticipantById(1);
    }

    @Test
    public void testGetParticipantByIdNotFound() {
        when(participantService.findParticipantById(1)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> participantController.getParticipantById(1));
        verify(participantService, times(1)).findParticipantById(1);
    }

    @Test
    public void testCreateParticipant() {
    Participant participant = new Participant();
    when(participantService.saveParticipant(any(Participant.class))).thenReturn(participant);

    Participant result = participantController.create(participant);

    assertEquals(participant, result);
    verify(participantService, times(1)).saveParticipant(participant);
    }

    @Test
    public void testUpdateParticipant() {
    Participant participant = new Participant();
    when(participantService.updateParticipant(anyInt(), any(Participant.class))).thenReturn(participant);

    Participant result = participantController.update(1, participant);

    assertEquals(participant, result);
    verify(participantService, times(1)).updateParticipant(1, participant);
    }

    @Test
    public void testDeleteParticipant() {
    doNothing().when(participantService).deleteParticipant(anyInt());

    ResponseEntity<String> result = participantController.delete(1);

    assertEquals(HttpStatus.OK, result.getStatusCode());
    verify(participantService, times(1)).deleteParticipant(1);
    }

    @Test
    public void testSearchParticipants() {
    Participant participant = new Participant();
    when(participantService.findParticipantsByName(anyString())).thenReturn(Arrays.asList(participant));

    List<Participant> result = participantController.search("test");

    assertEquals(1, result.size());
    verify(participantService, times(1)).findParticipantsByName("test");
    }
}
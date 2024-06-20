package kea.exams.athletics.services;

import kea.exams.athletics.models.Participant;
import kea.exams.athletics.repositories.ParticipantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public List<Participant> findAllParticipants() {
        return participantRepository.findAll();
    }

    public Optional<Participant> findParticipantById(int id) {
        return participantRepository.findById(id);
    }

    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public Participant updateParticipant(int id, Participant participantDetails) {
      Participant participant = participantRepository.findById(id)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Participant not found"));

        participant.setName(participantDetails.getName());
        participant.setDateOfBirth(participantDetails.getDateOfBirth());

        return participantRepository.save(participant);
    }

    public void deleteParticipant(int id) {
        Participant participant = participantRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Participant not found"));

        participantRepository.delete(participant);
    }

    public List<Participant> findParticipantsByName(String name) {
        return participantRepository.findByNameContainingIgnoreCase(name);
    }
}

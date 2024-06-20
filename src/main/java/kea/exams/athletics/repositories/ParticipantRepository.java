package kea.exams.athletics.repositories;

import kea.exams.athletics.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    List<Participant> findByNameContainingIgnoreCase(String name);
}

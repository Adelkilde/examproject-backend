package kea.exams.athletics.services;

import jakarta.annotation.PostConstruct;
import kea.exams.athletics.models.Discipline;
import kea.exams.athletics.repositories.DisciplineRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {

    private final DisciplineRepository disciplineRepository;

    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public List<Discipline> findAllDisciplines() {
        return disciplineRepository.findAll();
    }

    public Optional<Discipline> findDisciplineById(int id) {
        return disciplineRepository.findById(id);
    }

    public Discipline saveDiscipline(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    public Discipline updateDiscipline(int id, Discipline disciplineDetails) {
        Discipline discipline = disciplineRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Discipline not found"));

        discipline.setName(disciplineDetails.getName());

        return disciplineRepository.save(discipline);
    }

    public void deleteDiscipline(int id) {
        Discipline discipline = disciplineRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Discipline not found"));

        disciplineRepository.delete(discipline);
    }

}
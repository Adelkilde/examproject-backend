package kea.exams.athletics.services;

import kea.exams.athletics.models.Result;
import kea.exams.athletics.repositories.ResultRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<Result> findAllResults() {
        return resultRepository.findAll();
    }

    public List<Result> findResultByDiscipline(int disciplineId) {
        return resultRepository.findResultByDisciplineId(disciplineId);
    }

    public Result saveResult(Result result) {
        return resultRepository.save(result);
    }

    public Result updateResult(int id, Result resultDetails) {
        Result result = resultRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Result not found"));
        result.setParticipant(resultDetails.getParticipant());
        result.setDiscipline(resultDetails.getDiscipline());
        result.setResultValue(resultDetails.getResultValue());
        result.setDate(resultDetails.getDate());
        return resultRepository.save(result);
    }

    public void deleteResult(int id) {
        Result result = resultRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Result not found"));

        resultRepository.deleteById(result.getId());
    }
}

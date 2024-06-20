package kea.exams.athletics.controllers;

import kea.exams.athletics.models.Result;
import kea.exams.athletics.services.ResultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    public List<Result> getAllResults() {
        try {
            return resultService.findAllResults();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/discipline/{disciplineId}")
    public List<Result> getByDiscipline(@PathVariable int disciplineId) {
      try {
          return resultService.findResultByDiscipline(disciplineId);
     } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
     }
    }

    @PostMapping
    public Result create(@RequestBody Result result) {
        try {
            return resultService.saveResult(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable int id, @RequestBody Result result) {
        try {
            return resultService.updateResult(id, result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            resultService.deleteResult(id);
            return new ResponseEntity<>("Result has been deleted", HttpStatus.OK);
    } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
}

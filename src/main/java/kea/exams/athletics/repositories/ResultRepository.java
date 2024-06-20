package kea.exams.athletics.repositories;

import kea.exams.athletics.models.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer>{
    List<Result> findResultByDisciplineId(int disciplineId);
}

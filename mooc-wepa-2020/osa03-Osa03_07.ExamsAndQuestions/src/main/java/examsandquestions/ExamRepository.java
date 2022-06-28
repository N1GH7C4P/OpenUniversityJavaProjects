/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examsandquestions;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kimmo
 */

public interface ExamRepository extends JpaRepository<Exam, Long> {
    @EntityGraph(value ="Exam.questions")
    List<Exam> findAll();
}

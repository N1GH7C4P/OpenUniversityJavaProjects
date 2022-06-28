package examsandquestions;

import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExamController {
    
    @Autowired 
    private ExamRepository examRepository;
    
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/exams")
    public String listExams(Model model) {
        model.addAttribute("exams", examRepository.findAll(Sort.by("examDate").descending()));
        return "exams";
    }

    @GetMapping("/exams/{id}")
    public String viewExam(Model model, @PathVariable Long id) {
        
        Exam exam = examRepository.getOne(id);
        List<Question> questions = questionRepository.findAll();
        questions.removeAll(exam.getQuestions());
        model.addAttribute("exam", exam);
        model.addAttribute("questions", questions);
        
        return "exam";
    }

    @PostMapping("/exams")
    public String addExam(@RequestParam String subject,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate examDate) {
            Exam e = new Exam();
            e.setSubject(subject);
            e.setExamDate(examDate);
            examRepository.save(e);

        return "redirect:/exams";
    }

    @Transactional
    @PostMapping("/exams/{examId}/questions/{questionId}")
    public String addQuestionToExam(@PathVariable Long examId, @PathVariable Long questionId) {
        Exam e = examRepository.getOne(examId);
        Question q = questionRepository.getOne(questionId);
        e.getQuestions().add(q);
        return "redirect:/exams/" + examId;
    }
}

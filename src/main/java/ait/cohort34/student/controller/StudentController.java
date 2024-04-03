package ait.cohort34.student.controller;

import ait.cohort34.student.dto.ScoreDto;
import ait.cohort34.student.dto.StudentAddDto;
import ait.cohort34.student.dto.StudentDto;
import ait.cohort34.student.dto.StudentUpdateDto;
import ait.cohort34.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Boolean addStudent(@RequestBody StudentAddDto studentAddDto) {
        return studentService.addStudent(studentAddDto);
    }

    @GetMapping("/student/{studentId}")
    public StudentDto findStudent(@PathVariable("studentId") Integer id) {
        return studentService.findStudent(id);
    }

    @DeleteMapping("/student/{id}")
    public StudentDto removeStudent(@PathVariable Integer id) {
        return studentService.removeStudent(id);
    }

    @PutMapping("/student/{id}")
    public StudentAddDto updateStudent(@PathVariable Integer id, @RequestBody StudentUpdateDto studentUpdateDto) {
        return studentService.updateStudent(id, studentUpdateDto);
    }

    @PutMapping("/score/student/{id}")
    public Boolean addScore(@PathVariable Integer id, @RequestBody ScoreDto scoreDto) {
        return studentService.addScore(id, scoreDto);
    }

    @GetMapping("/score/student/{name}")
    public Iterable<StudentDto> findStudentByName(@PathVariable String name) {
        return studentService.findStudentByName(name);
    }

    @PostMapping("/quantity/students")
    public Long getStudentsNamesQuantity(@RequestBody Set<String> names) {
        return studentService.getStudentsNamesQuantity(names);
    }

    @GetMapping("/students/exam/{exam}/minscore/{minScore}")
    public Iterable<StudentDto> findStudentsByExamMinScore(@PathVariable String exam, @PathVariable Integer minScore) {
        return studentService.findStudentsByExamMinScore(exam, minScore);
    }
}

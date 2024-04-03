package ait.cohort34.student.service;

import ait.cohort34.student.dao.StudentRepository;
import ait.cohort34.student.dto.ScoreDto;
import ait.cohort34.student.dto.StudentAddDto;
import ait.cohort34.student.dto.StudentDto;
import ait.cohort34.student.dto.StudentUpdateDto;
import ait.cohort34.student.dto.exeptions.StudentNotFoundException;
import ait.cohort34.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Boolean addStudent(StudentAddDto studentAddDto) {
        if (studentRepository.findByIdc(studentAddDto.getId()).isPresent()) {
            return false;
        }
        Student student = new Student(studentAddDto.getId(), studentAddDto.getName(), studentAddDto.getPassword());
        studentRepository.save(student);
        return true;
    }

    @Override
    public StudentDto findStudent(Integer id) {
        Student student = studentRepository.findByIdc(id).orElseThrow(StudentNotFoundException::new);
        return new StudentDto(id, student.getName(), student.getScores());
    }

    @Override
    public StudentDto removeStudent(Integer id) {
        return null;
    }

    @Override
    public StudentAddDto updateStudent(Integer id, StudentUpdateDto studentUpdateDto) {
        return null;
    }

    @Override
    public Boolean addScore(Integer id, ScoreDto scoreDto) {
        return null;
    }

    @Override
    public Iterable<StudentDto> findStudentByName(String name) {
        return null;
    }

    @Override
    public Long getStudentsNamesQuantity(Set<String> names) {
        return (long) names.size();
    }

    @Override
    public Iterable<StudentDto> findStudentsByExamMinScore(String exam, Integer minScore) {
        return null;
    }
}

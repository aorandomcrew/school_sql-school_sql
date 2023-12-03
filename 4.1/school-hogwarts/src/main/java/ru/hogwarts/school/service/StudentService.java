package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.DataNotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    public StudentService(StudentRepository studentRepository, FacultyRepository facultyRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    public Student create(Student student) {
        logger.info("ivoked method create");
        return studentRepository.save(student);
    }


    public Student read(Long id) {
        logger.info("ivoked method read");
        return studentRepository.findById(id).orElseThrow(DataNotFoundException::new);
    }


    public Student update(Long id, Student student) {
        logger.info("ivoked method update");
        Student existStudent = studentRepository.findById(id).orElseThrow(DataNotFoundException::new);
        Optional.ofNullable(student.getName()).ifPresent(existStudent::setName);
        Optional.ofNullable(student.getAge()).ifPresent(existStudent::setAge);
        return studentRepository.save(existStudent);
    }

    public Student delete(Long id) {
        logger.info("ivoked method delete");
        Student existStudent = studentRepository.findById(id)
                .orElseThrow(DataNotFoundException::new);
        studentRepository.delete(existStudent);
        return existStudent;
    }

    public Collection<Student> getByAge(int age) {
        logger.info("ivoked method getByAge");
        return studentRepository.findAllByAge(age);
    }

    public Collection<Student> findByAgeBetween(int min, int max) {
        logger.info("ivoked method findByAgeBetween");
        return studentRepository.findAllByAgeBetween(min, max);
    }

    public Collection<Student> findByFacultyId(Long id) {
        logger.info("ivoked method findByFacultyId");
        return facultyRepository.findById(id)
                .map(Faculty::getStudent)
                .orElseThrow(DataNotFoundException::new);
    }

    public long count() {
        logger.info("ivoked method count");
        return studentRepository.count();
    }

    public double average() {
        logger.info("ivoked method average");
        return studentRepository.average();
    }

    public List<Student> lastFiveStudents(int quantity) {
        logger.info("ivoked method lastFiveStudents");
        return studentRepository.findLastFiveStudents(quantity);
    }
}

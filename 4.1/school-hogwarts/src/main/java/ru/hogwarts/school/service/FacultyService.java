package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.DataNotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;


@Service
public class FacultyService {

    private static final Logger logger = LoggerFactory.getLogger(FacultyService.class);

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public Faculty create(Faculty faculty) {
        logger.info("ivoked method create");
        return facultyRepository.save(faculty);
    }


    public Faculty read(Long id) {
        logger.info("ivoked method read");
        return facultyRepository.findById(id).orElseThrow(DataNotFoundException::new);
    }


    public Faculty update(Long id, Faculty faculty) {
        logger.info("ivoked method update");
        Faculty existingFaculty = facultyRepository.findById(id)
                .orElseThrow(DataNotFoundException::new);
        if (faculty.getName() != null) {
            existingFaculty.setName(faculty.getName());
        }
        if (faculty.getColor() != null) {
            existingFaculty.setColor(faculty.getColor());
        }
        return facultyRepository.save(existingFaculty);
    }

    public Faculty delete(Long id) {
        logger.info("ivoked method delete");
        Faculty existingFaculty = facultyRepository.findById(id)
                .orElseThrow(DataNotFoundException::new);
        facultyRepository.delete(existingFaculty);
        return existingFaculty;
    }

    public Collection<Faculty> getByColor(String color) {
        logger.info("ivoked method getByColor");
        return facultyRepository.findAllByColor(color);
    }

    public Collection<Faculty> getByColorOrNameIgnoreCase(String color, String name) {
        logger.info("ivoked method getByColorOrNameIgnoreCase");
        return facultyRepository.findAllByColorOrNameIgnoreCase(color, name);
    }

    public Faculty findByStudentId(Long id) {
        logger.info("ivoked method findByStudentId");
        return facultyRepository.findByStudent_Id(id).orElseThrow(DataNotFoundException::new);
    }
}

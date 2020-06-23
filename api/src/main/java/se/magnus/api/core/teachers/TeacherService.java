package se.magnus.api.core.teachers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface TeacherService {


    @GetMapping(value="/product/{productId}", produces = "application/json")
    Teacher getTeacher(@PathVariable int teacherId);

}

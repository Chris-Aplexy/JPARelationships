package com.rols.educ.Controller;

import com.rols.educ.Model.Course;
import com.rols.educ.Service.RolsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class RolsController {

    private final RolsServiceImpl rolsService;

    public RolsController(RolsServiceImpl rolsService) {
        this.rolsService = rolsService;
    }

    @PostMapping
    public ResponseEntity addCourse(@RequestBody Course course){
        return ResponseEntity.ok(rolsService.addCourse(course));
    }

    @GetMapping("/{id}")
    public ResponseEntity viewCourse(@PathVariable long id){
        return ResponseEntity.ok(rolsService.viewCourse(id));
    }

    @GetMapping
    public ResponseEntity viewAllCourses(){
        return ResponseEntity.ok(rolsService.viewAllCourses());
    }

    @PutMapping
    public ResponseEntity updateCourse(@RequestParam long id, @RequestBody Course course){
        return ResponseEntity.ok(rolsService.editCourse(id, course));
    }

    @DeleteMapping
    public ResponseEntity deleteCourse(@RequestParam long id){
        rolsService.deleteCourse(id);
        return ResponseEntity.ok(null);
    }
}

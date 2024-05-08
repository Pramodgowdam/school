package com.demo.school.controller;

import com.demo.school.request.StudentRequest;
import com.demo.school.response.StudentResponse;
import com.demo.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/school")
public class StudentController {

    @Autowired
    private SchoolService schoolService;



    @PostMapping("/students") // inserting
    public StudentResponse createStudent(@RequestBody StudentRequest studentRequest){
        return schoolService.addNewStudent(studentRequest);
    }
    @GetMapping("/students") //fetching
    public StudentResponse getStudent(@RequestParam(required = false) long id,
                                      @RequestParam(required = false) String name,
                                      @RequestParam(required = false) String standard) throws Exception {
        return schoolService.getStudents(id,name,standard);
    }
    @PutMapping("/students/{id}") // updating
    public StudentResponse updateStudent(@PathVariable Long  id, @RequestBody StudentRequest studentRequest) throws Exception {
        return schoolService.updateStudent(id,studentRequest);
    }
}

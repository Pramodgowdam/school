package com.demo.school.service;

import com.demo.school.request.StudentRequest;
import com.demo.school.response.StudentResponse;

public interface SchoolService {
    StudentResponse addNewStudent(StudentRequest studentRequest);

    StudentResponse getStudents(Long id, String name, String standard) throws Exception;

    StudentResponse updateStudent(Long id, StudentRequest studentRequest) throws Exception;
}

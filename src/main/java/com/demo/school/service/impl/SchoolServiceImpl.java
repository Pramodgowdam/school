package com.demo.school.service.impl;

import com.demo.school.request.StudentRequest;
import com.demo.school.response.StudentResponse;
import com.demo.school.respository.SchoolRepository;
import com.demo.school.respository.entity.School;
import com.demo.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;


    @Override
    public StudentResponse addNewStudent(StudentRequest studentRequest) {
        School school = createSchoolEntity(studentRequest);
        school  = schoolRepository.save(school);
        return createResponseEntity(school);
    }

    @Override
    public StudentResponse getStudents(Long id, String name, String standard) throws Exception {
        School school = null;
        if(null!=id){
            Optional<School> optionalSchool = schoolRepository.findById(id);
            school = optionalSchool.get();
        } else if(null!=name && !"".equalsIgnoreCase(name)) {
           school = schoolRepository.findByName(name);
        } else if(null!=name && !"".equalsIgnoreCase(name)) {
            school = schoolRepository.findByName(name);
        }else {
            throw new Exception("No matching criteria is given");
        }
        return createResponseEntity(school);
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) throws Exception {
        Optional<School> optionalSchool = schoolRepository.findById(id);
        if(optionalSchool.get() == null) {
            throw new Exception("Provided Student not found in our DB");
        }
        School school = createSchoolEntity(studentRequest);
        school.setId(id);
        school = schoolRepository.save(school);
        return createResponseEntity(school);
    }

    private StudentResponse createResponseEntity(School school) {
        if(school==null) return null;
        StudentResponse studentResponse  = new StudentResponse();
        studentResponse.setName(school.getName());
        studentResponse.setJoiningDate(school.getJoiningDate());
        studentResponse.setDateOfBirth(school.getDob());
        studentResponse.setStandard(school.getStandard());
        return studentResponse;
    }

    private School createSchoolEntity(StudentRequest studentRequest) {
        School school = new School();
        school.setStandard(studentRequest.getStandard());
        school.setDob(studentRequest.getDateOfBirth());
        school.setName(studentRequest.getName());
        school.setJoiningDate(studentRequest.getJoiningDate());
        return school;
    }


}

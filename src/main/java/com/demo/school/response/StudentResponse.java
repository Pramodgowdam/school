package com.demo.school.response;

import com.demo.school.request.StudentRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentResponse  extends StudentRequest {
    private Long id;
}

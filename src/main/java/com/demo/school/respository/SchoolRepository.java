package com.demo.school.respository;

import com.demo.school.respository.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    School findByName(String name);
    School findByStandard(int standard);


}
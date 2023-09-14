//class take request from controller (where user send request) and then transform into query and give to database

package com.example.first.repository;

import com.example.first.model.student;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MySqlRepository extends JpaRepository<student,Integer>{
    public List<student>findByName(String name);
    public List<student>findByNameLike(String name);

    @Query(value = "Select u From student u WHERE u.contact =:n",nativeQuery = true)
    public List<student>findBycontact(@Param("n") Integer name);


}

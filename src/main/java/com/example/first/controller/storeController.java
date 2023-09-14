package com.example.first.controller;

import com.example.first.model.student;
import com.example.first.repository.MySqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController

public class storeController {

    @Autowired
    MySqlRepository mySqlRepository;

    @GetMapping("/get-all-student")
    public List<student> getAllStudent(){
      return mySqlRepository.findAll();
    }
    @GetMapping("/get-student/{id}")
    public student getSingleStudent(@PathVariable("id") Integer id){
        return mySqlRepository.findById(id).get();
    }

    @GetMapping("/get-by-name")
    public ResponseEntity<List<student>> getbyname(@RequestParam String name) {
        return new ResponseEntity<List<student>>(mySqlRepository.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/name-start-with")
    public ResponseEntity<List<student>> namestartwith(@RequestParam String name) {
        return new ResponseEntity<List<student>>(mySqlRepository.findByNameLike(name), HttpStatus.OK);
    }

    @GetMapping("/contact")
    public ResponseEntity<List<student>> contact(@RequestParam Integer contact) {
        return new ResponseEntity<List<student>>(mySqlRepository.findBycontact(contact), HttpStatus.OK);
    }



    @DeleteMapping("/remove/{id}")
    public  boolean deleteRow(@PathVariable("id") Integer id){
        if(!mySqlRepository.findById(id).equals(Optional.empty())){
            mySqlRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @PutMapping("/update/{id}")
    public student updateStudent(@PathVariable("id") Integer id,
                                 @RequestBody Map<String,String> body){
        student curr = mySqlRepository.findById(id).get();
        curr.setName(body.get("name"));
        curr.setContact(Integer.parseInt(body.get("contact")));
        curr.setAddress(body.get("address"));
        mySqlRepository.save(curr);
        return curr;
    }
    @PostMapping("/add")
    public student create(@RequestBody Map<String,String>body){
        String name = body.get("name");
        Integer contact = Integer.parseInt(body.get("contact"));
        String address = body.get("address");
        student newstudent = new student(name,address,contact);
        return mySqlRepository.save(newstudent);
    }


}

package com.example.newton.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newton.model.Camera;
import com.example.newton.repository.CameraRepository;

@RestController
@RequestMapping("/camera")
public class CameraController {
    @Autowired
    private CameraRepository cameraRepository;

    @GetMapping("")
    public Iterable<Camera> getAll(){
        return cameraRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Camera> getById(@PathVariable int id){
        return cameraRepository.findById(id);
    }



    @GetMapping("/ip/{ipAddress}")
    public List<Camera> getByIpAddress(@PathVariable String ipAddress){
        return cameraRepository.findByIpAddress(ipAddress);
    }


    @GetMapping("/location/{location}")
    public List<Camera> getByLoacation(@PathVariable String location){
        return cameraRepository.findByLocationContaining(location);
    }



    



    @PostMapping("")
    public ResponseEntity<Camera> create(@RequestBody Camera camera){
        Camera newCamera = cameraRepository.save(camera);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCamera);
    }


    
}

package com.example.newton.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.newton.model.Camera;

public interface CameraRepository extends CrudRepository<Camera, Integer> {
    List<Camera> findByIpAddress(String ipAddress);
    List<Camera> findByLocationContaining(String location);
}

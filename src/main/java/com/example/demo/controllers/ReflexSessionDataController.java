package com.example.demo.controllers;

import com.example.demo.dto.ReflexSessionDataDTO;
import com.example.demo.services.ReflexSessionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reflexSessionData")
public class ReflexSessionDataController {

    @Autowired
    private ReflexSessionDataService reflexSessionDataService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ReflexSessionDataDTO>> getAllReflexSessionData() {
        List<ReflexSessionDataDTO> sessions = reflexSessionDataService.getAllReflexSessionData();
        return ResponseEntity.ok(sessions);
    }

    @PostMapping("/create")
    public ResponseEntity<ReflexSessionDataDTO> createReflexSessionData(@RequestBody ReflexSessionDataDTO reflexSessionDataDTO) {
        ReflexSessionDataDTO createdSession = reflexSessionDataService.createReflexSessionData(reflexSessionDataDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSession);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReflexSessionDataDTO> getReflexSessionDataById(@PathVariable int id) {
        ReflexSessionDataDTO sessionData = reflexSessionDataService.getReflexSessionDataById(id);
        return ResponseEntity.ok(sessionData);
    }

    @GetMapping("/getReflexSessionsByUserId/{userId}")
    public ResponseEntity<List<ReflexSessionDataDTO>> getReflexSessionsByUserId(@PathVariable int userId) {
        List<ReflexSessionDataDTO> sessionData = reflexSessionDataService.getReflexSessionsByUserId(userId);
        return ResponseEntity.ok(sessionData);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReflexSessionData(@PathVariable int id) {
        reflexSessionDataService.deleteReflexSessionData(id);
        return ResponseEntity.noContent().build();
    }
}

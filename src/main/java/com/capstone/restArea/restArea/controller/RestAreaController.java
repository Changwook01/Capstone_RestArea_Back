package com.capstone.restArea.restArea.controller;

import com.capstone.restArea.restArea.entity.RestArea;
import com.capstone.restArea.restArea.service.RestAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rest-areas")
public class RestAreaController {

    private final RestAreaService restAreaService;

    @Autowired
    public RestAreaController(RestAreaService restAreaService) {
        this.restAreaService = restAreaService;
    }

    @GetMapping
    public ResponseEntity<List<RestArea>> getAllRestAreas() {
        List<RestArea> restAreas = restAreaService.findAll();
        return ResponseEntity.ok(restAreas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestArea> getRestAreaById(@PathVariable Long id) {
        RestArea restArea = restAreaService.findById(id);
        return ResponseEntity.ok(restArea);
    }
}

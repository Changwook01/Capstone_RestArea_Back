package com.capstone.restArea.restArea.service;

import com.capstone.restArea.restArea.entity.RestArea;
import com.capstone.restArea.restArea.repository.RestAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RestAreaService {

    private final RestAreaRepository restAreaRepository;

    @Autowired
    public RestAreaService(RestAreaRepository restAreaRepository) {
        this.restAreaRepository = restAreaRepository;
    }

    public List<RestArea> findAll() {
        return restAreaRepository.findAll();
    }

    public RestArea findById(Long id) {
        return restAreaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid rest area Id:" + id));
    }
}

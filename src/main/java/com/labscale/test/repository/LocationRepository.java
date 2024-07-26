package com.labscale.test.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository {
    List<String> findLocalNamesByCoordinates(double latitude, double longitude);
}
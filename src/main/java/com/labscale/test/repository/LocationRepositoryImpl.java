package com.labscale.test.repository;

import com.labscale.test.dao.LocationDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LocationRepositoryImpl implements LocationRepository {
    private final LocationDAO locationDAO;

    @Override
    public List<String> findLocalNamesByCoordinates(double latitude, double longitude) {
        return locationDAO.findLocalNamesByCoordinates(latitude, longitude);
    }
}
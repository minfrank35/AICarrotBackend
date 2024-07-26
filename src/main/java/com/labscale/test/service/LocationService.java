package com.labscale.test.service;

import com.labscale.test.dto.res.LocationResDTO;
import com.labscale.test.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationResDTO getLocationData(double latitude, double longitude) {
        List<String> localNames = locationRepository.findLocalNamesByCoordinates(latitude, longitude);
        return new LocationResDTO(localNames);
    }
}
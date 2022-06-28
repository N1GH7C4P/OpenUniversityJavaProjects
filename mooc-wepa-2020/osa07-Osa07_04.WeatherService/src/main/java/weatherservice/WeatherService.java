/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author kimmo
 */
@Service
public class WeatherService {
    
    @Autowired
    private WeatherEntryRepository weatherEntryRepository;
    
    @Autowired
    private LocationRepository locationRepository;
    
    @Cacheable("locations")
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }
    
    @Cacheable("locations")
    public Location getLocationById(@PathVariable Long id) {
        return locationRepository.getOne(id);
    }

    @CacheEvict(cacheNames = "locations", allEntries=true)
    public void addLocation(Location loc) {
        locationRepository.save(loc);
    }
    
    @CacheEvict(cacheNames= "locations", allEntries=true)
    public void flushCaches() {
    }
    
}

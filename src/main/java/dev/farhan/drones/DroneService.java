package dev.farhan.drones;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DroneService {
    @Autowired
    private DroneRepository droneRepository;
    public List<Drone> allDrone() {
        System.out.println(droneRepository.findAll().toString());
        return droneRepository.findAll();
    }

    public Optional<Drone> singleDrone(ObjectId id) {
        return droneRepository.findById(id);
    }

    public Drone createDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    public Drone updateDrone(ObjectId id, Drone drone) {
        drone.setId(id);
        return droneRepository.save(drone);
    }

    public void deleteDrone(ObjectId id) {
        droneRepository.deleteById(id);
    }
}

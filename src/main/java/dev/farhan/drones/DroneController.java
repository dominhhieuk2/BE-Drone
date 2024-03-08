package dev.farhan.drones;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/drones")
public class DroneController {
    @Autowired
    private DroneService droneService;
    @GetMapping
    public ResponseEntity<List<Drone>> getAllDrones() {
        return new ResponseEntity<List<Drone>>(droneService.allDrone(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Drone>> getSingleDrone(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Drone>>(droneService.singleDrone(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Drone> createDrone(@RequestBody Drone drone) {
        Drone createdDrone = droneService.createDrone(drone);
        return new ResponseEntity<>(createdDrone, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drone> updateDrone(@PathVariable ObjectId id, @RequestBody Drone drone) {
        Drone updatedDrone = droneService.updateDrone(id, drone);
        return new ResponseEntity<>(updatedDrone, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrone(@PathVariable ObjectId id) {
        droneService.deleteDrone(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

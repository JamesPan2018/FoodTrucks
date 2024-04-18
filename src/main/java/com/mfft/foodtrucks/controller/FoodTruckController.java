package com.mfft.foodtrucks.controller;


import com.mfft.foodtrucks.model.FoodTruck;
import com.mfft.foodtrucks.service.FoodTruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/foodtrucks")
@CrossOrigin(origins = "http://localhost:3000")
public class FoodTruckController {

    private static final String INSERT_SUCCESSFULLY = "Food truck inserted successfully";
    private static final String INSERT_FAILED = "Failed to insert food truck";

    private static final String UPDATE_SUCCESSFULLY = "Food truck updated successfully";
    private static final String UPDATE_FAILED = "Failed to update food truck";

    private final FoodTruckService foodTruckService;

    @Autowired
    public FoodTruckController(FoodTruckService foodTruckService) {
        this.foodTruckService = foodTruckService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FoodTruck>> getAllFoodTrucks() {
        List<FoodTruck> foodTrucks = foodTruckService.getAllFoodTrucks();
        if (foodTrucks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(foodTrucks, HttpStatus.OK);
        }
    }

    @GetMapping("/getAll/paged")
    public ResponseEntity<List<FoodTruck>> getAllFoodTrucksPaged(@RequestParam int page, @RequestParam int size) {
        if (page < 1 || size < 0) {
            return new ResponseEntity<>(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
        }

        List<FoodTruck> foodTrucks = foodTruckService.getAllFoodTrucksPaged(page, size);
        if (foodTrucks == null || foodTrucks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(foodTrucks, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodTruck> getFoodTruckById(@PathVariable Long id) {
        FoodTruck foodTruck = foodTruckService.getFoodTruckById(id);
        if (foodTruck == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(foodTruck, HttpStatus.OK);
        }
    }

    @GetMapping("/filter/locationDescription")
    public ResponseEntity<List<FoodTruck>> getFoodTruckByLocationDescriptionKeyword(@RequestParam String keyword) {
        List<FoodTruck> foodTrucks = foodTruckService.getFoodTruckByLocationDescriptionKeyword(keyword);
        if (foodTrucks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(foodTrucks, HttpStatus.OK);
        }
    }

    @GetMapping("/filter/locationId")
    public ResponseEntity<List<FoodTruck>> getFoodTrucksByLocationId(@RequestParam String locationId) {
        List<FoodTruck> foodTrucks = foodTruckService.getFoodTrucksByLocationId(locationId);
        if (foodTrucks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(foodTrucks, HttpStatus.OK);
        }
    }

    @GetMapping("/filter/facilityType")
    public ResponseEntity<List<FoodTruck>> getFoodTrucksByFacilityType(@RequestParam String facilityType) {
        List<FoodTruck> foodTrucks = foodTruckService.getFoodTrucksByFacilityType(facilityType);
        if (foodTrucks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(foodTrucks, HttpStatus.OK);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insertFoodTruck(@RequestBody FoodTruck foodTruck) {
        try {
            foodTruckService.insertFoodTruck(foodTruck);
            return new ResponseEntity<>(INSERT_SUCCESSFULLY, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(INSERT_FAILED, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFoodTruck(@PathVariable Long id, @RequestBody FoodTruck foodTruck) {
        try {
            foodTruck.setId(id);
            foodTruckService.updateFoodTruck(foodTruck);
            return new ResponseEntity<>(UPDATE_SUCCESSFULLY, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(UPDATE_FAILED, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

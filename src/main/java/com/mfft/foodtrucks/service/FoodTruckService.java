package com.mfft.foodtrucks.service;

import com.mfft.foodtrucks.model.FoodTruck;

import java.util.List;

public interface FoodTruckService {
    void insertFoodTruck(FoodTruck foodTruck);
    void updateFoodTruck(FoodTruck foodTruck);
    List<FoodTruck> getAllFoodTrucks();
    FoodTruck getFoodTruckById(Long id);
    List<FoodTruck> getFoodTruckByLocationDescriptionKeyword(String keyword);
    List<FoodTruck> getFoodTrucksByLocationId(String location);
    List<FoodTruck> getFoodTrucksByFacilityType(String type);
    List<FoodTruck> getAllFoodTrucksPaged(int page, int size);
}

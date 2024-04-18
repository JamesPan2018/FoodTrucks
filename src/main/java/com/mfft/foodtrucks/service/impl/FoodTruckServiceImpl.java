package com.mfft.foodtrucks.service.impl;

import com.mfft.foodtrucks.mappers.FoodTruckMapper;
import com.mfft.foodtrucks.model.FoodTruck;
import com.mfft.foodtrucks.service.FoodTruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodTruckServiceImpl implements FoodTruckService {

    private final FoodTruckMapper foodTruckMapper;

    @Autowired
    public FoodTruckServiceImpl(FoodTruckMapper foodTruckMapper) {
        this.foodTruckMapper = foodTruckMapper;
    }

    @Override
    public List<FoodTruck> getAllFoodTrucks() {
        return foodTruckMapper.getAllFoodTrucks();
    }

    @Override
    public FoodTruck getFoodTruckById(Long id) {
        return foodTruckMapper.getFoodTruckById(id);
    }

    @Override
    public List<FoodTruck> getFoodTruckByLocationDescriptionKeyword(String keyword) {
        return foodTruckMapper.getFoodTruckByLocationDescriptionKeyword(keyword);
    }

    @Override
    public List<FoodTruck> getFoodTrucksByLocationId(String location) {
        return foodTruckMapper.getFoodTrucksByLocationId(location);
    }

    @Override
    public List<FoodTruck> getFoodTrucksByFacilityType(String type) {
        return foodTruckMapper.getFoodTrucksByFacilityType(type);
    }

    @Override
    public List<FoodTruck> getAllFoodTrucksPaged(int page, int size) {
        int offset = (page - 1) * size;
        return foodTruckMapper.getAllFoodTrucksPaged(offset, size);
    }

    @Override
    public void insertFoodTruck(FoodTruck foodTruck) {
        foodTruckMapper.insertFoodTruck(foodTruck);
    }

    @Override
    public void updateFoodTruck(FoodTruck foodTruck) {
        foodTruckMapper.updateFoodTruck(foodTruck);
    }

}

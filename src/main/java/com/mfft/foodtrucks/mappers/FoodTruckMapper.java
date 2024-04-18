package com.mfft.foodtrucks.mappers;

import com.mfft.foodtrucks.model.FoodTruck;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FoodTruckMapper {

    void insertFoodTruck(FoodTruck foodTruck);

    void updateFoodTruck(FoodTruck foodTruck);

    List<FoodTruck> getAllFoodTrucks();

    FoodTruck getFoodTruckById(Long id);

    List<FoodTruck> getFoodTruckByLocationDescriptionKeyword(@Param("keyword")String keyword);

    List<FoodTruck> getFoodTrucksByLocationId(@Param("locationId")String locationId);

    List<FoodTruck> getFoodTrucksByFacilityType(@Param("facilityType") String facilityType);

    List<FoodTruck> getAllFoodTrucksPaged(@Param("offset") int offset, @Param("limit") int limit);

}
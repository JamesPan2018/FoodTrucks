package com.mfft.foodtrucks.service.impl;

import com.mfft.foodtrucks.mappers.FoodTruckMapper;
import com.mfft.foodtrucks.model.FoodTruck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FoodTruckServiceImplTest {

    @Mock
    private FoodTruckMapper foodTruckMapper;

    @InjectMocks
    private FoodTruckServiceImpl foodTruckService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllFoodTrucks() {
        // Simulate a mapper to return data
        FoodTruck truck1 = generateFoodTruck();
        FoodTruck truck2 = generateFoodTruck();
        truck2.setLocationid("1569145");
//        FoodTruck truck2 = new FoodTruck("1569145", "Casita Vegana", "Truck", "7553000", "JOHN MUIR DR: LAKE MERCED BLVD to SKYLINE BLVD (200 - 699)", "Assessors Block 7283/Lot004", "7283004", "7283", "004", "21MFF-00105", "APPROVED", "Coffee: Vegan Pastries: Vegan Hot Dogs: Vegan Tamales: Te: Vegan Shakes", "5985417.15", "2091453.145", "37.72188970870838", "-122.4925212449949", "http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=21MFF-00105&ExportPDF=1&Filename=21MFF-00105_schedule.pdf", "", "", "11/05/2021 12:00:00 AM", "20211105", "0", "11/15/2022 12:00:00 AM", "(37.72188970870838 ,  -122.4925212449949)", "1", "8", "4", "64", "14");
        List<FoodTruck> mockTrucks = Arrays.asList(truck1, truck2);
        when(foodTruckMapper.getAllFoodTrucks()).thenReturn(mockTrucks);

        // Call the service method
        List<FoodTruck> result = foodTruckService.getAllFoodTrucks();

        // Verify that the mapper method was called.
        verify(foodTruckMapper, times(1)).getAllFoodTrucks();
        // Verify that the returned result is as expected
        assertEquals(2, result.size());
        assertEquals("1569152", result.get(0).getLocationid());
        assertEquals("1569145", result.get(1).getLocationid());
    }

    @Test
    public void testGetFoodTruckById() {
        // 模拟要查找的 FoodTruck 对象
        Long id = 1L;
        FoodTruck expectedFoodTruck = generateFoodTruck();
        expectedFoodTruck.setId(id);

        // 设置模拟方法调用的预期行为
        when(foodTruckMapper.getFoodTruckById(id)).thenReturn(expectedFoodTruck);

        // 调用 service 方法
        FoodTruck result = foodTruckService.getFoodTruckById(id);

        // 验证 mapper 方法是否被调用
        verify(foodTruckMapper, times(1)).getFoodTruckById(id);

        // 验证返回的结果是否符合预期
        assertEquals(id, result.getId());
        assertEquals("1569152", result.getLocationid());
        assertEquals("Truck", result.getFacilityType());
    }


    @Test
    public void testGetFoodTruckByLocationDescriptionKeyword() {
        // Simulate the keyword to be looked up and the corresponding FoodTruck list
        String keyword = "TREAT";
        FoodTruck truck1 = generateFoodTruck();
        FoodTruck truck2 = generateFoodTruck();
        truck2.setLocationid("1569153");
        truck2.setLocationDescription("TREAT AVE: MISTRAL ST to END: 650-699 BLOCK (630 - 699)");
        List<FoodTruck> expectedFoodTrucks = Arrays.asList(truck2);

        // Set the expected behavior of the simulated method call
        when(foodTruckMapper.getFoodTruckByLocationDescriptionKeyword(keyword)).thenReturn(expectedFoodTrucks);

        // Call the service method.
        List<FoodTruck> result = foodTruckService.getFoodTruckByLocationDescriptionKeyword(keyword);

        // Verify that the mapper method is called.
        verify(foodTruckMapper, times(1)).getFoodTruckByLocationDescriptionKeyword(keyword);

        // Verify that the returned result is as expected
        assertEquals(expectedFoodTrucks.size(), result.size());
        assertEquals("1569153", result.get(0).getLocationid());
        assertEquals("TREAT AVE: MISTRAL ST to END: 650-699 BLOCK (630 - 699)", result.get(0).getLocationDescription());
    }

    @Test
    public void testGetAllFoodTrucksPaged() {
        int page = 1;
        int size = 10;
        int offset = (page - 1) * size;

        // Simulate a list of FoodTrucks to look for
        FoodTruck truck1 = generateFoodTruck();
        FoodTruck truck2 = generateFoodTruck();
        truck2.setLocation("1569152");
        List<FoodTruck> expectedFoodTrucks = Arrays.asList(truck1, truck2);

        // Set the expected behavior of the simulated method call
        when(foodTruckMapper.getAllFoodTrucksPaged(offset, size)).thenReturn(expectedFoodTrucks);

        // Call the service method
        List<FoodTruck> result = foodTruckService.getAllFoodTrucksPaged(page, size);

        // Verify that the mapper method was called.
        verify(foodTruckMapper, times(1)).getAllFoodTrucksPaged(offset, size);

        // Verify that the returned result is as expected
        assertEquals(expectedFoodTrucks.size(), result.size());
        assertEquals(expectedFoodTrucks.get(0).getLocationid(), result.get(0).getLocationid());
        assertEquals(expectedFoodTrucks.get(1).getLocationid(), result.get(1).getLocationid());
    }

    @Test
    public void testInsertFoodTruck() {
        FoodTruck foodTruck = generateFoodTruck();
        // Call the service method
        foodTruckService.insertFoodTruck(foodTruck);
        // Verify that the mapper method has been called
        verify(foodTruckMapper, times(1)).insertFoodTruck(foodTruck);
    }

    private FoodTruck generateFoodTruck() {
        return new FoodTruck("1569152", "Datam SF LLC dba Anzu To You", "Truck", "12463000", "TAYLOR ST: BAY ST to NORTH POINT ST (2500 - 2599)", "2535 TAYLOR ST", "0029007", "0029", "007", "21MFF-00106", "APPROVED", "Asian Fusion - Japanese Sandwiches/Sliders/Misubi", "6008186.35457", "2121568.81783", "37.805885350100986", "-122.41594524663745", "http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=21MFF-00106&ExportPDF=1&Filename=21MFF-00106_schedule.pdf", "", "", "11/05/2021 12:00:00 AM", "20211105", "0", "11/15/2022 12:00:00 AM", "(37.805885350100986 , -122.41594524663745)", "5", "1", "10", "308", "23");
    }

}
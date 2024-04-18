package com.mfft.foodtrucks.init;


import com.mfft.foodtrucks.aop.LoggingAspect;
import com.mfft.foodtrucks.mappers.FoodTruckMapper;
import com.mfft.foodtrucks.model.FoodTruck;
import com.mfft.foodtrucks.service.FoodTruckService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


@Service
public class DataBaseInitializeService {

    private final Logger logger = LoggerFactory.getLogger(DataBaseInitializeService.class);

    private final String csvFilePath = "data/Mobile_Food_Facility_Permit.csv";

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.scriptPath}")
    private String scriptPath;

    private final FoodTruckService foodTruckService;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataBaseInitializeService(JdbcTemplate jdbcTemplate, FoodTruckService foodTruckService) {
        this.jdbcTemplate = jdbcTemplate;
        this.foodTruckService = foodTruckService;
    }

    @PostConstruct
    public void importDataFromCsv() {
        this.createTable();
        this.importData();
    }

    private void importData() {
        try {
            ClassPathResource resource = new ClassPathResource(csvFilePath);
            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Skip header line if needed
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 30) {
                    String locationid = parts[0].trim();
                    String applicant = parts[1].trim();
                    String facilityType = parts[2].trim();
                    String cnn = parts[3].trim();
                    String locationDescription = parts[4].trim();
                    String address = parts[5].trim();
                    String blocklot = parts[6].trim();
                    String block = parts[7].trim();
                    String lot = parts[8].trim();
                    String permit = parts[9].trim();
                    String status = parts[10].trim();
                    String foodItems = parts[11].trim();
                    String X = parts[12].trim();
                    String Y = parts[13].trim();
                    String latitude = parts[14].trim();
                    String longitude = parts[15].trim();
                    String schedule = parts[16].trim();
                    String dayshours = parts[17].trim();
                    String noiSent = parts[18].trim();
                    String approved = parts[19].trim();
                    String received = parts[20].trim();
                    String priorPermit = parts[21].trim();
                    String expirationDate = parts[22].trim();
                    String location = parts[23].trim() + "," + parts[24].trim();
                    String firePreventionDistricts = parts[25].trim();
                    String policeDistricts = parts[26].trim();
                    String supervisorDistricts = parts[27].trim();
                    String zipCodes = parts[28].trim();
                    String neighborhoods_old = parts[29].trim();

                    // Insert into database
                    FoodTruck foodTruck = new FoodTruck();
                    foodTruck.setLocationid(locationid);
                    foodTruck.setApplicant(applicant);
                    foodTruck.setFacilityType(facilityType);
                    foodTruck.setCnn(cnn);
                    foodTruck.setLocationDescription(locationDescription);
                    foodTruck.setAddress(address);
                    foodTruck.setBlocklot(blocklot);
                    foodTruck.setBlock(block);
                    foodTruck.setLot(lot);
                    foodTruck.setPermit(permit);
                    foodTruck.setStatus(status);
                    foodTruck.setFoodItems(foodItems);
                    foodTruck.setX(X);
                    foodTruck.setY(Y);
                    foodTruck.setLatitude(latitude);
                    foodTruck.setLongitude(longitude);
                    foodTruck.setSchedule(schedule);
                    foodTruck.setDayshours(dayshours);
                    foodTruck.setNoiSent(noiSent);
                    foodTruck.setApproved(approved);
                    foodTruck.setReceived(received);
                    foodTruck.setPriorPermit(expirationDate);
                    foodTruck.setExpirationDate(expirationDate);
                    foodTruck.setLocation(location);
                    foodTruck.setFirePreventionDistricts(firePreventionDistricts);
                    foodTruck.setPoliceDistricts(policeDistricts);
                    foodTruck.setSupervisorDistricts(supervisorDistricts);
                    foodTruck.setZipCodes(zipCodes);
                    foodTruck.setNeighborhoodsOld(neighborhoods_old);

                    foodTruckService.insertFoodTruck(foodTruck);
                }
            }
            reader.close();
        } catch (IOException e) {
            logger.error("Failed to insert FoodTruck into DB!");
            e.printStackTrace();
        }
    }

    private void createTable() {
        Connection connection = null;
        try {
            // 1. Establish a connection to the H2 database.
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            // 2. Execute the SQL commands in the SQL file.
            executeSqlScript(connection, scriptPath);
            logger.info("Table created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 3. Close the database connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Failed to create Table!");
                    e.printStackTrace();
                }
            }
        }
    }

    private void executeSqlScript(Connection connection, String scriptPath) throws SQLException {
        try (InputStream inputStream = DataBaseInitializeService.class.getResourceAsStream(scriptPath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            StringBuilder sqlBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sqlBuilder.append(line);
                sqlBuilder.append("\n");
            }

            String[] sqlCommands = sqlBuilder.toString().split(";");

            for (String sqlCommand : sqlCommands) {
                if (!sqlCommand.trim().isEmpty()) {
                    try (Statement statement = connection.createStatement()) {
                        statement.execute(sqlCommand);
                    }
                }
            }
            logger.info("Script execute successfully!");
        } catch (IOException e) {
            logger.error("Failed to execute SQL Script!");
            e.printStackTrace();
        }
    }
}

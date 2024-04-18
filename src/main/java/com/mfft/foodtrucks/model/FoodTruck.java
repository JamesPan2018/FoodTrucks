package com.mfft.foodtrucks.model;

public class FoodTruck {
    private Long id;      // unique id
    private String locationid;
    private String applicant;
    private String facilityType;
    private String cnn;
    private String locationDescription;
    private String address;
    private String blocklot;
    private String block;
    private String lot;
    private String permit;
    private String status;
    private String foodItems;
    private String X;
    private String Y;
    private String latitude;
    private String longitude;
    private String schedule;
    private String dayshours;
    private String noiSent;
    private String approved;
    private String received;
    private String priorPermit;
    private String expirationDate;
    private String location;
    private String firePreventionDistricts;
    private String policeDistricts;
    private String supervisorDistricts;
    private String zipCodes;
    private String neighborhoodsOld;

    public FoodTruck() {
    }

    public FoodTruck(String locationid, String applicant, String facilityType, String cnn, String locationDescription, String address, String blocklot, String block, String lot, String permit, String status, String foodItems, String x, String y, String latitude, String longitude, String schedule, String dayshours, String noiSent, String approved, String received, String priorPermit, String expirationDate, String location, String firePreventionDistricts, String policeDistricts, String supervisorDistricts, String zipCodes, String neighborhoodsOld) {
        this.locationid = locationid;
        this.applicant = applicant;
        this.facilityType = facilityType;
        this.cnn = cnn;
        this.locationDescription = locationDescription;
        this.address = address;
        this.blocklot = blocklot;
        this.block = block;
        this.lot = lot;
        this.permit = permit;
        this.status = status;
        this.foodItems = foodItems;
        X = x;
        Y = y;
        this.latitude = latitude;
        this.longitude = longitude;
        this.schedule = schedule;
        this.dayshours = dayshours;
        this.noiSent = noiSent;
        this.approved = approved;
        this.received = received;
        this.priorPermit = priorPermit;
        this.expirationDate = expirationDate;
        this.location = location;
        this.firePreventionDistricts = firePreventionDistricts;
        this.policeDistricts = policeDistricts;
        this.supervisorDistricts = supervisorDistricts;
        this.zipCodes = zipCodes;
        this.neighborhoodsOld = neighborhoodsOld;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getCnn() {
        return cnn;
    }

    public void setCnn(String cnn) {
        this.cnn = cnn;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBlocklot() {
        return blocklot;
    }

    public void setBlocklot(String blocklot) {
        this.blocklot = blocklot;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(String foodItems) {
        this.foodItems = foodItems;
    }

    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }

    public String getY() {
        return Y;
    }

    public void setY(String y) {
        Y = y;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDayshours() {
        return dayshours;
    }

    public void setDayshours(String dayshours) {
        this.dayshours = dayshours;
    }

    public String getNoiSent() {
        return noiSent;
    }

    public void setNoiSent(String noiSent) {
        this.noiSent = noiSent;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getPriorPermit() {
        return priorPermit;
    }

    public void setPriorPermit(String priorPermit) {
        this.priorPermit = priorPermit;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFirePreventionDistricts() {
        return firePreventionDistricts;
    }

    public void setFirePreventionDistricts(String firePreventionDistricts) {
        this.firePreventionDistricts = firePreventionDistricts;
    }

    public String getPoliceDistricts() {
        return policeDistricts;
    }

    public void setPoliceDistricts(String policeDistricts) {
        this.policeDistricts = policeDistricts;
    }

    public String getSupervisorDistricts() {
        return supervisorDistricts;
    }

    public void setSupervisorDistricts(String supervisorDistricts) {
        this.supervisorDistricts = supervisorDistricts;
    }

    public String getZipCodes() {
        return zipCodes;
    }

    public void setZipCodes(String zipCodes) {
        this.zipCodes = zipCodes;
    }

    public String getNeighborhoodsOld() {
        return neighborhoodsOld;
    }

    public void setNeighborhoodsOld(String neighborhoodsOld) {
        this.neighborhoodsOld = neighborhoodsOld;
    }

    @Override
    public String toString() {
        return "FoodTruck{" +
                "id=" + id +
                ", locationid='" + locationid + '\'' +
                ", applicant='" + applicant + '\'' +
                ", facilityType='" + facilityType + '\'' +
                ", cnn='" + cnn + '\'' +
                ", locationDescription='" + locationDescription + '\'' +
                ", address='" + address + '\'' +
                ", blocklot='" + blocklot + '\'' +
                ", block='" + block + '\'' +
                ", lot='" + lot + '\'' +
                ", permit='" + permit + '\'' +
                ", status='" + status + '\'' +
                ", foodItems='" + foodItems + '\'' +
                ", X='" + X + '\'' +
                ", Y='" + Y + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", schedule='" + schedule + '\'' +
                ", dayshours='" + dayshours + '\'' +
                ", noiSent='" + noiSent + '\'' +
                ", approved='" + approved + '\'' +
                ", received='" + received + '\'' +
                ", priorPermit='" + priorPermit + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", location='" + location + '\'' +
                ", firePreventionDistricts='" + firePreventionDistricts + '\'' +
                ", policeDistricts='" + policeDistricts + '\'' +
                ", supervisorDistricts='" + supervisorDistricts + '\'' +
                ", zipCodes='" + zipCodes + '\'' +
                ", neighborhoods_old='" + neighborhoodsOld + '\'' +
                '}';
    }
}

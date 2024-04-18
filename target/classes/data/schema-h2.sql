-- 创建 food_truck 表
CREATE TABLE IF NOT EXISTS food_truck
(
    id                      BIGINT AUTO_INCREMENT PRIMARY KEY,
    locationid              VARCHAR(255)  NOT NULL,
    applicant               VARCHAR(255)  NOT NULL,
    facilityType            VARCHAR(255)  NOT NULL,
    cnn                     VARCHAR(255)  NOT NULL,
    locationDescription     VARCHAR(255)  NOT NULL,
    address                 VARCHAR(255)  NOT NULL,
    blocklot                VARCHAR(255)  NOT NULL,
    block_value             VARCHAR(255),
    lot                     VARCHAR(255)  NOT NULL,
    permit                  VARCHAR(255)  NOT NULL,
    status_value            VARCHAR(255),
    foodItems               VARCHAR(1000) NOT NULL,
    X                       VARCHAR(255)  NOT NULL,
    Y                       VARCHAR(255)  NOT NULL,
    latitude                VARCHAR(255)  NOT NULL,
    longitude               VARCHAR(255)  NOT NULL,
    schedule_value          VARCHAR(255),
    dayshours               VARCHAR(255)  NOT NULL,
    noiSent                 VARCHAR(255)  NOT NULL,
    approved                VARCHAR(255)  NOT NULL,
    received                VARCHAR(255)  NOT NULL,
    priorPermit             VARCHAR(255)  NOT NULL,
    expirationDate          VARCHAR(255)  NOT NULL,
    location                VARCHAR(255)  NOT NULL,
    firePreventionDistricts VARCHAR(255)  NOT NULL,
    policeDistricts         VARCHAR(255)  NOT NULL,
    supervisorDistricts     VARCHAR(255)  NOT NULL,
    zipCodes                VARCHAR(255)  NOT NULL,
    neighborhoods_old       VARCHAR(255)
);
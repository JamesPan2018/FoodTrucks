# 用户指南


1.项目概述：
* Food Truck 数据管理系统是一个用于管理食品车辆信息的应用程序。
* 它提供了对食品车辆数据的搜索、筛选和管理功能，支持 RESTful API 和基本的用户认证。
* 因为时间关系，前端UI，CSS，数据分页， API Security还没有做， JUnit Test 也只是写了一部分。
* UI部分比较简陋，因此我提供了Postman的Request文件，可以对我所有的RESTful API进行调用测试，request文件我放在foodtrucks/postman目录下了。
* 为了避免Demo项目的额外配置时间，我使用了MyBatis+H2数据库的形式，可以在启动项目的时候自动load Mobile_Food_Facility_Permit.csv里面的数据并加载进入基于内存的H2数据库，方便测试。

2.安装和部署

    2.1 环境要求,确保系统中已安装以下软件和工具：
    Java 17 或更高版本
    Maven
    Node.js 和 npm（用于前端部分）

2.2 下载和运行
    
    启动应用 FoodtrucksApplication.java启动后端
    在foottrucks/fronted目录下使用cmd指令运行npm start启动前端，打开浏览器访问 http://localhost:3000 查看应用界面。
    注意，因为项目打包太大了，所以我暂时移除了foottruck


3. 功能和用法


    3.1 数据检索
    UI：目前只是提供了两个方法（getAllData,getTruckByLocationId），可以按照locationId进行搜索，也可以点击clear按钮重新调用getAllData方法
    RESTFUL API：
    
    3.3 RESTful API
    GET /foodtrucks: 获取所有食品车辆信息。
    GET /getAll/paged：获取所有食品车辆信息（分页）。
    GET /foodtrucks/{id}: 根据 ID 获取特定食品车辆信息。
    GET /filter/locationDescription： 根据 locationDescription 获取特定食品车辆信息。
    GET /filter/locationId：根据 locationId 获取特定食品车辆信息。
    GET /filter/facilityType：根据 facilityType 获取特定食品车辆信息。
    POST /insert: 添加新的食品车辆信息。
    PUT /{id}：根据 ID 更新特定食品车辆信息
   

   
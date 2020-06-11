# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.workforce.springboot-shift-belonger' is invalid and this project uses 'com.workforce.springbootshiftbelonger' instead.

# Getting Started


## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Gradle](https://gradle.org/)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.workforce.springbootshiftbelonger.SpringbootShiftBelongerApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
gradle bootRun
```


### Application boot up
1. For database schema and table creation, please run application with 
	spring.jpa.hibernate.ddl-auto=create
2. After, that please update the value accordingly. 



### Database relationship:
 There are three tables
 1. shift 
 	id-> primary key, auto incremented
 	code-> unique, not null

2. shift_group 
	id->primary key, auto incremented
	code-> unique, not null

3. shift_grouping
	id->primary key, auto incremented
	shift_code-> foreign key(shift.code)
	shift_group_code-> foreign key(shift_group.code)

Table shift code will have one to many relation with shift_grouping and vice versa(Many to One)
Table shift_group code will have one to many relation with shift_grouping and vice versa(Many to One)

Assumptions and Decision

	1. I have assumed the in shift_grouping table shift_code and shift_group_code may can contain same record as mentioned in the diagram.So, decided to to keep one occurrence.
	2. As the solution is related to check the shift belongs to group hence decided to keep Cacheable annotation. We can also implement Redis Cache for loading the data and search on those data for 
	huge number of records in short duration of time.
	 
	
	 

	


# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.workforce.springboot-shift-belonger' is invalid and this project uses 'com.workforce.springbootshiftbelonger' instead.

# Getting Started

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

Table shift code will have one to many relation with shift_grouping and vice versa(Many to one)
Table shift_group code will have one to many relation with shift_grouping and vice versa(Many to one)

Assumptions and Decision

	1. I have assumed the in shift_grouping table shift_code and shift_group_code may can contain same record as mentioned in the diagram.So, decided to to keep one occurrence.
	2. As the solution is related to check the shift belongs to group hence decided to keep Cacheable annotation. We can also implement Redis Cache for loading the data and search on those data for 
	huge number of records in short duration of time.
	 
	
	 

	


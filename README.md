# 311-Chicago-Incidents Complait Administration Application

Design and implementation of a database solution to manage “311 Incidents” data openly published by the city of Chicago, IL. 
Access to the database through a Web Application for the Residents of Chicago to report incidents that affect their every day life in the city. 
Reports are used by the city to offer recovery, sanitation.

# Functionalities available through the Web interface

1. Find the total requests per type that were created within a specified time range and sort them in a descending order.
2. Find the total requests per day for a specific request type and time range.
3. Find the most common service request per zipcode for a specific day.
4. Find the average completion time per service request for a specific date range.
5. Find the most common service request in a specified bounding box (as designated by GPS- coordinates) for a specific day.
6. Find the top-5 Special Service Areas (SSA) with regards to total number of requests per day for a specific date range.
7. Find the license plates (if any) that have been involved in abandoned vehicle complaints more
8. Find the second most common color of vehicles involved in abandoned vehicle complaints.
9. Find the rodent baiting requests where the number of premises baited is less than a specified number.
10. Same as the above (i.e., 9) for premises with garbage.
11. Same as the above (i.e., 10) for premises with rats.
12. Find the police districts that have handled “pot holes” requests with more than one number of potholes on the same day that they also handled “rodent baiting” requests with more than one number of premises baited, for a specific day.

New complaint report. Any type of new complaint request, can be inserted to the database, as well. 

# Implementation

Spring-Boot Framework, Java Persistence API (JPA), Hibernate, Gradle. PosgreSQL RDBMS 

# duple - DUPLicate Entity
Java utility that copies all data from one object to another using reflection. 
The "copy" action, si done based on the existing getters and setters. 
The source and destination classes, must have the same getters and the same setters for this to work.

In my projects, I always had to create a lot of DTO java classes(data transfer object) in order to transfer 
data from repository layer to the service one, and from this point to the web layer.

I know, there are many frameworks that are doing this (Dozer etc), but I wanted something quick, 
without any other xml configurations, and so on.

The current version is just a test, feel free to take the code and modify as you wish :-)

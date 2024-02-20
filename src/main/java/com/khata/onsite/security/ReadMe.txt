*************************************** BY MOHSIN For Next Implementation ***********************************************
1.	Add Spring boot security dependency in the POM.xml file.
2.	Create a User’s Entity and implements UserDetails interface provided by Spring Security.
3.	The UserDetails will force to implement few methods that can be accessed later.
4.	Create a complete user creation CRUD and in the service layer implement the UserDetailsService same like we implemented in Entity.
5.	Create JWT service to generate token and set the different parameters like expiry/creation etc.
6.	Create a Request filter in order to validate the authorization etc. 
7.	Create a Security configuration class to manage and register the security configurations.




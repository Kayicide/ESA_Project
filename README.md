# ESA_Project
## Setting Up
1. Create a Java DB Database with the details set up as:
    * Name: ESA
    * Username: ESA
    * Password: ESA
2. Run the SQL code found in the CreateTableStatement.txt file to setup the database
3. Run the project in netbeans.
4. Enjoy

## Creating an Admin Account
1. Register an Account on the website
2. Run this code inserting your accounts username:
```sql
UPDATE USER_INFO SET USER_INFO."ADMIN" = 'true' WHERE USER_INFO.USERNAME = '[Your Username]';
```


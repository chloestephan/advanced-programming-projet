# Project - Advanced programming

## Code repository

The code for the project is accessible [here](https://github.com/chloestephan/ST2APR_2023_Employees_JDBC_TODO).

## Hosted Site

You can access a hosted version of the project here [here](https://gift-advanced-programming-production.up.railway.app).

The site is redeployed every time the ```master``` branch is updated.


### Test credentials

- test / pass
- johnd / pass

## Features:

- JPA, Easy to change database without changing code.
- Authentication, passwords are encrypted using ```bcrypt```
- 30 mintue sessions after login
- REST endpoint: ```/api/interns```
- Server side data validation: ex => Internship form, refused if grades aren't between 0 and 20,...
- Search bar, looking for values in many different columns.
- Add, Remove and modify internships.
- Layout management: Views are modular (ex: header doesn't need to be declared in every view, only content)


## Architecture

- We used the MVC Pattern.
- Access to the database is separated into **Services**.
- **Controllers** have very little logic included, they just call *services* and return *views*
- *Views* take the data from *controllers* and displays it.
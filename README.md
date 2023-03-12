# Project - Advanced programming

## Code repository

The code for the project is accessible [here](https://github.com/chloestephan/ST2APR_2023_Employees_JDBC_TODO).


## Hosted Site

You can access a hosted version of the project [here](https://gift-advanced-programming-production.up.railway.app).


### Test credentials

- test / pass
- johnd / pass

### Run locally

To run the app locally you can run

```
docker compose up --build
```

You will then find the app at: http://localhost:8080

## Link to our video

You can access our video [here](https://www.youtube.com/watch?v=EB2WePUYHaw).

## Features: 
- JPA: Easy to change the database without having to change the code.
- Authentication, passwords are encrypted using ```bcrypt```, uses web sessions.
- REST endpoint: ```/api/interns```
- Server side data validation using Java Bean validators (JSR 380).
- Search bar: look for values in many different columns.
- Add, remove and modify internships.
- Layout management: Views are modular, (ex: header is only declared once, content is injected in a standard layout)
- Custom error handling, with custom error page

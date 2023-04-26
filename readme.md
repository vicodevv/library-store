# Library-store	
A spring boot web application for managing a small library. The application has a frontend interface and a backend (admin) interface. Library Managers can add books to the library's collection via the admin interface. Customers can browse for books, borrow and return the books via the frontend interface. They can see past books they have borrowed. When a book has exceeded it's rental period, an automatic mail is being triggered to remind the customer to return it.

## Technologies
- Spring Boot
- Angular
- MySQL

## Features
- Login/Register
- Admin Interface
- searching for books
- pagination
- book borrow system
- user list (activating/deactivating, deleting..)
- Create/Read/Delete operations for copies, books, authors and categories

## Security
Project provides authentication and authorization with JWT Spring Security.
There are parts of application available for not logged users, and parts that require specific
permissions.
> User types:
- not logged in
- unauthorized
- authorized
- admin

<img src="https://user-images.githubusercontent.com/55485439/234560693-0ddf3b27-7751-4a08-8f8f-ca7e6ae1d62b.png" width=700>

## preview
<img src="https://user-images.githubusercontent.com/55485439/234602249-c5487928-ebf4-42e7-96f8-19d4b7736886.png" width=800>
<img src="https://user-images.githubusercontent.com/55485439/234602467-0fb0c2a9-7027-450d-b57e-5bf77a401a32.png" width=800>
<img src="https://user-images.githubusercontent.com/55485439/234602575-31a9effe-4647-4582-8092-1397c6e846c4.png" width=800>
<img src="https://user-images.githubusercontent.com/55485439/234602745-62761b3b-31d1-461a-8575-b111095da769.png" width=800>
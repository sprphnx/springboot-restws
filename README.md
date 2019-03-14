## # RESTful WS (CRUD) Demo with the following features

1. Exception handling in REST
    ExceptionController to handle exceptions in a sigle controller
    Use of @ControllerAdvice and @ExceptionHandler
    Handling validation of data with javax.validation package.

2. Internationalization (I18N) support (demo greetings service switching response language to english, french and arabic according to the request header)
- 		Handling messages via different property files.
- 		Using the request header Accept-language parameter to pass the locale

3. HATEOAS demo in create user, by returning back the created user URI
- 		The create user scenario modified to return the URI of the created user.
4. XML and JSON support
- 		Support for XML and JSON in the same service for both request and response
- 		Key point is to add jackson-databind-xml dependancy.
5. Swagger - Documentation of the service. -- in progress

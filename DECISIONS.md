# Design Decision

Please note due to the time constraints of this project certain preferred design decisions will be made to cut corners in interest of time. All specific decisions will be noted here.

1. This repo will contain both the frontend and backend of our application. This is in the interest of ease, but it's noted typically, they would be separated out into spearate repos.
2. The JWT token authenticator has not been properly implemented.
3. Error handling needs to be properly implemented with custom errors for certain scenarios
4. Password handling has been implemented with plain Strings which should definitely not be the case
5. Validation on due date has not been implemented.
6. Unfortunately, I ran out of time to implement the front end and thus this is purely a backend project.

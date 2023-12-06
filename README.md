Start server with the command `./gradlew bootRun`

REST API endpoints:

Method | Endpoint | Body | Return | Note
--- | --- | --- | --- | ---
GET | /schedule/{employeeID} | | [{"date": *date*}, ...] | Returns the array of dates requested off and dates processed by management
POST | /schedule/day/add | {"date": *date*} | | Adds a requested day off
PUT | /schedule/day/status | {"date": *date*, "status": *status*} | | Changes the status of a day
DELETE | /schedule/delete | {"date": *date*} | | Deletes specified day
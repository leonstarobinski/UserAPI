# UserApplication

### _Endpoints are the following -_

**GET /users
Returns a list of all users.**

Request - No request parameters required.

Response - A JSON object containing an array of user objects.

Example response:

`[
{
"id": 1,
"firstName": "Leonid",
"lastName": "Starobinski",
"email": "8lsrage@gmail.com",
"password": "theBestPassword123!",
"birthday": "16.09.1994"
}
]`

**POST /save
Creates a new user.**

Request - A JSON object containing the user's information.

Example request:

`{
"firstName": "Leonid",
"lastName": "Starobinski",
"email": "8lsrage@gmail.com",
"password": "theBestPassword123!",
"birthday": "16.09.1994"
}`

**PUT /update/{id}
Updates an existing user with the specified ID.**

Request - A JSON object containing the updated user's information.

Example request:

`{
"firstName": "Leonid",
"lastName": "Starobinski",
"email": "8lsrage@gmail.com",
"password": "aNewPassword123!",
"birthday": "16.09.1994"
}`

**DELETE /delete/{id} Deletes the user with the specified ID.**

Request - No request parameters required.

Response - A JSON object containing a success message.

Example response:
`{
"message": "removed.."
}`



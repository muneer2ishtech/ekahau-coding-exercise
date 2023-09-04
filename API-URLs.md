# APIs

## APIs for Auth
 
<table>
<tr>
<td><b>Signin</b> - <code>HTTP POST</code></td>
<td><a href="http://localhost:8080/api/auth/signin">localhost:8080/api/auth/signin</a></td>
</tr>
<tr>
<td style="vertical-align:text-top">
Sample Request JSON

```json
{
    "username": "muneer2ishtech@gmail.com",
    "password": "Test1234"
}
```
</td>
<td style="vertical-align:text-top">
Sample Response JSON

```json
{
    "iss": "ekahau.ishtech.fi",
    "sub": "muneer2ishtech@gmail.com",
    "iat": 1693838542156,
    "exp": 1693840342156,
    "scopes": [
        "ROLE_USER"
    ],
    "token_type": "Bearer",
    "access_token": "eyJhbGciOiJIUzI1NiJ9"
}
```
</td>
</tr>
</table>
<br>
<br>
<br>
<table>
<tr>
<td><b>Signup</b> - <code>HTTP POST</code></td>
<td><a href="http://localhost:8080/api/auth/signup">localhost:8080/api/auth/signup</a></td>
</tr>
<tr>
<td style="vertical-align:text-top">
Sample Request JSON

```json
{
    "username": "muneer2ishtech@gmail.com",
    "password": "Test1234",
    "passwordRepeat": "Test1234",
    "firstName": "Muneer",
    "lastName": "Syed"
}
```
</td>
<td>
Http Response code is 201 - Created<br>
Response is <code>id</code> of the user signed up<br><br>
Http Reponse code - 400 - Bad Request if username / email already exists

</td>
</tr>
</table>
<br>
<br>
<br>
<table>
<tr>
<td><b>Update Password</b> - <code>HTTP PATCH</code></td>
<td><a href="http://localhost:8080/api/auth/update-password">localhost:8080/api/auth/update-password</a></td>
</tr>
<tr>
<td style="vertical-align:text-top">
Sample Request JSON

```json
{
    "oldPassword": "Test1234",
    "newPassword": "Test1235",
    "newPasswordRepeat": "Test1235"
}
```
</td>
<td>
Response is <code>BLANK</code> for HTTP 200
</td>
</tr>
</table>

## APIs for USER management

<table>
<tr>
<td><b>Get User Details</b> - <code>HTTP GET</code></td>
<td><a href="http://localhost:PORT/api/v1/users/{userId}">localhost:8080/api/v1/users/1</a></td>
</tr>
<tr>
<td>
Request Param: <code>userId</code><br><br>
If <code>userId</code> does not match with <code>user.id</code> in authentication context,<br>
then <code>403-Forbidden</code>error will be thrown.

</td>
<td style="vertical-align:text-top">
Sample Response JSON

```json
{
    "id": 1,
    "email": "muneer2ishtech@gmail.com",
    "firstName": "Muneer",
    "lastName": "Syed"
}
```
</td>
</tr>
</table>
<br>
<br>
<br>
<table>
<tr>
<td><b>Update User Details</b> - <code>HTTP PUT</code></td>
<td><a href="http://localhost:PORT/api/v1/users">localhost:8080/api/v1/users</a></td>
</tr>
<tr>
<td style="vertical-align:text-top">
Sample Request JSON

```json
{
    "id": 1,
    "firstName": "New Muneer",
    "lastName": "New Syed"
}
```

If <code>user.id</code> from request body does not match with <code>user.id</code> in authentication context,<br>
then <code>403-Forbidden</code> error will be thrown.<br><br>
email or password cannot be updated using this request

</td>
<td style="vertical-align:text-top">
Sample Response JSON

```json
{
    "id": 1,
    "firstName": "New Muneer",
    "lastName": "New Syed"
}
```
</td>
</tr>
</table>
<br>
<br>
<br>

## APIs for BOOK management

<table>
<tr>
<td><b>Create Book</b> - <code>HTTP POST</code></td>
<td><a href="http://localhost:PORT/api/v1/books">localhost:8080/api/v1/books</a></td>
</tr>
<tr>
<td style="vertical-align:text-top">
Sample Request JSON

```json
{
    "title" : "Postgre Fundamentals",
    "author" : "Ahmed",
    "year": 2022,
    "price": 12.34
}
```

</td>
<td>
Http Response code is 201 - Created<br>
Response is <code>id</code> of the book created<br><br>
Http Reponse code - 400 - Bad Request if Book name already exists
</td>
</tr>
</table>
<br>
<br>
<br>

# Ports

- Default port: 8080

### Additional Ports
- If application property `fi.istech.ekahau.additional-ports` or environment variable `FI_ISTECH_EKAHAU_ADDITIONAL-PORTS` is set to `true`


## 
###REST Principles
- based on JSON payload
- using http protocol
- 
###HTTP codes family
- 1xx - processing in progress
- 2xx - success
- 3xx - redirects
- 4xx - client's errors
- 5xx - server's errors

###Http exchange message consists of:
- request
  - url
  - headers
  - body
- response
  - status code
  - headers
  - body
  
###CRUD over Http (Create/Read/Update/Delete)
- read data
  - GET method
- create data
  - POST method
- delete data
  - DELETE method
- updated data
  - PUT method - for replacing data
  - PATCH method - for partial update

- urls - good practice(playing with person)
- we need to treat items like hierarchical collections
  - read
    - whole collections: /persons - with GET
    - one item: /persons/{id} - with GET, eg.persons/1
  - create
    - url: /persons - with POST
    - payload put inside request body
  - delete
    - url: /persons/{id} with DELETE eg. /persons/1
    - no content in request
  - update
    - url: /persons/{id} - with PUT, eg. /persons/1 - replace object
    - url: /persons/{id} - with PATCH, eg. /persons/1 - partial update
## TODO
### Product
    [X] - Create
    [X] - Get All
    [X] - Get 1
    [X] - Put
    [X] - Delete

### User
    [X] - Create
    [X] - Get All
    [X] - Get 1
    [X] - Put
    [X] - Delete
    [X] - Patch


## Remaining
    [ ] - Implement https

401 → missing/invalid/expired JWT
403 → authenticated user lacks required role or isn't the product owner
404 → user/product not found
400 → validation or malformed request body
409 → email already exists (registration conflict)

# README

- Before lunch

```
export JWT_SECRET="THIS_IS_A_VERY_LONG_SECRET_KEY_CHANGE_IT_123456789"
```

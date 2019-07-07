This is a simple application to connect to a database and read some data to json, as a tech challenge for my interview
with grand.digital.

This project comes with some scripts to handle database setup and teardown. Running `start.sh` will start a docker 
container with a mariadb database, initialize the schema, and populate it with data. Running `stop.sh` will tear it down.

To run the functions, pass the appropriate arguments to `./gradlew run`. For example:
`./gradlew run --args='android medium'` wil output:
```json
{
  "products": [
    {
      "title": "Halloween",
      "url": "/android/hdpi/halloween_hdpi.png"
    },
    {
      "title": "Jaws",
      "url": "/android/hdpi/jaws_hdpi.png"
    },
    {
      "title": "The Birds",
      "url": "/android/hdpi/the_birds_hdpi.png"
    }
  ]
}
```

and `./gradlew run --args='ios small 1963 1978'` outputs:
```json
{
  "products": [
    {
      "title": "The Birds",
      "year": 1963,
      "url": "/ios/1x/the_birds_1x.png"
    },
    {
      "title": "Jaws",
      "year": 1975,
      "url": "/ios/1x/jaws_1x.png"
    },
    {
      "title": "Halloween",
      "year": 1978,
      "url": "/ios/1x/halloween_1x.png"
    }
  ]
}
```

Valid values for the first argument (os) are:
- `android`
- `ios`

Valid values for the second argument (size) are:
- `small`
- `medium`
- `large`

Valid values for the third and fourth argument are integers, indicating dates.
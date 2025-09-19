Feature: Generate random number for user and pass

  Scenario:
    * def Random = Java.type('java.util.Random')
    * def randomGenerator = new Random()
    * def randomNumber = randomGenerator.nextInt(1000000000)
    * def username = (username) ? username : 'user' + randomNumber
    * def password = (password) ? password : 'pass' + randomNumber
    * print 'User to use ' + username
    * print 'Pass to use ' + password
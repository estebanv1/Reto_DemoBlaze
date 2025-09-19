Feature: Sign up and login on DemoBlaze store

  Background:

    * url 'https://api.demoblaze.com'
    * def loginRequest = read('classpath:json/LoginRequest.json')
    * def signUpRequest = read('classpath:json/SignUpRequest.json')

  @SuccessfulSignUp
  Scenario: Successful sign up on DemoBlaze

    * signUpRequest.username = username
    * signUpRequest.password = password

    Given path 'signup'
    And request signUpRequest
    When method post
    Then status 200
    And match response == '""\n'


  @FailedSignUp
  Scenario: Failed sign up in DemoBlaze by existing user

    * signUpRequest.username = username
    * signUpRequest.password = password

    Given path 'signup'
    And request signUpRequest
    When method post
    Then status 200
    And match response.errorMessage == "This user already exist."


  @SuccessfulLogin
  Scenario: Successful login on DemoBlaze

    * loginRequest.username = username
    * loginRequest.password = password

    Given path 'login'
    And request loginRequest
    When method post
    Then status 200
    And match response contains '"Auth_token:'


  @FailedLogin
  Scenario: Failed login in DemoBlaze by existing user

    * loginRequest.username = username
    * loginRequest.password = password + 'ab'

    Given path 'login'
    And request loginRequest
    When method post
    Then status 200
    And match response.errorMessage == "Wrong password."

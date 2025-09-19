function fn() {
    var username = karate.properties['username'] || ''
    var password = karate.properties['password'] || ''

    var config = {
      username: username,
      password: password
    }

    var helpers = karate.callSingle('classpath:demoblaze/helpers/generate_random.feature', config)

    config.username = helpers.username
    config.password = helpers.password

    return config;
}
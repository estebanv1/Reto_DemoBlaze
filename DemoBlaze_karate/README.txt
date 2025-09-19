# Reto karate
Reto de pruebas para API

### Postman

Se adjunta una colección de postman para pruebas manuales y familiarización con el servicio en la ruta `"Reto_DemoBlaze\DemoBlaze_karate\Documentos de pruebas"`.

### Escenarios de prueba

Se define un helper para generar un usuario y contraseña aleatorios, con el fin de tener un primer registro exitoso.
También es posible especificar un usuario y una contraseña, agregando en la ejecución las variables "-Dusername=usuario -Dpassword=contraseña", y no debe existir el usuario en el sitio.

Se definen los siguientes 4 escenarios de prueba:

- Successful sign up on DemoBlaze: Es el primer escenario en ejecutarse, genera un registro exitoso con el usuario y la contraseña definidos.
- Failed sign up in DemoBlaze by existing user: Este escenario intenta volver a registrar el usuario que se registró en el escenario anterior, por lo que debe generar una excepción.
- Successful login on DemoBlaze: Este escenario inicia sesión con el usuario y contraseña generados en el primer escenario.
- Failed login in DemoBlaze by existing user: Intento de inicio de sesión con el usuario creado en el primer escenario, pero con una contraseña diferente, por lo que debe fallar.

### Ejecución de pruebas

Es posible ejecutar las pruebas utilizando un IDE como Intellij con los plugins Gradle, Cucumber for Java y Karate, además de java 17, ejecutando la clase `src\test\java\demoblaze\store\StoreRunner.java`, o bien, desde el cmd ubicado en la raíz del proyecto con el comando `gradlew clean test --tests "demoblaze.store.StoreRunner --info"`.
El otro runner presente en el proyecto es para ejecutar múltiples features y generar el reporte en cucumber.

### Reportes

Los reportes se encuentran almacenados en las rutas `"Reto_DemoBlaze\DemoBlaze_karate\Documentos de pruebas\karate-reports\karate-report.html"` y `"Reto_DemoBlaze\DemoBlaze_karate\Documentos de pruebas\cucumber-html-reports\Cucumber-report.html"`.

### Conclusiones

Se genera el archivo de conclusiones en la ruta `"Reto_DemoBlaze\DemoBlaze_karate\Documentos de pruebas"`.


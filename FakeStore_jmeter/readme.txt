# Reto Jmeter
Reto de prueba de performance de API

### Archivos generados

ScriptFakeStoreApi.jmx - Script de jmeter para ejecutar la prueba
DatasetFakeStoreApi.csv - Dataset utilizado en la prueba (Debe estar en la misma carpeta, o indicarse específicamente su ubicación utilizando el parámetro datasetPath)
Bitácora de prueba de performance.docx - Bitácora con la información de la prueba ejecutada
testResults.csv - CSV resultante de la prueba ejecutada y documentada en la bitácora
ReporteJmeter.xlsx - Herramienta de apoyo generada para graficar los resultados en el csv
conclusiones.txt - Archivo de conclusiones del ejercicio

### Escenarios de prueba

Se definen un escenario de carga, de 15 minutos de duración, con 30 hilos y 21 tps promedio (Mayor información en la Bitácora)

### Ejecución de pruebas

Se genera el script 'ScriptFakeStoreApi.jmx' Es posible ejecutar las pruebas utilizando jmeter 5.6.3 y Java 17

### Reportes

Se genera la bitácora de performance condensando información relevante de la ejecución

### Conclusiones

Se genera el archivo de conclusiones llamado conclusiones.txt
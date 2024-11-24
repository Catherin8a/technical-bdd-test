# Proyecto de Automatización con Serenity BDD y Maven

Este proyecto utiliza **Serenity BDD** para la automatización de pruebas tanto en el front-end (usando la demo de Applitools) como en servicios REST (usando la API de [Reqres](https://reqres.in/api/)). Los escenarios de pruebas están escritos en **Gherkin** para facilitar la legibilidad y comprensión.

## Requisitos previos

1. **Java 17**
2. **Maven 3.8.1** instalado y configurado.
3. IDE compatible (IntelliJ IDEA).
4. Chrome instalado para correr las pruebas de front-end.
5. Conexión a internet para acceder a la demo de Applitools y la API de Reqres.

## Estructura del proyecto

El arquetipo del proyecto está construído de la siguiente forma:
```Gherkin
src
  + main
  + test
    + java                        Test runners and supporting code
    + resources
      + features                  Feature files
```

## Instalación y Ejecución

### Clonar el repositorio
```
git clone https://github.com/Catherin8a/technical-bdd-test.git
```
### Compilar el proyecto
```
$ mvn clean compile
```


### Ejecutar todas las pruebas

Para ejecutar todas las pruebas y generar el reporte con SerenityBDD, ejecute el siguiente comando:
```
$ mvn verify 
```

#language: es

Característica: Pruebas de API para creación y consulta de usuarios
  Como ingeniero de calidad
  Quiero probar la funcionalidad de creación y consulta de usuarios de la API
  Para asegurarme de que funciona correctamente

  Escenario: Crear un nuevo usuario
    Dado que tengo los siguientes datos de usuario:
      | name      | job                 |
      | Test User | Automation Engineer |
    Cuando envíe una solicitud POST al endpoint de usuarios
    Entonces el usuario debe ser creado
    Y el cuerpo de la respuesta debe contener un campo "id"

  Escenario: Consultar usuario creado y obtener sus detalles con éxito
    Dado que creé un usuario con los siguientes datos
      | name      | job                 |
      | Test User | Automation Engineer |
    Cuando obtenga el usuario creado mediante el id
    Entonces la respuesta debe ser exitosa
    Y el cuerpo de la respuesta debe contener los siguientes datos:
      | first_name | Test User           |
      | job        | Automation Engineer |

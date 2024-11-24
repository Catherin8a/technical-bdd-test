#language: es
Característica: Transacciones en Applitools
  Yo como usuario de Applitools
  Quiero iniciar sesión en el sitio web de Applitools
  Para conocer el estado de mis transacciones

  Antecedentes:
    Dado que el usuario navegó a la página de inicio de sesión de Applitools Demo

  Escenario: Verificar transacciones en Applitools
    Cuando ingrese las credenciales usuario: "testuser" y contraseña: "testpassword"
    Entonces iniciará sesión con éxito
    Y podrá ver 6 transacciones en la tabla de gastos
    Y los valores positivos deberán estar en verde
    Pero los valores negativos deberán estar en rojo
    Y el saldo total será de "$350"
    Y el crédito disponible será de "$17,800"

# pruebaOesia2017

Se plantea lo siguiente:

Necesitamos diseñar un sistema que registre eventos y que bajo ante ciertos casos lance otros. 
Los eventos, los sistemas de entrada/salida de eventos, la persistencia y la lógica sobre la que generar nuevos eventos son temas que pueden variar con el tiempo.
Inicialmente, para este ejercicio, recibiremos eventos de encendido y apagado de mecanismos por entrada estandar, se persistirán solo en memoria y enviaremos los eventos
generados a la salida estandar. Se generará un evento de "Alarma en dispositivo" cuando un mecanismo se apague indicando los segundos que estuvo encendido:

Por ejemplo, para la siguientes entradas: 
ON Device1
ON Device2
OFF Device1

Siendo cada línea un evento, la primera palabra de cada línea el tipo de evento y las siguientes palabras los parámetros.
Se producirá la siguiente salida:
ALARM Device1 12

El ejercicio platea una situación inicial ("Inicialmente ...") donde define como tratar la entrada, la salida y la persistencia, e indica que el diseño debe ser modificable (adaptable a nuevos sistemas de entrada, salida...). Se busca una arquitectura que defina componentes que sean fácilmente reemplazables por otros. Se busca diseñar un sistema que sea fácilmente modificable.

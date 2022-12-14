# Proyecto Tour Francia Implementando Clean Architecture

## Enunciado

Tenemos el siguiente escenario: uno de los eventos más importantes del ciclismo a nivel mundial es el Tour de Francia. Como parte del equipo de tecnología que apoya a la competición, se te ha encargado la tarea de desarrollar una aplicación o servicio que permita el registro de los equipos y sus respectivos ciclistas.

Como requerimientos del sistema, se establecen las siguientes reglas:
* Cada equipo debe tener como datos principales: nombre de equipo, un código abreviado único (alfanumérico, máximo 3 caracteres), y un país asociado
* Cada ciclista debe tener como datos principales: nombre completo, un número de competidor único (máximo 3 dígitos), estar asociado a un equipo y un país de procedencia (nacionalidad).
* Un equipo de ciclismo estará conformado por un máximo de 8 corredores.


## Antes de Iniciar

Empezaremos por explicar los diferentes componentes del proyectos y partiremos de los componentes externos, continuando con los componentes core de negocio (dominio) y por último el inicio y configuración de la aplicación.

Lee el artículo [Clean Architecture — Aislando los detalles](https://medium.com/bancolombia-tech/clean-architecture-aislando-los-detalles-4f9530f35d7a)

# Arquitectura

![Clean Architecture](https://miro.medium.com/max/1400/1*ZdlHz8B0-qu9Y-QO3AXR_w.png)

## Domain

Es el módulo más interno de la arquitectura, pertenece a la capa del dominio y encapsula la lógica y reglas del negocio mediante modelos y entidades del dominio.

## Usecases

Este módulo gradle perteneciente a la capa del dominio, implementa los casos de uso del sistema, define lógica de aplicación y reacciona a las invocaciones desde el módulo de entry points, orquestando los flujos hacia el módulo de entities.

## Infrastructure

### Helpers

En el apartado de helpers tendremos utilidades generales para los Driven Adapters y Entry Points.

Estas utilidades no están arraigadas a objetos concretos, se realiza el uso de generics para modelar comportamientos
genéricos de los diferentes objetos de persistencia que puedan existir, este tipo de implementaciones se realizan
basadas en el patrón de diseño [Unit of Work y Repository](https://medium.com/@krzychukosobudzki/repository-design-pattern-bc490b256006)

Estas clases no puede existir solas y debe heredarse su compartimiento en los **Driven Adapters**

### Driven Adapters

Los driven adapter representan implementaciones externas a nuestro sistema, como lo son conexiones a servicios rest,
soap, bases de datos, lectura de archivos planos, y en concreto cualquier origen y fuente de datos con la que debamos
interactuar.

### Entry Points

Los entry points representan los puntos de entrada de la aplicación o el inicio de los flujos de negocio.

## Application

Este módulo es el más externo de la arquitectura, es el encargado de ensamblar los distintos módulos, resolver las dependencias y crear los beans de los casos de use (UseCases) de forma automática, inyectando en éstos instancias concretas de las dependencias declaradas. Además inicia la aplicación (es el único módulo del proyecto donde encontraremos la función “public static void main(String[] args)”.

**Los beans de los casos de uso se disponibilizan automaticamente gracias a un '@ComponentScan' ubicado en esta capa.**

## postman consultation images
### Save Team
![](https://github.com/JohnEstebanAP/tour-francia-reactive/blob/main/images/save%20Team1.png?raw=true)

### Teams may only have a maximum of 8 cyclists
![](https://github.com/JohnEstebanAP/tour-francia-reactive/blob/main/images/save%20Team2.png?raw=true)

### The team id must have a maximum of 3 characters
![](https://github.com/JohnEstebanAP/tour-francia-reactive/blob/main/images/save%20cyclist4.png?raw=true)

### Save Cyclist
![](https://github.com/JohnEstebanAP/tour-francia-reactive/blob/main/images/save%20cyclist.png?raw=true)

### The Cyclist's unique id must be only 3 digits long.
![](https://github.com/JohnEstebanAP/tour-francia-reactive/blob/main/images/save%20cyclist2.png?raw=true)

### The Cyclist's unique id must be numeric only.
![](https://github.com/JohnEstebanAP/tour-francia-reactive/blob/main/images/save%20cyclist3.png?raw=true)

### Find All Cyclist
![](https://github.com/JohnEstebanAP/tour-francia-reactive/blob/main/images/find%20all%20cyclist.png?raw=true)


## Json file with Imsonia queries [clik](https://github.com/JohnEstebanAP/tour-francia-reactive/tree/main/query)

# Proyecto SalmonttApp (PRY2202 - Semana 3)

## Descripción

Este proyecto es la implementación base en Java para el nuevo sistema de gestión de personal de la empresa Salmontt. El sistema modela la estructura de las personas de la organización, aplicando principios clave de la Programación Orientada a Objetos (POO) como encapsulamiento, herencia y composición, para resolver la problemática de desorganización y duplicación de datos de la empresa.

## Estructura del Proyecto

El proyecto está organizado en dos paquetes principales:

* **`app`**: Contiene la clase `Main.java`. Esta clase es el punto de entrada de la aplicación y se utiliza para instanciar objetos y probar la funcionalidad del modelo.
* **`model`**: Contiene todas las clases que definen el dominio del negocio:
    * **`Direccion.java`**: Clase que representa una dirección. Es utilizada por `Persona` para demostrar **composición**.
    * **`Persona.java`**: Clase base que contiene atributos comunes (rut, nombre, apellido) y la relación de composición con `Direccion`.
    * **`Empleado.java`**: Clase que demuestra **herencia**, extendiendo de `Persona` y añadiendo atributos propios del empleado (idEmpleado, cargo).

## Instrucciones de Ejecución

1.  Clonar o descargar este repositorio.
2.  Abrir el proyecto en IntelliJ IDEA.
3.  Navegar al archivo `src/app/Main.java`.
4.  Hacer clic derecho sobre el archivo `Main.java` y seleccionar la opción **"Run 'Main.main()'"**.
5.  La salida de la prueba (creación de 3 objetos y actualización de uno) se mostrará en la consola de IntelliJ.

## Autor

* Giovanni Bencini

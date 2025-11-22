Proyecto SalmonttApp - Fase 2 (Semana 5)

Descripción del Proyecto

Este proyecto corresponde a la Evaluación Sumativa de la Semana 5 de la asignatura Desarrollo Orientado a Objetos I.

El sistema es una actualización profesional de la gestión de personal para la empresa Salmontt. En esta versión, se ha implementado una arquitectura modular robusta, persistencia de datos mediante lectura de archivos planos (CSV) y gestión eficiente de memoria utilizando Colecciones de Java (ArrayList).

El objetivo principal es demostrar competencias en:

Modularidad y encapsulamiento (Paquetes y visibilidad).

Uso de Colecciones para manejo dinámico de objetos.

Lectura de datos externos y manejo de excepciones (try-catch).

Estructura del Proyecto (Paquetes)

El código fuente se ha refactorizado bajo el dominio cl.duoc.salmontt para seguir estándares profesionales:

cl.duoc.salmontt.app

Contiene la clase Main.java. Es el punto de entrada del programa, encargado de orquestar la carga de datos y la interacción con el usuario (consola).

cl.duoc.salmontt.model

Contiene las clases de dominio del negocio: Empleado, Persona y Direccion.

Estas clases aplican principios de POO como Herencia, Composición y Encapsulamiento.

cl.duoc.salmontt.service

Contiene la clase SalmonttService. Actúa como una librería personalizada que encapsula la lógica de negocio.

Aquí se gestiona la lista de empleados (ArrayList) y la lectura del archivo empleados.csv.

cl.duoc.salmontt.util

Paquete reservado para validaciones y utilidades transversales del sistema.

Requisitos de Ejecución

Java JDK: Versión 11 o superior.

IDE: IntelliJ IDEA (Recomendado).

Archivo de Datos: El archivo empleados.csv debe estar ubicado estrictamente en la carpeta raíz del proyecto (al mismo nivel que la carpeta src).

Instrucciones de Instalación y Uso

Clonar o Descargar: Descarga el proyecto en tu equipo.

Verificar Archivo CSV: Asegúrate de que el archivo empleados.csv contenga datos válidos en el formato:
RUT,Nombre,Apellido,Calle,Numero,Ciudad,ID,Cargo

Ejecutar:

Abre el proyecto en IntelliJ IDEA.

Navega al paquete cl.duoc.salmontt.app.

Ejecuta la clase Main.

Resultados:

El sistema cargará automáticamente los datos del archivo.

Se mostrará el listado completo en la consola.

Se ejecutarán pruebas automáticas de filtros por cargo.

Autor

Nombre: Giovanni Bencini

Asignatura: Desarrollo Orientado a Objetos I (PRY2202)

Institución: Duoc UC

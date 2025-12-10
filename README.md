# Sistema de Gestión Salmontt - Versión 3.6 🐟

## 📖 Descripción del Proyecto
Aplicación de escritorio desarrollada en Java para la gestión de recursos de la empresa salmonera **Salmontt**.
Esta versión final (v3.6) integra una interfaz gráfica profesional con validaciones estrictas y una arquitectura robusta para gestionar personal interno y proveedores externos.

## 🛠 Características Técnicas (Semana 8)
El sistema cumple con todos los requerimientos de la evaluación y agrega mejoras de usabilidad:

- **Arquitectura MVC:** Código organizado modularmente en paquetes `model`, `data` y `ui`.
- **Polimorfismo e Interfaces:** Implementación de la interfaz `Registrable` para unificar el comportamiento de distintas entidades.
- **Lógica de Negocio:** Uso de `instanceof` en `GestorEntidades` para diferenciar y etiquetar automáticamente los registros en el reporte.
- **Interfaz Gráfica (GUI) Avanzada:**
    - Ventana principal moderna (`JFrame`) con diseño limpio (sin emojis para compatibilidad total).
    - **Formularios Responsivos:** Uso de `GridBagLayout` y barras de desplazamiento (`JScrollPane`) para asegurar la visualización en cualquier pantalla.
    - **Validación de Datos:**
        - RUT con verificación de formato chileno (Regex).
        - Campos obligatorios y numéricos validados.
    - **Manejo de Dirección Detallada:** Desglose de direcciones de proveedores en Calle, Número, Comuna y Región.
    - **Campos Opcionales:** Sección específica para ingresar información extra de productos.

## 📂 Estructura del Proyecto
- `src/model`: Clases de entidad (`Empleado`, `Proveedor`, `Direccion`) y Contrato (`Registrable`).
- `src/data`: Gestor de la colección polimórfica (`GestorEntidades`).
- `src/ui`: Interfaz gráfica de usuario (`MenuGUI`).
- `src/Main.java`: Punto de entrada de la aplicación.

## 🚀 Instrucciones de Ejecución
1. Abrir el proyecto en **IntelliJ IDEA**.
2. Navegar a `src/Main.java`.
3. Ejecutar el método `main` (Play).
4. Utilizar el menú visual para:
    - **Ingresar Personal:** Permite registrar empleados con cálculo automático de sueldo según cargo.
    - **Registrar Proveedor:** Formulario completo con dirección detallada y giro.
    - **Ver Reporte:** Genera un listado consolidado de todos los registros del sistema.

## 👤 Autor
Giovanni Bencini
*Desarrollo de Soluciones en Java - Duoc UC*
Sistema de Gestión de Librería

Este proyecto es una aplicación de consola desarrollada en Java para gestionar el inventario y las ventas de una librería. Implementa conceptos avanzados de Programación Orientada a Objetos (POO) como herencia, polimorfismo, abstracción y encapsulamiento, bajo los principios de Clean Code.

✨ Características Principales

Gestión de Catálogo: Soporta diferentes tipos de libros (TextBook y Novel).

Búsqueda Inteligente: Búsqueda por título o autor ignorando mayúsculas y tildes.

Transacciones Seguras: Validación de disponibilidad de stock antes de procesar ventas.

Historial de Clientes: Registro de los libros adquiridos por cada cliente.

Interfaz Interactiva: Menú CLI intuitivo con tablas formateadas y datos pre-cargados para pruebas.

📂 Estructura del Proyecto

Asegúrate de que tus archivos estén organizados exactamente de esta manera antes de compilar:

proyecto-libreria/
│
├── README.md
├── Memoria_Laboratorio_Final.md
└── src/
└── libreria/
├── Main.java
├── models/
│ ├── Author.java
│ ├── Book.java
│ ├── Client.java
│ ├── Novel.java
│ └── TextBook.java
└── services/
└── Bookstore.java

⚙️ Requisitos Previos (Prerequisites)

Para compilar y ejecutar este proyecto, necesitas tener instalado el Java Development Kit (JDK) versión 8 o superior (se recomienda JDK 17).

Comprobar instalación de Java

Abre tu terminal o consola de comandos y escribe:

java -version

Si ves un número de versión (ej. java 17.0.x), estás listo para continuar. Si dice "comando no encontrado", sigue los pasos de instalación de tu sistema operativo.

🚀 Instrucciones de Ejecución

El proceso de compilación y ejecución se realiza desde la carpeta src de tu proyecto. Elige tu sistema operativo:

🐧 Para Usuarios de Linux (Fedora / Ubuntu / Debian)

1. Instalar el JDK (Si no lo tienes):

En Fedora: sudo dnf install java-17-openjdk-devel

En Ubuntu/Debian: sudo apt install default-jdk

2. Compilar y Ejecutar:
   Abre la terminal y navega hasta la carpeta src de tu proyecto, luego ejecuta los siguientes comandos:

# Navegar a la carpeta fuente

cd ruta/hacia/tu/proyecto-libreria/src

# Compilar todo el proyecto

javac libreria/Main.java

# Ejecutar la aplicación

java libreria.Main

🪟 Para Usuarios de Windows

1. Instalar el JDK:
   Si no lo tienes, descarga e instala el JDK desde Adoptium (Eclipse Temurin) o desde la página oficial de Oracle. Asegúrate de marcar la opción "Add to PATH" durante la instalación.

2. Compilar y Ejecutar:
   Abre el Símbolo del Sistema (cmd) o PowerShell, navega hasta la carpeta src y ejecuta los comandos (nota el uso de la barra invertida \):

# Navegar a la carpeta fuente

cd ruta\hacia\tu\proyecto-libreria\src

# Compilar todo el proyecto

javac libreria\Main.java

# Ejecutar la aplicación

java libreria.Main

🛠️ Solución de Problemas Comunes

Error: java.lang.ClassNotFoundException: libreria.Main
Este error ocurre si intentas ejecutar el programa desde la carpeta raíz en lugar de la carpeta src, o si no has compilado el proyecto primero usando el comando javac.

Los acentos se ven mal en la consola (Windows):
Si ves símbolos extraños en lugar de tildes en la consola de Windows, ejecuta este comando antes de correr tu programa para cambiar la codificación a UTF-8:

chcp 65001

Desarrollado para el Laboratorio #1: Diseño e Implementación de Clases.

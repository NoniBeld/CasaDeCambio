🏠 CasaDeCambio - Proyecto en Java 17
CasaDeCambio es un programa de conversión de divisas. 
Utiliza la API de Frankfurter para obtener las tasas de cambio de las monedas y 
proporciona una interfaz gráfica simple mediante JOptionPane para interactuar con el usuario.

🚀 Características
Conversor de divisas (USD, EUR, MXN, etc.).

Soporte para más monedas a través de la API Frankfurter.

Historial de operaciones guardado en un archivo de texto con marca de tiempo.

Manejo de errores para entradas de monedas no válidas o fallos en la API.

Interfaz gráfica con JOptionPane para interacciones fáciles.

🔧 Tecnologías Usadas
Java 17 LTS: Lenguaje de programación utilizado.

JOptionPane: Para la interfaz gráfica.

Gson: Para analizar respuestas JSON.

API Frankfurter: Para obtener tasas de cambio de divisas.

🛠️ Requisitos
Antes de ejecutar el proyecto, asegúrate de tener instalado:

JDK 17 o superior

IDE: Eclipse o cualquier otro editor que soporte Java 17.

⚡ Instrucciones de Uso
1. Clonar el Proyecto
Puedes clonar este proyecto utilizando Git:

bash
Copiar
Editar
git clone https://github.com/tu_usuario/CasaDeCambio.git

2. Instalar Dependencias
Asegúrate de tener la librería Gson en tu proyecto. Si usas Eclipse o un IDE similar, puedes agregarlo manualmente o usar Maven para gestionar dependencias.

Si usas Maven, agrega esto en tu archivo pom.xml:

xml
Copiar
Editar
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.8</version>
</dependency>

3. Ejecutar el Proyecto
Para ejecutar el programa:

Abre tu IDE y carga el proyecto.

Ejecuta la clase principal CasaDeCambio.java.

Verás un cuadro de diálogo donde podrás elegir las monedas y realizar conversiones.

4. Realizar Conversiones
La aplicación te pedirá ingresar:

La moneda de origen (por ejemplo, USD, EUR, MXN).

La moneda de destino (por ejemplo, EUR, MXN, USD).

El monto que deseas convertir.

🔄 Cómo Funciona
El usuario ingresa una moneda de origen, una moneda de destino y un monto.

La aplicación hace una solicitud HTTP GET a la API de Frankfurter para obtener las tasas de cambio.

El programa analiza el JSON recibido y calcula la conversión.

El resultado se muestra en un cuadro de diálogo con el monto convertido.

El historial de operaciones se guarda en un archivo de texto con fecha y hora.

📄 Historial de Operaciones
El programa guarda cada operación realizada en un archivo de texto. Esto incluye la fecha, las monedas convertidas y el monto convertido.

Ejemplo de entrada en el archivo historial.txt:

less
Copiar
Editar
2025-04-12 10:30:15 - Convertido 100 USD a EUR: 91.0 EUR

🔄 Para Más Funcionalidades
Este proyecto es modular y fácil de extender. Puedes agregar más monedas, metales preciosos o recursos naturales. La estructura del código está diseñada para ser flexible y permitir fácilmente la integración de nuevas APIs o conversiones.

📈 Próximos Pasos
Mejorar la interfaz gráfica.

Agregar soporte para más metales y recursos.

Optimizar la gestión de errores.

Ampliar el historial de operaciones para permitir la visualización en la UI.

📝 Contribuciones
Si quieres contribuir a este proyecto:

Haz un fork del proyecto.

Crea una rama (git checkout -b feature/nueva-funcionalidad).

Realiza tus cambios y haz un commit.

Haz un pull request con tus cambios.

Este proyecto fue desarrollado por NoniBeld como parte de un aprendizaje sobre desarrollo de aplicaciones en Java con APIs externas.






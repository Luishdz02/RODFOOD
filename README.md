# RODFOOD - Sistema de Gestión de Restaurante

![Build Status](https://github.com/Luishdz02/RODFOOD/actions/workflows/maven.yml/badge.svg) ![Java Version](https://img.shields.io/badge/Java-17-blue) ![Status](https://img.shields.io/badge/Status-BETA-orange)

##  Resumen Ejecutivo

### Descripción
RODFOOD es un sistema web interno diseñado para centralizar y automatizar la operación diaria del restaurante. El proyecto busca eliminar la gestión manual actual para transicionar a una administración digital eficiente, alineada con los objetivos de productividad de la empresa.

### Problema Identificado
Actualmente, la empresa gestiona sus pedidos, inventarios y facturación mediante libretas y hojas de cálculo desconectadas, lo que ocasiona:
* Errores humanos en la toma de órdenes y cobros.
* Descontrol en el inventario (ingredientes agotados sin aviso).
* Pérdida de tiempo en la consolidación de reportes y facturación lenta.

### Solución Propuesta
Implementación de una aplicación web modular que conecta al personal de caja, cocina y administración en tiempo real.
* **Módulo de Pedidos:** Digitaliza la comanda y notifica a cocina instantáneamente.
* **Módulo de Inventario:** Descuenta insumos automáticamente con cada venta registrada.
* **Módulo de Facturación:** Prepara la información para generar CFDIs conectándose a un PAC externo.

### Arquitectura de la Solución
El sistema utiliza una arquitectura MVC desplegada en la nube.
* **Frontend:** HTML5/Bootstrap (Diseño responsivo para tablets de cajeros).
* **Backend:** Spring Boot (Java 17).
* **Base de Datos:** MySQL (Cloud).
* **Integración:** API REST para facturación electrónica.
  
*  Requerimientos del Sistema
Para ejecutar y desarrollar este proyecto se requiere el siguiente software:
Servidor de Aplicación: Apache Tomcat (Embebido en Spring Boot).
Lenguaje: Java JDK 17 (OpenJDK / Temurin).
Gestor de Dependencias: Maven 3.8+.
Control de Versiones: Git.
Base de Datos: MySQL 8.0 o superior (o H2 en memoria para pruebas).

1. Instalación y Despliegue
1. Instalación del Ambiente de Desarrollo
Sigue estos pasos para ejecutar el proyecto en tu máquina local:

# 1. Clonar el repositorio
git clone [https://github.com/Luishdz02/RODFOOD.git](https://github.com/Luishdz02/RODFOOD.git)

# 2. Entrar a la carpeta del proyecto
cd RODFOOD

# 3. Entrar al directorio del código fuente (IMPORTANTE: El código está en 'demo')
cd demo

# 4. Instalar dependencias y compilar
./mvnw clean install
# Nota: En Windows CMD usar: mvnw clean install

2. Ejecución de Pruebas Manuales
El proyecto cuenta con integración continua (GitHub Actions), pero puedes correr las pruebas locales:
./mvnw test

3. Ejecución Local (Despliegue)
Para levantar el servidor de aplicaciones:
./mvnw spring-boot:run

Una vez iniciado (verás el logo de Spring), el sistema estará disponible en: http://localhost:8080
4. Implementación en Producción
Para desplegar en servicios Cloud (Heroku/Render/AWS):
Generar el ejecutable: ./mvnw package
Subir el archivo .jar generado en la carpeta /target.
Configurar las variables de entorno en el panel del proveedor Cloud.

Configuración
El sistema está construido con Spring Boot, la configuración principal reside en:
demo/src/main/resources/application.properties
Variables de Entorno (Producción)
Importante: Por seguridad, no se guardan contraseñas en el repositorio. Para el entorno productivo, configurar las siguientes variables:

Variable                                   Descripción                 Ejemplo
SPRING_DATASOURCE_URL                  URL de conexión JDBC       jdbc:mysql://cloud-db:3306/rodfood 
SPRING_DATASOURCE_USERNAME             Usuario de la BD           admin_rodfood
SPRING_DATASOURCE_PASSWORD             Contraseña de la BD        secret123

Manual de Uso
Perfil: Cajero (Tablet)
Diseñado para la operación rápida.
Ingreso: Acceder con credenciales de empleado.
Nueva Orden:
Ir a la pestaña "Nueva Comanda".
Tocar los platillos para agregarlos.
Usar el botón "Editar" para notas (ej. "Sin cebolla").
Confirmar: Presionar "Enviar a Cocina". Esto descuenta el inventario automáticamente.
Cierre: Seleccionar la mesa y presionar "Cobrar" para liberar el espacio.

Perfil: Administrador (Web)
Diseñado para la gestión.
Menú: Ir a "Catálogo > Platillos" para agregar o modificar precios y recetas.
Reportes: Acceder al Dashboard para ver ventas del día y alertas de stock bajo.

Guía de Contribución
Este proyecto sigue la metodología Gitflow. Pasos para colaborar:

1.clonar y reparar
git checkout develop

2.Crear Rama (Feature Branch):
Nunca trabajar en master. Crear una rama descriptiva:
git checkout -b feature/nombre-tarea

3.Desarrollo y Pruebas:
Realizar cambios y verificar que no rompen el build:
cd demo
mvn test

4.Pull Request:
Subir cambios: git push origin feature/nombre-tarea
Abrir PR en GitHub apuntando hacia develop.
Esperar aprobación (CI en verde).

Roadmap (Futuro)
Funcionalidades fuera del alcance actual, planificadas para la Versión 2.0:
[ ] App Móvil para clientes finales (Pedidos desde mesa con QR).
[ ] Módulo de predicción de compras basado en IA.
[ ] Pasarela de pagos en línea (Stripe/PayPal).
[ ] Actualización a Facturación 4.0 automática.

Producto y Demostración
Video de Demostración
(https://1drv.ms/v/c/70d822be0ecb2c47/IQCShETLq_DHRJAC8jKzFe4EAUSoh1LCjptHV0mWs13V8GU?e=U5ts6Q)

Evidencia de Ejecución
Captura de pantalla del servidor Spring Boot iniciado exitosamente en el puerto 8080:
![Servidor Iniciado] (https://drive.google.com/file/d/1BPTw7_z8OilwnCxGXAKLG9W3W9ecsZZY/view?usp=drivesdk)
Acceso
Código Fuente: Disponible en este repositorio.
Ejecutables: Los archivos .jar se generan en la carpeta target tras la compilación.
```mermaid
graph TD
    User((Cajero))
    Admin((Admin))

    subgraph Sistema_RODFOOD [Sistema Web Interno]
        UI[Interfaz Web / Tablets]
        
        subgraph Backend [Lógica de Negocio]
            Orders[Módulo Pedidos]
            Inv[Módulo Inventario]
            Bill[Módulo Facturación]
        end
        
        DB[(Base de Datos MySQL)]
    end

    PAC[API Facturación SAT]

    User --> UI
    Admin --> UI
    UI --> Orders
    Orders --> Inv
    Orders --> Bill
    Orders --> DB
    Inv --> DB
    Bill --> PAC

    

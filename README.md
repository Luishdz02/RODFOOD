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

    

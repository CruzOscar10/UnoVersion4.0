# 🎮 UNO 4.0 - Sistema de Juego en Java

## 📌 Descripción

Este proyecto implementa una versión del juego **UNO** en Java, incluyendo lógica completa de juego, manejo de cartas, turnos, inteligencia básica para bots y validación de reglas.

El sistema fue desarrollado siguiendo principios de programación orientada a objetos, separando responsabilidades en distintas clases para mejorar la mantenibilidad y escalabilidad.

---

## 🧱 Arquitectura del Sistema

El sistema está dividido en los siguientes componentes principales:

* **Game** → Controlador principal del juego
* **Player** → Representa jugadores (humano o bot)
* **Hand** → Maneja las cartas de cada jugador
* **Deck** → Mazo de cartas
* **Card** → Representación de carta
* **RuleEngine** → Lógica de reglas del juego
* **TurnManager** → Control de turnos

---

## 🎴 Reglas Implementadas

* ✔ Cartas numéricas
* ✔ SALTO (pierde turno)
* ✔ REVERSA (cambia dirección)
* ✔ ROBA 2
* ✔ COMODÍN (cambia color)
* ✔ ROBA 4

---

## 🧪 Pruebas Implementadas

Se realizaron pruebas automatizadas con **JUnit 5**, cubriendo:

### 🔲 Caja Negra

* Validación de comodín (siempre jugable)
* Validación de ROBA 4
* Cambio de dirección con REVERSA

### ⚪ Caja Blanca

* Validación por color
* Validación por número
* Validación por tipo
* Flujo de turnos

### 🔄 Turnos

* Avance correcto de turno
* Ejecución de turno de bot

### ⚠️ Manejo de errores

* Índices inválidos en mano
* Mazo vacío
* Mano sin cartas válidas

---

## 📊 UML

Se desarrolló un diagrama UML completo del sistema, mostrando:

* Clases
* Relaciones
* Métodos y atributos

---

## 📋 Plan de Pruebas

El plan de pruebas incluyó:

* Validación de reglas del juego
* Verificación de flujo de turnos
* Pruebas de casos límite
* Detección de errores mediante excepciones

---

## 🐞 Bugs Encontrados

| ID | Descripción                           |
| -- | ------------------------------------- |
| B1 | Bot fallaba si no había carta en mesa |
| B2 | Doble avance de turno                 |
| B3 | Métodos inexistentes en pruebas       |
| B4 | Acceso inválido a mano                |
| B5 | Mazo vacío sin control adecuado       |

---

## 🔧 Correcciones Realizadas

* ✔ Se inicializó correctamente la carta en mesa en pruebas
* ✔ Se corrigieron llamadas a métodos inexistentes
* ✔ Se implementaron pruebas con excepciones (`assertThrows`)
* ✔ Se ajustó la lógica de pruebas del bot
* ✔ Se mejoró validación de jugadas

---

# 🚀 ACTUALIZACIÓN (MEJORAS REALIZADAS)

En esta versión se realizaron mejoras importantes en estabilidad, pruebas y diseño:

### 🔥 Mejoras Clave

* 🧪 **Sistema de pruebas completo**

  * Se añadieron pruebas de caja negra y blanca
  * Se validaron reglas críticas del juego

* 🤖 **Corrección del comportamiento del bot**

  * Ahora el bot requiere carta en mesa para actuar correctamente
  * Se mejoró la lógica de decisión

* 🔄 **Mejora en control de turnos**

  * Se evitó comportamiento inconsistente en el flujo de turnos
  * Se validó correctamente la dirección del juego

* ⚠️ **Manejo de errores robusto**

  * Se controlaron excepciones en mazo y mano
  * Se evitaron fallos en ejecución

* 🧱 **Mejor organización del código**

  * Separación clara de responsabilidades
  * Uso adecuado de clases como `RuleEngine` y `TurnManager`

---

## 🛠️ Tecnologías Utilizadas

* Java
* JUnit 5
* Eclipse IDE

---

## ▶️ Ejecución

1. Ejecutar la clase `Main`
2. Ingresar nombre del jugador
3. Jugar desde consola

---

## 📌 Conclusión

El sistema cumple con los requisitos del juego UNO, incluyendo lógica de reglas, flujo de turnos y manejo de errores.
Las pruebas implementadas garantizan su correcto funcionamiento y permiten detectar fallos de manera temprana.

---

## 👨‍💻 Autor
Cruz mejia oscar Adolfo
Ordaz Reyes Evelyn Julieta

# Proyecto de Automatización Front-End: POM + Page Factory (AUTO_FRONT_POM_FACTORY)

Este repositorio contiene la automatización de un flujo de prueba de punta a punta (E2E) para una aplicación de gestión de transacciones financieras, implementando el patrón de diseño **Page Object Model (POM)** con la factoría de elementos de **Serenity BDD** (@FindBy).

## 🚀 Objetivo del Proyecto
Validar el flujo completo de registro de usuario, inicio de sesión y creación de transacciones (ingresos y egresos) en la plataforma, asegurando la integridad de la interfaz de usuario y la persistencia de los datos en el listado.

## 🛠️ Stack Tecnológico
* **Lenguaje:** Java 11+
* **Framework de Automatización:** Serenity BDD
* **BDD Tool:** Cucumber
* **Gestión de Dependencias:** Gradle
* **Navegador:** Google Chrome (Configurado en `serenity.conf`)

## 🏗️ Arquitectura
El proyecto sigue el estándar de Serenity BDD:
* `src/test/resources/features`: Escenarios en lenguaje Gherkin (Declarativos).
* `src/test/java/com/automation/pages`: Page Objects utilizando `@FindBy` de Page Factory.
* `src/test/java/com/automation/steps`: Clases de lógica de pasos (@Step).
* `src/test/java/com/automation/steps/definitions`: Glue code que conecta Gherkin con los pasos.

## 📋 Prerrequisitos
1. Tener instalado el **JDK 11** o superior.
2. Tener instalado **Gradle** (opcional si se usa el `gradlew` incluido).
3. Google Chrome instalado.

## 🏃 Ejecución de Pruebas
Para ejecutar los escenarios de prueba y generar el reporte agregado de Serenity, utiliza el siguiente comando desde la terminal:

```bash
./gradlew clean test aggregate
```

*(En Windows utiliza `gradlew.bat`)*

## 📊 Reportes
Una vez finalizada la ejecución, el reporte detallado (Living Documentation) se encontrará en la siguiente ruta:
`target/site/serenity/index.html`

Se recomienda abrir el archivo `index.html` en un navegador para visualizar el flujo paso a paso con capturas de pantalla integradas.

## 📝 Buenas Prácticas Aplicadas
* **Page Factory:** Uso estricto de la anotación `@FindBy` para la localización de elementos.
* **Gherkin Declarativo:** Escenarios enfocados en el comportamiento del negocio, evitando detalles técnicos del DOM en los archivos `.feature`.
* **Clean Code:** Nomenclatura descriptiva y ausencia de código comentado.
* **DRY (Don't Repeat Yourself):** Reutilización de componentes y pasos de navegación.

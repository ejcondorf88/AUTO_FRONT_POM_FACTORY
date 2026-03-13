# Plan de Implementación de Pruebas: Gestión Financiera

Este documento define la estrategia global para la validación funcional de la aplicación de finanzas personales, asegurando que los requerimientos de negocio se cumplan mediante pruebas automatizadas distribuidas en tres repositorios independientes.

---

## 1. Historia de Usuario (User Story)

**Título**: Gestión de Movimientos Financieros

**Como**: Nuevo usuario de la plataforma.
**Quiero**: Registrar mis ingresos y egresos de forma rápida y sencilla.
**Para**: Mantener un control detallado de mis finanzas y balance de gastos.

### Criterios de Aceptación

- El sistema debe permitir el registro de un nuevo usuario con datos válidos.
- El usuario debe poder iniciar sesión tras el registro.
- El sistema debe permitir el registro de transacciones de tipo "Ingreso" y "Egreso".
- Las transacciones registradas deben reflejarse inmediatamente en la tabla de movimientos.

---

## 2. Estrategia de Pruebas

### Repositorio 1 — `AUTO_FRONT_POM_FACTORY`

- **Patrón**: POM + Page Factory (`@FindBy`)
- **Tipo**: Front-End E2E
- **Aplicación**: App de Gestión Financiera Personal
- **Flujos cubiertos**:
  - Registro de Usuario (Happy Path)
  - Login y gestión de sesión
  - Registro de transacción tipo Ingreso
  - Registro de transacción tipo Egreso
  - Visualización de movimientos en tabla

### Repositorio 2 — `AUTO_FRONT_SCREENPLAY`

- **Patrón**: Screenplay (Actores, Tareas, Acciones, Preguntas)
- **Tipo**: Front-End E2E
- **Aplicación**: App de Gestión Financiera Personal
- **Flujos cubiertos**: Mismos flujos del Repositorio 1
- **Principio aplicado**: Single Responsibility en cada `Task`
- **Nota**: Ambos repositorios validan la misma Historia de Usuario con enfoques arquitectónicos distintos, permitiendo comparar mantenibilidad y escalabilidad entre POM y Screenplay.

### Repositorio 3 — `AUTO_API_PETSTORE_SCREENPLAY`

- **Patrón**: Screenplay + Serenity REST
- **Tipo**: API Testing — Ciclo CRUD completo
- **Aplicación**: PetStore Swagger (`https://petstore.swagger.io`)
- **Flujo cubierto**:
  - `POST` → Crear mascota
  - `GET` → Consultar mascota creada
  - `PUT` → Actualizar datos de la mascota
  - `DELETE` → Eliminar la mascota

---

## 3. Stack Tecnológico

| Componente | Herramienta / Versión |
| :--- | :--- |
| Lenguaje | Java 11+ |
| Framework de automatización | Serenity BDD |
| Test Runner | Cucumber |
| Gestión de dependencias | Gradle |
| Patrón Front (Repo 1) | POM + Page Factory |
| Patrón Front (Repo 2) | Screenplay |
| Patrón API (Repo 3) | Screenplay + Serenity REST |
| IDE | IntelliJ IDEA / VS Code |
| Asistente IA | GitHub Copilot |
| Control de versiones | GitHub |

---

## 4. Entornos de Ejecución

| Repositorio | URL Base | Navegador |
| :--- | :--- | :--- |
| AUTO_FRONT_POM_FACTORY | `http://localhost:3000` | Chrome |
| AUTO_FRONT_SCREENPLAY | `http://localhost:3000` | Chrome |
| AUTO_API_PETSTORE_SCREENPLAY | `https://petstore.swagger.io/v2` | N/A (REST) |

> La configuración del driver y base URL se gestiona a través de `serenity.conf`.

---

## 5. Criterios de Entrada y Salida

### Criterios de Entrada

- Entorno de pruebas estable y disponible (local o servidor de QA).
- Documentación de requerimientos (Feature files) aprobada.
- Framework de automatización configurado y listo para ejecución.
- Set de datos de prueba pre-definido.

### Criterios de Salida

- Ejecución del 100% de los casos de prueba definidos en el alcance.
- Tasa de éxito (Pass Rate) superior al 95%.
- Reportes de Serenity generados y sin errores críticos pendientes.
- Verificación exitosa de los criterios de aceptación de la Historia de Usuario.

---

## 6. Datos de Prueba (Test Data)

| Perfil | Nombre | Email | Tipo | Descripción | Monto |
| :--- | :--- | :--- | :--- | :--- | :--- |
| Ingreso | Elian | e1l221...a21n4@test.com | income | Initial Salary | 2000 |
| Egreso | Juan | ju1221...a2n4@test.com | expense | Rent Payment | 800 |

> Los emails utilizan sufijos aleatorios para evitar duplicidad en ejecuciones consecutivas.

---

## 7. Alcance

### Dentro del Alcance

- Flujo de Registro de Usuario (Happy Path).
- Flujo de Login y Gestión de Sesión.
- Mantenimiento de Transacciones (Creación y Visualización).
- Navegación base del sistema (Sidebar y Módulos).
- Ciclo CRUD completo sobre la API de PetStore.

### Fuera del Alcance (Out of Scope)

- Pruebas de carga o rendimiento.
- Validaciones de seguridad (SQL Injection, XSS).
- Flujos de recuperación de contraseña ("Olvidé mi contraseña").
- Pruebas de compatibilidad con navegadores móviles o tablets.
- Edición o eliminación de transacciones ya existentes en el Front.

---

## 8. Riesgos y Mitigaciones

| Riesgo | Mitigación |
| :--- | :--- |
| Inestabilidad de elementos dinámicos (Selects personalizados) | Uso de esperas explícitas de Serenity y selectores robustos (CSS/XPath) |
| Duplicidad de datos de registro en ejecuciones consecutivas | Uso de generadores de datos aleatorios o limpieza de base de datos previa |
| Inestabilidad del endpoint público de PetStore | Reintentos controlados y validación de status code antes de continuar el flujo |
| Cambios en la UI de la aplicación propia | Centralización de locators en Page Objects / Tasks para fácil mantenimiento |

---

## 9. Entregables

| # | Entregable | Repositorio |
| :--- | :--- | :--- |
| 1 | Suite de automatización Front — POM + Page Factory | `AUTO_FRONT_POM_FACTORY` |
| 2 | Suite de automatización Front — Screenplay | `AUTO_FRONT_SCREENPLAY` |
| 3 | Suite de automatización API — Screenplay REST | `AUTO_API_PETSTORE_SCREENPLAY` |
| 4 | Plan de Implementación de Pruebas (este documento) | Incluido en cada repositorio |
| 5 | Reporte consolidado de ejecución (`Living Documentation`) | Generado por Serenity BDD |

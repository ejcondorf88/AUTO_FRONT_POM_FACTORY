# Plan de Implementación de Pruebas: Gestión Financiera

Este documento define la estrategia global para la validación funcional de la aplicación de finanzas personales, asegurando que los requerimientos de negocio se cumplan mediante pruebas automatizadas.

## 1. Historia de Usuario (User Story)

**Título**: Gestión de Movimientos Financieros
**Como**: Nuevo usuario de la plataforma.
**Quiero**: Registrar mis ingresos y egresos de forma rápida y sencilla.
**Para**: Mantener un control detallado de mis finanzas y balance de gastos.

### Criterios de Aceptación:
*   El sistema debe permitir el registro de un nuevo usuario con datos válidos.
*   El usuario debe poder iniciar sesión tras el registro.
*   El sistema debe permitir el registro de transacciones de tipo "Ingreso" y "Egreso".
*   Las transacciones registradas deben reflejarse inmediatamente en la tabla de movimientos.

## 2. Criterios de Entrada y Salida

### Criterios de Entrada:
*   Entorno de pruebas estable y disponible (local o servidor de QA).
*   Documentación de requerimientos (Feature files) aprobada.
*   Framework de automatización configurado y listo para ejecución.
*   Set de datos de prueba pre-definido.

### Criterios de Salida:
*   Ejecución del 100% de los casos de prueba definidos en el alcance.
*   Tasa de éxito (Pass Rate) superior al 95%.
*   Reportes de Serenity generados y sin errores críticos pendientes.
*   Verificación exitosa de los criterios de aceptación de la Historia de Usuario.

## 3. Datos de Prueba (Test Data)

Se utilizarán los siguientes sets de datos para las pruebas E2E:

| Perfil | Nombre | Email | Tipo | Descripción | Monto |
| :--- | :--- | :--- | :--- | :--- | :--- |
| Ingreso | Elian | e1l221...a21n4@test.com | income | Initial Salary | 2000 |
| Egreso | Juan | ju1221...a2n4@test.com | expense | Rent Payment | 800 |

## 4. Alcance

### Dentro del Alcance:
*   Flujo de Registro de Usuario (Happy Path).
*   Flujo de Login y Gestión de Sesión.
*   Mantenimiento de Transacciones (Creación y Visualización).
*   Navegación base del sistema (Sidebar y Módulos).

### Fuera del Alcance (Out of Scope):
*   Pruebas de carga o rendimiento.
*   Validaciones de seguridad (SQL Injection, XSS).
*   Flujos de recuperación de contraseña ("Olvidé mi contraseña").
*   Pruebas de compatibilidad con navegadores móviles o tablets.
*   Edición o eliminación de transacciones ya existentes.

## 5. Riesgos y Mitigaciones
*   **Riesgo**: Inestabilidad del elemento dinámico (Select personalizados).
*   **Mitigación**: Uso de esperas explícitas de Serenity y selectores robustos (CSS/XPath).
*   **Riesgo**: Duplicidad de datos de registro en ejecuciones seguidas.
*   **Mitigación**: Uso de generadores de datos aleatorios o limpieza de base de datos previa.

## 6. Entregables
1.  Suite de automatización en Serenity/Screenplay.
2.  Plan de Implementación de Pruebas (este documento).
3.  Reporte consolidado de ejecución (`Living Documentation`).

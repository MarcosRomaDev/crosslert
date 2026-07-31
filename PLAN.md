# PLAN.md — Crosslert (Watchlist Bursátil con Alertas y Análisis Técnico)

Plan de desarrollo por milestones. Se trabaja **un milestone cada vez**; no se avanza al
siguiente hasta que el actual funciona. Este archivo es la única fuente de verdad del plan:
si algo se reordena, se cambia aquí.

## Idea del proyecto

**Crosslert** — de *crossover* (cruce de medias móviles) + *alert* (alertas): el nombre
recoge las dos funcionalidades estrella del proyecto.

App **multi-usuario** para seguir acciones de bolsa. Cada usuario tiene su watchlist, ve
gráficas de precio e indicadores técnicos (medias móviles, RSI), y configura alertas por
precio y por indicador. Fuente de datos: API externa real (Alpha Vantage o similar), con
caché en BBDD por los límites del free tier.

## Stack

- **Frontend:** JavaScript vanilla + Chart.js (sin frameworks)
- **Backend:** Java + Spring Boot
- **BBDD:** PostgreSQL
- **API externa:** Alpha Vantage a confirmar en Milestone 2 (alternativa: Finnhub, con
  límite algo más generoso)

## Norma transversal

Desde el Milestone 4, todas las entidades se diseñan **ya preparadas para multi-usuario**
(con `usuario_id`), aunque hasta el Milestone 9 se use un usuario fijo/mock. Así el paso a
autenticación real es un refactor limpio y no una reescritura.

---

## Milestones

### 1. Setup mínimo
Backend (Spring Boot) + frontend + BBDD vacía. Un endpoint "hola mundo" que el front
consuma y pinte.
**Objetivo:** validar que las dos capas se comunican antes de construir nada encima.
**Nota:** BBDD ya decidida (PostgreSQL). Levantarla en local (instalación directa o Docker)
y conectar Spring Boot a ella como parte de este milestone.

### 2. Integración API externa + caché
Conectar la API de bolsa. Cachear las respuestas de precio en BBDD. Gestionar el rate
limit (no volver a pedir lo que ya tenemos fresco).
**Objetivo:** el corazón del proyecto. Es la fuente de datos de casi todo lo demás.
**Decisiones a cerrar aquí:**
- API definitiva: **Alpha Vantage** (decidido). Finnhub descartado — su endpoint de velas
  para acciones US da 403 en el free tier, solo disponible de pago.
- Política de caché (cada cuánto se considera "caducado" un precio). Pendiente — condicionada
  por el límite de **25 peticiones/día** del free tier de Alpha Vantage, así que la caché debe
  ser agresiva.

### 3. Buscar y ver un activo + gráfica de precio
Buscar por ticker/nombre, ficha del activo, histórico de precio dibujado con Chart.js.
**Objetivo:** primer resultado visual real en pantalla. Valida que la API + caché funcionan
de punta a punta.

### 4. Watchlist CRUD
Añadir / eliminar / listar activos seguidos. Usuario mock todavía (sin login).
**Recordatorio:** entidades con `usuario_id` desde ya.
**Objetivo:** primera lógica de negocio propia, limpia, sin el ruido de la autenticación.

### 5. Alertas de precio
CRUD de alertas simples: "avísame si X sube/baja de un precio". Evaluación de alertas al
cargar la app (comparar precio actual cacheado contra las condiciones guardadas).
**Objetivo:** segunda funcionalidad estrella sobre una base ya sólida.

### 6. Indicadores técnicos I — Medias móviles
Calcular y superponer medias móviles (SMA/EMA) sobre la gráfica de precio.
**Objetivo:** ampliar la parte visual con poco riesgo. Introduce el cálculo sobre series
de precios.

### 7. Indicadores técnicos II — RSI
Calcular el RSI **a partir de los precios de cierre** (fórmula propia, no endpoint mágico)
y mostrarlo en un panel/gráfico secundario.
**Objetivo:** la parte de más nivel técnico. Lógica de cálculo vistosa y defendible.

### 8. Alertas por indicador
Condiciones sobre indicadores, no solo precio: "avísame si el RSI baja de 30", "si el
precio cruza la media de 50".
**Objetivo:** combinar alertas + indicadores. Es lo más diferenciador del proyecto.

### 9. Autenticación
Registro / login / JWT. Migrar del usuario mock a usuarios reales; cada usuario ve solo su
watchlist y sus alertas.
**Objetivo:** blindar y volver multi-usuario real lo que ya funciona. Es un ejercicio de
**refactor con sentido**, no una feature nueva desde cero (por eso las entidades ya venían
con `usuario_id`).

### 10. Scheduled tasks + pulido + despliegue
`@Scheduled` en Spring para evaluar alertas periódicamente sin la app abierta (marcar
alertas disparadas en BBDD). Pulido de UI/UX. Despliegue final.
**Objetivo:** cierre del proyecto y toque profesional.

---

## Estado actual

- [x] Milestone 1
- [ ] Milestone 2
- [ ] Milestone 3
- [ ] Milestone 4
- [ ] Milestone 5
- [ ] Milestone 6
- [ ] Milestone 7
- [ ] Milestone 8
- [ ] Milestone 9
- [ ] Milestone 10

*(Ir marcando a medida que se completan.)*

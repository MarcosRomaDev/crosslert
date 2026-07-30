# Crosslert

> Watchlist bursátil multi-usuario con alertas y análisis técnico.

**Crosslert** (de *crossover* + *alert*) es una aplicación web para seguir acciones de
bolsa: cada usuario mantiene su watchlist, consulta gráficas de precio e indicadores
técnicos (medias móviles, RSI) y configura alertas —tanto por precio como por indicador—
que le avisan cuando el mercado se mueve.

Proyecto de portfolio del ciclo de **Desarrollo de Aplicaciones Web (DAW)**.

## Stack

| Capa | Tecnología |
|------|-----------|
| Frontend | JavaScript vanilla + Chart.js |
| Backend | Java + Spring Boot |
| Base de datos | PostgreSQL |
| API externa | Alpha Vantage (datos de bolsa) |

## Funcionalidades

- Búsqueda de acciones por ticker y ficha de detalle con histórico de precio.
- Watchlist personal por usuario.
- Alertas de precio ("avísame si X sube/baja de un valor").
- Indicadores técnicos: medias móviles (SMA/EMA) y RSI calculado a partir de los
  precios de cierre.
- Alertas basadas en indicadores (p. ej. RSI en sobreventa, cruce de medias).
- Autenticación multi-usuario (registro / login).
- Evaluación periódica de alertas en segundo plano.

## Estado del proyecto

En desarrollo. El plan de trabajo detallado, organizado por milestones, está en
[PLAN.md](./PLAN.md).

## Metodología

Este proyecto se desarrolla con la asistencia de un agente de IA configurado como **tutor**,
no como generador de código: sus reglas (ver [CLAUDE.md](./CLAUDE.md)) le impiden escribir
el código por mí y le obligan a guiarme mediante método socrático, para que el aprendizaje
sea real. Todo el código lo escribo yo.

## Puesta en marcha

> Pendiente de completar conforme avance el desarrollo (requisitos, variables de entorno,
> arranque del backend y del frontend).

---

Autor: **Marcos Roma** · [github.com/marcosromadev](https://github.com/marcosromadev)

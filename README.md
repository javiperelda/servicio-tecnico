# Servicio Técnico

Aplicacion de escritorio para gestión de servicio técnico de equipos.  
El proyecto esta hecho en Java, usa PostgreSQL como base de datos y JasperReports para generar reportes.

## Funcionalidades principales

- Gestión de clientes (alta, edición, baja, busqueda y listado).
- Gestión de tecnicos.
- Gestión de equipos.
- Gestión de ordenes de reparación.
- Reporte de clientes.
- Reporte de orden de reparación (por número de orden seleccionado).

## Stack 

- Java SE 8 
- Java Swing (UI)
- PostgreSQL 
- JDBC PostgreSQL
- JasperReports 4.0.2

## Estructura del proyecto

- `src/Modelo`: entidades y lógica de negocio.
- `src/Vistas`: formularios Swing y gestores de vistas.
- `src/sql`: conexión y acceso a base de datos.
- `src/Reportes`: plantillas y reportes Jasper (`.jrxml` / `.jasper`).
- `src/sql/config/config.properties`: configuración de conexión a PostgreSQL.
- `st.sql`: script de creación/carga inicial de base de datos.


## Configuración de base de datos

1. Crear/cargar la base con el script **st.sql**
2. Revisar credenciales en:

`src/sql/config/config.properties`

Ejemplo actual:

```properties
dbhost=localhost
dbport=5432
dbuser=postgres
dbpassword=pass
database=serviciotecnico
```

## Notas importantes

- Los reportes usan `sql.Conexion`, que tiene credenciales hardcodeadas (`localhost`, `postgres`, `3719`).
  Si cambias credenciales, revisa tambien `src/sql/Conexion.java`.


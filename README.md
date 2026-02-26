# STecnico

Aplicacion de escritorio para gestion de servicio tecnico de equipos.  
El proyecto esta hecho en Java, usa PostgreSQL como base de datos y JasperReports para generar reportes.

## Funcionalidades principales

- Gestion de clientes (alta, edicion, baja, busqueda y listado).
- Gestion de tecnicos.
- Gestion de equipos.
- Gestion de ordenes de reparacion.
- Reporte de clientes.
- Reporte de orden de reparacion (por numero de orden seleccionado).

## Stack 

- Java SE 8 
- Java Swing (UI)
- PostgreSQL 
- JDBC PostgreSQL
- JasperReports 4.0.2

## Estructura del proyecto

- `src/Modelo`: entidades y logica de negocio.
- `src/Vistas`: formularios Swing y gestores de vistas.
- `src/sql`: conexion y acceso a base de datos.
- `src/Reportes`: plantillas y reportes Jasper (`.jrxml` / `.jasper`).
- `src/sql/config/config.properties`: configuracion de conexion a PostgreSQL.
- `st.sql`: script de creacion/carga inicial de base de datos.


## Configuracion de base de datos

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


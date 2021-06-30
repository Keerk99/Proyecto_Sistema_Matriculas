Drop database IF EXISTS matricula;
Create database matricula;
use matricula;

DROP TABLE IF EXISTS seccion;
CREATE table seccion(
IdSeccion int primary key,
NroSeccion varchar(10)
);

DROP TABLE IF EXISTS grado;
CREATE table grado(
IdGrado int primary key,
NroGrado varchar(10)
);

DROP TABLE IF EXISTS seccion_grado;
CREATE table seccion_grado(
IdSeccion int,
IdGrado int,
FOREIGN KEY(IdSeccion) REFERENCES seccion(IdSeccion),
FOREIGN KEY(IdGrado) REFERENCES grado(IdGrado)
);

DROP TABLE IF EXISTS grado_instruccion;
CREATE table grado_instruccion(
IdPeriodo int primary key,
NomInstruccion varchar(50)
);

DROP TABLE IF EXISTS curso;
CREATE table curso(
IdCurso int primary key,
NomCurso varchar(50),
IdGrado int,
IdPeriodo int,
FOREIGN KEY(IdGrado) REFERENCES grado(IdGrado),
FOREIGN KEY(IdPeriodo) REFERENCES grado_instruccion(IdPeriodo)
);



/*INSERT INTO `DatoLlenado` VALUES (1,50,30,30,30,30,30,30,30,30,30);

INSERT INTO `Usuarios` VALUES ('admin2','1234');

-- Tiempo maximo de llenado
select * from `DatoLlenado` where `TiempoLlenado`=(select MAX(`TiempoLlenado`) from DatoLlenado);

-- Consultas adicionales
select MIN(`TiempoLlenado`) from `DatoLlenado`;
select MIN(`TiempoVaceado`) from `DatoLlenado`;
*/
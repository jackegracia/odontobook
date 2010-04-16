alter table PACIENTE drop constraint FK5B4D037164899C74
drop table DOCTOR if exists
drop table HISTOGRAMA if exists
drop table PACIENTE if exists
drop table TURNO if exists
create table DOCTOR (id varchar(255) not null, apellido varchar(255), direccion varchar(255), dni integer not null, edad integer not null, matricula integer not null, nombre varchar(255), telefono integer not null, primary key (id))
create table HISTOGRAMA (DIENTES_ID integer generated by default as identity (start with 1), cara varchar(255), tratamiento varchar(255), primary key (DIENTES_ID))
create table PACIENTE (DOCTOR_ID integer generated by default as identity (start with 1), apellido varchar(255), direccion varchar(255), edad integer not null, nombre varchar(255), obraSocial varchar(255), telefono integer not null, histograma_DIENTES_ID integer, primary key (DOCTOR_ID))
create table TURNO (codigo bigint generated by default as identity (start with 1), asistido bit not null, primary key (codigo))
alter table PACIENTE add constraint FK5B4D037164899C74 foreign key (histograma_DIENTES_ID) references HISTOGRAMA

create database Dentista
go
use Dentista
go 
create table Paciente (
IdPaciente int primary key identity(1,1) not null ,
Nombre varchar (50) not null,
Telefono varchar (15) not null,
Direccion varchar (max) not null,
Sexo char (1) check (Sexo in ('M','F')) not null,
Edad int check (Edad >= 10 and Edad <= 60)
)
select Sexo from Paciente order by Sexo
go
create table Cita (
Fecha_Cita varchar (20) primary key not null,
IdPaciente int not null references Paciente(IdPaciente),
Paciente varchar (50) not null,
Horario varchar (10) not null,
)
create table servicios(
Descripcion varchar (50) primary key   not null,
Idservicio int identity(1,1) not null,
Cantidad_Pago int,
)
insert into servicios values('Ortodoncia','3000')
insert into servicios values('Curacion','500')
insert into servicios values('Protesis','600')
insert into servicios values('Consulta','100')
insert into servicios values('Centado','400')
insert into servicios values('Operatoria Dental','2500')
select * from servicios 
go
create table Pago (
Fecha_Pago varchar (20) primary key not null, 
Descripcion varchar (50) references servicios(Descripcion) not null,
Cantidad_Pago int,
IdPaciente int not null references Paciente(IdPaciente),
Paciente varchar (50) not null,
)
go
create table contrasenas(
usuario varchar (20) primary key not null,
password varchar (20) not null,
tipo char (1) check (tipo in ('A','D','S')),
status char (1) check (status in('A','D'))
)
insert into contrasenas values ('Karen','8520','A','A')
insert into contrasenas values ('alejandro','1724','A','A')
insert into contrasenas values ('Katherin','1234','D','A')
insert into contrasenas values ('SEBASTIAN','ADMIN','D','A')
insert into contrasenas values ('MAYTE','LILO','S','A')
insert into contrasenas values ('LAURA','LLLL','S','A')
GO
select * from contrasenas 
insert into Paciente values ('Katherin Garcia Alcivar','55-18-99-29-75','Calle 37 No 99 Colonia de Jardines de Santa Clara C.P 55450','F',20)
insert into Paciente values ('Alejandro Perez Lopez','55-12-48-96-99','Calle Alba Mz 2 Lt 19 Col. Quinto sol','M',23)
select * from Paciente
select * from Cita
select * from Pago
drop database dentista

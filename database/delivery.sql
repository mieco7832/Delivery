/*
*	Delivery
*/

-- Regla de tabulación de base de datos Guión Bajo

drop database if exists delivery;
create database delivery charset utf8 collate utf8_spanish_ci;

use delivery;

drop table if exists sucursal;
create table sucursal(
id_sucursal int auto_increment,
nombre_suscursal varchar(50),
ubicacion varchar(150) not null,
telefeno varchar(9) not null,
constraint pk_sucursal primary key(id_sucursal)
)engine innodb;

drop table if exists personal;
create table personal(
id_personal varchar(10) not null,
nombre_personal varchar(20) not null,
apellido_personal varchar(20) not null,
nombre_usuario varchar(20) not null,
clave_usuario varchar(16) not null,
direccion_usuario varchar(50) not null,
rol enum('Cajero','Motorista','Supervisor'),
id_sucursal int not null,
constraint pk_personal primary key(id_personal),
constraint fk_sucursal_personal foreign key(id_sucursal) references sucursal(id_sucursal) on update cascade on delete no action
)engine innodb;

insert into delivery.sucursal(nombre_suscursal,ubicacion,telefeno) values('Delivery Central','Metrocentro San Salvador, San Salvador','2000 2000');
insert into delivery.personal(id_personal,nombre_personal,apellido_personal,nombre_usuario,clave_usuario,direccion_usuario,rol,id_sucursal) 
values('04552427-4','Marcos','Castañeda','marcas','maca80','San Salvador','Supervisor','1'),
('07675761-3','Violeta','Acevedo','vioace','viac94','San Salvador','Cajero','1'),
('08138492-5','Juan','Navarrete','juanav','juna89','San Salvador','Motorista','1'),
('01751761-1','Juan David','Castaño','juadav','juda96','San Salvador','Motorista','1'),
('06879985-6','Alberto Jose','Enriquez','albern','albe92','San Salvador','Motorista','1');

drop table if exists unidad;
create table unidad(
id_unidad varchar(9), -- placa
modelo varchar(20),
id_sucursal int not null,
constraint pk_unidad primary key(id_unidad),
constraint fk_sucursal_unidad foreign key(id_sucursal) references sucursal(id_sucursal) on update cascade on delete no action
)engine innodb;

insert into unidad(id_unidad,modelo,id_sucursal) values('M 827384','Yamaha','1'),('M 629384','Suzuki','1'),('M 927384','Honda','1');

drop table if exists motociclista;
create table motociclista(
id_motociclista int auto_increment,
id_unidad varchar(9) not null,
id_personal varchar(10) not null,
posee_moto enum('Si','No') not null,
constraint pk_motociclista primary key(id_motociclista),
constraint fk_unidad_motociclista foreign key(id_unidad) references unidad(id_unidad) on update cascade on delete no action,
constraint fk_personal_motociclista foreign key(id_personal) references personal(id_personal) on update cascade on delete no action
)engine innodb;

insert into motociclista(id_unidad,id_personal,posee_moto) values('M 827384','01751761-1','No'),('M 629384','06879985-6','Si'),('M 927384','08138492-5','No');

drop table if exists turno;
create table turno(
id_personal varchar(10) not null,
id_turno enum('Matutino','Vespertino','Nocturno'),
constraint pk_turno primary key(id_personal),
constraint fk_personal_turno foreign key(id_personal) references personal(id_personal) on update cascade on delete no action
)engine innodb;

insert into delivery.turno(id_turno,id_personal) values('Matutino','04552427-4'),
('Matutino','07675761-3'),
('Matutino','08138492-5'),
('Matutino','01751761-1'),
('Matutino','06879985-6');

drop table if exists pedido;
create table pedido(
id_pedido int auto_increment,
producto varchar(150) not null,
precio decimal(18,2) not null,
direccion varchar(100) not null,
id_personal varchar(10) not null,
constraint pk_pedido primary key(id_pedido),
constraint fk_personal_pedido foreign key(id_personal) references personal(id_personal) on update cascade on delete no action
)engine innodb;

drop table if exists ruta;
create table ruta(
id_ruta int auto_increment,
fecha_ruta datetime default current_timestamp,
tipo_marcado enum('Asignado','Salida','Entrada'), 
id_pedido int not null, 
id_motociclista int not null,
constraint pk_ruta primary key(id_ruta),
constraint fk_pedido_ruta foreign key(id_pedido) references pedido(id_pedido) on update cascade on delete no action,
constraint fk_motociclista_ruta foreign key(id_motociclista) references motociclista(id_motociclista) on update cascade on delete no action
)engine innodb;
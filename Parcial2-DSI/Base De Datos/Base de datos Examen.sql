create database examen;

use examen;

create table cuentas (
    idcuenta int primary key auto_increment,
    nombres varchar(100),
    apellidos varchar(100),
    dui varchar(10),
    tipo enum('ahorro', 'corriente', 'plazo'),
    saldo decimal(10,2),
    fecha date,
    activa boolean
);

select * from cuentas;

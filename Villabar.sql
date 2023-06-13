create database villabar;
use villabar;
create table clientes(
id_clientes int auto_increment not null,
nombre varchar(45),
cedula varchar(45),
telefono varchar(45),
direccion varchar(45),
primary key(id_clientes)
);
create table empleado(
id_empleados int auto_increment not null,
nombre_empleado varchar(45),
cedula varchar(45),
telefono_empleado varchar(45),
primary key(id_empleados)
);
create table tipo_pago(
id_pago int auto_increment not null,
nombre_pago varchar(45),
primary key(id_pago)
);
create table proveedores(
id_proveedores int auto_increment not null,
empresa varchar(45),
nombre_proveedor varchar(45),
tipo_producto varchar(100),
primary key(id_proveedores)
);
create table productos(
id_productos int auto_increment not null,
id_proveedores int not null,
fecha_vencimiento date,
precio_venta varchar(45),
nombre_producto varchar(100),
primary key(id_productos,id_proveedores),
constraint productos_proveedores_fk1 foreign key (id_proveedores) references proveedores(id_proveedores)
);
create table compras(
id_compras int auto_increment not null,
id_empleados int not null,
fecha_compra date,
cantidad_compra int,
id_productos int not null,
primary key (id_compras, id_empleados,id_productos),
constraint compras_empleado_fk1 foreign key (id_empleados) references empleado(id_empleados),
constraint compras_productos_fk2 foreign key (id_productos) references productos(id_productos)
);
create table ventas(
id_ventas int auto_increment not null,
id_pago int not null,
descuento float,
id_empleados int not null,
id_productos int not null,
cantidad int,
id_clientes int not null,
primary key(id_ventas,id_empleados,id_pago,id_clientes,id_productos),
constraint ventas_tipopago_fk1 foreign key (id_pago) references tipo_pago(id_pago),
constraint ventas_clientes_fk2 foreign key (id_clientes) references clientes(id_clientes),
constraint ventas_productos_fk3 foreign key (id_productos) references productos(id_productos),
constraint ventas_empleado_fk4 foreign key (id_empleados) references empleado(id_empleados)
);

#clientes
insert into clientes(nombre,cedula,telefono,direccion)
values("Nestor Hernández","1096946315","3212666981","edificio_cristales"),
("Rafael Barrera","1005230561","3138731312","cra 8#8-09"),
("Katherin Villamarin","1004530561","3149731312","cra 8#8-09"),
("Pedro Esteban","6005230561","3204899200","EDificio San Rafael"),
("Claudia Barrera","6002138761","3204899201","cra 8#8-09"),
("Juandiego Joya","1895230561","3138731879","cra 15#10-45"),
("Hugo Sanchez","6805250531","3147883129","cra 9#25-40"),
("Federico Fidalgo","6805888531","321750035","cra 8#03-45"),
("Damian Becerra","1005231526","",""),
("Ramon Arribas","6002211111","",""),
("Fran Escobar","6060121254","3132755207",""),
("Leider Esteban","10005230560","","cra8#8-02"),
("Tatiana Vargas","","",""),
("Ana Paez","6005245632","3224526879",""),
("Cristian Moreno","","","cra8#4-02"),
("Fabian Rojas","","3214587963",""),
("Damian Cáceres","1053801555","3104501895",""),
("Harry López","","3104035063",""),
("Paula Torres","1140816752","3103733374","cra8#8-08"),
("Paula Torres","1045684960","3100210408","cr9#10-05");

#empleado
insert into empleado(nombre_empleado,cedula,telefono_empleado)
values ("Marco","6005581432","3105526755"),
("Rafael Barrera","1005230561","3138731312"),
("Claudia Barrera","6002138761","3204899201");

#tipo_pago
insert into tipo_pago(nombre_pago)
values("fiado"),("directo");

#proveedores
insert into proveedores(empresa,nombre_proveedor,tipo_producto)
values("Coca Cola Company","Coca Cola","refrescos"),
("Colombina","La Constancia","conservas, salsas, esparcibles y vinagres"),
("Bavaria","Bavaria","bebidas"),
("Jet","Jet","chocolates"),
("COMERCIAL KEWIN","Pepsico","comestibles"),
("Distribuciones Domecaris","Distribuciones Domecaris","variados"),
("Lummy's","Lummy's","variados"),
("Antioqueño","Antioqueño","Aguardiente"),
("Freska Leche S.A.S","Freska Leche","productos lácteos"),
("Comoriente S.A","Comoriente","licores"),
("Meico S.A","Meico","licores"),
("Nutresa","Nutresa","fiambres, galletas, chocolates, café, helados y pastas"),
("Productos Ramo S.A","Ramo","productos de panadería"),
("Postobon","Postobon","bebidas"),
("Alpina","Alpina","alimentos​ a base de lácteos"),
("Comercializadora Terraza Veracruz S.A.S","Terraza Veracruz","licores"),
("Bizcopan Zapatoca","Bizcopan Zapatoca","pan"),
("Familia","Familia","cuidado personal,aseo del hogar y baños"),
("Aceite ideal","Aceite ideal","aceites"),
("Distribuciones Pastor Julio Delgado S.A.S","Pastor Julio","productos de consumo masivo"),
("D'Chucuri","D'Chucuri","chocolate");
alter table proveedores auto_increment=1;
#productos
insert into productos(id_proveedores,fecha_vencimiento,precio_venta,nombre_producto)
values(10,"2023-07-02",25000,"Ron Viejo Caldas 1/2"),
(8,"2025-08-23",22000,"Aguardiente Antioqueño 1/2"),
(3,"2026-02-28",2500,"Aguila 330 cm"),
(3,"2026-02-28",2500,"Poker 330 cm"),
(3,"2026-04-28",3500,"Club Colombia 330 cm"),
(11,"2028-05-15",150000,"Wisky Bukanas 750 cm"),
(11,"2028-07-15",130000,"Wisky Old Parr 750 cm"),
(3,"2027-04-28",3500,"Ceveza Corona"),
(1,"2024-02-02",9000,"Gaseosa Coca_Cola 3 L"),
(1,"2024-02-02",5500,"Gaseosa Coca_Cola litro 1/4"),
(14,"2023-12-02",6000,"Gaseosa Postobon 2 L 1/2"),
(12,"2024-01-01",7000,"Galletas Paquete Ducales Grandes"),
(12,"2023-07-01",5500,"Galletas Club Social paquete"),
(12,"2023-08-04",8500,"Galletas Festival pequeña"),
(13,"2024-08-02",5000,"Torta Ponque Ramo"),
(13,"2024-01-01",2000,"Chocorramo"),
(13,"2023-07-08",1800,"Ponque Gala"),
(9,"2023-06-02",6000,"Leche Freskaleche"),
(14,"2024-01-02",1500,"Jugo Caja sabores"),
(2,"2024-02-01",8500,"Bombombunes paquete"),
(5,"2023-06-05",7000,"De todito grande"),
(5,"2023-06-05",2600,"De todito pequeño");

#compras
insert into compras(id_empleados,fecha_compra,cantidad_compra,id_productos)
values(1,"2023-01-02",12,22),
(1,"2023-02-02",20,12),
(1,"2023-03-25","18",22),
(1,"2023-03-01",10,15),
(2,"2023-04-01",12,18),
(1,"2023-02-05",40,3),
(3,"2023-02-21",40,4),
(1,"2023-03-05",40,5),
(1,"2023-02-01",20,6),
(1,"2023-03-08",20,21),
(1,"2023-03-05",40,5),
(2,"2023-03-05",40,5),
(1,"2023-03-05",40,3),
(3,"2023-04-01",20,19),
(1,"2023-03-03",15,18),
(1,"2023-02-26",10,20),
(3,"2023-02-03",22,11),
(1,"2023-01-30",25,19),
(3,"2023-01-06",12,18),
(1,"2023-04-01",16,17);

#ventas
insert into ventas(id_pago,descuento,id_empleados,id_productos,cantidad,id_clientes)
values(1,0,2,14,2,2),
(1,0,2,10,1,5),
(2,0,3,21,5,11),
(2,0,1,5,6,3),
(1,0.5,1,6,4,17),
(2,0.1,1,9,2,13),
(1,0.3,1,2,2,2),
(1,0.3,1,2,2,2),
(2,0,3,7,1,9),
(1,0,3,19,22,3),
(1,0,1,6,8,18),
(1,0,3,3,5,4),
(2,0,1,12,4,8),
(1,0,1,5,4,7),
(1,0,1,3,2,1),
(2,0.1,2,4,9,2),
(1,0,2,9,2,19),
(1,0,1,8,3,11),
(1,0.01,2,9,4,1),
(1,0,1,5,1,14);




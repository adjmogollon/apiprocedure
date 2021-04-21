CREATE  OR REPLACE VIEW `infoCliente` AS
select c.id numeroCliente, c.nombre nombreCliente, 
c.apellido apellidoCliente, c.email CorreoCliente, 
r.id numeroRegion, r.nombre nombreRegion 
from clientes as c
inner join regiones as r on (c.region_id = r.id);

DELIMITER $$
CREATE PROCEDURE `cantidadFacturasTodosClientes`()
BEGIN
select c.nombre nombreCliente, c.apellido apellidoCliente,c.email emailCliente, count(c.id) cantidadFacturas 
from clientes as c 
inner join facturas as f on (c.id = f.cliente_id)
group by  c.nombre, c.apellido,c.email;
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `contarClientePorRegion`(
IN idRegion integer,
out cantidad integer)
BEGIN
select count(id) into cantidad from clientes as c 
where region_id = idRegion;
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `contarClientes`(out cantidad integer)
BEGIN
select count(id) into cantidad from clientes as c;
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `contarClientesEntero`()
BEGIN
select count(id) from clientes as c;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `facturasClientePorEmail`(IN correoCliente VARCHAR(255))
BEGIN
select 
f.id idFactura, f.cliente_id idCliente, f.descripcion descripcionFactura,
f.observacion observacionFactura,c.email emailCliente, c.nombre nombreCliente, c.apellido apellidoCliente
from facturas as f 
inner join clientes as c  on (f.cliente_id = c.id)
where c.email = correoCliente;
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `infoClientePorCorreo`(IN correoCliente VARCHAR(255))
BEGIN
select c.id numberClient, c.nombre firtsNameClient, c.apellido lastNameClient, c.email emailCliente, r.id numberRegion, r.nombre nameRegion 
from clientes as c
inner join regiones as r on (c.region_id = r.id) 
where c.email = correoCliente;
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `infoClientesTodos`()
BEGIN
select * from clientes;
END$$
DELIMITER ;


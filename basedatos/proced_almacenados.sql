create proc sp_listar_clientes
as 
select*from clientes
go

create proc sp_guardar_clientes
@codigo varchar(10),
@nombre varchar(20),
@apellido varchar (20),
@dni int,
@ruc varchar(11),
@edad int,
@sexo char(1),
@telef char(9),
@direc varchar(50)
as
insert into clientes
values (@codigo,@nombre,@apellido,@dni,@ruc,@edad,@sexo,@telef,@direc)
go

create proc sp_editar_clientes
@codigo varchar(10),
@nombre varchar(20),
@apellido varchar (20),
@dni int,
@ruc varchar(11),
@edad int,
@sexo char(1),
@telef char(9),
@direc varchar(50)
as
update clientes set nombre=@nombre, apellidos=@apellido,dni=@dni,ruc=@ruc,edad=@edad,sexo=@sexo,telefono=@telef,direccion=@direc
where idcliente=@codigo
go


create proc sp_eliminar_cliente
@codigo varchar(10)
as
delete from clientes where idcliente=@codigo
go


create proc sp_buscar_cliente
@dni varchar(8)
as
select * from clientes where dni like @dni+'%'
go

select * from clientes



create proc sp_listar_proveedor
as
select * from proveedor
go

create proc sp_guardar_proveedor
@codigo varchar(10),
@razon varchar(30),
@ruc varchar(11),
@telef varchar(9),
@direc varchar(50)
as 
insert into proveedor values(@codigo,@razon,@ruc,@telef,@direc)
go


create proc sp_editar_proveedor
@codigo varchar(10),
@razon varchar(30),
@ruc varchar(11),
@telef varchar(9),
@direc varchar(50)
as 
update proveedor set razonsocial=@razon,ruc=@ruc,telefono=@telef,direccion=@direc
where idproveedor=@codigo
go

create proc sp_eliminar_proveedor
@codigo varchar(10)
as
delete from proveedor where idproveedor=@codigo
go

create proc sp_buscar_proveedor
@nombre varchar(30)
as
select*from proveedor where razonsocial like @nombre+'%'

go



create proc RegistrarCategoria
@descripcion varchar(15)
as
insert into categoria values (@descripcion)
go




select * from categoria

create proc sp_listar_producto
@nombre varchar(30)
as
select productos.idproducto, productos.serie, productos.nombre, 
productos.f_ingreso, productos.f_vencimiento, productos.prec_compra,
productos.prec_venta, productos.cantidad,
productos.idcategoria, categoria.descripcion AS categ 
from categoria INNER JOIN productos on categoria.idcategoria=productos.idcategoria
where nombre like @nombre+'%'
order by idcategoria
go

--drop procedure sp_guardar_producto

create proc sp_guardar_producto
@codigo varchar(10),
@serie varchar(10),
@nombre varchar(30),
@fecha_ingre varchar(15),
@fecha_cadu varchar(15),
@prec_compra decimal(9,2),
@prec_venta decimal(9,2),
--@cant int,
@categoria int
as
insert into productos
values(@codigo,@serie,@nombre,@fecha_ingre,@fecha_cadu,@prec_compra,@prec_venta,0,@categoria)
go


create proc sp_editar_producto
@codigo varchar(10),
@serie varchar(10),
@nombre varchar(30),
@fecha_ingre varchar(15),
@fecha_cadu varchar(15),
@prec_compra decimal(9,2),
@prec_venta decimal(9,2),
@categoria int
as

update productos set serie=@serie,nombre=@nombre,f_ingreso=@fecha_ingre,f_vencimiento=@fecha_cadu,
prec_compra=@prec_compra,prec_venta=@prec_venta,idcategoria=@categoria
where idproducto=@codigo
go


create proc sp_eliminar_producto
@codigo varchar(10)
as
delete from productos where idproducto=@codigo
go





create proc sp_listar_categoria
as
select * from categoria
go



create proc sp_listar_empleados
as 
select * from empleados
go


create proc sp_guardar_empleados
@idempleado varchar(5),
@nombre varchar(20),
@apellido varchar(20),
@dni varchar(8),
@telef varchar(9),
@direc varchar(50)
as
insert into empleados values(@idempleado,@nombre,@apellido,@dni,@telef,@direc)
go

create proc sp_editar_empleados
@idempleado varchar(5),
@nombre varchar(20),
@apellido varchar(20),
@dni varchar(8),
@telef varchar(9),
@direc varchar(50)
as
update empleados set nombre=@nombre,apellidos=@apellido,dni=@dni,telefono=@telef,direccion=@direc
where idempleado=@idempleado
go


create proc sp_eliminar_empleados
@idempleado varchar(5)
as
delete from empleados where idempleado=@idempleado
go


create proc sp_buscar_empleado
@dni varchar(8)
as
select*from empleados where dni like @dni+'%'
go



create proc sp_listar_usuario
@usuario varchar(20)
as
select usuarios.idusuario,usuarios.idempleado,empleados.nombre,
empleados.apellidos,usuarios.usuario,usuarios.pass,usuarios.acceso,
usuarios.estado from usuarios INNER JOIN empleados
on usuarios.idempleado=empleados.idempleado
where usuario like @usuario+'%'
go

create proc sp_guardar_usuarios
@idempleado varchar(5),
@usuario varchar(20),
@password varchar(20),
@acceso varchar(20),
@estado char(2)
as
insert into usuarios values(@idempleado,@usuario,@password,@acceso,@estado)
go

create proc sp_editar_usuarios
@idempleado varchar(5),
@usuario varchar(20),
@password varchar(20),
@acceso varchar(20),
@estado char(2)
as

update usuarios set usuario=@usuario,pass=@password,acceso=@acceso,estado=@estado
where idempleado=@idempleado
go

create proc sp_eliminar_usuarios
@idusuario int
as
delete from usuarios where idusuario=@idusuario
go



create proc sp_sesion
@usuario varchar(20),
@password varchar(20)
as
select usuarios.idusuario, usuarios.idempleado as idemple,
empleados.nombre as nombre, empleados.apellidos as apellidos,
usuarios.usuario,usuarios.pass,usuarios.acceso,usuarios.estado
from usuarios INNER JOIN empleados
on usuarios.idempleado = empleados.idempleado
where usuario=@usuario and pass=@password and estado='SI'
go
 
 
 create proc sp_listar_compras
 as
 select compras.idcompra,proveedor.razonsocial,compras.fecha,empleados.nombre+' '+empleados.apellidos,
 compras.tipo_documento,compras.num_documento,compras.estado,compras.subtotal,
 compras.igv,compras.total from compras INNER JOIN proveedor
 on compras.idproveedor=proveedor.idproveedor INNER JOIN usuarios
 on compras.idusuario=usuarios.idusuario INNER JOIN empleados
 on usuarios.idempleado = empleados.idempleado
 go


 create proc sp_guardar_compra
 @fecha varchar(10),
 @hora varchar(10),
 @num_documento varchar (7),
 @tipo_documento varchar (7),
 @subtotal decimal(8,2),
 @igv decimal (8,2),
 @total decimal (8,2),
 @estado varchar(20),
 @idusuario int,
 @idproveedor varchar(10)
 as
 insert into compras
 values(@fecha,@hora,@num_documento,@tipo_documento,@subtotal,@igv,@total,@estado,@idusuario,@idproveedor)
 go

 

 create proc sp_listar_detalle_compra
 @idcompra int
 as
 select detalle_compras.iddetallecompra,detalle_compras.idcompra,
 productos.nombre,detalle_compras.cantidad,
 productos.prec_compra,detalle_compras.total
 from detalle_compras INNER JOIN productos
 on detalle_compras.idproducto = productos.idproducto
 where idcompra=@idcompra
 go


 create proc sp_guardar_detalle_compras
 @idcompra int,
 @idproducto varchar(10),
 @cantidad int,
 @precio decimal(8,2),
 @total decimal(8,2)
 as
 insert into detalle_compras values(@idcompra,@idproducto,@cantidad,@precio,@total)
 go







 create proc sp_listar_ventas
 as
 select ventas.idventa,clientes.nombre+'   '+ clientes.apellidos,
 ventas.fecha,empleados.nombre+' '+empleados.apellidos,ventas.tipo_documento,
 ventas.num_documento,ventas.estado,ventas.subtotal,ventas.igv,ventas.total
 from ventas INNER JOIN clientes
 on ventas.idcliente= clientes.idcliente INNER JOIN usuarios
 on ventas.idusuario=usuarios.idusuario INNER JOIN empleados
 on usuarios.idempleado= empleados.idempleado
 go

 create proc sp_guardar_venta
 @fecha varchar(10),
 @hora varchar(10),
 @serie varchar(7),
 @num_documento varchar(7),
 @tipo_documento varchar(7),
 @subtotal decimal(8,2),
 @igv decimal (8,2),
 @total decimal(8,2),
 @estado varchar(20),
 @idusuario int,
 @idcliente varchar(10)
 as
 insert into ventas
 values (@fecha,@hora,@serie,@num_documento,@tipo_documento,@subtotal,@igv,@total,@estado,@idusuario,@idcliente)
 go


 create proc sp_listar_detalle_venta
 @idventa int
 as
 select detalle_ventas.idventa,productos.idproducto,productos.nombre,
 detalle_ventas.cantidad,productos.prec_venta,detalle_ventas.total
 from detalle_ventas INNER JOIN productos
 on detalle_ventas.idproducto= productos.idproducto
 where idventa=@idventa
 go


 create proc sp_guardar_detalle_venta
 @idventa int,
 @idproducto varchar(10),
 @cant int,
 @precio decimal (8,2),
 @total decimal (8,2)
 as
 insert into detalle_ventas
 values(@idventa,@idproducto,@cant,@precio,@total)
 go


 --====================agregar empleado para inicio de sesion========================
select * from empleados

insert into empleados values('0001','Carlos', 'Vera Ruiz','6543213','954323212','AV.TUPAC AMARU-LOS OLIVOS')
--agregar usuarios
insert into usuarios values('0001','cvera','1234','Administrador','SI')



























CREATE TABLE usuario (
id_usuario INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(30),
apodo VARCHAR(30),
email VARCHAR(50),
contraseña VARCHAR (50),
apodo_steam VARCHAR (50));

CREATE TABLE videojuego(
id_videojuego INT AUTO_INCREMENT PRIMARY KEY,
titulo VARCHAR(30));

CREATE TABLE party(
id_party INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(30),
titulo VARCHAR(30),
id_usuario INT,
id_videojuego INT,
FOREIGN KEY (id_usuario)
REFERENCES usuario (id_usuario)
ON DELETE SET NULL
ON UPDATE CASCADE,
FOREIGN KEY (id_videojuego)
REFERENCES videojuego (id_videojuego)
ON DELETE SET NULL
ON UPDATE CASCADE);

CREATE TABLE miembro (
id_usuario INT,
id_party INT,
PRIMARY KEY (id_usuario, id_party),
FOREIGN KEY (id_usuario)
REFERENCES usuario (id_usuario)
ON DELETE CASCADE
ON UPDATE CASCADE,
FOREIGN KEY (id_party)
REFERENCES party (id_party)
ON DELETE CASCADE
ON UPDATE CASCADE); 

CREATE TABLE  mensaje(
id_mensaje INT AUTO_INCREMENT PRIMARY KEY,
mensaje TEXT,
fecha DATETIME,
id_usuario INT,
id_party INT,
FOREIGN KEY (id_usuario)
REFERENCES usuario (id_usuario)
ON DELETE SET NULL
ON UPDATE CASCADE,
FOREIGN KEY (id_party)
REFERENCES party (id_party)
ON DELETE SET NULL
ON UPDATE CASCADE); 





/*============ENTITY TABLES=============*/

/*Users*/
insert into users(id, nome, cognome ) values('1000','admin','admin');
insert into users(id, nome, cognome ) values('1001','user','user');

/*Credentials (le password sono: "password". Esse sono realizzate tramite il metodo encode della classe BCryptPasswordEncoder)*/
insert into credentials(id, password, role, username, user_id ) values('2000', '$2a$10$H90gDy3sDjHh64GqNIimseg0wifDVWpLpDednMiqWAUSae5SLwvzO' ,'ADMIN','admin', '1000');
insert into credentials(id, password, role, username, user_id ) values('2001', '$2a$10$H90gDy3sDjHh64GqNIimseg0wifDVWpLpDednMiqWAUSae5SLwvzO' ,'USER','user', '1001');

/*Chef*/
insert into chef(id, cognome, nazionalita, nome) values('100', 'Shapi', 'Giapponese', 'Sughi');
insert into chef(id, cognome, nazionalita, nome) values('101', 'Potato', 'Inglese', 'John');
insert into chef(id, cognome, nazionalita, nome) values('102', 'Ratatouille', 'Francese', 'Jean Jacques');
insert into chef(id, cognome, nazionalita, nome) values('103', 'Pi a din', 'Marocchina', 'Ahmed');
insert into chef(id, cognome, nazionalita, nome) values('104', 'Tortilla', 'Spagnola', 'Fernando');

/*Buffet*/

insert into buffet(id, categoria, descrizione, nome, chef_id) values('200', 'carnivoro','Gran buffet di carne', 'Grand viande', '101');
insert into buffet(id, categoria, descrizione, nome, chef_id) values('201', 'vegano','Gran buffet di verdure', 'OK', '102');
insert into buffet(id, categoria, descrizione, nome, chef_id) values('202', 'onnivoro','Gran buffet variegato', 'Mix', '103');
insert into buffet(id, categoria, descrizione, nome, chef_id) values('203', 'onnivoro','Gran buffet di pesce', 'Osaka Fish', '100');
insert into buffet(id, categoria, descrizione, nome, chef_id) values('204', 'carnivoro','Gran buffet variegato', 'Meater', '101');
insert into buffet(id, categoria, descrizione, nome, chef_id) values('205', 'vegetariano','Gran buffet vegetariano', 'VegOK', '104');


/*Piatto*/
insert into piatto(id, descrizione, nome) values('300', 'la migliore bistecca che potrai mai mangiare', 'Bistecca ai ferri');
insert into piatto(id, descrizione, nome) values('301', 'una pasta', 'Pasta in bianco');
insert into piatto(id, descrizione, nome) values('302', 'polpette molto buone', 'Polpette di ceci e curcuma');
insert into piatto(id, descrizione, nome) values('303', 'Dessert di riso soffiato', 'Budino di riso');
insert into piatto(id, descrizione, nome) values('304', 'Ottima ricciola, non troppo salata', 'Ricciola in crosta di sale');

/*Ingrediente*/

insert into ingrediente(id, nome, origine, descrizione) values('400', 'Scottona', 'Toscana', 'la miglior carne di vacca');
insert into ingrediente(id, nome, origine, descrizione) values('401', 'Sale', 'Ceccano', 'Sale delle famose saline');
insert into ingrediente(id, nome, origine, descrizione) values('402', 'Pepe nero di Sarawak', 'Malesia', 'Un fantastico pepe');
insert into ingrediente(id, nome, origine, descrizione) values('403', 'Verdura', 'Ceccano', 'Orto a km zero');
insert into ingrediente(id, nome, origine, descrizione) values('404', 'Ricciola', 'Mar Adriatico', 'Del peschereccio');
insert into ingrediente(id, nome, origine, descrizione) values('405', 'Pasta', 'Canada', 'Farine extraeuropee');
insert into ingrediente(id, nome, origine, descrizione) values('406', 'Riso', 'Cina', 'Della tipologia basmati');

/*============JOIN TABLES=============*/

/*chef_buffets*/
insert into chef_buffets(chef_id, buffets_id) values('101', '200');
insert into chef_buffets(chef_id, buffets_id) values('102', '201');
insert into chef_buffets(chef_id, buffets_id) values('103', '202');
insert into chef_buffets(chef_id, buffets_id) values('100', '203');
insert into chef_buffets(chef_id, buffets_id) values('101', '204');
insert into chef_buffets(chef_id, buffets_id) values('104', '205');

/*buffet_piatti*/
insert into buffet_piatti(buffet_id, piatti_id) values('200','300');
insert into buffet_piatti(buffet_id, piatti_id) values('201','302');
insert into buffet_piatti(buffet_id, piatti_id) values('202','303');
insert into buffet_piatti(buffet_id, piatti_id) values('203','304');
insert into buffet_piatti(buffet_id, piatti_id) values('205','301');


/*piatto_ingredienti*/

insert into piatto_ingredienti(piatto_id, ingredienti_id) values('300', '400');
insert into piatto_ingredienti(piatto_id, ingredienti_id) values('301', '405');
insert into piatto_ingredienti(piatto_id, ingredienti_id) values('302', '403');
insert into piatto_ingredienti(piatto_id, ingredienti_id) values('303', '406');
insert into piatto_ingredienti(piatto_id, ingredienti_id) values('304', '404');

# This project is built with VS Code. To test and run use VS Code.

## Gergely Vamosi

## Feel free to use and redistribute.

Database sample data:

(Cassandra)

CREATE TABLE account(    id timeuuid PRIMARY KEY,    number text,    owner text,    balance decimal );

insert into account (id, NUMBER, owner) values (now(), '123456789', 'Keri Lee');
insert into account (id, NUMBER, owner) values (now(), '123456001', 'Dollie R. Schnidt');
insert into account (id, NUMBER, owner) values (now(), '123456002', 'Cornelia J. LeClerc');
insert into account (id, NUMBER, owner) values (now(), '123456003', 'Cynthia Rau');
insert into account (id, NUMBER, owner) values (now(), '123456004', 'Douglas R. Cobbs');
insert into account (id, NUMBER, owner) values (now(), '123456005', 'Michael Patel');
insert into account (id, NUMBER, owner) values (now(), '123456006', 'Suzanne Wong');
insert into account (id, NUMBER, owner) values (now(), '123456007', 'Ivan C. Jaya');
insert into account (id, NUMBER, owner) values (now(), '123456008', 'Ida Ketterer');
insert into account (id, NUMBER, owner) values (now(), '123456009', 'Laina Ochoa Lucero');
insert into account (id, NUMBER, owner) values (now(), '123456010', 'Wesley M. Montana');
insert into account (id, NUMBER, owner) values (now(), '123456011', 'Leslie F. McCleary');
insert into account (id, NUMBER, owner) values (now(), '123456012', 'Sayeed D. Mudra');
insert into account (id, NUMBER, owner) values (now(), '123456013', 'Pietronella J. Domingo');
insert into account (id, NUMBER, owner) values (now(), '123456014', 'John S. O''Leary');
insert into account (id, NUMBER, owner) values (now(), '123456015', 'Gladys D. Smith');
insert into account (id, NUMBER, owner) values (now(), '123456016', 'Sally O. Thygesen');
insert into account (id, NUMBER, owner) values (now(), '123456017', 'Rachel Vogt');
insert into account (id, NUMBER, owner) values (now(), '123456018', 'Julia DeLong');
insert into account (id, NUMBER, owner) values (now(), '123456019', 'Mark T. Rizzoli');
insert into account (id, NUMBER, owner) values (now(), '123456020', 'Maria J. Angelo');

CREATE CUSTOM INDEX idx_owner ON gergelyvamosi.account (owner) USING 'org.apache.cassandra.index.sasi.SASIIndex' WITH OPTIONS = { 'mode': 'CONTAINS', 'analyzer_class': 'org.apache.cassandra.index.sasi.analyzer.NonTokenizingAnalyzer', 'case_sensitive': 'false'};
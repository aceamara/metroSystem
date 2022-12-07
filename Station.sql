create database MetroStation;
use MetroStation;

create table Station(
stationId int primary key,
stationName varchar(20) not null);

insert into Station
values(1, "Paddington"),
(2, "King’s Cross"),
(3, "Waterloo"),
(4, "London Bridge"),
(5, "Charing Cross");
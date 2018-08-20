--Adresa
INSERT INTO adresa (broj,drzava,grad,ulica) values ('92','Srbija','Vrbas','Marsala Tita');
INSERT INTO adresa (broj,drzava,grad,ulica) values ('79','Srbija','Novi Sad','Bulevar cara Lazara');
INSERT INTO adresa (broj,drzava,grad,ulica) values ('10','Srbija','Beograd','Vladimira Popovica');
INSERT INTO adresa (broj,drzava,grad,ulica) values ('58','Crna Gora','Herceg Novi','Save Kovacevica');
INSERT INTO adresa (broj,drzava,grad,ulica) values ('322','Crna Gora','Kotor','Old town');

--Smestaj
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip) 
values ('1','Vrbas','Hotel Backa','2','Jedini hotel u Vrbasu','Hotel');
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip) 
values ('4','Novi Sad','Hotel Aleksandar','2','Najlepsi hotel u Novom Sadu','Hotel');
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip) 
values ('5','Beograd','Crowne Plaza','2','Jedan od najluksuznijih hotela u Srbiji','Hotel');
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip) 
values ('3','Herceg Novi','Plaza','4','Hotel u Herceg Novom','Hotel');
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip) 
values ('4','Kotor','Astoria','5','Jedini od najlepsih hotela u Crnoj Gori','Hotel');
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip) 
values ('5','Madrid','InterContinental','5','Jedan od najboljih hotela u Madridu','Hotel');

--Ponuda
INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_id) values ('2018-08-15','1','3500','2018-08-10','1');
INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_id) values ('2018-08-25','3','11000','2018-08-15','2');
INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_id) values ('2018-09-1','2','7500','2018-08-25','3');
INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_id) values ('2018-08-26','4','13000','2018-08-16','4');
INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_id) values ('2018-08-25','2','9600','2018-08-17','5');
INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_id) values ('2018-08-20','2','8500','2018-08-18','6');


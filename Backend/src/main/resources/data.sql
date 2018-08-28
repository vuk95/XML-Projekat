-- KORISNICI
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen) VALUES ('RegistrovaniKorisnik','pera@gmail.com','Petar','password','Peric',0);
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen) VALUES ('Admin','admin@gmail.com','Stole','password','Markovic',0);
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen,poslovni_maticni_broj) VALUES ('Agent','ana@gmail.com','Ana','password','Ivanovic',0,'02357483342');

--Smestaj
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip, parking, wifi, dorucak, polupansion, pansion, tv, kuhinja, kupatilo) 
values ('1','Vrbas','Hotel Backa','2','Jedini hotel u Vrbasu','Hotel', 1, 1, 1, 0, 0, 1, 1, 0);
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip, parking, wifi, dorucak, polupansion, pansion, tv, kuhinja, kupatilo) 
values ('4','Novi Sad','Hotel Aleksandar','2','Najlepsi hotel u Novom Sadu','Hotel',1, 1, 1, 0, 0, 1, 1, 0);
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip, parking, wifi, dorucak, polupansion, pansion, tv, kuhinja, kupatilo) 
values ('5','Beograd','Crowne Plaza','2','Jedan od najluksuznijih hotela u Srbiji','Hotel',1, 1, 1, 1, 1, 1, 1, 0);
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip, parking, wifi, dorucak, polupansion, pansion, tv, kuhinja, kupatilo) 
values ('3','Herceg Novi','Plaza','4','Hotel u Herceg Novom','Hotel',1, 1, 1, 1, 1, 1, 1, 0);
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip, parking, wifi, dorucak, polupansion, pansion, tv, kuhinja, kupatilo) 
values ('4','Kotor','Astoria','5','Jedini od najlepsih hotela u Crnoj Gori','Hotel', 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip, parking, wifi, dorucak, polupansion, pansion, tv, kuhinja, kupatilo) 
values ('5','Madrid','InterContinental','4','Jedan od najboljih hotela u Madridu','Hotel', 1, 1, 1, 0, 0, 1, 1, 0);

--Ovde nesto kenja za smestaj_id
--Ponuda
--INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_id) values ('2018-08-15','1','3500','2018-08-10',1);
--INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_id) values ('2018-08-25','3','11000','2018-08-15',2);
--INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_id) values ('2018-09-1','2','7500','2018-08-25',3);
--INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_id) values ('2018-08-26','4','13000','2018-08-16',4);
--INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_id) values ('2018-08-25','2','9600','2018-08-17',5);
--INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_id) values ('2018-08-20','2','8500','2018-08-18',6);


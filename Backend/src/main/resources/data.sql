-- KORISNICI
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen) VALUES ('RegistrovaniKorisnik','pera@gmail.com','Petar','password','Peric',0);
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen) VALUES ('RegistrovaniKorisnik','jovan352@gmail.com','Jovan','password','Jovanovic',0);
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen) VALUES ('RegistrovaniKorisnik','sale22@gmail.com','Sasa','password','Ilic',0);
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen) VALUES ('RegistrovaniKorisnik','ricardo@gmail.com','Rikardo','password','Gomes',0);
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen) VALUES ('RegistrovaniKorisnik','zakaric@gmail.com','Goran','password','Zakaric',0);
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen) VALUES ('RegistrovaniKorisnik','daca10@gmail.com','Danilo','password','Pantic',0);
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen) VALUES ('RegistrovaniKorisnik','djerlek_armin@gmail.com','Armin','password','Djerlek',0);
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen) VALUES ('RegistrovaniKorisnik','vule85@gmail.com','Miroslav','password','Vulicevic',1);
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen) VALUES ('RegistrovaniKorisnik','23vanja@gmail.com','Vanja','password','Marinkovic',0);
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen) VALUES ('RegistrovaniKorisnik','mihajlo_andr@gmail.com','Mihajlo','password','Andric',1);
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen) VALUES ('RegistrovaniKorisnik','novica12ubica@gmail.com','Novica','password','Velickovic',0);

INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen) VALUES ('Admin','admin@gmail.com','Stole','password','Markovic',0);
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen,poslovni_maticni_broj) VALUES ('Agent','ana@gmail.com','Ana','password','Ivanovic',0,'02357483340');
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen,poslovni_maticni_broj) VALUES ('Agent','jokernolo@gmail.com','Novak','nolo','Djokovic',0,'02357483341');
INSERT INTO korisnik(dtype,email,ime,lozinka,prezime,zabranjen,poslovni_maticni_broj) VALUES ('Agent','stefanmilovic2@gmail.com','Stefan','sm22','Milovic',0,'02357483342');
--Smestaj
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip, parking, wifi, dorucak, polupansion, pansion, tv, kuhinja, kupatilo,agent_id) 
values ('1','Vrbas','Hotel Backa','2','Jedini hotel u Vrbasu','Hotel', 1, 1, 1, 0, 0, 1, 1, 0,13);
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip, parking, wifi, dorucak, polupansion, pansion, tv, kuhinja, kupatilo,agent_id) 
values ('4','Novi Sad','Hotel Aleksandar','2','Najlepsi hotel u Novom Sadu','Hotel',1, 1, 1, 0, 0, 1, 1, 0,14);
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip, parking, wifi, dorucak, polupansion, pansion, tv, kuhinja, kupatilo,agent_id) 
values ('5','Beograd','Crowne Plaza','2','Jedan od najluksuznijih hotela u Srbiji','Hotel',1, 1, 1, 1, 1, 1, 1, 0,15);
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip, parking, wifi, dorucak, polupansion, pansion, tv, kuhinja, kupatilo,agent_id) 
values ('3','Herceg Novi','Plaza','4','Hotel u Herceg Novom','Hotel',1, 1, 1, 1, 1, 1, 1, 0,13);
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip, parking, wifi, dorucak, polupansion, pansion, tv, kuhinja, kupatilo,agent_id) 
values ('4','Kotor','Astoria','5','Jedan od najlepsih hotela u Crnoj Gori','Hotel', 1, 1, 1, 1, 1, 1, 1, 1,15);
INSERT INTO smestaj (kategorija,lokacija,naziv,ocena,opis,tip, parking, wifi, dorucak, polupansion, pansion, tv, kuhinja, kupatilo,agent_id) 
values ('5','Madrid','InterContinental','4','Jedan od najboljih hotela u Madridu','Hotel', 1, 1, 1, 0, 0, 1, 1, 0,14);

--Ponuda
INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_smestaj_id) values ('2018-08-15','1','3500','2018-08-10',1);
INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_smestaj_id) values ('2018-08-25','3','11000','2018-08-15',2);
INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_smestaj_id) values ('2018-09-1','2','7500','2018-08-25',3);
INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_smestaj_id) values ('2018-08-26','4','13000','2018-08-16',4);
INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_smestaj_id) values ('2018-08-25','2','9600','2018-08-17',5);
INSERT INTO ponuda (do_datuma,broj_kreveta,cena,od,smestaj_smestaj_id) values ('2018-08-20','2','8500','2018-08-18',6);

--KOMENTARI
INSERT INTO komentar (odobren,sadrzaj,registrovani_korisnik_id,smestaj_smestaj_id) VALUES (false,'Pogled je prelep.',2,4);
INSERT INTO komentar (odobren,sadrzaj,registrovani_korisnik_id,smestaj_smestaj_id) VALUES (false,'Stvarno je jedan od najboljih hotela u Madridu! :).',3,6);
INSERT INTO komentar (odobren,sadrzaj,registrovani_korisnik_id,smestaj_smestaj_id) VALUES (false,'Usluga je katastrofalna.',8,1);
INSERT INTO komentar (odobren,sadrzaj,registrovani_korisnik_id,smestaj_smestaj_id) VALUES (true,'Prosecan',5,1);
INSERT INTO komentar (odobren,sadrzaj,registrovani_korisnik_id,smestaj_smestaj_id) VALUES (false,'Hrana je solidna',6,5);

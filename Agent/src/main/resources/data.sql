insert into adresa(drzava, grad, ulica, broj) values ("Srbija", "Novi Sad", "Cara Dusana", 82)

insert into agent(ime, prezime, email, lozinka, adresa_id, poslovni_maticni_broj) values ("Pera", "Peric", "pera@pera.com", "pera", 1, "123")

insert into smestaj(agent_id, adresa_id, kategorija, tip, opis, slika, ocena, ponuda_id) values (1, 1, 2, "stan", "jednoiposobni", "slika", 4, null)
USE sys;

DROP TABLE IF EXISTS interns;
DROP TABLE IF EXISTS tutors;

CREATE TABLE tutors (
                        id INT NOT NULL AUTO_INCREMENT,
                        name VARCHAR(50) NOT NULL,
                        username VARCHAR(50) NOT NULL,
                        password VARCHAR(50) NOT NULL,
                        primary key (id)
);

CREATE TABLE interns (
                         id INT NOT NULL AUTO_INCREMENT,
                         firstname VARCHAR(50) NOT NULL,
                         lastname VARCHAR(50) NOT NULL,
                         username VARCHAR(50) NOT NULL,
                         email VARCHAR(50) NOT NULL,
                         groupe VARCHAR(50) NOT NULL,
                         debut_stage DATE NOT NULL,
                         fin_stage DATE NOT NULL,
                         entreprise VARCHAR(50) NOT NULL,
                         maitre_de_stage VARCHAR(50) NOT NULL,
                         adresse_stage VARCHAR(50) NOT NULL,
                         cahier_des_charges boolean NOT NULL,
                         fiche_visite boolean NOT NULL,
                         fiche_evaluation boolean NOT NULL,
                         sondage_web boolean NOT NULL,
                         rapport_rendu boolean NOT NULL,
                         soutenance boolean NOT NULL,
                         visite_planifiee boolean NOT NULL,
                         visite_faite boolean NOT NULL,
                         note_tech float,
                         note_com float,
                         id_tutor int NOT NULL,
                         PRIMARY KEY (id),
                         FOREIGN KEY (id_tutor) REFERENCES tutors(id)
);


INSERT INTO tutors (name, username, password) VALUES
	('Dark Vador', 'dark_vador', 'darkpassword'),
	('Darth Maul', 'darth_maul', 'darthpassword'),
	('Darth Sidious', 'darth_sidious', 'sidiouspassword'),
	('Test admin', 'a', 'a');

INSERT INTO interns (firstname, lastname, username, email, groupe, debut_stage, fin_stage, entreprise, maitre_de_stage, adresse_stage, cahier_des_charges, fiche_visite, fiche_evaluation, sondage_web, rapport_rendu, soutenance, visite_planifiee, visite_faite, note_tech, note_com, id_tutor) VALUES
	('Ronald', 'Weasley', 'ronald_weasley', 'ronald.weasley@example.com', 'M1', '2022-10-31', '2023-03-31', 'Societe Generale', 'Chouquette', 'Cabine dHagrid', true , false, true, false, true, false, true, false, null, null, 1),
	('Luna', 'Lovegood', 'luna_lovegood', 'luna.lovegood@example.com', 'M2', '2023-04-03', '2023-09-30', 'Credit Agricole', 'Baguette', '12, square Grimmaurd', true, true, true, true, true, true, true, true, 15, 5, 1),
	('Albus', 'Dumbledore', 'albus_dumbledore', 'Albus.dumbledore@example.com', 'M1', '2022-10-31', '2023-03-31', 'Thales', 'Soupe', 'Maison des Lovegood', true , false, true, false, false, true, false, false, null, null, 1),
	('Harry', 'Potter', 'harry_potter', 'harry.potter@example.com', 'M2', '2023-04-03', '2023-09-30', 'BNP Paribas', 'Crouton', 'Manoir des Malefoy', true, true, true, true, true, true, true, true, 0, 5, 2),
	('Ginny', 'Weasley', 'ginny_weasley', 'ginny.weasley@example.com', 'M2', '2023-02-28', '2023-08-31', 'Weasleys Wizard Wheezes', 'Pain au chocolat', 'Burrow', true, false, true, false, true, false, true, false, null, null, 2),
	('Draco', 'Malfoy', 'draco_malfoy', 'draco.malfoy@example.com', 'M1', '2023-06-30', '2023-12-31', 'Manoir Malefoy', 'Croissant aux amandes', 'Salle commune de Serpentard', true, false, true, false, true, false, true, false, null, null, 4),
	('Cho', 'Chang', 'cho_chang', 'cho.chang@example.com', 'M1', '2023-04-30', '2023-10-31', 'Magasin de baguettes Ollivander', 'Croissant', 'Salle commune de Serdaigle', true, false, true, false, true, false, true, false, null, null, 4),
	('Cedric', 'Diggory', 'cedric_diggory', 'cedric.diggory@example.com', 'M2', '2023-07-31', '2024-01-31', 'Boutique des accessoires de Quidditch', 'Pain au raisin', 'Salle commune de Poufsouffle', true, true, true, true, true, true, true, true, 20, 20, 4),
	('Fleur', 'Delacour', 'fleur_delacour', 'fleur.delacour@example.com', 'M1', '2023-06-30', '2023-12-31', 'Boutique de vêtements de Madame Guipure', 'Croissant', 'Dortoir de Beauxbâtons', true, false, true, false, true, false, true, false, null, null, 4),
	('Nymphadora', 'Tonks', 'nymphadora_tonks', 'nymphadora.tonks@example.com', 'M2', '2023-09-30', '2024-03-31', 'Département de la justice magique', 'Pain au chocolat', 'Dortoir de Ordre du Phénix', true, false, true, false, true, false, true, false, null, null, 4),
	('Minerva', 'McGonagall', 'minerva_mcgonagall', 'minerva.mcgonagall@example.com', 'M1', '2023-01-31', '2023-07-31', 'École de sorcellerie de Poudlard', 'Scone', 'Bureau de la directrice de Gryffondor', true, false, true, false, true, false, true, false, null, null, 4),
	('Sirius', 'Black', 'sirius_black', 'sirius.black@example.com', 'M1', '2023-06-30', '2023-12-31', '12, square Grimmaurd', 'Croissant', 'La Chambre des Secrets', true, false, true, false, true, false, true, false, null, null, 4),
	('Remus', 'Lupin', 'remus_lupin', 'remus.lupin@example.com', 'M1', '2023-08-31', '2024-02-29', 'Ordre du Phénix', 'Pain au chocolat', 'Cabane de Hagrid', true, false, true, false, true, false, true, false, null, null, 4),
	('Neville', 'Londubat', 'neville_londubat', 'neville.londubat@example.com', 'M2', '2023-09-30', '2024-03-31', 'Herboristerie de Fleury et Bott', 'Pain au chocolat', 'Salle commune de Gryffondor',true, true, true, true, true, true, true, true, 20, 8, 4),
	('Dobby', 'Elf', 'dobby_elf', 'dobby.elf@example.com', 'M2', '2023-02-28', '2023-08-31', 'Maison de la famille Malfoy', 'Pain aux raisins', 'Chambre de Harry Potter', true, false, true, false, true, false, true, false, null, null, 4),
	('Hermione', 'Granger', 'hermione_granger', 'hermione.granger@example.com', 'M2', '2023-04-03', '2023-09-30', 'LCL', 'Croissant', 'Impasse du Tisseur',true, true, true, true, true, true, true, true, 20, 20, 4);
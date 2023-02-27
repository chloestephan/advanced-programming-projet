USE sys;

DROP TABLE IF EXISTS interns;
DROP TABLE IF EXISTS tutors;
DROP TABLE IF EXISTS association_tutor_interns;

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
                         PRIMARY KEY (id)
);

CREATE TABLE tutors (
                        id INT NOT NULL AUTO_INCREMENT,
                        name VARCHAR(50) NOT NULL,
                        username VARCHAR(50) NOT NULL,
                        password VARCHAR(50) NOT NULL,
                        primary key (id)
);

CREATE TABLE association_tutor_interns
(
    id INT NOT NULL AUTO_INCREMENT,
    id_tutor INT NOT NULL,
    id_intern INT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO interns (firstname, lastname, username, email, groupe, debut_stage, fin_stage, entreprise, maitre_de_stage, adresse_stage, cahier_des_charges, fiche_visite, fiche_evaluation, sondage_web, rapport_rendu, soutenance, visite_planifiee, visite_faite) VALUES
	('Ronald', 'Weasley', 'ronald_weasley', 'ronald.weasley@example.com', 'M1', '2022-10-31', '2023-03-31', 'Societe Generale', 'Chouquette', 'Cabine dHagrid', true , false, true, false, true, false, true, false),
	('Luna', 'Lovegood', 'luna_lovegood', 'luna.lovegood@example.com', 'M2', '2023-04-03', '2023-09-30', 'Credit Agricole', 'Baguette', '12, square Grimmaurd', true , false, false, false, false, false, false, false),
	('Albus', 'Dumbledore', 'albus_dumbledore', 'Albus.dumbledore@example.com', 'M1', '2022-10-31', '2023-03-31', 'Thales', 'Soupe', 'Maison des Lovegood', true , false, false, false, false, false, false, false),
	('Harry', 'Potter', 'harry_potter', 'harry.potter@example.com', 'M2', '2023-04-03', '2023-09-30', 'BNP Paribas', 'Crouton', 'Manoir des Malefoy', true , false, false, false, false, false, false, false),
	('Hermione', 'Granger', 'hermione_granger', 'hermione.granger@example.com', 'M2', '2023-04-03', '2023-09-30', 'LCL', 'Croissant', 'Impasse du Tisseur', true , true, true, true, false, false, false, false);

INSERT INTO tutors (name, username, password) VALUES
	('Dark Vador', 'dark_vador', 'darkpassword'),
	('Darth Maul', 'darth_maul', 'darthpassword'),
	('Darth Sidious', 'darth_sidious', 'sidiouspassword'),
    ('Test admin', 'a', 'a');

INSERT INTO association_tutor_interns (id_tutor, id_intern) VALUES
	('1', '1'),
    ('1', '2'),
	('1', '3'),
    ('2', '4'),
    ('2', '5'),
	('4', '1'),
    ('4', '2'),
	('4', '3');
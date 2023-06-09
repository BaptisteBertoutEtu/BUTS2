-- Auteur:
-- BERTOUT Baptiste
-- LAWSON Killian


--Suppression des tables déjà existantes :
DROP TABLE import;
DROP TABLE participe;
DROP TABLE athlete;
DROP TABLE competition;
DROP TABLE equipe;
DROP TABLE regions;


-- Création de la table import
CREATE TABLE import (
    id integer,
    name TEXT,
    sex CHAR(1),
    age CHAR(2),
    height TEXT,
    weight TEXT,
    team TEXT,
    noc CHAR(3),
    games TEXT,
    year integer,
    season CHAR(6),
    city TEXT,
    sport TEXT,
    event TEXT,
    medal CHAR(6)
);

-- Création de la table regions
CREATE TABLE regions (
    noc CHAR(3),
    region TEXT,
    notes TEXT
);



--Pour copier le contenu du fichier athlete_events.csv et le contenu du fichier noc_regions.csv à l'iut, il faut utiliser cette ligne :
--\copy import from athlete_events.csv with (format CSV, delimiter ',', HEADER)
--\copy import from noc_regions.csv with (format CSV, delimiter ',', HEADER)

--Pour copier le contenu du fichier athlete_events.csv et le contenu du fichier noc_regions.csv sur mon ordinateur personnel, il faut utiliser cette ligne :
\copy import from C:/Users/bapti/Documents/cours/BUT_s2/ALL_SAE/S2.04/athlete_events.csv with (format CSV, delimiter ',', HEADER)
\copy regions from C:/Users/bapti/Documents/cours/BUT_s2/ALL_SAE/S2.04/noc_regions.csv with (format CSV, delimiter ',', HEADER)

-- Suppression de toutes les informations avant 1920 et de toutes les épreuves “Artistiques”
DELETE FROM import WHERE year < 1992;
DELETE FROM import WHERE sport = 'Art Competitions';




-- Création de la table equipe
CREATE TABLE equipe (
    eno SERIAL,
    team TEXT, 
    noc CHAR(3), 
    CONSTRAINT pk_equipe PRIMARY KEY (eno)
);

-- Insertion des données correspondantes de import dans équipe
INSERT INTO equipe(team, noc) SELECT DISTINCT team, noc FROM import;



-- Création de la table athlete
CREATE TABLE athlete (
    ano SERIAL, 
    name TEXT, 
    sex CHAR(1), 
    age CHAR(2), 
    height TEXT, 
    weight TEXT, 
    eno integer, 
    CONSTRAINT pk_athlete PRIMARY KEY (ano)
);

--Insertion des données correspondantes de import et de equipe dans athlete
INSERT INTO athlete(name, sex, age, height, weight, eno) SELECT DISTINCT name, sex, age, height, weight, eno
                                                            FROM import i, equipe e
                                                            WHERE i.team = e.team
                                                            AND i.noc = e.noc;


-- Création de la table competition
CREATE TABLE competition (
    cno SERIAL, 
    sport TEXT, 
    event TEXT, 
    games CHAR(11),
    year integer, 
    season CHAR(6), 
    city TEXT,
    CONSTRAINT pk_competition PRIMARY KEY (cno)
);

-- Insertion des données correspondantes de import dans competition
INSERT INTO competition(sport, event,games, year, season, city) SELECT DISTINCT sport, event,games, year, season, city 
                                                            FROM import;

-- Création de la table participe (relation entre athlete et competition)
CREATE TABLE participe(
    ano integer, 
    cno integer, 
    medal CHAR(6),
    CONSTRAINT pk_participe PRIMARY KEY (ano,cno),
    CONSTRAINT fk_athlete FOREIGN KEY (ano) 
                REFERENCES athlete(ano),
    CONSTRAINT fk_competition FOREIGN KEY (cno) 
                REFERENCES competition(cno)
);

-- Insertion des données correspondantes de import, athlete, competition et de equipe dans participe
INSERT INTO participe(ano, cno, medal) SELECT a.ano, c.cno, i.medal 
                                        FROM import i, athlete a, competition c, equipe e
                                        WHERE i.name = a.name 
                                        AND i.age = a.age
                                        AND i.height = a.height
                                        AND i.weight = a.weight
                                        AND i.noc = e.noc
                                        AND i.team = e.team
                                        AND i.sport = c.sport
                                        AND i.event = c.event
                                        AND i.games = c.games
                                        AND i.year = c.year
                                        AND i.season = c.season
                                        AND a.eno = e.eno;


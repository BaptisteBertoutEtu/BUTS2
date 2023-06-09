-- Auteur:
-- BERTOUT Baptiste
-- LAWSON Killian

-- EXERCICE 3

-- Q1 Compter les colonnes


-- Q2 Compter les lignes :
SELECT COUNT() 
FROM  import;
-- 255080 lignes 

-- Q3 Compter les NOC
SELECT COUNT(noc) 
FROM regions;
-- 230 lignes

-- Q4 Compter les athlètes différents
SELECT COUNT(DISTINCT name) 
FROM import;
-- 126782 lignes
 
-- Q5 Compter les médailles d'or
SELECT COUNT() 
FROM IMPORT
WHERE medal = 'Gold';
-- 12116 lignes

-- Q6 Compter les lignes de Carl Lewis
SELECT COUNT(*) 
FROM import 
WHERE name LIKE '%Carl Lewis%';
-- 2 lignes



-- EXERCICE 5
--Q1
SELECT e.noc, COUNT(e.noc) 
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno)
GROUP BY e.noc 
ORDER BY COUNT(e.noc) DESC;

--Q2
SELECT e.noc, COUNT(p.medal) 
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno)
WHERE p.medal = 'Gold'
GROUP BY e.noc 
ORDER BY COUNT(p.medal) DESC;

--Q3
SELECT e.noc, COUNT(p.medal) 
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno)
WHERE p.medal <> 'NA'
GROUP BY e.noc 
ORDER BY COUNT(p.medal) DESC;

--Q4
SELECT a.name, COUNT(p.medal) 
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno)
WHERE p.medal = 'Gold'
GROUP BY a.name
ORDER BY COUNT(p.medal) DESC;

--Q5
SELECT e.country, COUNT(p.medal) 
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno)
WHERE c.city = 'Albertville'
AND p.medal <> 'NA'
GROUP BY e.country
ORDER BY COUNT(p.medal) DESC;


--Q8
SELECT DISTINCT age, medal
FROM athlete a JOIN participe USING(ano) JOIN competition USING(cno)
WHERE medal='Gold'
GROUP BY age,medal;

--Q9
SELECT sport
FROM athlete a JOIN participe USING(ano) JOIN competition USING(cno)
WHERE age <> 'NA'
AND CAST(age AS integer) > 50
GROUP BY sport
ORDER BY sport DESC;

--Q10
SELECT year,sport,count(event)
FROM competition c
GROUP BY year,sport
ORDER BY year;

--Q11
SELECT year,count(medal)
FROM athlete a JOIN participe p USING(ano) JOIN competition c USING(cno)
WHERE sex = 'F'
AND season = 'Summer'
AND medal <> 'NA'
GROUP BY year
ORDER BY year;


--Exercice 6
-- pays = france
-- sport = handball

-- Les JO auxquels la France a participé au handball
Select team,noc,games,year,season,city
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno)
WHERE e.noc = 'FRA'
AND c.sport='Handball'
GROUP BY team,noc,games,year,season,city;


-- Combien de médailles d'or elle a gagné
Select count(medal)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno)
WHERE e.noc = 'FRA'
AND c.sport='Handball'
AND medal='Gold';

-- Combien de femme on participer aux JO par année
Select year,count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno)
WHERE e.noc = 'FRA'
AND c.sport='Handball'
AND sex ='F'
GROUP BY year
ORDER BY year;

-- L'âge moyen des athlete présent aux JO
SELECT ROUND(AVG(CAST(age AS integer)),3)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno)
WHERE e.noc = 'FRA'
AND c.sport='Handball';
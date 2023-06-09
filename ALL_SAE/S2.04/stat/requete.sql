--les 20 ahtlete affichant le plus de participation aux JO
/*
select name
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno)
group by name
ORDER BY count(DISTINCT (name,year)) desc
LIMIT 20;

--2.a
--pays :
select distinct region
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where year=1992 and season='Summer';


select ROUND(AVG(CAST(age AS integer)),2)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where year=1992 and season='Summer' and age <> 'NA'
group by region;

select count(distinct name)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where year=1992 and season='Summer'
group by region;

select min(CAST(age AS integer))
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where year=1992 and season='Summer' and age <> 'NA'
group by region;

select max(CAST(age AS integer))
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where year=1992 and season='Summer' and age <> 'NA'
group by region;

--2.b
--age moyen participant :
select ROUND(AVG(CAST(age AS integer)),2)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno)
where year=1992 and season='Summer' and age <> 'NA';

--age moyen des medaillés :
select ROUND(AVG(CAST(age AS integer)),2)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno)
where year=1992 and season='Summer' and age <> 'NA' and medal<>'NA';

--2.c
--poids moyen H participant
select AVG(CAST(weight AS numeric))
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno)
where year=1992 and season='Summer' and sex='M' and weight<>'NA';
--poids moyen F participant
select AVG(CAST(weight AS numeric))
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno)
where year=1992 and season='Summer' and sex='F' and weight<>'NA';
--poids moyen H medaillé
select AVG(CAST(weight AS numeric))
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno)
where year=1992 and season='Summer' and sex='M' and medal<>'NA' and weight<>'NA';
--poids moyen F medaillée
select AVG(CAST(weight AS numeric))
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno)
where year=1992 and season='Summer' and sex='F' and medal<>'NA' and weight<>'NA';



--3.a
select region,count(medal)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where medal<>'NA'
group by region
order by count(medal) desc
limit 15;


--3.b
-- pays : USA
--i
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='USA'
group by year
order by year;

--ii
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='USA' and medal<>'NA'
group by year
order by year;

--iii
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='USA' and sex='F'
group by year
order by year;

--iv
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='USA' and sex='M'
group by year
order by year;

--v
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='USA' and sex='F' and medal <> 'NA'
group by year
order by year;

-- pays : Russie
--i
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='Russia'
group by year
order by year;

--ii
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='Russia' and medal<>'NA'
group by year;


--iii
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='Russia' and sex='F'
group by year
order by year;


--iv
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='Russia' and sex='M'
group by year
order by year;

--v
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='Russia' and sex='F' and medal <> 'NA'
group by year
order by year;

-- pays : Allemagne
--i
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='Germany'
group by year
order by year;

--ii
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='Germany' and medal<>'NA'
group by year;


--iii
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='Germany' and sex='F'
group by year
order by year;


--iv
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='Germany' and sex='M'
group by year
order by year;

--v
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='Germany' and sex='F' and medal <> 'NA'
group by year
order by year;

-- pays : Italie
--i
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='Italy'
group by year
order by year;

--ii
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='Italy' and medal<>'NA'
group by year;


--iii
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='Italy' and sex='F'
group by year
order by year;


--iv
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='Italy' and sex='M'
group by year
order by year;

--v
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='Italy' and sex='F' and medal <> 'NA'
group by year
order by year;

*/
/*
-- pays : France
--i
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='France'
group by year
order by year;

--ii
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='France' and medal<>'NA'
group by year;


--iii
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='France' and sex='F'
group by year
order by year;

--iv
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='France' and sex='M'
group by year
order by year;
--v
select count(*)
FROM equipe e JOIN athlete a USING(eno) JOIN participe p USING(ano) JOIN competition c USING(cno) join regions r USING(noc)
where region='France' and sex='F' and medal <> 'NA'
group by year
order by year;
*/




















--C:/Users/bapti/Documents/cours/BUT_s2/ALL_SAE/S2.04/stat/requete.sql
--Exercice 1

--Q1 1e cas (etudiant qui a une note mais a qui il manque des notes)
SELECT numetu
FROM notes
GROUP BY numetu
HAVING COUNT(*) < (SELECT COUNT(*)
                    FROM controles);

--Q1 2eme cas (etudiant qui n'a aucune notes donc pas present dans la table note)
SELECT numetu 
FROM etudiants
WHERE numetu NOT IN (SELECT numetu
            FROM NOTES);

--Q2
SELECT mat , numcont
FROM notes
GROUP BY mat, numcont
HAVING COUNT(*)<(SELECT COUNT(*)
                FROM etudiants);

--Q3
SELECT numetu
FROM notes
WHERE note=(SELECT MAX(note)
            FROM notes);

--Q4
SELECT nom , prenom
FROM etudiants e JOIN notes n ON n.numetu=e.numetu
WHERE note=(SELECT MAX(note)
            FROM notes);

--Q5
SELECT groupe, COUNT(*)
FROM etudiants
GROUP BY groupe
ORDER BY COUNT(*) ASC;

--Q6
SELECT groupe
FROM etudiants
GROUP BY groupe
HAVING COUNT(*)<= ALL(SELECT COUNT(*)
                FROM etudiants 
                GROUP BY groupe);

--Q7
SELECT numetu
FROM notes
GROUP BY numetu
HAVING AVG(note)>= ALL (SELECT AVG(note)*0.8
                    FROM notes
                    GROUP BY numetu);

--Q8
SELECT prenom
FROM etudiants
GROUP BY prenom
HAVING COUNT(*)>= ALL (SELECT COUNT(*)
                FROM etudiants
                GROUP BY prenom);

--Q9
SELECT nom
FROM etudiants s1
WHERE prenom IN (SELECT prenom
                FROM etudiants
                GROUP BY prenom
                HAVING COUNT(*)>= ALL (SELECT COUNT(*)
                                FROM etudiants
                                GROUP BY prenom));

--exercice 2

--Q1
SELECT DISTINCT numetu
FROM notes AS n1
WHERE EXISTS (SELECT note
                FROM notes AS n2
                WHERE n1.numetu=n2.numetu
                AND n2.note>15);


--Q2
--> affiche les etudiants ayant une note superieur a 15

--Q3
SELECT DISTINCT numetu
FROM notes
WHERE note>15;

--Q4
SELECT DISTINCT numetu
FROM notes
WHERE numetu NOT IN (SELECT numetu
                    FROM notes
                    GROUP BY numetu
                    HAVING AVG(note)>10);

--Q5
--> affiche les numetu ayant une moyenne en <= 10

--Q6
SELECT DISTINCT numetu
FROM notes
GROUP BY numetu
HAVING AVG(note)<=10;



--exercice 3
--Q1
SELECT numetu, numcont, mat
FROM notes n1
WHERE note = (SELECT MAX(note)
                    FROM notes n2
                    WHERE n1.mat=n2.mat AND n1.numcont=n2.numcont);

--Q2
SELECT numetu
FROM notes
WHERE numetu NOT IN (SELECT numetu
                    FROM notes
                    WHERE note<(SELECT AVG(note)
                                FROM notes));

-- ou

SELECT numetu
FROM notes n1
WHERE NOT EXISTS (SELECT numetu
                    FROM notes n2
                    WHERE n1.numetu=n2.numetu
                    AND note<(SELECT AVG(note)
                            FROM notes));

--Q3

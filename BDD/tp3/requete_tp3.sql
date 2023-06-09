--q1
SELECT numetu , ROUND(CAST(SUM(n.note*c.coeff) AS decimal)/SUM(c.coeff),2) AS moy
FROM notes n JOIN  controles c USING(numcont)
GROUP BY numetu;

--q2.1
SELECT numetu, groupe
FROM etudiants
WHERE groupe = (SELECT groupe
                FROM etudiants
                WHERE numetu=111);
                
--q2.2
SELECT e1.numetu, e1.groupe
FROM etudiants e1 JOIN etudiants e2 ON e2.numetu=111
WHERE e1.groupe=e2.groupe;

--q3
SELECT numetu
FROM notes
WHERE numcont=2 AND mat='maths' AND note<(SELECT AVG(note)*0.80
                                        FROM notes
                                        WHERE numcont=2 AND mat='maths');

--q4
SELECT numetu
FROM etudiants
WHERE numetu NOT IN (SELECT numetu
                    FROM notes
                    WHERE numcont=2 AND mat='bdd');

--q5
SELECT numetu
FROM etudiants
WHERE numetu NOT IN (SELECT numetu
                    FROM notes);

--q6
SELECT nom
FROM etudiants
WHERE length(nom)<(SELECT AVG(length(nom))
                    FROM etudiants);

--q6.1
SELECT nom
FROM etudiants
WHERE length(nom)>(SELECT AVG(length(nom))
                    FROM etudiants);

--q6.2
SELECT nom
FROM etudiants
WHERE length(nom)=(SELECT MAX(length(nom))
                    FROM etudiants);

--q7
SELECT mat
FROM controles
GROUP BY mat
HAVING COUNT(numcont)=(SELECT COUNT(numcont)
                        FROM controles
                        WHERE mat='algo');

--q8
SELECT numetu , note
FROM notes
WHERE mat='algo' AND numcont=2 AND note>(SELECT AVG(note)
                                        FROM notes
                                        WHERE mat='algo' AND numcont=2);

--q9
SELECT COUNT(DISTINCT prenom)
FROM etudiants;

--q10
SELECT note,count(note) AS frequence
FROM notes
WHERE mat='algo' AND numcont=2
GROUP BY note
ORDER BY note ASC;


--q10.1
SELECT note,repeat('*',cast(count(note) AS INTEGER)) AS frequence
FROM notes
WHERE mat='algo' AND numcont=2
GROUP BY note
ORDER BY note ASC;




--exercice 2
--q1
SELECT n.numetu , n.mat, ROUND(CAST(SUM(n.note*c.coeff) AS decimal)/SUM(c.coeff),2) AS moy
FROM notes n JOIN  controles c USING(numcont)
GROUP BY n.numetu, n.mat
ORDER BY n.numetu; \crosstabview

--q2

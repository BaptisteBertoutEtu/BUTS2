# compilation

## compilation et execution normale a partir du répertoire

```bash
javac <NomDuFichier>.java
java <NomDuFichier>(.class)
```

## compilation et execution normale en dehors du répertoire

```bash
javac <chemin>/<NomDuFichier>.java
java -cp <chemin> <NomDuFichier>(.class)
```

## Compilation basique: avec dépendance, sans paquetage dans le repertoire

Il faut compiler l'ensemble des programmes dans le dossier pour palier au probleme de dependance

```bash
javac *.java
java <nomDuFichier>(.class)
```

## Compilation basique: avec dépendance, sans paquetage en dehors du repertoire

```bash
javac <chemin>/*.java
java -cp <chemin> <nomDuFichier>(.class)
```

## Compilation séparée

:warning: : ça dépend de la ou on se trouve.

```bash
javac -d bin <nomDuFichier>.java
java -cp bin <nomFichier>(.class)
```

## Compilation avancée: sans dépendance, avec paquetage

Avec paquetage, obligation de compilé en séparé pour avoir une hierarchie dans les fichiers.

```bash
javac -d bin *.java
java -cp bin <nomPackage>.<nomFichier>
```

## Compilation basique: avec dépendance, avec paquetage

Il faut bien faire attention à importé les fichiers avec dépendance

`pareil que la partie du dessus`

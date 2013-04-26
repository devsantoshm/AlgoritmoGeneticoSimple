AlgoritmoGeneticoSimple
=======================

Un simple algoritmo genético para experimentar, consiste en optimizar una 
función matemática. Inspirado en el primer pseudocódigo presentado en el libro
* Algoritmos Evolutivos Un Enfoque Práctico - Lourdes Araujo, Carlos Cervigón * 

Release 0.1 Super ALFA
----------------------
Importando la carpeta raíz como un proyecto en netbeans, se
puede ejecutar el programa sin problemas. Esta version "Super ALFA" contiene
todos los parámetros del algoritmo genético definidos en el método main del
archivo AGSimple  

Descripción de archivos
-----------------------
# AGSimple.java  
Clase principal donde está definido el main. Es la encargada de leer los argumentos de entrada del algoritmo  
t enviarselos a la clase AlgoritmoGeneticoSimple.java.  
TODO LIST  
- Idear una forma de introducir argumentos mediante consola / archivo de texto  

# AlgoritmoGeneticoSimple.java
Es la clase donde corre todo el algoritmo, contiene el loop de la evolución, en
donde se evalúan, seleccionan, reproducen y mutan los diferentes individuos.
Todos éstos métodos están definidos en esta clase.  
En ésta clase todos los parámetros son atributos privados

# TIndividuo.java
Contiene la definición de un individuo de esta poblacion. Cuando se construye
genera un cromosoma binario usando la clase TCromosoma; A partir del valor del
cromosoma se calcula la adaptación del individuo.  
Contiene muchos métodos para setear y recuperar su puntuación individual y 
acumulada (éstos sirven para la selección del individuo en la clase
AlgoritmoGeneticoSimple.java), para ver el valor de su cromosoma, etc.


# TCromosoma.java
Define el cromosoma del individuo que pertenece a la población. Contiene métodos
para calcular el valor en base decimal del cromosoma (decod=decodificar),
convertirlo en un string, etc.




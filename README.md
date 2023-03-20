# ProyectoEvolutiva

Nuevo tipo de individuo:

  - Como hay atributos de individuo que no se usan en el individuo tsp, estaria bien hacer una clase IndividuoFuncion de la que luego hereden individuoBool y double
    para que, de esta manera el individuo tsp no tenga cosas que no usa.

Individuo TSP: 

  - Ahora mismo tenemos hecho que el Controller tiene una instancia de todas las listas de cruces o selecciones en función de si el tipo de la funcion es Bool o Double
    para poder implementar el TSP y evitar esto anterior se puede sustiuir el campo de el TipoDato por directamente las listas de selecciones,cruces y mutaciones que         puede hacer el individuo seleccionado. 
  - El problema del TSP se elegirá igual que si fuese una función más.
    
Control excepciones intervalos:
 
  - Hay que hacer el control de excepciones en las casillas de los intervalos y darles valores por defecto.
  

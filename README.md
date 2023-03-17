# ProyectoEvolutiva

Nuevo tipo de individuo:

  - Como hay atributos de individuo que no se usan en el individuo tsp, estaria bien hacer una clase IndividuoFuncion de la que luego hereden individuoBool y double
    para que, de esta manera el individuo tsp no tenga cosas que no usa.

Individuo TSP: 

  - Ahora mismo tenemos hecho que el Controller tiene una instancia de todas las listas de cruces o selecciones en función de si el tipo de la funcion es Bool o Double
    para poder implementar el TSP y evitar esto anterior se puede sustiuir el campo de el TipoDato por directamente las listas de selecciones,cruces y mutaciones que         puede hacer el individuo seleccionado. 
  - El problema del TSP se elegirá igual que si fuese una función más.
    
   
Interfaz para varias ejecuciones con intervalos: 

   - Para elegir la ejecución con intervalos, habrá un botón o casilla en el TopPannel que al ser seleccionada cambiará la interfaz por completo, haciendo invisible la       interfaz normal y dejando a la vista únicamente la interfaz correspondiente. De esta manera el bottonPanel también cambiará y el botón ejecutar ya no será el mismo       que era anteriormente, para que al clickarse se realice una llamada a un run() distinto del controller.
  

# ProyectoEvolutiva

Mutación: 
  - Para implementar la mutación haremos una interfaz Mutación con el método mutar(). 
  - Cada clase que implemente esta interfaz lo hará llamando a una función de Individuo que corresponda. La implementación real de la mutación se hará en las                 clases individuo double e individuoInt.
  - Ejemplo:

          public class Permutacion implements Mutacion{
          
              mutar() {
                for(individuo: poblacion)
                  indiviudo.mutarPermutacion();
              }
          }
      
Individuo TSP: 

  - Ahora mismo tenemos hecho que el Controller tiene una instancia de todas las listas de cruces o selecciones en función de si el tipo de la funcion es Bool o Double
    para poder implementar el TSP y evitar esto anterior se puede sustiuir el campo de el TipoDato por directamente las listas de selecciones,cruces y mutaciones que         puede hacer el individuo seleccionado. 
  - El problema del TSP se elegirá igual que si fuese una función más.
    
   
Interfaz para varias ejecuciones con intervalos: 

   - Para elegir la ejecución con intervalos, habrá un botón o casilla en el TopPannel que al ser seleccionada cambiará la interfaz por completo, haciendo invisible la       interfaz normal y dejando a la vista únicamente la interfaz correspondiente. De esta manera el bottonPanel también cambiará y el botón ejecutar ya no será el mismo       que era anteriormente, para que al clickarse se realice una llamada a un run() distinto del controller.
  

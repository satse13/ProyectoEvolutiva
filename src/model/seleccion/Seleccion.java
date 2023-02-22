package model.seleccion;

import java.util.ArrayList;

import model.individuos.Individuo;
import utils.Pair;

public interface Seleccion {
    public ArrayList<Pair<Integer, Integer>> seleccionar(ArrayList<Individuo> poblacion, double prob);
}

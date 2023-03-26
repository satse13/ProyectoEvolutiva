package model.individuos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@SuppressWarnings("serial")
public class IndividuoTSP extends Individuo<Integer>{
	
	public final static int NUM_CIUDADES = 26;

	private final static int[][] _DIST = {
				{},
				{171},
				{369,	294},
				{366,	537,	633},
				{525,	696,	604,	318},
				{540,	515,	809,	717,	1022},
				{646,	817,	958,	401,	694,	620},
				{488,	659,	800,	243,	536,	583,	158},
				{504,	675,	651,	229,	89,	918,	605,	447},
				{617,	688,	484,	618,	342,	1284,	1058,	900,	369},
				{256,	231,	525,	532,	805,	284,	607,	524,	701,	873},
				{207,	378,	407,	256,	318,	811,	585,	427,	324,	464,	463},
				{354,	525,	332,	457,	272,	908,	795,	637,	319,	263,	610,	201},
				{860,	1031,	1172,	538,	772,	1118,	644,	535,	683,	1072,	1026,	799,	995},
				{142,	313,	511,	282,	555,	562,	562,	404,	451,	708,	305,	244,	445,	776},
				{640,	615,	909,	817,	1122,	100,	720,	683,	1018,	1384,	384,	911,	1008,	1218,	662},
				{363,	353,	166,	534,	438,	868,	829,	671,	485,	335,	584,	278,	166,	1043,	479,	968},
				{309,	480,	621,	173,	459,	563,	396,	238,	355,	721,	396,	248,	458,	667,	136,	663,	492},
				{506,	703,	516,	552,	251,	1140,	939,	781,	323,	219,	856,	433,	232,	1006,	677,	1240,	350,	690},
				{495,	570,	830,	490,	798,	274,	322,	359,	694,	1060,	355,	587,	797,	905,	406,	374,	831,	339,	1029},
				{264,	415,	228,	435,	376,	804,	730,	572,	423,	367,	520,	179,	104,	944,	380,	904,	99,	393,	336,	732},
				{584,	855,	896,	255,	496,	784,	359,	201,	407,	796,	725,	511,	733,	334,	500,	884,	761,	391,	730,	560,	668},
				{515,	490,	802,	558,	866,	156,	464,	427,	762,	1128,	259,	655,	865,	973,	472,	256,	861,	407,	1097,	118,	779,	628},
				{578,	653,	899,	358,	676,	468,	152,	115,	595,	999,	455,	526,	736,	650,	464,	568,	770,	278,	968,	244,	671,	316,	312},
				{762,	933,	1074,	440,	674,	1020,	546,	437,	585,	974,	928,	696,	897,	98,	678,	1120,	945,	569,	908,	807,	846,	236,	875,	352},
				{251,	422,	563,	115,	401,	621,	395,	237,	297,	663,	417,	190,	400,	609,	167,	721,	434,	58,	632,	397,	335,	333,	465,	336,	551},
				{473,	482,	219,	644,	436,	997,	939,	781,	506,	265,	713,	388,	187,	1153,	615,	1097,	129,	602,	313,	941,	209,	877,	1009,	880,	1055,	544},
				{150,	75,	219,	516,	675,	590,	796,	638,	654,	613,	306,	357,	444,	1010,	292,	690,	278,	459,	628,	611,	340,	734,	583,	694,	912,	401,	407}
	};
	
	private final Map<Integer,String> CIUDADES = new HashMap<Integer,String>() {{
		put(0,"Albacete"); put(1,"Alicante"); put(2,"Almería"); put(3,"Ávila");
		put(4,"Badajoz"); put(5,"Barcelona"); put(6,"Bilbao"); put(7,"Burgos");
		put(8,"Cáceres"); put(9,"Cádiz"); put(10,"Castellón"); put(11,"Ciudad Real");
		put(12,"Córdoba"); put(13,"A Coruña"); put(14,"Cuenca"); put(15,"Gerona");
		put(16,"Granada"); put(17,"Guadalajara"); put(18,"Huelva"); put(19,"Huesca");
		put(20,"Jaén"); put(21,"León"); put(22,"Lérida"); put(23,"Logroño");
		put(24,"Madrid"); put(25,"Málaga"); put(26,"Murcia");
	}};

	public IndividuoTSP() {
		initIndividuo();
		
		this.cromosoma = new ArrayList<Integer>(NUM_CIUDADES);
				
		for(int i = 0; i <= NUM_CIUDADES;i++) {
			if(i != 24)
				cromosoma.add(i);
		}
		
		Collections.shuffle(cromosoma);
		
		this.fitness = this.getValor();
	}
	
	public IndividuoTSP(ArrayList<Integer> cromosoma) {

		initIndividuo();
		this.cromosoma = new ArrayList<Integer>(cromosoma);
		//this.fitness = this.getValor();
	}
	
	
	@Override
	public int compareTo(Individuo o) {
		 if(this.getFitness() > o.getFitness())
			 return 1;
		 else if(this.getFitness() == o.getFitness())
			 return 0;
		 else
			 return -1;
	}

	@Override
	protected double getValor() {
		
		return distTotal(cromosoma);
	}
	
	private double distTotal(ArrayList<Integer> lista) { // Hacemos esto para poder usar la funcion en 
		int dist = 0; 									 // la mutacion heuristica

		dist += calDist(24,lista.get(0));
		
		for(int i = 1; i < lista.size();i++) {
			dist += calDist(lista.get(i-1), lista.get(i));
		}
		dist += calDist(24,lista.get(lista.size()-1));

		return dist;
	}

	@Override
	protected String decodificar() {
		String str = "Orden del recorrido: Madrid";
		
		for(int i = 0; i < NUM_CIUDADES; i++) {
			str+= ", " + CIUDADES.get(cromosoma.get(i));
		}
		str += " - Distancia recorrida = " + this.getFitness();  
		
		return str;
	}

	@Override
	public double getFenotipo(int gen) {
        return cromosoma.get(gen);
    }


	@Override
	public boolean mejorFitness(Individuo individuo) {
		if(individuo.getFitness() > this.getFitness())
			return true;
		return false;
	}

	@Override
	public Double adaptar(Individuo individuo) { // No sabemos si tiene sentido que esta funcion este aqui, pq no puedes tener fitness negativo en el tsp
		return individuo.getFitness() + Math.abs(this.getFitness() 	* 1.05);
	}
	
	private void initIndividuo() {
		this.tamGenes = new int[NUM_CIUDADES];	
		this.rand = new Random();		
	}
	
	private int calDist(int a,int b) {
		int dist = 0;
		try {
			dist += _DIST[a][b];
			return dist;
		}
		catch(Exception e){
			dist += _DIST[b][a];
			return dist;
		}
	}
	public void mutarInser(double prob) {
		if(rand.nextDouble(0,1) < prob) {
			int elem = rand.nextInt(0,NUM_CIUDADES);
			int pos = rand.nextInt(0,NUM_CIUDADES);
			
			int aux = this.cromosoma.get(elem);
			this.cromosoma.remove(elem);
			this.cromosoma.add(null);
			for(int i = this.cromosoma.size()-1; i >= pos;i--) {
				this.cromosoma.set(i, this.cromosoma.get(i-1));
			}
			this.cromosoma.set(pos, aux);
			this.fitness = this.getValor();
		}
	}
	
	public void mutarInter(double prob) {
		if(rand.nextDouble(0,1) < prob) {
			int elem1 = rand.nextInt(0,NUM_CIUDADES);
			int elem2 = rand.nextInt(0,NUM_CIUDADES);
			
			Collections.swap(cromosoma, elem1, elem2);
			this.fitness = this.getValor();
		}

	}
	
	public void mutarInver(double prob) {
		if(rand.nextDouble(0,1) < prob) {
			int pos1 = rand.nextInt(0,NUM_CIUDADES);
			int pos2 = rand.nextInt(0,NUM_CIUDADES);
			
			if(pos2 < pos1) {
				int aux = pos1;
				pos1 = pos2;
				pos2 = aux;
			}
				
			while(pos1 < pos2) {
				Collections.swap(cromosoma, pos1, pos2);
				pos1++;
				pos2--;
			}
			this.fitness = this.getValor(); 
		}
	}

	public void mutarHeur(double prob) {
		if(rand.nextDouble(0,1) < prob) {
			
			int pos1 = rand.nextInt(0,NUM_CIUDADES);
			int pos2 = rand.nextInt(0,NUM_CIUDADES);
			int pos3 = rand.nextInt(0,NUM_CIUDADES);

			ArrayList<Integer> lista = new ArrayList<Integer>();
			lista.add(this.cromosoma.get(pos1));
			lista.add(this.cromosoma.get(pos2));
			lista.add(this.cromosoma.get(pos3));
			
			List<List<Integer>> permutaciones = getPermutations(lista);
			
			ArrayList<Integer> mejor = new ArrayList<Integer>(cromosoma);
			double mejorF = distTotal(mejor);
			
			for(List<Integer> p: permutaciones) {
				ArrayList<Integer> aux = new ArrayList<Integer>(cromosoma);
				aux.set(pos1, p.get(0));
				aux.set(pos2, p.get(1));
				aux.set(pos3, p.get(2));
				double fitnessAux = distTotal(aux);
				if(fitnessAux < mejorF) {
					mejorF = fitnessAux;
					mejor = new ArrayList<Integer>(aux);
				}
			}
			this.cromosoma = new ArrayList<Integer>(mejor);
			this.fitness = mejorF;
		}
	}
	private List<List<Integer>> getPermutations(ArrayList<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        if (list.size() == 1) {
            result.add(list);
            return result;
        }
        for (Integer integer : list) {
            ArrayList<Integer> remaining = new ArrayList<>(list);
            remaining.remove(integer);
            List<List<Integer>> permutations = getPermutations(remaining);
            for (List<Integer> permutation : permutations) {
                permutation.add(0, integer);
                result.add(permutation);
            }
        }
        return result;
    }
	
	public static void main(String args[]) {
		IndividuoTSP a = new IndividuoTSP();
		System.out.println(a.cromosoma);
		a.mutarHeur(1);
		System.out.println(a.cromosoma);
	}
	
}

package model.individuos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
				{309,	480,	621,	173,	459,	563,	396,	238,	355,	721,	396,	248,	458,	667,	486,	663,	492},
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
		put(0,"Albacete"); put(1,"Alicante"); put(2,"Almer�a"); put(3,"�vila");
		put(4,"Badajoz"); put(5,"Barcelona"); put(6,"Bilbao"); put(7,"Burgos");
		put(8,"C�ceres"); put(9,"C�diz"); put(10,"Castell�n"); put(11,"Ciudad Real");
		put(12,"C�rdoba"); put(13,"A Coru�a"); put(14,"Cuenca"); put(15,"Gerona");
		put(16,"Granada"); put(17,"Guadalajara"); put(18,"Huelva"); put(19,"Huesca");
		put(20,"Ja�n"); put(21,"Le�n"); put(22,"L�rida"); put(23,"Logro�o");
		put(24,"Madrid"); put(25,"M�laga"); put(26,"Murcia");
	}};

	public IndividuoTSP() {
		initIndividuo();
		
		this.cromosoma = new ArrayList<Integer>(NUM_CIUDADES);
				
		for(int i = 0; i < NUM_CIUDADES+1;i++) {
			if(i != 24)
				cromosoma.add(i);
		}
		
		Collections.shuffle(cromosoma);
		
		this.fitness = this.getValor();
	}
	
	public IndividuoTSP(ArrayList<Integer> cromosoma) {

		initIndividuo();
		this.cromosoma = new ArrayList<Integer>(cromosoma);
		this.fitness = this.getValor();
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
		
		int dist = 0; 

		dist += calDist(24,cromosoma.get(0));
		
		for(int i = 1; i < cromosoma.size();i++) {
			dist += calDist(cromosoma.get(i-1), cromosoma.get(i));
		}
		dist += calDist(24,cromosoma.get(cromosoma.size()-1));

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
		return _DIST[a].length < b ? dist += _DIST[b][a] : (dist += _DIST[a][b]);
	}

	@Override
	public void mutar(double prob) {}
}

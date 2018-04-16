import java.util.ArrayList;

	/**
	 * Clase Grafo
	 * @author Juan Sebastian
	 */
	public class Grafo {

	    public int[][] g = {{2, 1, 0, 1, 0},
			                {1, 2, 1, 0, 0},
			                {0, 1, 2, 1, 0},
			                {1, 0, 1, 2, 1},
			                {0, 0, 0, 1, 2}};
	    private boolean[] visitadoAnchura = new boolean[5];
	    private boolean[] visitadoProfunidad = new boolean[5];

	    public Grafo() {
	    }

	    public int[][] getG() {
	        return g;
	    }

	public ArrayList<Integer> recorridoAnchura(int nodoI) {
	//Lista donde guardo los nodos recorridos
	        ArrayList<Integer> recorridos = new ArrayList<Integer>();
	//El nodo inicial ya está visitado
	        visitadoAnchura[nodoI] = true;
	//Cola de visitas de los nodos adyacentes
	        ArrayList<Integer> cola = new ArrayList<Integer>();
	//Se lista el nodo como ya recorrido
	        recorridos.add(nodoI);
	//Se agrega el nodo a la cola de visitas
	        cola.add(nodoI);
	//Hasta que visite todos los nodos
	        while (!cola.isEmpty()) {
	            int j = cola.remove(0); //Se saca el primero nodo de la cola
	//Se busca en la matriz que representa el grafo los nodos adyacentes
	            for (int i = 0; i < g.length; i++) {
	//Si es un nodo adyacente y no está visitado entonces
	                if (g[j][i] == 1 && !visitadoAnchura[i]) {
	                    cola.add(i);//Se agrega a la cola de visitas
	                    recorridos.add(i);//Se marca como recorrido
	                    visitadoAnchura[i] = true;//Se marca como visitado
	                }
	            }
	        }
	        return recorridos;//Devuelvo el recorrido del grafo en anchura
	    }

	    public ArrayList<Integer> recorridoProfunidad(int nodoI) {
	//Lista donde guardo los nodos recorridos
	        ArrayList<Integer> recorridos = new ArrayList<Integer>();
	        visitadoProfunidad[nodoI] = true;//El nodo inicial ya está visitado
	//Cola de visitas de los nodos adyacentes
	        ArrayList<Integer> cola = new ArrayList<Integer>();
	        recorridos.add(nodoI);//Listo el nodo como ya recorrido
	        cola.add(nodoI);//Se agrega el nodo a la cola de visitas
	        while (!cola.isEmpty()) {//Hasta que visite todos los nodos
	            int j = cola.remove(0);//Se saca el primer nodo de la cola
	    //Se busca en la matriz que representa el grafo los nodos adyacentes
	            for (int i = 0; i < g.length; i++) {
	//Si es un nodo adyacente y no está visitado entonces
	                if (g[j][i] == 1 && !visitadoProfunidad[i]) {
	                    cola.add(i);//Se agrega a la cola de visita
	//Se recorren los hijos del nodo actual de visita y se agrega el recorrido al la lista
	                    recorridos.addAll(recorridoProfunidad(i));
	                    visitadoProfunidad[i] = true;//Se marca como visitado
	                }
	            }
	        }
	        return recorridos;//Se devuelve el recorrido del grafo en profundidad
	    }
	
	

	//Para porbar los métodos se ejecuta el siguiente código:

	

	/**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        // TODO code application logic here
	        Grafo g=new Grafo();
	        ArrayList<Integer> enAnchura=g.recorridoAnchura(0);//Nodo inicial 0
	        System.out.println("Recorrido en anchura de un grafo representado como matriz: ");
	        for(int i=0;i<enAnchura.size();i++){
	            System.out.print(""+enAnchura.get(i)+" ");
	        }
	        ArrayList<Integer> enProfundidad=g.recorridoProfunidad(0);//Nodo inicial 0
	        System.out.println("");
	        System.out.println("Recorrido en profundidad de un grafo representado como matriz: ");
	        for(int i=0;i<enProfundidad.size();i++){
	            System.out.print(""+enProfundidad.get(i)+" ");
	        }
	    }
	}
	
	
	


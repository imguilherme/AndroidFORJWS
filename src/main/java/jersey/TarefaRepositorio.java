package jersey;

import java.util.ArrayList;
import java.util.List;

public class TarefaRepositorio {
	
	private static List<Tarefa> lista;
	
	public static int LAST_ID;
	
	public static List<Tarefa> getLista(){
		if(lista == null){
			lista = new ArrayList<Tarefa>();
		}
		return lista;
	}
	
	
}

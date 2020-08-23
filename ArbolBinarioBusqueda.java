import java.util.Comparator;

public class ArbolBinarioBusqueda extends ArbolBinario {
  public final Comparator prueba;

  public ArbolBinarioBusqueda(){
    super();
    prueba = new ComparaEnteros();
  }

  public Nodo buscar(Object buscado){
    if (raiz == null){
      return null;
    }else{
      return localizar(raizArbol(), buscado);
    }
  }

  protected Nodo localizar(Nodo raizSub, Object buscado){
    if (raizSub == null)
      return null;
    else if (prueba.compare(buscado ,raizSub.valorNodo()) < 0)
      return localizar(raizSub.subarbolIzdo(), buscado);
    else if (prueba.compare(buscado ,raizSub.valorNodo()) > 0)
      return localizar(raizSub.subarbolDcho(), buscado);
    else
      System.out.println("el valor se encuentra en el arbol binario");
      return raiz;
  }

  public void insertar(Object valor) throws Exception{
    raiz = insertar(raiz, valor);
  }

  //método interno para realizar la operación
  protected Nodo insertar(Nodo raizSub, Object dato) throws Exception{
    if (raizSub == null){
      raizSub = new Nodo(dato);
    }else if (prueba.compare(dato ,raizSub.valorNodo()) < 0){
      Nodo iz;
      iz = insertar(raizSub.subarbolIzdo(), dato);
      raizSub.ramaIzdo(iz);
    }else if (prueba.compare(dato, raizSub.valorNodo()) > 0){
      Nodo dr;
      dr = insertar(raizSub.subarbolDcho(), dato);
      raizSub.ramaDcho(dr);
    }else
      throw new Exception("Nodo duplicado");
      return raizSub;
  }


  public void eliminar (Object valor) throws Exception{
    raiz = eliminar(raiz, valor);
  }

  //método interno para realizar la operación
  protected Nodo eliminar (Nodo raizSub, Object dato) throws Exception{
    if (raizSub == null)
      throw new Exception ("No encontrado el nodo con la clave");
    else if (prueba.compare(dato ,raizSub.valorNodo()) < 0){
      Nodo iz;
      iz = eliminar(raizSub.subarbolIzdo(), dato);
      raizSub.ramaIzdo(iz);
    }else if (prueba.compare(dato ,raizSub.valorNodo()) > 0){
      Nodo dr;
      dr = eliminar(raizSub.subarbolDcho(), dato);
      raizSub.ramaDcho(dr);
    }else{ // Nodo encontrado
      Nodo q;
      q = raizSub; // nodo a quitar del árbol
      if (q.subarbolIzdo() == null)
        raizSub = q.subarbolDcho();
      else if (q.subarbolDcho() == null)
        raizSub = q.subarbolIzdo();
      else{ // tiene rama izquierda y derecha
        q = reemplazar(q);
      }
      q = null;
      System.out.println("nodo eliminado");
    }
    return raizSub;
    }

// método interno para susutituir por el mayor de los menores
  private Nodo reemplazar(Nodo act){
    Nodo a, p;
    p = act;
    a = act.subarbolIzdo(); // rama de nodos menores
    while (a.subarbolDcho() != null){
      p = a;
      a = a.subarbolDcho();
    }
    act.nuevoValor(a.valorNodo());
    if (p == act)
      p.ramaIzdo(a.subarbolIzdo());
    else
      p.ramaDcho(a.subarbolIzdo());
    return a;
  }

  /*
   * Clase privada que compara dos elementos enteros
   */
  private class ComparaEnteros implements Comparator {
	  public int compare(Object o1, Object o2) {
	    return ((Integer)o1).intValue() - ((Integer)o2).intValue();
	  }
  }
}
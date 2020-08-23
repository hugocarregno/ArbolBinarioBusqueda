class Main {
  public static void main(String[] args) {
    /***
    *Implementa un árbol binario de búsqueda utilizando los conceptos del
capítulo 13 del Libro Estructura de Datos en Java. Implementa las clases y métodos
necesarios para crear el árbol, insertar un nodo, borrar un nodo, buscar un nodo y recorrer
el árbol en preorden, inorden y postorden. Los nodos del árbol pueden ser cualquier dato a
tu elección
    ***/
   System.out.println("Arbol binario de busqueda de enteros\n");

     ArbolBinarioBusqueda arbolBinarioBusqueda = new ArbolBinarioBusqueda();
    try{
      
      arbolBinarioBusqueda.insertar(10);
      arbolBinarioBusqueda.insertar(15);
      arbolBinarioBusqueda.insertar(7);
      arbolBinarioBusqueda.insertar(3);
      arbolBinarioBusqueda.insertar(9);
      arbolBinarioBusqueda.insertar(1);
      arbolBinarioBusqueda.buscar(15);
      arbolBinarioBusqueda.eliminar(15);
      
      System.out.println("\npre orden");
      ArbolBinario.preorden(arbolBinarioBusqueda.raizArbol());
      System.out.println("\nin orden");
      ArbolBinario.inorden(arbolBinarioBusqueda.raizArbol());
      System.out.println("\npost orden");
      ArbolBinario.postorden(arbolBinarioBusqueda.raizArbol());
      
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
 
  


  }
}
package co.edu.uptc.dynamic;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

@SuppressWarnings("rawtypes")
public class SimpleList<T> implements List<T> {
  Node<T> header;
  Node<T> last;
  public int size = 0;
  private Node<T> lastget = null;

  public SimpleList() {
    header = null;
    last = null;
  }

  @Override
  public boolean add(T e) {
    Node<T> newNode = new Node<T>();
    newNode.setInfo(e);
    newNode.setNext(null);
    size = size + 1;
    if (header == null) {
      header = newNode;
      last = header;
    } else {
      last.setNext(newNode);
      last = newNode;
    }
    return true;
  }

  public void showList() {
    Node aux = header;
    while (aux != null) {
      System.out.println(aux.getInfo());
      aux = aux.getNext();
    }

  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public T get(int index) {
    Node<T> aux = header;
    int conta = 0;
    // if (lastget == null) {
    // lastget = header;
    // } else {
    // if (lastget.getNext() != null)
    // lastget = lastget.getNext();
    // else
    // return null;
    // }
    while (conta < index) {
      aux = aux.getNext();
      conta++;
    }
    return aux.getInfo();
  }

  @Override
  public boolean isEmpty() {
    return header == null;
  }

  @Override
  public boolean contains(Object o) {
    Node<T> auxNode = header;
    if (header == null) {
      return false;
    }
    isIntanceOf(header.getInfo().getClass(), o);

    while (auxNode != null) {
      if (auxNode.getInfo().equals(o)) {
        return true;
      }
      auxNode = auxNode.getNext();
    }
    return false;
  }

  @Override
  public Iterator iterator() {

    return new Iterator<T>() {

      private Node<T> current = header;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        T value = current.getInfo();
        current = current.getNext();
        return value;
      }

    };
  }

  @Override
  public Object[] toArray() {
    Object[] objects = new Object[this.size];
    Node<T> auxNode = header;
    int i = 0;

    while (auxNode != null) {
      objects[i] = auxNode.getInfo();
      auxNode = auxNode.getNext();
      i++;
    }
    return objects;
  }

  @Override
  public Object[] toArray(Object[] a) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toArray'");
  }

  @Override
  public boolean remove(Object o) {
    if (header == null) {
      return false;
    }
    if (header.getInfo().equals(o)) {
      Node<T> temp = header;
      header = header.getNext();
      temp.setNext(null); 
      size--;
      return true;
  }
    isIntanceOf(header.getInfo().getClass(), o);

    Node<T> current = header;

    while (current.getNext() != null) {
      if (current.getNext().getInfo().equals(o)) {
        Node<T> temp = current.getNext();
            current.setNext(current.getNext().getNext());
            temp.setNext(null);
            size--;
        return true;
      }
      current = current.getNext();
    }

    return false;
  }

  @Override
  public boolean containsAll(Collection c) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
  }

  @Override
  public boolean addAll(Collection c) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addAll'");
  }

  @Override
  public boolean addAll(int index, Collection c) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addAll'");
  }

  @Override
  public boolean removeAll(Collection c) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
  }

  @Override
  public boolean retainAll(Collection c) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'clear'");
  }

  @Override
  public Object set(int index, Object element) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'set'");
  }

  @Override
  public void add(int index, T element) {
    Node<T> newNode = new Node<T>(element);
    Node<T> current = header;

    isIntanceOf(current.getInfo().getClass(), element);
    isIndexInsideList(index, size());
    isNull(element);

    for (int i = 0; i < index - 1; i++) {
      current = current.getNext();
    }

    if (current.getNext() != null) {
      newNode.setNext(current.getNext());

    }
    current.setNext(newNode);
    size++;
  }

  @Override
  public T remove(int index) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'remove'");
  }

  @Override
  public int indexOf(Object o) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
  }

  @Override
  public int lastIndexOf(Object o) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
  }

  @Override
  public ListIterator listIterator() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
  }

  @Override
  public ListIterator listIterator(int index) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
  }

  @Override
  public List subList(int fromIndex, int toIndex) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'subList'");
  }

  private boolean isIntanceOf(Class<? extends Object> clazz, Object o) throws ClassCastException {

    boolean flag = true;

    if (!clazz.isInstance(o)) {
      flag = false;

      throw new ClassCastException();

    }

    return flag;
  }

  private void isIndexInsideList(int index, int size) throws IndexOutOfBoundsException {

    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }

  }

  private void isNull(Object o) throws NullPointerException {
    if (o == null) {
      throw new NullPointerException();
    }
  }
}

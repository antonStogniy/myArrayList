package javaIntensive;

import java.util.Comparator;

/**
 * Собственная реализация коллекции ArrayList
 * @param <T> принимаемый тип элементов коллекции
 */
public class MyArrayList<T>{
    /**
     * Создание массива для хранения данных
     */
    private T[] list;
    /**
     * Размер коллекции
     */
    private int size;
    /**
     * Стартовый размер ArrayList
     */
    private final int DEFAULT_CAPACITY = 10;

    /**
     * Конструкор с возможностью изменения размера коллекции
     * @param capacity размер коллекции
     */
    public MyArrayList(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("Capacity <= 0");
        }else {
            list = (T[]) new Object[capacity];
        }
    }

    /**
     * Конструктор без параметров
     */
    public MyArrayList(){
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Добавление элемента
     * @param item элемент, который хотим добавить
     */
    public void add(T item){
        //проверить переполнение
        if(size == list.length){
            sizeUp();
        }
        list[size++] = item;
    }

    /**
     * Добавление элемента по индексу
     * @param index номер, по которому добавляем
     * @param item элемент, который добавляем
     */
    public void add(int index, T item){
        if(size == list.length){
            sizeUp();
        }
        for(int i = size; i > index; i--){
            list[i] = list[i -1];
        }
        list[index] = item;
        size++;
    }
    private void sizeUp(){
        T[] newItems = (T[]) new Object[list.length + list.length / 2];
        for (int i = 0; i < size; i++){
            newItems[i] = list[i];
            list = newItems;
        }
    }

    /**
     * Удаление элемента по индексу
     * @param index номер элемента, который хотим удалить
     */
    public void delete(int index){

        for (int i = index; i < size; i++){
            list[i] = list[i + 1];
        }
        size--;
    }

    /**
     * Удаление конкретного элемента коллекции
     * @param item элемент коллекции
     */
    public void delete(T item){
        int pos = getIndex(item);
        if(pos == -1){
            return;
        }
        delete(pos);
    }

    /**
     * Получение номера элемента коллекци по его значению
     * @param item искомый элемент
     * @return
     */
    private int getIndex(T item){
        if(item ==  null){
            return -1;
        }
        for(int i = 0; i < size; i++){
            if(item.equals(list[i])){
                return i;
            }
        }
        return -1;
    }
    public int getSize(){
        return size;
    }

    /**
     * Печать списка элементов
     */
    public void display(){
        for (T item: list) {
            System.out.println(item);
        }
    }

    /**
     * Получение элемента по индексу
     * @param index номер элемента
     * @return
     */
    public T get(int index){
        //проверить индекс в границах
        if(index >= 0 && index < size) {
            return list[index];
        }else {
            System.out.println("Index not found");
            return null;
        }
    }

    /**
     * Изменение, редактирование элемента коллекции
     * @param index номер элемента
     * @param item элемент коллекции
     */
    public void set(int index, T item){
        list[index] = item;
    }

    /**
     * Реализация быстрой сортировки, при помощи рекурсии
     * Метод пребразует коллекцию в массив для дальнейшей сортировки
     * @param comparator Способ сравнения элеметов
     */
    public void quickSort(Comparator<T> comparator){
        T[] tempM = (T[]) new Object[size];
        for(int i = 0; i < size; i++){
            tempM[i] = get(i);
        }
        massiveSort(tempM, 0, size - 1, comparator);
        clear();
        for(int i = 0; i < tempM.length; i++){
            list[i] = tempM[i];
            size++;
        }

    }

    /**
     * Метод очищает колекцию
     */
    private void clear(){
        list = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Метод сортирует переданный массив
     * @param arr массив
     * @param begin начанльный элемент массива
     * @param end последний элемент массива
     * @param comparator способ сортировки
     */
    private void massiveSort(T[] arr, int begin, int end, Comparator comparator){
        if(begin >= end){
            return;
        }
        int pi = partition(arr, begin, end, comparator);
        massiveSort(arr, begin, pi - 1, comparator);
        massiveSort(arr, pi + 1, end, comparator);
    }
    private int partition(T[] arr, int begin, int end, Comparator comparator){
        T pivot = arr[end];
        int ptr = begin - 1;
        for(int i = begin; i < end; i++){
            if((comparator.compare(arr[i], pivot)) < 0 ){
                ptr++;
                swap(ptr, i, arr);
            }
        }
        swap(ptr + 1, end, arr);

        return ptr + 1;
    }

    private void swap(int ptr, int i, T[] arr){
        T temp = arr[ptr];
        arr[ptr] = arr[i];
        arr[i] = temp;
    }
}

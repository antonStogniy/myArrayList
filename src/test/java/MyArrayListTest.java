import javaIntensive.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyArrayListTest {
    private MyArrayList<String> myList;


    @BeforeEach
    public void setup(){
        myList = new MyArrayList<>();
        myList.add("Д");
        myList.add("Е");
        myList.add("Г");
        myList.add("В");
        myList.add("А");
        myList.add("Б");
    }
    @Test
    public void testGet(){
        assertEquals("Г", myList.get(2));
        assertEquals("Е", myList.get(1));
        assertEquals("Д", myList.get(0));
    }
    @Test
    public void testAdd(){
        myList.add("З");
        myList.add("И");
        myList.add("К");

        assertEquals("З",myList.get(6));
        assertEquals("И",myList.get(7));
        assertEquals("К",myList.get(8));
    }
    @Test
    public void testAddParametr(){
        myList.add(0, "З");
        myList.add(1, "И");
        myList.add(2, "К");
        assertEquals("З", myList.get(0));
        assertEquals("И", myList.get(1));
        assertEquals("К", myList.get(2));
    }
    @Test
    public void testDelete(){
        myList.delete(0);
        assertEquals("Е", myList.get(0));
        assertEquals("Г", myList.get(1));
        assertEquals("В", myList.get(2));
        assertEquals(5, myList.getSize());
    }
    @Test
    public void testDeleteItem(){
        myList.delete("Г");
        assertEquals("В", myList.get(2));
        assertEquals(5, myList.getSize());
    }
    @Test
    public void testSet(){
        myList.set(0, "test");
        assertEquals("test", myList.get(0));
        assertEquals(6, myList.getSize());
    }
    @Test
    public void testQuickSort(){
        myList.quickSort(Comparator.naturalOrder());

        assertEquals(6, myList.getSize());
        assertEquals("А", myList.get(0));
        assertEquals("Б", myList.get(1));
        assertEquals("В", myList.get(2));
        assertEquals("Г", myList.get(3));
        assertEquals("Д", myList.get(4));
        assertEquals("Е", myList.get(5));
    }
}

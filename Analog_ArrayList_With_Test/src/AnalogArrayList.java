import java.util.Arrays;
import java.util.Iterator;

public class AnalogArrayList<T> {
    private final int DEFAULT_CAPACITY = 16; // початковий розмір масиву
    private final int REDUCTION_SIZE = 4; // розмір масиву для зменшення
    private Object[] arrayObjects = new Object[DEFAULT_CAPACITY]; // масив зі стартовим розміром
    private int pointer = 0; // вказівник на граничну межу масиву

    public boolean add(T elementOfArray) { // додавання елемента в масив
        if (pointer == arrayObjects.length - 1) { // якщо досягли межі масиву
            Object[] newSizeArrayObjects = new Object[arrayObjects.length * 2]; // збільшуємо розмір масиву вдвічі
            System.arraycopy(arrayObjects, 0, newSizeArrayObjects, 0, pointer); // копіюємо елементи в новий збільшений масив
            arrayObjects = newSizeArrayObjects; // оновлюємо посилання на масив
        }
        arrayObjects[pointer] = elementOfArray; // крайньому елементу присвоюємо значення доданого елемента
        pointer++; // збільшуємо вказівник межі масиву
        return true;
    }

    public boolean remove(int index) { // видалення елемента масиву за індексом
        for (int i = index; i < pointer; i++) { // проходимо циклом від заданого індексу до межі масиву
            arrayObjects[i] = arrayObjects[i + 1]; // зміщуємо всі елементи праворуч від видаленого вліво
        }
        arrayObjects[pointer] = null; // останньому елементу присвоюємо значення null
        pointer--; // зменшуємо вказівник межі масиву

        if (arrayObjects.length > DEFAULT_CAPACITY && pointer < arrayObjects.length / REDUCTION_SIZE) { 
            // якщо елементів у масиві менше, ніж його довжина, поділена на REDUCTION_SIZE, зменшуємо масив
            Object[] newSizeArrayObjects = new Object[arrayObjects.length / 2]; // зменшуємо розмір масиву вдвічі
            System.arraycopy(arrayObjects, 0, newSizeArrayObjects, 0, pointer); // копіюємо заповнені елементи
            arrayObjects = newSizeArrayObjects; // оновлюємо посилання на масив
        }
        return true;
    }

    public int size() { // метод для отримання розміру масиву
        return pointer; // розмір масиву дорівнює вказівнику межі
    }

    public T get(int index) { // повертаємо елемент масиву за індексом
        T obj = null; // створюємо змінну посилання типу T
        if (index > pointer || index < 0) { // якщо індекс поза межами або негативний
            obj = (T) new String("IndexOutOfBoundsException"); // присвоюємо змінній повідомлення про помилку
        } else { 
            obj = (T) arrayObjects[index]; // повертаємо елемент масиву за індексом
        }
        return (T) obj; // повертаємо змінну, приведену до типу Generics
    }

    public void print() { // метод для виведення масиву на консоль
        Iterator<Object> iterator = Arrays.stream(arrayObjects).iterator(); // отримуємо ітератор для масиву
        while (iterator.hasNext()) { // перевіряємо наявність елементів у масиві
            var object = iterator.next(); // отримуємо поточний елемент
            if (object != null) 
                System.out.println(object); // друкуємо елемент, якщо він не null
        }
    }

    public boolean contains(T elementOfArray) { // метод для перевірки наявності елемента в масиві
        for (Object element : arrayObjects) { // для кожного елемента масиву
            if (element.equals(elementOfArray)) { // якщо елемент масиву дорівнює заданому
                return true; // повертаємо істину
            }
        }
        return false; // якщо елемент не знайдено, повертаємо хибу
    }
}

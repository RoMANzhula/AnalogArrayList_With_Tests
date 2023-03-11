
import org.junit.Assert;
import org.junit.Test;

public class AnalogArrayListTest {

    @Test
    public void add() {
        AnalogArrayList<String> analogArrayList = new AnalogArrayList<String>();
        var result3 = analogArrayList.add("one");
        var expected = true;
        Assert.assertEquals(expected, result3);
    }

    @Test
    public void remove() {
        AnalogArrayList<String> analogArrayList = new AnalogArrayList<String>();
        analogArrayList.add("three");
        analogArrayList.add("two");
        var result2 = analogArrayList.remove(1);
        String result2_1 = (String) analogArrayList.get(1);
        Assert.assertTrue(result2);
        Assert.assertEquals(null, result2_1);
    }

    @Test
    public void size() {
        AnalogArrayList<String> analogArrayList = new AnalogArrayList<String>();
        analogArrayList.add("three");
        analogArrayList.add("two");
        analogArrayList.add("one");
        var result = analogArrayList.size();
        var expected = 3;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void get() {
        AnalogArrayList<String> analogArrayList = new AnalogArrayList<String>();
        analogArrayList.add("three");
        analogArrayList.add("two");
        var result = analogArrayList.get(1);
        var expected = "two";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void contains() {
        AnalogArrayList<String> analogArrayList = new AnalogArrayList<String>();
        analogArrayList.add("one");
        Assert.assertTrue(analogArrayList.contains("one"));
    }
}
import java.util.*;
import java.io.*;


public class coreCodeTest
{
    public static void main(String[] args)
    {
    testcase1();
    System.out.println("Test 1 Sucessful");

    testcase2();
    System.out.println("Test 2 Sucessful");

    testcase3();
    System.out.println("Test 3 Sucessful");

    testcase4();
    System.out.println("Test 4 Sucessful");

    testcase5();
    System.out.println("Test 5 Sucessful");

    testcase6();
    System.out.println("Test 6 Sucessful");

    testcase7();
    System.out.println("Test 7 Sucessful");
    }

    public static void testcase1()
{
     String simInput = "thilina";
     System.setIn(new ByteArrayInputStream(simInput.getBytes()));
     assert "value Converted to uppercase : THILINA\nvalue Converted to Lowercase : thilina".equals(coreCode.stringCase("thilina"));
}

public static void testcase2()
{


System.setIn(new ByteArrayInputStream("thi210li388na".getBytes()));
assert "\nThe entered string contain numerical values".equals(coreCode.numScan());


}

public static void testcase3()
{


System.setIn(new ByteArrayInputStream("athukorala".getBytes()));
assert "\nThe entered string do not contain numerical values".equals(coreCode.numScan());


}

public static void testcase4()
{

    System.setIn(new ByteArrayInputStream("210388".getBytes()));
    assert "It is a valid number".equals(coreCode.valNum());
    
    
}

public static void testcase5()
{

    System.setIn(new ByteArrayInputStream("38875thilina".getBytes()));
    assert "It is a not a valid number".equals(coreCode.valNum());
    
    
}

public static void testcase6()
{

    System.setIn(new ByteArrayInputStream("388.75".getBytes()));
    assert "It is a decimal number".equals(coreCode.valNum());
    
    
}

public static void testcase7()
{

    System.setIn(new ByteArrayInputStream("Athukorala21038875".getBytes()));
    assert ("value Converted to uppercase : ATHUKORALA\nvalue Converted to Lowercase : athukorala" ).equals(coreCode.remDigit());
    
    
}

}


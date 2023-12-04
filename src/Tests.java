
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    //check negative-positive
    @Test
    public void CheckNegative() {
        Assertions.assertEquals(-100, Integer.decode("-100"));
    }

    @Test
    public void CheckPositive() {
        Assertions.assertEquals(100, Integer.decode("+100"));
    }

    //check null
    @Test
    public void CheckNullException() {

        NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
            Integer.decode(null);
        });
        Assertions.assertEquals(NullPointerException.class, thrown.getClass());
    }

    //check format

    @Test
    public void CheckZeroLengthException() {

        NumberFormatException thrown = Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.decode("");
        });
        Assertions.assertEquals(NumberFormatException.class, thrown.getClass());
    }

    @Test
    public void CheckWrongFormatException() {

        NumberFormatException thrown = Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.decode("asdasd");
            Integer.decode("gdf");
            Integer.decode("34h");
        });
        Assertions.assertEquals(NumberFormatException.class, thrown.getClass());
    }

    @Test
    public void CheckSignPositionException() {

        NumberFormatException thrown = Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.decode("--111");
            Integer.decode("111--");
            Integer.decode("11+1");
        });
        Assertions.assertEquals(NumberFormatException.class, thrown.getClass());
    }

    //HEX
    @Test
    public void CheckHexWithSmallX(){
        assertEquals(Integer.decode("-0x200"), -512);
        assertEquals(Integer.decode("0x200"), 512);
    }

    @Test
    public void CheckHexWithX(){
        assertEquals(Integer.decode("-0X200"), -512);
        assertEquals(Integer.decode("0X200"), 512);
    }

    @Test
    public void CheckHexWithSharp(){
        assertEquals(Integer.decode("-#200"), -512);
        assertEquals(Integer.decode("#200"), 512);
    }

    //octal
    @Test
    public void CheckOctal() {
        assertEquals(Integer.valueOf(-0200), Integer.decode("-128"));
        assertEquals(Integer.valueOf(0200), Integer.decode("128"));
    }
}

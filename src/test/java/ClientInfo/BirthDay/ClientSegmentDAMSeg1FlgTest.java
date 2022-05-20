package ClientInfo.BirthDay;

import ClientInfo.Helper.DAMSeg1FlgTrue;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class ClientSegmentDAMSeg1FlgTest {
    @Test
    public void ClientSegmentDAMSeg1Flg() {
        ArrayList<String> client = new DAMSeg1FlgTrue().getSegments();

        assertEquals("1234567897", client.get(0));
        assertEquals("17", client.get(1));
        assertEquals("8", client.get(2));
        assertEquals("2005", client.get(3));
        assertEquals("MONEYBOX", client.get(4));
        assertEquals("100000", client.get(5));
        assertEquals("10000", client.get(6));
    }
}

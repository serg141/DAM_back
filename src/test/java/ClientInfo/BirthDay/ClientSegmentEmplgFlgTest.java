package ClientInfo.BirthDay;

import ClientInfo.Helper.EmplFlgTrue;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ClientSegmentEmplgFlgTest {
    @Test
    public void ClientSegmentDAMSeg1Flg() {
        ArrayList<String> client = new EmplFlgTrue().getSegments();

        assertEquals("1234567895", client.get(0));
        assertEquals("VTB_EMPLOYEE", client.get(1));
    }
}

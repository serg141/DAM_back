package ClientInfo.BirthDay;

import ClientInfo.Helper.StLstCrmFlgTrue;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ClientSegmentStLstCrmFlgTest {
    @Test
    public void ClientSegmentDAMSeg1Flg() {
        ArrayList<String> client = new StLstCrmFlgTrue().getSegments();

        assertEquals("1234567896", client.get(0));
        assertEquals("REFUSE_AD", client.get(1));
        assertEquals("SALARY_SERVICE", client.get(2));
    }
}

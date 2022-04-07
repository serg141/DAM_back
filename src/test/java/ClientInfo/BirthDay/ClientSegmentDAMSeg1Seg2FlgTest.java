package ClientInfo.BirthDay;

import ClientInfo.Helper.DAMSeg1Seg2FlgTrue;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;

public class ClientSegmentDAMSeg1Seg2FlgTest {
    @Test
    public void ClientSegmentDAMSeg1Flg() {
       ArrayList<String> client = new DAMSeg1Seg2FlgTrue().getSegments();

       assertFalse(client.get(0).contains("SPEND"));
    }
}

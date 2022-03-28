package DAM.Tests.Placements.Lists;

import DAM.Helper.Placements.BulletedList;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateBulletedListTest {

    @Test
    public void createBulletedListTest() throws JSONException {

        String[] bulleted = new BulletedList().getBulletedList();

        assertEquals("BulletedList", bulleted[0]);
        assertEquals("BULLETED_LIST", bulleted[1]);
        assertEquals("Заголовок списка", bulleted[2]);
        assertEquals("description", bulleted[3]);
        assertEquals("TEXT", bulleted[4]);
        assertEquals("LIST_ROW_TITLE", bulleted[5]);
    }
}

package DAM.Tests.Placements.Lists;

import DAM.Helper.Placements.BulletedList;
import org.json.JSONException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CreateBulletedListTest {

    @Test
    public void createBulletedListTest() throws JSONException {
        ArrayList<String> bulleted = new BulletedList().getBulletedList();

        assertEquals("BulletedList", bulleted.get(0));
        assertEquals("BULLETED_LIST", bulleted.get(1));
        assertEquals("Заголовок списка", bulleted.get(2));
        assertEquals("description", bulleted.get(3));
        assertEquals("TEXT", bulleted.get(4));
        assertEquals("LIST_ROW_TITLE", bulleted.get(5));
    }
}

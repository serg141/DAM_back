package DAM.Tests.Placements.Lists;

import DAM.Helper.Placements.IconList;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateIconListTest {

    @Test
    public void createIconListTest() throws JSONException {
        String[] icon = new IconList().getIconList();

        assertEquals("IconList", icon[0]);
        assertEquals("ICON_LIST", icon[1]);
        assertEquals("Иконка", icon[2]);
        assertEquals("image", icon[3]);
        assertEquals("IMAGE", icon[4]);
        assertEquals("Заголовок", icon[5]);
        assertEquals("title", icon[6]);
        assertEquals("TEXT", icon[7]);
        assertEquals("LIST_ROW_TITLE", icon[8]);
    }
}

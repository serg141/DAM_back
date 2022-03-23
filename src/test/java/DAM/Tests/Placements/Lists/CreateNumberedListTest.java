package DAM.Tests.Placements.Lists;

import DAM.Helper.Placements.NumberedList;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateNumberedListTest {

    @Test
    public void createNumberedListTest() throws JSONException {
        String[] number = new NumberedList().getNumberList();

        assertEquals("NumberedList", number[0]);
        assertEquals("NUMBERED_LIST", number[1]);
        assertEquals("Заголовок", number[2]);
        assertEquals("title", number[3]);
        assertEquals("TEXT", number[4]);
        assertEquals("LIST_ROW_TITLE", number[5]);
        assertEquals("Описание", number[6]);
        assertEquals("description2", number[7]);
        assertEquals("TEXT", number[8]);
        assertEquals("LIST_ROW_DESCRIPTION", number[9]);
    }
}

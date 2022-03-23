package DAM.Tests.Placements.Lists;

import DAM.Helper.Placements.LinkList;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateLinkListTest {

    @Test
    public void createLinkListTest() throws JSONException {
        String[] links = new LinkList().getLinkList();

        assertEquals("LinkList", links[0]);
        assertEquals("LINK_LIST", links[1]);
        assertEquals("Фон ссылки", links[2]);
        assertEquals("body", links[3]);
        assertEquals("BLOCK", links[4]);
        assertEquals("STYLE_IMAGE", links[5]);
        assertEquals("Ссылка", links[6]);
        assertEquals("description", links[7]);
        assertEquals("TEXT", links[8]);
    }
}

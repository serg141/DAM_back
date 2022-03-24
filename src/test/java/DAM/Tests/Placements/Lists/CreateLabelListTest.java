package DAM.Tests.Placements.Lists;

import DAM.Helper.Placements.LabelList;
import org.json.JSONException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateLabelListTest {

    @Test
    public void createLabelListTest() throws JSONException {
        String[] label = new LabelList().getLabelList();

        assertEquals("LabelList", label[0]);
        assertEquals("LABEL_LIST", label[1]);
        assertEquals("STYLE_IMAGE", label[2]);
        assertEquals("Фон метки", label[3]);
        assertEquals("body", label[4]);
        assertEquals("BLOCK", label[5]);
        assertEquals("Метка", label[6]);
        assertEquals("description", label[7]);
        assertEquals("TEXT", label[8]);
    }
}

package DAM.Tests.Flight.SegmentCategoriesSocial;

import DAM.Helper.SegmentCategories.SegmentCategories;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GetSegmentsCategoriesSocialTest {

    @Test
    public void getSegmentsCategoriesSocialTest() {
        ArrayList<String> categories = new SegmentCategories().getCategories();

        assertEquals("SPEND", categories.get(0));
        assertEquals("CLIENTTYPE", categories.get(1));
        assertEquals("BLACKLIST", categories.get(2));
        assertEquals("AGE", categories.get(3));
        assertEquals("GENDER", categories.get(4));
    }
}

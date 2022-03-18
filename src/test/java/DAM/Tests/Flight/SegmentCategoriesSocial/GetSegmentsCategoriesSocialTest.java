package DAM.Tests.Flight.SegmentCategoriesSocial;

import DAM.SegmentCategories.GetSegmentCategories;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetSegmentsCategoriesSocialTest {

    @Test
    public void getSegmentsCategoriesSocialTest() {
        String[] categories = new GetSegmentCategories().getCategories();

        assertEquals("SPEND", categories[0]);
        assertEquals("CLIENTTYPE", categories[1]);
        assertEquals("BLACKLIST", categories[2]);
        assertEquals("AGE", categories[3]);
        assertEquals("GENDER", categories[4]);
    }
}

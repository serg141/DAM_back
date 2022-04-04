package DAM.Tests.Moderation;

import DAM.Parametrs.Moderation.ModerationDeclineParameters;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ModerationCommentsTest {
    Integer[] numberStage = new Integer[6];
    List<String> mappingKey, commentType, comment;
    List<Integer> stage;

    @Before
    public void getEndpoint() throws JSONException {

        for (int i = 0; i < 6; i++) numberStage[i] = i;

        ArrayList<String> idList = new DAM.Parametrs.Moderation.SendToModeration().getIdList();
        String body = idList.get(0);
        String body1 = new ModerationDeclineParameters().getComments();
        String id = idList.get(1);

        given().body(body).when().put("moderation");
        given().when().put(id + "/moderation/start");
        given().body(body1).when().put(id + "/moderation/decline");
        Response response = given().when().get(id + "/moderation/comments").then().extract().response();

        mappingKey = response.path("mappingKey");
        stage = response.path("stage");
        commentType = response.path("commentType");
        comment = response.path("comment");
    }

    @Test
    public void moderationCommentsBasicInfo() {
        assertEquals("basicInfo.name", mappingKey.get(0));
        assertEquals("basicInfo.period", mappingKey.get(1));
        assertEquals("basicInfo.frequency", mappingKey.get(2));
        assertEquals("basicInfo.priority", mappingKey.get(3));
        assertEquals("basicInfo", mappingKey.get(4));

        for(int i = 0; i < 5; i++) {
            assertEquals(numberStage[1], stage.get(i));
            assertEquals("Test" + i, comment.get(i));
        }

        for(int j = 0; j < 4; j++) {
            assertEquals("ATTRIBUTE", commentType.get(j));
        }
        assertEquals("STAGE", commentType.get(4));
    }

    @Test
    public void moderationCommentsPlacementInfo() {
        assertEquals("placementInfo", mappingKey.get(5));
        assertEquals(numberStage[2], stage.get(5));
        assertEquals("STAGE", commentType.get(5));
        assertEquals("Test5", comment.get(5));
    }

    @Test
    public void moderationCommentsSocialSegmentsInfo() {
        assertEquals("socialSegmentsInfo.segments", mappingKey.get(6));
        assertEquals("socialSegmentsInfo.age", mappingKey.get(7));
        assertEquals("socialSegmentsInfo", mappingKey.get(8));

        for(int i = 6; i < 9; i++) {
            assertEquals(numberStage[3], stage.get(i));
            assertEquals("Test" + i, comment.get(i));
        }

        for(int i = 6; i < 7; i++) {
            assertEquals("ATTRIBUTE", commentType.get(i));
        }
        assertEquals("STAGE", commentType.get(8));
    }

    @Test
    public void moderationCommentsTechSegmentsInfo() {
        assertEquals("techSegmentsInfo.appInfo", mappingKey.get(9));
        assertEquals("techSegmentsInfo.AR", mappingKey.get(10));
        assertEquals("techSegmentsInfo", mappingKey.get(11));

        for(int i = 9; i < 12; i++) {
            assertEquals(numberStage[4], stage.get(i));
            assertEquals("Test" + i, comment.get(i));
        }

        for(int i = 9; i < 11; i++) {
            assertEquals("ATTRIBUTE", commentType.get(i));
        }
        assertEquals("STAGE", commentType.get(11));
    }

    @Test
    public void moderationCommentsCreativesInfo() {
        assertEquals("creativesInfo", mappingKey.get(12));
        assertEquals(numberStage[5], stage.get(12));
        assertEquals("Test" + 12, comment.get(12));
        assertEquals("STAGE", commentType.get(12));
    }

    @Test
    public void moderationCommentsFlightInfo() {
        assertEquals("flight", mappingKey.get(13));
        assertEquals(numberStage[0], stage.get(13));
        assertEquals("Test" + 13, comment.get(13));
        assertEquals("STAGE", commentType.get(13));
    }
}

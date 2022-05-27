package DAM.Parametrs.Moderation;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Data
public class ModerationDeclineParameters {
    JSONArray comments = new JSONArray();

    public ModerationDeclineParameters() throws JSONException {
        JSONObject blockName = new JSONObject();
        JSONObject blockPeriod = new JSONObject();
        JSONObject blockFrequency = new JSONObject();
        JSONObject blockPriority = new JSONObject();
        JSONObject basicInfo = new JSONObject();
        JSONObject placementInfo = new JSONObject();
        JSONObject blockSegments = new JSONObject();
        JSONObject blockAge = new JSONObject();
        JSONObject socialSegmentsInfo = new JSONObject();
        JSONObject blockAppInfo = new JSONObject();
        JSONObject blockAR = new JSONObject();
        JSONObject techSegmentsInfo = new JSONObject();
        JSONObject creativesInfo = new JSONObject();
        JSONObject flight = new JSONObject();

        blockName.put("mappingKey", "basicInfo.name");
        blockName.put("stage", 1);
        blockName.put("commentType", "ATTRIBUTE");
        blockName.put("comment", "Test0");

        blockPeriod.put("mappingKey", "basicInfo.period");
        blockPeriod.put("stage", 1);
        blockPeriod.put("commentType", "ATTRIBUTE");
        blockPeriod.put("comment", "Test1");

        blockFrequency.put("mappingKey", "basicInfo.frequency");
        blockFrequency.put("stage", 1);
        blockFrequency.put("commentType", "ATTRIBUTE");
        blockFrequency.put("comment", "Test2");

        blockPriority.put("mappingKey", "basicInfo.priority");
        blockPriority.put("stage", 1);
        blockPriority.put("commentType", "ATTRIBUTE");
        blockPriority.put("comment", "Test3");

        basicInfo.put("mappingKey", "basicInfo");
        basicInfo.put("stage", 1);
        basicInfo.put("commentType", "STAGE");
        basicInfo.put("comment", "Test4");

        placementInfo.put("mappingKey", "placementInfo");
        placementInfo.put("stage", 2);
        placementInfo.put("commentType", "STAGE");
        placementInfo.put("comment", "Test5");

        blockSegments.put("mappingKey", "socialSegmentsInfo.segments");
        blockSegments.put("stage", 3);
        blockSegments.put("commentType", "ATTRIBUTE");
        blockSegments.put("comment", "Test6");

        blockAge.put("mappingKey", "socialSegmentsInfo.age");
        blockAge.put("stage", 3);
        blockAge.put("commentType", "ATTRIBUTE");
        blockAge.put("comment", "Test7");

        socialSegmentsInfo.put("mappingKey", "socialSegmentsInfo");
        socialSegmentsInfo.put("stage", 3);
        socialSegmentsInfo.put("commentType", "STAGE");
        socialSegmentsInfo.put("comment", "Test8");

        blockAppInfo.put("mappingKey", "techSegmentsInfo.appInfo");
        blockAppInfo.put("stage", 4);
        blockAppInfo.put("commentType", "ATTRIBUTE");
        blockAppInfo.put("comment", "Test9");

        blockAR.put("mappingKey", "techSegmentsInfo.AR");
        blockAR.put("stage", 4);
        blockAR.put("commentType", "ATTRIBUTE");
        blockAR.put("comment", "Test10");

        techSegmentsInfo.put("mappingKey", "techSegmentsInfo");
        techSegmentsInfo.put("stage", 4);
        techSegmentsInfo.put("commentType", "STAGE");
        techSegmentsInfo.put("comment", "Test11");

        creativesInfo.put("mappingKey", "creativesInfo");
        creativesInfo.put("stage", 5);
        creativesInfo.put("commentType", "STAGE");
        creativesInfo.put("comment", "Test12");

        flight.put("mappingKey", "flight");
        flight.put("stage", 0);
        flight.put("commentType", "STAGE");
        flight.put("comment", "Test13");

        comments.put(blockName);
        comments.put(blockPeriod);
        comments.put(blockFrequency);
        comments.put(blockPriority);
        comments.put(basicInfo);
        comments.put(placementInfo);
        comments.put(blockSegments);
        comments.put(blockAge);
        comments.put(socialSegmentsInfo);
        comments.put(blockAppInfo);
        comments.put(blockAR);
        comments.put(techSegmentsInfo);
        comments.put(creativesInfo);
        comments.put(flight);
    }
}

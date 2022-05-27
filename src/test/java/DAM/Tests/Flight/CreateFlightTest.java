package DAM.Tests.Flight;

import DAM.Helper.Flights.CreateFlights;
import org.json.JSONException;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateFlightTest {

    @Test (priority = 1)
    public void successCreateStepOne() throws JSONException {
        ArrayList<String> dataFlightStepOne = new CreateFlights().CreateStepOne();

        assertEquals("FlightTest", dataFlightStepOne.get(0));
        assertEquals("DRAFT", dataFlightStepOne.get(1));
        assertEquals("STANDARD", dataFlightStepOne.get(2));
        assertEquals("DAILY", dataFlightStepOne.get(3));
        assertEquals("Камынин Сергей Игоревич", dataFlightStepOne.get(4));
    }

    @Test (priority = 2)
    public void successCreateStepTwo() throws JSONException {
        ArrayList<String> dataFlightStepTwo = new CreateFlights().CreateStepTwo();

        assertEquals("Мобильный Банк", dataFlightStepTwo.get(0));
        assertEquals("MOBILE", dataFlightStepTwo.get(1));
        assertEquals("Главный Экран", dataFlightStepTwo.get(2));
        assertEquals("MAIN_PAGE", dataFlightStepTwo.get(3));
        assertEquals("Баннер при входе", dataFlightStepTwo.get(4));
        assertEquals("FULL_SCREEN", dataFlightStepTwo.get(5));
        assertEquals("Информационный Pre-roll", dataFlightStepTwo.get(6));
        assertEquals("PRE-ROLL_INFO_1", dataFlightStepTwo.get(7));
    }

    @Test (priority = 3)
    public void successCreateStepThreeCsv() throws JSONException {
        ArrayList<String> dataFlightStepThree = new CreateFlights().CreateStepThreeWithCsv();

        assertEquals("mdm_id_10.csv", dataFlightStepThree.get(0));
        assertEquals("NOT_READY", dataFlightStepThree.get(1));
        assertEquals("Ожидает обработки.", dataFlightStepThree.get(2));
    }

    @Test (priority = 3)
    public void successCreateStepThreeAuth() throws JSONException {
        ArrayList<String> dataFlightStepThree = new CreateFlights().CreateStepThreeWithAuth();

        assertEquals("ee0ef64f-6e90-4f9c-981d-895288796529", dataFlightStepThree.get(0));
        assertTrue(dataFlightStepThree.get(1).contains("ageAll"));
        assertTrue(dataFlightStepThree.get(2).contains("genderAll"));
    }

    @Test (priority = 3)
    public void successCreateStepThreeNoCsv() throws JSONException {
        new CreateFlights().CreateStepThreeWithoutCsv();
    }

    @Test (priority = 4)
    public void successCreateWithOutVersion() throws JSONException {
        ArrayList<String> dataFlightWithOutTechVersion = new CreateFlights().CreateStepFourWithoutTech();

        assertEquals("64c2f22d-7566-48b3-a9cb-af11f1868494", dataFlightWithOutTechVersion.get(0));
        assertEquals("{}", dataFlightWithOutTechVersion.get(1));
        assertEquals("a27c47b7-500f-48d9-b4ff-517451c9c17e", dataFlightWithOutTechVersion.get(2));
        assertEquals("{}", dataFlightWithOutTechVersion.get(3));
        assertEquals("{}", dataFlightWithOutTechVersion.get(4));
    }

    @Test (priority = 4)
    public void successCreateWithVersions() throws JSONException {
        ArrayList<String> dataFlightWithTechVersion = new CreateFlights().CreateStepFourWithTech();
        assertEquals("64c2f22d-7566-48b3-a9cb-af11f1868494", dataFlightWithTechVersion.get(0));
        assertEquals("15.4.0", dataFlightWithTechVersion.get(1));
        assertEquals("15.4.2", dataFlightWithTechVersion.get(2));
        assertEquals("a27c47b7-500f-48d9-b4ff-517451c9c17e", dataFlightWithTechVersion.get(3));
        assertEquals("15.4.0", dataFlightWithTechVersion.get(4));
        assertEquals("15.4.2", dataFlightWithTechVersion.get(5));
    }

    @Test (priority = 5)
    public void successCreateFlightStepFiveGhostNone() throws JSONException {
        ArrayList<String> dataFlightStepFiveGhostNone = new CreateFlights().CreateStepFiveGhostNone();

        assertEquals("1", dataFlightStepFiveGhostNone.get(0));
        assertEquals("NONE", dataFlightStepFiveGhostNone.get(1));

        assertEquals("https://core-cms-backend.dso-core.apps.d0-oscp.corp.dev.vtb/projects/dam/files/597733151_33.png",
                dataFlightStepFiveGhostNone.get(2));
        assertEquals("image#root", dataFlightStepFiveGhostNone.get(3));
        assertEquals("IMAGE", dataFlightStepFiveGhostNone.get(4));
        assertEquals("2", dataFlightStepFiveGhostNone.get(5));
        assertEquals("INTERNAL", dataFlightStepFiveGhostNone.get(6));

        assertEquals("Заголовок", dataFlightStepFiveGhostNone.get(7));
        assertEquals("heading#root", dataFlightStepFiveGhostNone.get(8));
        assertEquals("TEXT", dataFlightStepFiveGhostNone.get(9));

        assertEquals("Описание", dataFlightStepFiveGhostNone.get(10));
        assertEquals("description#root", dataFlightStepFiveGhostNone.get(11));
        assertEquals("TEXT", dataFlightStepFiveGhostNone.get(12));

        assertEquals("body#root", dataFlightStepFiveGhostNone.get(13));
        assertEquals("BLOCK", dataFlightStepFiveGhostNone.get(14));
        assertEquals("2", dataFlightStepFiveGhostNone.get(15));
        assertEquals("INTERNAL", dataFlightStepFiveGhostNone.get(16));
        assertEquals("TIFFANY", dataFlightStepFiveGhostNone.get(17));
        assertEquals("#00BCD4", dataFlightStepFiveGhostNone.get(18));
        assertEquals("#FFFFFF", dataFlightStepFiveGhostNone.get(19));

        assertEquals("Creative", dataFlightStepFiveGhostNone.get(20));
        assertEquals("LIGHT_THEME", dataFlightStepFiveGhostNone.get(21));
        assertEquals("", dataFlightStepFiveGhostNone.get(22));
    }

    @Test (priority = 5)
    public void successCreateFlightStepFiveGhostWithPolling() throws JSONException {
        assertEquals("CROSS_WITH_POLLING", new CreateFlights().CreateStepFiveGhostWithPolling());
    }

    @Test (priority = 5)
    public void successCreateFlightStepFiveGhostWithOutPolling() throws JSONException {
        assertEquals("CROSS_WITHOUT_POLLING", new CreateFlights().CreateStepFiveGhostWithoutPolling());
    }

    @Test (priority = 6)
    public void successCreateFlightStepFivePrerollNone() throws JSONException {
        ArrayList<String> dataFlightStepFivePrerollNone = new CreateFlights().CreateStepFivePrerollNone();
        assertEquals("1", dataFlightStepFivePrerollNone.get(0));
        assertEquals("NONE", dataFlightStepFivePrerollNone.get(1));

        assertEquals("https://core-cms-backend.dso-core.apps.d0-oscp.corp.dev.vtb/projects/dam/files/597733151_33.png",
                dataFlightStepFivePrerollNone.get(2));
        assertEquals("preroll-image#root", dataFlightStepFivePrerollNone.get(3));
        assertEquals("IMAGE", dataFlightStepFivePrerollNone.get(4));
        assertEquals("Https:www.vtb.ru", dataFlightStepFivePrerollNone.get(5));
        assertEquals("EXTERNAL", dataFlightStepFivePrerollNone.get(6));

        assertEquals("Заголовок", dataFlightStepFivePrerollNone.get(7));
        assertEquals("preroll-heading#root", dataFlightStepFivePrerollNone.get(8));
        assertEquals("TEXT", dataFlightStepFivePrerollNone.get(9));

        assertEquals("Описание", dataFlightStepFivePrerollNone.get(10));
        assertEquals("preroll-description#root", dataFlightStepFivePrerollNone.get(11));
        assertEquals("TEXT", dataFlightStepFivePrerollNone.get(12));

        assertEquals("Кнопка", dataFlightStepFivePrerollNone.get(13));
        assertEquals("preroll-button#root", dataFlightStepFivePrerollNone.get(14));
        assertEquals("BUTTON", dataFlightStepFivePrerollNone.get(15));
        assertEquals("Https:www.vtb.ru", dataFlightStepFivePrerollNone.get(16));
        assertEquals("EXTERNAL", dataFlightStepFivePrerollNone.get(17));

        assertEquals("Creative", dataFlightStepFivePrerollNone.get(18));
        assertEquals("LIGHT_THEME", dataFlightStepFivePrerollNone.get(19));
        assertEquals("", dataFlightStepFivePrerollNone.get(20));
    }

    @Test (priority = 6)
    public void successCreateFlightStepFivePrerollWithOutPolling() throws JSONException {
        assertEquals("CROSS_WITHOUT_POLLING", new CreateFlights().CreateStepFivePrerollWithOutPolling());
    }

    @Test (priority = 6)
    public void successCreateFlightStepFivePrerollWithPolling() throws JSONException {
        assertEquals("CROSS_WITH_POLLING", new CreateFlights().CreateStepFivePrerollWithPolling());
    }

    @Test (priority = 7)
    public void successCreateFlightStepFiveSliderNone() throws JSONException {
        ArrayList<String> dataFlightStepFiveSliderNone = new CreateFlights().CreateStepFiveSliderNone();

        assertEquals("1", dataFlightStepFiveSliderNone.get(0));
        assertEquals("NONE", dataFlightStepFiveSliderNone.get(1));

        assertEquals("Заголовок", dataFlightStepFiveSliderNone.get(2));
        assertEquals("heading#root", dataFlightStepFiveSliderNone.get(3));
        assertEquals("TEXT", dataFlightStepFiveSliderNone.get(4));

        assertEquals("Описание", dataFlightStepFiveSliderNone.get(5));
        assertEquals("description#root", dataFlightStepFiveSliderNone.get(6));
        assertEquals("TEXT", dataFlightStepFiveSliderNone.get(7));

        assertEquals("body#root", dataFlightStepFiveSliderNone.get(8));
        assertEquals("BLOCK", dataFlightStepFiveSliderNone.get(9));
        assertEquals("FUCHSIA", dataFlightStepFiveSliderNone.get(10));
        assertEquals("#F86D86", dataFlightStepFiveSliderNone.get(11));
        assertEquals("#FFFFFF", dataFlightStepFiveSliderNone.get(12));

        assertEquals("label-body#root", dataFlightStepFiveSliderNone.get(13));
        assertEquals("BLOCK", dataFlightStepFiveSliderNone.get(14));
        assertEquals("ORANGE", dataFlightStepFiveSliderNone.get(15));
        assertEquals("#FF8515", dataFlightStepFiveSliderNone.get(16));
        assertEquals("#FFFFFF", dataFlightStepFiveSliderNone.get(17));

        assertEquals("label-text#root", dataFlightStepFiveSliderNone.get(18));
        assertEquals("Метка", dataFlightStepFiveSliderNone.get(19));
        assertEquals("TEXT", dataFlightStepFiveSliderNone.get(20));

        assertEquals("Кнопка", dataFlightStepFiveSliderNone.get(21));
        assertEquals("primary-button#root", dataFlightStepFiveSliderNone.get(22));
        assertEquals("BUTTON", dataFlightStepFiveSliderNone.get(23));
        assertEquals("2", dataFlightStepFiveSliderNone.get(24));
        assertEquals("DEEPLINK", dataFlightStepFiveSliderNone.get(25));

        assertEquals("Creative", dataFlightStepFiveSliderNone.get(26));
        assertEquals("LIGHT_THEME", dataFlightStepFiveSliderNone.get(27));
        assertEquals("", dataFlightStepFiveSliderNone.get(28));
    }

    @Test (priority = 7)
    public void successCreateFlightStepFiveSliderWithOutPolling() throws JSONException {
        assertEquals("CROSS_WITHOUT_POLLING", new CreateFlights().CreateStepFiveSliderWithOutPolling());
    }

    @Test (priority = 7)
    public void successCreateFlightStepFiveSliderWithPolling() throws JSONException {
        assertEquals("CROSS_WITH_POLLING", new CreateFlights().CreateStepFiveSliderWithPolling());
    }

    @Test (priority = 8)
    public void stepSixTest() throws JSONException {
        ArrayList<String> dataFlightStepSix = new CreateFlights().CreateStepSix();

        assertEquals("FlightTest", dataFlightStepSix.get(0));
        assertEquals("DAILY", dataFlightStepSix.get(1));
        assertEquals("Мобильный Банк", dataFlightStepSix.get(2));
        assertEquals("Главный Экран", dataFlightStepSix.get(3));
        assertEquals("Баннер при входе", dataFlightStepSix.get(4));
        assertEquals("Информационный Pre-roll", dataFlightStepSix.get(5));
        assertEquals("Траты клиента", dataFlightStepSix.get(6));
        assertEquals("Нет счета \"Копилка\"", dataFlightStepSix.get(7));
        assertEquals("IOS", dataFlightStepSix.get(8));
        assertEquals("15.4.0", dataFlightStepSix.get(9));
        assertEquals("15.4.2", dataFlightStepSix.get(10));
        assertEquals("15.4.1", dataFlightStepSix.get(11));
    }
}

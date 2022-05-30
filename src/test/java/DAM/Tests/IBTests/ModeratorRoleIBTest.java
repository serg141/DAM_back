package DAM.Tests.IBTests;

import DAM.Helper.IB.CheckRole;
import DAM.Helper.IB.ControlRoleIB;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;

public class ModeratorRoleIBTest {

    @BeforeClass
    public void SetRoleModerator() throws SQLException {
        new CheckRole().CheckRoleModerator();
    }

    @Test (priority = 1)
    public void RemoveChannelTest() {
        String error = new ControlRoleIB().RemoveChannelModerator();

        assertEquals("Нет доступа", error);
    }

    @Test (priority = 2)
    public void CreateChannelTest() {
        String error = new ControlRoleIB().CreateChannelModerator();

        assertEquals("Нет доступа", error);
    }

    @Test (priority = 3)
    public void EditChannelTest() {
        String error = new ControlRoleIB().EditChannelModerator();

        assertEquals("Нет доступа", error);
    }

    @Test (priority = 4)
    public void RemoveLocationTest() {
        String error = new ControlRoleIB().RemoveLocationModerator();

        assertEquals("Нет доступа", error);
    }

    @Test (priority = 5)
    public void CreateLocationTest() {
        String error = new ControlRoleIB().CreateLocationModerator();

        assertEquals("Нет доступа", error);
    }

    @Test (priority = 6)
    public void EditLocationTest() {
        String error = new ControlRoleIB().EditLocationModerator();

        assertEquals("Нет доступа", error);
    }

    @Test (priority = 7)
    public void RemovePositionTest() {
        String error = new ControlRoleIB().RemovePositionModerator();

        assertEquals("Нет доступа", error);
    }

    @Test (priority = 8)
    public void CreatePositionTest() {
        String error = new ControlRoleIB().CreatePositionModerator();

        assertEquals("Нет доступа", error);
    }

    @Test (priority = 9)
    public void EditPositionTest() {
        String error = new ControlRoleIB().EditPositionModerator();

        assertEquals("Нет доступа", error);
    }

    @Test (priority = 10)
    public void RemoveFormatTest() {
        String error = new ControlRoleIB().RemoveFormatModerator();

        assertEquals("Нет доступа", error);
    }

    @Test (priority = 11)
    public void CreateFormatTest() {
        String error = new ControlRoleIB().CreateFormatModerator();

        assertEquals("Нет доступа", error);
    }

    @Test (priority = 12)
    public void EditFormatTest() {
        String error = new ControlRoleIB().EditFormatModerator();

        assertEquals("Нет доступа", error);
    }

    @Test (priority = 13)
    public void RemoveTemplateTest() {
        String error = new ControlRoleIB().RemoveTemplateModerator();

        assertEquals("Нет доступа", error);
    }

    @Test (priority = 14)
    public void CreateTemplateTest() {
        String error = new ControlRoleIB().CreateTemplateModerator();

        assertEquals("Нет доступа", error);
    }

    @Test (priority = 15)
    public void EditTemplateTest() {
        String error = new ControlRoleIB().EditTemplateModerator();

        assertEquals("Нет доступа", error);
    }
}

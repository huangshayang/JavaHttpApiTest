package test.com.company; 

import com.company.LoginTest;
import com.company.LogoutTest;
import net.sf.json.JSONObject;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ApiTest {
    @Test
    public void testloginSuccess() throws Exception {
        JSONObject result = LoginTest.loginSuccess();
        assertEquals(200, Integer.parseInt(result.getString("status")));
        assertEquals("Operation is successful.", result.getString("message"));
    }
    @Test
    public void testlogoutSuccess() throws Exception {
        JSONObject result = LogoutTest.logoutSuccess();
        assertEquals(200, Integer.parseInt(result.getString("status")));
        assertEquals("Operation is successful.", result.getString("message"));
    }
}

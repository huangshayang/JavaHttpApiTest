package Java;

import com.hsy.resultparam.ResultParam;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by HSY on 2017/7/14.
 */
@RunWith(Parameterized.class)
public class LoginCaseTest {
    private int actCode;
    private String actMessage;
    private int expCode;
    private String expMessage;

    public LoginCaseTest(int expCode, int actCode, String expMessage, String actMessage) {
        this.expCode = expCode;
        this.actCode = actCode;
        this.expMessage = expMessage;
        this.actMessage = actMessage;
    }

    @Parameterized.Parameters
    public static Collection prepareData() throws IOException, ClassNotFoundException, NoSuchFieldException {
        ResultParam resultParam = new ResultParam("test_case.xlsx", 0);
        int size = resultParam.size();
        Object[][] objects = new Object[size][4];
        for (int i = 0; i < objects.length; i++) {
            objects[i][0] = resultParam.expCode().get(i);
            objects[i][1] = resultParam.actCode().get(i);
            objects[i][2] = resultParam.expMessage().get(i);
            objects[i][3] = resultParam.actMessage().get(i);
        }
        return Arrays.asList(objects);
    }

    @Test
    public void testLogin() {
        Assert.assertEquals(expCode, actCode);
        Assert.assertEquals(expMessage, actMessage);
    }
}

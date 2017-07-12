package hwp.basketball.mobility;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import net.danlew.android.joda.JodaTimeAndroid;

import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import hwp.basketball.mobility.account.login.LoginActivity;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@android.test.suitebuilder.annotation.SmallTest
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Exception {
        JodaTimeAndroid.init(InstrumentationRegistry.getTargetContext());
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("hwp.basketball.mobility", appContext.getPackageName());
    }

    @Test
    public void testDateFromat() {
        String now = LocalDateTime.now().toString("MM/dd/YYYY-HH:mm");
        System.out.println(now);
        assertEquals("", now);
    }
}

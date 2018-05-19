package me.tree.treehttp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TestHttp {
    @Test
    public void testHttpGet() {
        String url = "http://api.stay4it.com";
        Request request = new Request();
        request.url = url;
        String result = HttpUrlConnectionUtil.get(request);
        Log.i("tree", "testHttpGet request : " + result);
    }

    @Test
    public void testHttpPost(){
        String url = "http://api.stay4it.com/v1/public/core/?service=user.login";
        String content = "account=stay4it&password=123456";
        Request request = new request();
        request.url = url;
        request.content = content;
        String result = HttpUrlConnectionUtil.post(request);
        Log.i("tree", "testHttpPost request : " + result);

    }
}

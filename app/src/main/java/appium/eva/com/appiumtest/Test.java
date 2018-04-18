package appium.eva.com.appiumtest;

import com.alibaba.fastjson.JSON;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author eva
 * @date 2017/5/15
 */

public class Test {

    public static void main(String... args) {
        JSONObject object = new JSONObject();
        try {
            object.put("name", "android");
            object.put("key", "value");

            System.out.print(JSON.toJSONString(object));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

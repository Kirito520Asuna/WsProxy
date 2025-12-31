package com.cloud_guest;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.cloud_guest.domain.WsProxy;

/**
 * @Author yan
 * @Date 2025/12/31 21:50:51
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        WsProxy wsProxy = new WsProxy();
        String action = "send_private_msg";
        String userId = "xxxxxx";
        String test = "xxxxxx";
        String type = "text";
        String body = "{\n" +
                "        \"action\": \"" + action + "\",\n" +
                "        \"params\": {\n" +
                "            \"user_id\": \"" + userId + "\",\n" +
                "            \"message\": [{\n" +
                "                \"type\": \"" + type + "\",\n" +
                "                \"data\": {\n" +
                "                    \"text\": \"" + test + "\\n\"\n" +
                "                }\n" +
                "            }]\n" +
                "        }\n" +
                "    }";
        wsProxy.setBodyJson(body);
        wsProxy.setUrl("ws://ip:port/");
        wsProxy.setToken("token");
        HttpUtil.createPost("http://localhost:8080/message/send")
                .body(JSONUtil.toJsonStr(wsProxy))
                .execute();
    }
}

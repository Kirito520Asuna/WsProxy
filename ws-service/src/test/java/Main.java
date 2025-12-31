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
        String action = "send_private_msg";//私发 //send_group_msg //群发
        String userId = "1608362555";
        String test = "xxxxxx";
        String type = "text";//
        String urlWsProxy = "http://127.0.0.1:8081/ws-proxy/message/send/";//
        String url = "ws://39.108.183.241:3001/";//
        String token = "ws-token";//
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
        wsProxy.setUrl(url);
        wsProxy.setToken(token);
        HttpUtil.createPost(urlWsProxy)
                .body(JSONUtil.toJsonStr(wsProxy))
                .execute();
    }
}

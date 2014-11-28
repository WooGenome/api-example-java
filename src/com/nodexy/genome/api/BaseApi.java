package com.nodexy.genome.api;

/**
 * 23andme API wrapper 
 * 
 * ref. https://api.23andme.com/docs/reference   version20141126
 * 
 * @Title: BaseApi
 * @Description:
 * @Author: <a href="mailto:nodexy@gmail.com">Chris Yang</a>
 * @Since: 2014年11月26日 上午10:32:50
 * @Modified By:
 * @Modified Date:
 * @Why & What is modified:
 * @Version:1.0
 */
public class BaseApi {

    private String accessToken;

    public BaseApi(String accessToken) {
        this.accessToken = accessToken;
        // set HTTP header auth info
        // OAuth 2.0注意事项： 
        // 1 获取access_token时，请使用POST 
        // 2 访问需要授权的Api，请使用https协议，并且加上access token的Header 
        // 3 Header格式为"Authorization: Bearer access_token"，其中Bearer后面有一个空格 
    }

    public String getAccessToken(){
        return this.accessToken;
    }
}

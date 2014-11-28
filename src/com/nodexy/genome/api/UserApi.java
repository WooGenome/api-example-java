package com.nodexy.genome.api;

import java.util.Map;

import javax.servlet.http.HttpUtils;

import com.nodexy.genome.ApiConfig;
import com.nodexy.genome.util.HttpUtil;

public class UserApi extends BaseApi {

    public UserApi(String accessToken) {
        super(accessToken);
    }


    // /user
    public String getUser() {
        return getUser(false, false);
    }
    
    public String getUser(boolean needEmail,boolean needServices) {
        StringBuffer url = new StringBuffer(ApiConfig.API_ENDPOINT_URL_DEMO);
        url.append("/user/?");
        if(needEmail){
            url.append("email=true&");
        }
        if(needServices){
            url.append("services=true");
        }
        
        // http post 
        return HttpUtil.get(url.toString(),getAccessToken());
    }

    // /names
    public String getNames() {
        return getNames(null);
    }
    
    public String getNames(String profileId) {

        return null; // TODO
    }

    // /profile_picture 
    public String getProfilePicture() {

        return null; // TODO
    }

    public String postProfilePicture() {

        return null; // TODO
    }

    // /publish
    public String getPublish(String profileId, String featureId) {

        /*
         following feature_ids:

         music: DNA Music 
         neanderthal: Neanderthal Ancestry 
         maternal: Maternal Haplogroup 
         composition: Ancestry Composition 
         paternal: Paternal Haplogroup
         */
        
        return null;// TODO
    }
    
    public String getPublish(String profileId, String featureId, String linkId) {

        return null;// TODO
    }

    public String putPublish(String profileId, String featureId, String linkId) {

        return null;// TODO
    }

    public String postPublish(String profileId, String featureId) {

        return null;// TODO
    }

    // /introduction
    public String getIntroduction(String profileId,String matchId) {

        return null;// TODO
    }

    public String patchIntroduction(String profileId,String matchId, Map data) {

        return null;// TODO
    }

    public String postIntroduction(String profileId,String matchId, Map data) {

        return null;// TODO
    }
}

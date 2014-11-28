package com.nodexy.genome.api;

import com.nodexy.genome.util.HttpUtil;

public class AncestryApi extends BaseApi {

    public AncestryApi(String accessToken) {
        super(accessToken);
    }

    public String getHaplogroups(String profileId) {
        return HttpUtil.get("/haplogroups/" + profileId, getAccessToken());
    }

    public String getAncestry(String profileId, String threshold) {
        String url = "/ancestry/" + profileId;
        if (threshold != null) {
            url += ("threshold=" + threshold);
        }
        return HttpUtil.get(url, getAccessToken());
    }

    public String getFamilyMembers(Integer limit,Integer offset) {
        String url = "/family_memebers";
        if(limit!=null){
            url += ("?limit="+limit);
        }
        if(offset!=null){
            url += ("&offset="+offset);
        }
        return HttpUtil.get(url, getAccessToken());
    }

    public String getNeanderthal(String profileId) {
        return HttpUtil.get("/neanderthal/" + profileId, getAccessToken());
    }

    public String getRelatives(String profileId,Integer limit,Integer offset,String since,String shareStatus, String introStatus) {
        StringBuffer url = new StringBuffer("/relatives/").append(profileId);
        if(limit!=null){
            url.append("?limit="+limit);
        }
        if(offset!=null){
            url.append("?offset="+offset);
        }
        if(since!=null){
            url.append("?since="+since);
        }
        if(shareStatus!=null){
            url.append("?shareStatus="+shareStatus);
        }
        if(introStatus!=null){
            url.append("?introStatus="+introStatus);
        }
        return HttpUtil.get(url.toString(), getAccessToken());
    }

    public String patchRelatives(String profileId,String matchId,String notes,String userRelationshipCode) {
        StringBuffer url = new StringBuffer("/relatives/");
        url.append(profileId).append("/").append(matchId)
        .append("?notes=").append(notes)
        .append("&user_relationship_code="+userRelationshipCode);
        return HttpUtil.patch(url.toString(), getAccessToken(),null);
    }

}

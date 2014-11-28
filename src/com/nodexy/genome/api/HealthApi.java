package com.nodexy.genome.api;

import com.nodexy.genome.util.HttpUtil;

public class HealthApi extends BaseApi {

    public HealthApi(String accessToken) {
        super(accessToken);
    }

    public String getRisks(String profileId) {
        return HttpUtil.get("/risks/"+profileId,getAccessToken());
    }

    public String getCarriers(String profileId) {
        return HttpUtil.get("/carriers/"+profileId,getAccessToken());
    }

    public String getDrugResponses(String profileId) {
        return HttpUtil.get("/drug_responses/"+profileId,getAccessToken());
    }

    public String getTraits(String profileId) {
        return HttpUtil.get("/traits/"+profileId,getAccessToken());
    }

    public String getGrfs(String profileId) {
        return HttpUtil.get("/grfs/"+profileId,getAccessToken());
    }
}

package com.nodexy.genome.api;

import com.nodexy.genome.util.HttpUtil;

public class GeneticsApi extends BaseApi {

    public GeneticsApi(String accessToken) {
        super(accessToken);
    }

    public String getGenomes(String profileId,String unfiltered) {
        String url = "/genomes/"+profileId;
        if(unfiltered!=null){
            url+=("?unfiltered="+unfiltered);
        }
        return HttpUtil.get(url.toString(), getAccessToken());
    }

    public String getGenotypes(String profileId,String locations,
            String unfiltered, String format) {
        StringBuffer url = new StringBuffer("/genotypes/").append(profileId).append("?");
        if(locations!=null){
            url.append("locations="+locations);
        }
        if(unfiltered!=null){
            url.append("&unfiltered="+unfiltered);
        }
        if(format!=null){
            url.append("&format="+format);
        }
        
        return HttpUtil.get(url.toString(), getAccessToken());
    }
    
}

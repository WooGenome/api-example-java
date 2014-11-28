package com.nodexy.genome.api;

import com.nodexy.genome.util.HttpUtil;

public class PhenotypesApi extends BaseApi {

    public PhenotypesApi(String accessToken) {
        super(accessToken);
    }

    /*
     
     List of phenotypes you can get/set
For the /phenotypes read and write endpoints, your phenotype_id can be any of the following:

sex: sex
date_of_birth: date of birth (YYYY-MM-DD)
public_tree_url: public tree url
weight_g: weight in grams
height_mm: height in millimeters
     
     */

    public String get(String profileId, String phenotypeId) {
        String url = String.format("/phenotypes/%s/%s/",profileId,phenotypeId);
        
        return HttpUtil.get(url, getAccessToken());
    }

    public String put(String profileId, String phenotypeId, String data) {
        String url = String.format("/phenotypes/%s/%s/",profileId,phenotypeId);

        String params = "value=" +data;
        
        return HttpUtil.put(url, getAccessToken(),params);
    }
}

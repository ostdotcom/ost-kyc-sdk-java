package com.ost.kyc.services.v2;

import com.google.gson.JsonObject;
import com.ost.kyc.lib.OSTKYCRequestClient;
import com.ost.kyc.services.OSTKYCAPIService;

import java.io.IOException;
import java.util.Map;

public class UsersKycDetail extends OSTKYCAPIService {

    static String servicePrefix = "/api/v2/users-kyc-detail";
    public UsersKycDetail(OSTKYCRequestClient OSTKYCRequestClient) {
        super(OSTKYCRequestClient, servicePrefix);
    }

    /**
     * @param params Request Params
     * @return API Response
     */
    public JsonObject get(Map<String,Object> params) throws MissingParameter, IOException {
        String resource = this.urlPrefix + "/" + this.getUserId( params );
        return this.request.get(resource, params);
    }

}

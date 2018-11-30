package com.ost.kyc.services.v2;

import com.google.gson.JsonObject;
import com.ost.kyc.lib.OSTKYCRequestClient;
import com.ost.kyc.services.OSTKYCAPIService;

import java.io.IOException;
import java.util.Map;

public class Validators extends OSTKYCAPIService {

    static String servicePrefix = "/api/v2";
    public Validators(OSTKYCRequestClient OSTKYCRequestClient) {
        super(OSTKYCRequestClient, servicePrefix);
    }

    /**
     * @param params Request Params
     * @return API Response
     */
    public JsonObject verify_ethereum_address(Map<String,Object> params) throws IOException {
        String resource = this.urlPrefix + "/ethereum-address-validation";
        return this.request.get(resource, params);
    }

}

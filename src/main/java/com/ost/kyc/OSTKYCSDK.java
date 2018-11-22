package com.ost.kyc;

import com.ost.kyc.services.OSTKYCServiceManifest;
import com.ost.kyc.services.v2.Manifest;

import java.util.Map;

public class OSTKYCSDK {
    String apiEndpoint;
    String apiKey;
    String apiSecret;
    public OSTKYCServiceManifest services;

    public OSTKYCSDK(Map<String, Object> params) {
        if (params.containsKey("apiEndpoint") && params.get("apiEndpoint") instanceof String &&
                params.get("apiEndpoint") != "") {
            apiEndpoint = (String) params.get("apiEndpoint");
        } else {
            throw new IllegalArgumentException("Invalid apiEndpoint.");
        }

        if (params.containsKey("apiKey") && params.get("apiKey") instanceof String &&
                params.get("apiKey") != "") {
            apiKey = (String) params.get("apiKey");
        } else {
            throw new IllegalArgumentException("Invalid apiKey.");
        }

        if (params.containsKey("apiSecret") && params.get("apiSecret") instanceof String &&
                params.get("apiSecret") != "") {
            apiSecret = (String) params.get("apiSecret");
        } else {
            throw new IllegalArgumentException("Invalid apiSecret.");
        }

        services = new Manifest(params);

    }
}

package com.ost.kyc.services;

import com.ost.kyc.lib.OSTKYCRequestClient;

import java.util.Map;

public abstract class OSTKYCServiceManifest {

    protected OSTKYCRequestClient request;
    public OSTKYCServiceManifest(Map<String,Object> params) {
        request = new OSTKYCRequestClient( params );
    }

}

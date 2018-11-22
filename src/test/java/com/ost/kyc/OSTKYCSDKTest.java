package com.ost.kyc;

import com.ost.kyc.services.OSTKYCServiceManifest;
import com.ost.kyc.services.v2.Manifest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class OSTKYCSDKTest {

    private HashMap<String, Object> apiV2Params;

    @Before
    public void setUp() throws Exception {

        String apiKey = System.getenv("OST_KYC_API_KEY");
        if ( null == apiKey ) {
            throw new Exception("Environment Variable OST_KYC_API_KEY is not set.");
        }

        String apiSecret = System.getenv("OST_KYC_API_SECRET");
        if ( null == apiSecret ) {
            throw new Exception("Environment Variable OST_KYC_API_SECRET is not set.");
        }

        String v0Endpoint = System.getenv("OST_KYC_API_ENDPOINT");
        if ( null == v0Endpoint ) {
            throw new Exception("Environment Variable OST_KYC_API_ENDPOINT is not set.");
        }

        apiV2Params = new HashMap<String, Object>();
        apiV2Params.put( "apiKey", apiKey);
        apiV2Params.put( "apiSecret", apiSecret);
        apiV2Params.put( "apiEndpoint", v0Endpoint);

    }

    @Test
    public void createOSTSdkForV2Api() {
        OSTKYCSDK OSTKYCSDK = createSDKInstanceForV2API();
        assertNotNull(OSTKYCSDK);

        OSTKYCServiceManifest services = OSTKYCSDK.services;
        assert( services instanceof Manifest);
    }


    private OSTKYCSDK createSDKInstanceForV2API() {
        return new OSTKYCSDK( apiV2Params );
    }

}
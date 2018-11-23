package com.ost.kyc.services;

import com.google.gson.JsonObject;
import com.ost.kyc.OSTKYCSDK;
import org.junit.After;
import org.junit.Assert;

import java.util.HashMap;

public abstract class ServiceTestBase {
    private OSTKYCSDK OSTKYCSDK;
    private HashMap<String, Object> apiParams;
    protected OSTKYCServiceManifest services;
    private OSTKYCAPIService service;

    public void setUp() throws Exception {

        String apiKey = System.getenv("OST_KYC_API_KEY");
        if ( null == apiKey ) {
            throw new Exception("Environment Variable OST_KYC_API_KEY is not set.");
        }

        String apiSecret = System.getenv("OST_KYC_API_SECRET");
        if ( null == apiSecret ) {
            throw new Exception("Environment Variable OST_KYC_API_SECRET is not set.");
        }

        String apiEndPoint = System.getenv("OST_KYC_API_ENDPOINT");
        if ( null == apiEndPoint ) {
            throw new Exception("apiEndPoint can not be null.");
        }

        apiParams = new HashMap<String, Object>();
        apiParams.put( "apiKey", apiKey);
        apiParams.put( "apiSecret", apiSecret);
        apiParams.put( "apiEndpoint", apiEndPoint);

        OSTKYCSDK = new OSTKYCSDK(apiParams);
        services = OSTKYCSDK.services;
    }

    protected static void validateResponseWithSuccess(JsonObject response) {

        // Validate presence of success key in response.
        Assert.assertEquals( "success key missing in response.", true, response.has("success") );

        // Validate Success Flag.
        boolean success = response.get("success").getAsBoolean();
        Assert.assertEquals( success, true);

    }

    @After
    public void tearDown() throws Exception {
        OSTKYCSDK = null;
        apiParams.clear();
        apiParams = null;
    }

    protected void setService(OSTKYCAPIService service) {
        this.service = service;
    }

    public OSTKYCAPIService getService() {
        return service;
    }
    public OSTKYCServiceManifest getServiceManifest() {
        return services;
    }
}

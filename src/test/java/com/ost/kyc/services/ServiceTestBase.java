package com.ost.kyc.services;

import com.google.gson.JsonObject;
import com.ost.kyc.OSTKYCSDK;
import org.junit.After;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public abstract class ServiceTestBase {
    private OSTKYCSDK OSTKYCSDK;
    private HashMap<String, Object> apiParams;
    protected OSTKYCServiceManifest services;
    private OSTKYCAPIService service;
    private static final int sleepMilliSeconds = 300;

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


    public static void validateResponseWithSuccess( JsonObject response ) {
        validateResponseWithSuccess(response, null, false);
    }
    public static void validateResponseWithSuccess( JsonObject response, String resultType ) {
        validateResponseWithSuccess(response, resultType, false);
    }
    protected static void validateResponseWithSuccess(JsonObject response, String resultType, Boolean isArrayResultType) {


        // Validate presence of basic keys in response.
        Assert.assertEquals( "success key missing in response.", true, response.has("success") );
        Assert.assertEquals( "data key missing in response.", true,  response.has("data") );

        // Validate Success Flag.
        boolean success = response.get("success").getAsBoolean();
        Assert.assertEquals( success, true);

        // Validate data is not an empty Object.
        JsonObject data = response.get("data").getAsJsonObject();
        Assert.assertTrue( data.size() > 0 );

        if ( null == resultType ) {
            return;
        }

        Assert.assertEquals(resultType + " key missing in response.", data.has( resultType ), true );

        if ( !isArrayResultType ) {
            return;
        }

        JsonObject results = data.get( resultType ).getAsJsonObject();
        Assert.assertTrue( results.size() > 0 );
    }

    protected static void validateResult( Map<String,Object> params, JsonObject result ) {
        for( Map.Entry<String,Object> param: params.entrySet() ) {
            String paramKey  = param.getKey();

            Assert.assertEquals("result does not contain key" + paramKey, true, result.has( paramKey ) );

            String paramVal  = param.getValue().toString();
            String resultVal = result.get( paramKey ).getAsString();
            Assert.assertEquals("result value for key " + paramKey + " does not match expected value.", paramVal, resultVal );

        }
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

package com.ost.kyc;

import com.google.gson.JsonObject;
import com.ost.kyc.OSTKYCSDK;
import com.ost.kyc.services.OSTKYCAPIService;
import java.io.IOException;
import java.util.HashMap;

public class TestMain {
    private static com.ost.kyc.services.v2.Manifest services;

    public static void main(String[] args) throws IOException, OSTKYCAPIService.MissingParameter {
        HashMap<String, Object> sdkConfig = new HashMap<String, Object>();
        sdkConfig.put("apiEndpoint", "kyc.developmentost.com:8080");
        sdkConfig.put("apiKey", "28ad8ebb00c8469e1e32156849e94b3f"); // replace with the API Key you obtained earlier
        sdkConfig.put("apiSecret", "511e8f559f4a3bb8ff75071253bb13a0"); // replace with the API Secret you obtained earlier

        // Initialize SDK object
        OSTKYCSDK ostObj = new OSTKYCSDK(sdkConfig);
        services = (com.ost.kyc.services.v2.Manifest) ostObj.services;

        com.ost.kyc.services.v2.User userService = services.user;
        HashMap <String,Object> params = new HashMap<String,Object>();
        params.put("id", "11007");
        JsonObject response = userService.get( params );
        System.out.println("response: " + response.toString() );
    }
}
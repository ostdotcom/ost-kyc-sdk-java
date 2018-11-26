package com.ost.kyc.services.v2;

import com.google.gson.JsonObject;
import com.ost.kyc.services.ServiceTestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashMap;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsersKycDetailTest extends ServiceTestBase {

    @Override
    public UsersKycDetail getService() {
        return (UsersKycDetail) super.getService();
    }

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        setService(getServiceManifest().usersKycDetail);
    }

    @Override
    public Manifest getServiceManifest() {
        return (Manifest) super.getServiceManifest();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void get() throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        String user_id = System.getenv("USER_ID");
        params.put("user_id", user_id);
        // Test-Case: Get an existing UserKycDetail.

        JsonObject response;
        response = getService().get(params);
        validateResponseWithSuccess(response);

    }
}
package com.ost.kyc.services.v2;

import com.google.gson.JsonObject;
import com.ost.kyc.services.OSTKYCAPIService;
import com.ost.kyc.services.ServiceTestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.HashMap;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest extends ServiceTestBase {

    @Override
    public User getService() {
        return (User) super.getService();
    }

    @Before @Override
    public void setUp() throws Exception {
        super.setUp();
        setService(getServiceManifest().user);
    }

    @Override
    public Manifest getServiceManifest() {
        return (Manifest) super.getServiceManifest();
    }

    @Test
    public void get() throws Exception {

        HashMap<String, Object> params = new HashMap<String, Object>();
        String user_id = System.getenv("USER_ID");
        params.put("id", Integer.parseInt(user_id));

        // Test-Case: Get an existing User.
        JsonObject response;
        response = getService().get(params);
        validateResponseWithSuccess(response);

    }

    @Test
    public void create() throws Exception{

        HashMap<String, Object> params = new HashMap<String, Object>();
        String version = System.getProperty("java.version");
        // make unique email using timestamp
        params.put("email", "kyctest+" + (System.currentTimeMillis() / 1000) +"_"+ version + "@ost.com");

        // Test-Case: Create a new User.
        JsonObject response;
        response = getService().create(params);
        validateResponseWithSuccess(response);

    }


    @Test
    public void get_with_id_zero() throws Exception{

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("id", "0");

        // Test-Case: Get an existing User with id = 0.
        JsonObject response;
        response = getService().get(params);
        validateResponseWithFaliure(response);

    }

    @Test
    public void get_with_id_null() throws Exception{

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("id", "");

        // Test-Case: Get an existing User with id = 0.
        JsonObject response;
        try{
            response = getService().get(params);
        } catch (OSTKYCAPIService.InvalidParameter I)
        {
            Assert.assertEquals( I.toString(), "com.ost.kyc.services.OSTKYCAPIService$InvalidParameter: id is invalid");
        }
    }

    @Test
    public void list() throws Exception {

        HashMap<String, Object> params = new HashMap<String, Object>();

        // Test-Case: List an existing Users.
        JsonObject response;
        response = getService().list(params);
        validateResponseWithSuccess(response);

    }

}
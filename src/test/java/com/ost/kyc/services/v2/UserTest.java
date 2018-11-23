package com.ost.kyc.services.v2;

import com.google.gson.JsonObject;
import com.ost.kyc.services.OSTKYCAPIService;
import com.ost.kyc.services.ServiceTestBase;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
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
        setService( getServiceManifest().user );
    }

    @Override
    public Manifest getServiceManifest() {
        return (Manifest) super.getServiceManifest();
    }

    public HashMap<String,Object> getParams() {
        HashMap <String,Object> params = new HashMap<String, Object>();
        HashMap <String,Object> emptyHash = new HashMap<String, Object>();
        ArrayList<String> emptyArray = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        list.add("");
        list.add(null);
        params.put("a", null);
        params.put("b", emptyArray);
        params.put("c", "");
        params.put("d", list);
        params.put("e", emptyHash);

        HashMap <String,Object> emptyHashWithArrayAndString = new HashMap<String, Object>();
        emptyHashWithArrayAndString.put("a", emptyArray);
        emptyHashWithArrayAndString.put("f", "");
        params.put("f", emptyHashWithArrayAndString);

        ArrayList<HashMap> listWithHash = new ArrayList<HashMap>();
        HashMap <String,Object> hashWith1KeyValue = new HashMap<String, Object>();
        HashMap <String,ArrayList> nestedMap = new HashMap<String, ArrayList>();
        hashWith1KeyValue.put("d", "1");
        listWithHash.add(hashWith1KeyValue);
        nestedMap.put("a", listWithHash);
        params.put("listWithHash", nestedMap);


        HashMap <String,Object> hashWithMultipleKeyValue = new HashMap<String, Object>();
        HashMap <String,HashMap> nestedHash = new HashMap<String, HashMap>();
        hashWithMultipleKeyValue.put("aman", "1");
        hashWithMultipleKeyValue.put("tejas", "2");
        hashWithMultipleKeyValue.put("mayur", "3");
        nestedHash.put("h", hashWithMultipleKeyValue);
        params.put("nestedHash", nestedHash);

        HashMap <String,ArrayList> hashWithNestedArray = new HashMap<String, ArrayList>();
        ArrayList<String> specialCharacters = new ArrayList<String>();
        specialCharacters.add("er");
        specialCharacters.add("~!@#$%^&*()_+}{|':><?`1234567890-=");
        specialCharacters.add(";,./'");
        specialCharacters.add("'");
        hashWithNestedArray.put("i", specialCharacters);
        params.put("hashWithNestedArray", hashWithNestedArray);

        return params;
    }

    @Test
    public void get() {

        HashMap <String,Object> params = getParams();
        params.put("id", "11007");

        JsonObject response;
        // Test-Case: Get User by id.
        try {
            response = getService().get( params );
            validateResponseWithSuccess( response);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (OSTKYCAPIService.MissingParameter missingParameter) {
            missingParameter.printStackTrace();
        }

    }

    @Test
    public void create() {

        HashMap <String,Object> params = getParams();
        // make unique email using timestamp
        params.put("email", "email+" +(System.currentTimeMillis() / 1000) + "@domain.co");

        JsonObject response;
        // Test-Case: Create a new User.
        try {
            response = getService().create( params );
            validateResponseWithSuccess( response);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
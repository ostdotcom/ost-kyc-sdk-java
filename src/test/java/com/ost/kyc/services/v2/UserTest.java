package com.ost.kyc.services.v2;

import com.google.gson.JsonObject;
import com.ost.kyc.services.ServiceTestBase;
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

    public HashMap<String, Object> getParams() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        HashMap<String, Object> emptyHash = new HashMap<String, Object>();
        ArrayList<String> emptyArray = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        list.add("");
        list.add(null);
        params.put("a", null);
        params.put("b", emptyArray);
        params.put("c", "");
        params.put("d", list);
        params.put("e", emptyHash);

        HashMap<String, Object> emptyHashWithArrayAndString = new HashMap<String, Object>();
        emptyHashWithArrayAndString.put("a", emptyArray);
        emptyHashWithArrayAndString.put("f", "");
        params.put("f", emptyHashWithArrayAndString);

        ArrayList<HashMap> listWithHash = new ArrayList<HashMap>();
        HashMap<String, Object> hashWith1KeyValue = new HashMap<String, Object>();
        HashMap<String, ArrayList> nestedMap = new HashMap<String, ArrayList>();
        hashWith1KeyValue.put("d", "1");
        listWithHash.add(hashWith1KeyValue);
        nestedMap.put("a", listWithHash);
        params.put("listWithHash", nestedMap);


        HashMap<String, Object> hashWithMultipleKeyValue = new HashMap<String, Object>();
        HashMap<String, HashMap> nestedHash = new HashMap<String, HashMap>();
        hashWithMultipleKeyValue.put("aman", "1");
        hashWithMultipleKeyValue.put("tejas", "2");
        hashWithMultipleKeyValue.put("mayur", "3");
        nestedHash.put("h", hashWithMultipleKeyValue);
        params.put("nestedHash", nestedHash);

        HashMap<String, ArrayList> hashWithNestedArray = new HashMap<String, ArrayList>();
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
    public void get() throws Exception {

        HashMap<String, Object> params = getParams();
        String user_id = System.getenv("USER_ID");
        params.put("id", user_id);

        // Test-Case: Get an existing User.
        JsonObject response;
        response = getService().get(params);
        validateResponseWithSuccess(response);

    }

    @Test
    public void create() throws Exception{

        HashMap<String, Object> params = getParams();
        String version = System.getProperty("java.version");
        // make unique email using timestamp
        params.put("email", "kyctest+" + (System.currentTimeMillis() / 1000) +"_"+ version + "@ost.com");

        // Test-Case: Create a new User.
        JsonObject response;
        response = getService().create(params);
        validateResponseWithSuccess(response);

    }

    @Test
    public void list() throws Exception {

        HashMap<String, Object> params = getParams();

        // Test-Case: List an existing Users.
        JsonObject response;
        response = getService().list(params);
        validateResponseWithSuccess(response);

    }

}
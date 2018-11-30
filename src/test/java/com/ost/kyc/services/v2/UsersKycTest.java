package com.ost.kyc.services.v2;

import com.google.gson.JsonObject;
import com.ost.kyc.services.ServiceTestBase;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.HashMap;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsersKycTest extends ServiceTestBase {

    @Override
    public UsersKyc getService() {
        return (UsersKyc) super.getService();
    }

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        setService(getServiceManifest().usersKyc);
    }

    @Override
    public Manifest getServiceManifest() {
        return (Manifest) super.getServiceManifest();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void submit_kyc() throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        String user_id = System.getenv("USER_ID");
        params.put("user_id", user_id);
        params.put("first_name", "YOGESH");
        params.put("last_name", "SAWANT");
        params.put("birthdate", "29/07/1992");
        params.put("country", "INDIA");
        params.put("document_id_number", "DMDPS9634C");
        params.put("document_id_file_path", "2/i/016be96da275031de2787b57c99f1471");
        params.put("selfie_file_path", "2/i/9e8d3a5a7a58f0f1be50b7876521aebc");
        params.put("ethereum_address", "0x04d39e0b112c20917868ffd5c42372ecc5df577b");
        params.put("estimated_participation_amount", "1.2");
        params.put("residence_proof_file_path", "2/i/4ed790b2d525f4c7b30fbff5cb7bbbdb");
        params.put("city", "pune");
        params.put("nationality", "INDIAN");
        params.put("state", "maharashtra");
        params.put("postal_code", "411028");

        // Test-Case: Create/Update a UserKyc.
        JsonObject response;
        response = getService().submit_kyc(params);
        validateResponseWithFaliure(response);

    }

    @Test
    public void get() throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        String user_id = System.getenv("USER_ID");
        params.put("user_id", user_id);

        // Test-Case: Get an existing UserKyc.
        JsonObject response;
        response = getService().get(params);
        validateResponseWithSuccess(response);

    }

    @Test
    public void list() throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();

        // Test-Case: List an existing UsersKyc.
        JsonObject response;
        response = getService().list(params);
        validateResponseWithSuccess(response);

    }

    @Test
    public void get_presigned_url_post() throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        HashMap<String, String> nestedparams = new HashMap<String, String>();
        nestedparams.put("selfie", "image/jpeg");
        params.put("files", nestedparams);

        // Test-Case: Get Presigned URL for POST call.
        JsonObject response;
        response = getService().get_presigned_url_post(params);
        validateResponseWithSuccess(response);

    }

    @Test
    public void get_presigned_url_put() throws Exception{
        HashMap<String, Object> params = new HashMap<String, Object>();
        HashMap<String, String> nestedparams = new HashMap<String, String>();
        nestedparams.put("selfie", "image/jpeg");
        params.put("files", nestedparams);

        // Test-Case: Get Presigned URL for PUT call.
        JsonObject response;
        response = getService().get_presigned_url_post(params);
        validateResponseWithSuccess(response);

    }
}
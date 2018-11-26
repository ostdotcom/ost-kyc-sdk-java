package com.ost.kyc.services.v2;

import com.google.gson.JsonObject;
import com.ost.kyc.services.ServiceTestBase;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashMap;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ValidatorsTest extends ServiceTestBase {

    @Override
    public Validators getService() {
        return (Validators) super.getService();
    }

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        setService(getServiceManifest().validators);
    }

    @Override
    public Manifest getServiceManifest() {
        return (Manifest) super.getServiceManifest();
    }

    @Test
    public void verify_ethereum_address() throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("ethereum_address", "0x7f2ED21D1702057C7d9f163cB7e5458FA2B6B7c4");

        // Test-Case: Verify an ethereum address.
        JsonObject response;
        response = getService().verify_ethereum_address(params);
        validateResponseWithSuccess(response);

    }
}
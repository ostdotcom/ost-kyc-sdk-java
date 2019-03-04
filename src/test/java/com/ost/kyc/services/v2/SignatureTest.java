package com.ost.kyc.services.v2;

import com.ost.kyc.lib.OSTKYCRequestClient;
import com.ost.kyc.services.ServiceTestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class SignatureTest extends ServiceTestBase {

    public SignatureTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
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
        ArrayList<String> array = new ArrayList<String>();
        array.add("Hello");
        array.add("There");
        array.add("12345");
        params.put("k1", 125.45);
        params.put("k2", "Tejas");

        HashMap<String, Object> hashWithKeyValue1 = new HashMap<String, Object>();
        hashWithKeyValue1.put("a", "L21A");
        hashWithKeyValue1.put("b", "L21B");
        HashMap<String, Object> hashWithKeyValue2 = new HashMap<String, Object>();
        hashWithKeyValue2.put("a", "L22A");
        hashWithKeyValue2.put("b", "L22B");
        HashMap<String, Object> hashWithKeyValue3 = new HashMap<String, Object>();
        hashWithKeyValue3.put("a", "L23A");
        hashWithKeyValue3.put("b", "L23B");

        HashMap<String, Object> nestedparams = new HashMap<String, Object>();
        nestedparams.put("a" , hashWithKeyValue1);
        nestedparams.put("b" , hashWithKeyValue2);
        nestedparams.put("c" , hashWithKeyValue3);


        params.put("aaaaa", nestedparams);
        params.put("arrayValues", array);
        params.put("garbage_str", "~!@#$%^&*()_+-= {}[]:\";'?/<>,. this is garbage");


        return params;
    }

    @Test
    public void testSignature() throws Exception {

        HashMap<String, Object> params = getParams();
        String apiKey = System.getenv("OST_KYC_API_KEY");
        String apiSecret = System.getenv("OST_KYC_API_SECRET");
        String apiEndpoint = System.getenv("OST_KYC_API_ENDPOINT");
        System.out.println("The apiKey is : "+apiKey);
        System.out.println("The apiSecret is : "+apiSecret);
        System.out.println("The apiEndPoint is : "+apiEndpoint);

        params.put("apiSecret",apiSecret);
        params.put("apiKey",apiKey);
        params.put("apiEndpoint",apiEndpoint);

        // Test-Case: Test Signature.
        String signature;
        OSTKYCRequestClient obj = new OSTKYCRequestClient(params);
        signature = obj.getSignature("/api/v2/users", params);
        boolean success;
        if (signature.equalsIgnoreCase("9114b899d656e687b1c69acb6b7d99fb4817df590328e7149109fab11e69eea2")) {
            success = true;
        } else {
            success = false;
        }
        System.out.println("The signature is : "+signature);
        Assert.assertEquals( success, true);
    }
}

package com.ost.kyc.services;

import com.ost.kyc.lib.OSTKYCRequestClient;

import java.util.regex.*;

import com.ost.kyc.lib.*;

import java.util.Map;

public abstract class OSTKYCAPIService {
    protected OSTKYCRequestClient request;
    protected String urlPrefix;

    public OSTKYCAPIService(OSTKYCRequestClient OSTKYCRequestClient) {
        this.request = OSTKYCRequestClient;
        this.urlPrefix = "";
    }

    public OSTKYCAPIService(OSTKYCRequestClient OSTKYCRequestClient, String servicePrefix) {
        this(OSTKYCRequestClient);
        this.urlPrefix = servicePrefix;
    }

    public String getId(Map<String, Object> params) throws MissingParameter, InvalidParameter {
        String id = "";
        if (null == params || !params.containsKey("id") || null == params.get("id")) {
            throw new MissingParameter("id");
        }
        if (!isValidParameter(params.get("id"))) {
            throw new InvalidParameter("id");
        }
        id = params.get("id").toString();
        params.remove("id");
        return id;
    }

    public String getUserId(Map<String, Object> params) throws MissingParameter, InvalidParameter {
        String user_id = "";
        if (null == params || !params.containsKey("user_id") || null == params.get("user_id")) {
            throw new MissingParameter("user_id");
        }
        if (!isValidParameter(params.get("user_id"))) {
            throw new InvalidParameter("user_id");
        }

        user_id = params.get("user_id").toString();
        params.remove("user_id");

        return user_id;
    }

    public Boolean isValidParameter(Object params) throws InvalidParameter {
        if(params instanceof Number){
            return true;
        }else if(params instanceof String){
            Pattern p = Pattern.compile("[0-9a-zA-Z.-]+");
            return p.matcher((String) params).matches();
        }else{
            return false;
        }
    }

    public class MissingParameter extends Exception {
        public MissingParameter(String paramName) {
            super(paramName + " missing in request params");
        }
    }

    public class InvalidParameter extends Exception {
        public InvalidParameter(String paramName) {
            super(paramName + " is invalid");
        }
    }


}

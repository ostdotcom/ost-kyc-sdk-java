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

    public String getId( Map<String,Object> params) throws MissingParameter, InvalidParameter {
        if ( null == params || !params.containsKey("id") || null == params.get("id") ) {
            throw new MissingParameter("id");
        }
        if (!isValidParameter(params.get("id"))){
            throw new InvalidParameter("id");
        }
        return params.get("id").toString();
    }

    public String getUserId( Map<String,Object> params) throws MissingParameter, InvalidParameter {
        if ( null == params || !params.containsKey("user_id") || null == params.get("user_id") ) {
            throw new MissingParameter("user_id");
        }
        if (!isValidParameter(params.get("user_id"))){
            throw new InvalidParameter("user_id");
        }
        return params.get("user_id").toString();
    }

    public Boolean isValidParameter(Object params) throws InvalidParameter {
        Pattern p = Pattern.compile("[0-9a-zA-Z.-]+");
        return p.matcher((String)params).matches();
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

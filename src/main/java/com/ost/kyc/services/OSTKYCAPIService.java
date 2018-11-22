package com.ost.kyc.services;
import com.ost.kyc.lib.OSTKYCRequestClient;
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

    public String getId( Map<String,Object> params) throws MissingParameter {
        if ( null == params || !params.containsKey("id") || null == params.get("id") ) {
            throw new MissingParameter("id");
        }
        return params.get("id").toString();
    }

    public String getUserId( Map<String,Object> params) throws MissingParameter {
        if ( null == params || !params.containsKey("user_id") || null == params.get("user_id") ) {
            throw new MissingParameter("user_id");
        }
        return params.get("user_id").toString();
    }

    public class MissingParameter extends Exception {
        public MissingParameter(String paramName) {
            super(paramName + " missing in request params");
        }
    }


}

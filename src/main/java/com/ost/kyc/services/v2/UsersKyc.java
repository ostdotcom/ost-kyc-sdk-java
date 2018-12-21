package com.ost.kyc.services.v2;

import com.google.gson.JsonObject;
import com.ost.kyc.services.OSTKYCAPIService;
import com.ost.kyc.lib.OSTKYCRequestClient;

import java.io.IOException;
import java.util.Map;

public class UsersKyc extends OSTKYCAPIService {

    static String servicePrefix = "/api/v2/users-kyc";
    public UsersKyc(OSTKYCRequestClient OSTKYCRequestClient) {
        super(OSTKYCRequestClient, servicePrefix);
    }

    /**
     * @param params Request Params
     * @return API Response
     */
    public JsonObject submit_kyc(Map<String,Object> params) throws MissingParameter, IOException, InvalidParameter {
        String resource = this.urlPrefix + "/" + this.getUserId( params );
        return this.request.post(resource, params);
    }

    /**
     * @param params Request Params
     * @return API Response
     */
    public JsonObject email_approve(Map<String,Object> params) throws MissingParameter, IOException, InvalidParameter {
        String resource = this.urlPrefix + "/" + this.getUserId( params ) + "/email/approve";
        return this.request.post(resource, params);
    }
    /**
     * @param params Request Params
     * @return API Response
     */
    public JsonObject email_deny(Map<String,Object> params) throws MissingParameter, IOException, InvalidParameter {
        String resource = this.urlPrefix + "/" + this.getUserId( params ) + "/email/deny";
        return this.request.post(resource, params);
    }
    /**
     * @param params Request Params
     * @return API Response
     */
    public JsonObject email_report_issue(Map<String,Object> params) throws MissingParameter, IOException, InvalidParameter {
        String resource = this.urlPrefix + "/" + this.getUserId( params ) + "/email/report-issue";
        return this.request.post(resource, params);
    }

    /**
     * @param params Request Params
     * @return API Response
     */
    public JsonObject get(Map<String,Object> params) throws MissingParameter, IOException, InvalidParameter {
        String resource = this.urlPrefix + "/" + this.getUserId( params );
        return this.request.get(resource, params);
    }

    /**
     * @param params Request Params
     * @return API Response
     */
    public JsonObject list(Map<String,Object> params) throws IOException {
        String resource = this.urlPrefix;
        return this.request.get(resource, params);
    }

    /**
     * @param params Request Params
     * @return API Response
     */
    public JsonObject get_presigned_url_post(Map<String,Object> params) throws IOException {
        String resource = this.urlPrefix + "/pre-signed-urls/for-post";
        return this.request.get(resource, params);
    }

    /**
     * @param params Request Params
     * @return API Response
     */
    public JsonObject get_presigned_url_put(Map<String,Object> params) throws IOException {
        String resource = this.urlPrefix + "/pre-signed-urls/for-put";
        return this.request.get(resource, params);
    }

}

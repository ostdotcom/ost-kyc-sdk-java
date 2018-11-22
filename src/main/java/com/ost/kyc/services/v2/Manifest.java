package com.ost.kyc.services.v2;

import com.ost.kyc.services.OSTKYCServiceManifest;

import java.util.Map;

public class Manifest extends OSTKYCServiceManifest {

    public User user;
    public UsersKyc usersKyc;
    public UsersKycDetail usersKycDetail;
    public Validators validators;

    public Manifest(Map<String, Object> params) {
        super(params);
        init();
    }

    private void init() {
        this.user = new User( this.request );
        this.usersKyc = new UsersKyc( this.request );
        this.usersKycDetail = new UsersKycDetail( this.request );
        this.validators = new Validators( this.request );
    }
}
# OST KYC JAVA SDK
The official [OST KYC JAVA SDK](https://dev.ost.com/docs/kyc/index.html).


[![Travis](https://travis-ci.org/OpenSTFoundation/ost-kyc-sdk-java.svg?branch=master)](https://travis-ci.org/OpenSTFoundation/ost-kyc-sdk-java)
[![Gitter: JOIN CHAT](https://img.shields.io/badge/gitter-JOIN%20CHAT-brightgreen.svg)](https://gitter.im/OpenSTFoundation/SimpleToken)

## Requirements

To use this node module, developers will need to:
1. Login on [https://kyc.ost.com/admin/login](https://kyc.ost.com/admin/login).
2. Obtain an API Key and API Secret from [https://kyc.ost.com/admin/settings/developer-integrations](https://kyc.ost.com/admin/settings/developer-integrations).

## Documentation

[https://dev.ost.com/docs/kyc/index.html](https://dev.ost.com/docs/kyc/index.html)

## Installation

### Maven users
#### Add this dependency to your project's POM:
```xml
<dependency>
<groupId>com.ost.kyc</groupId>
<artifactId>ost-kyc-sdk-java</artifactId>
<version>2.0.0</version>
</dependency>
```

### Building from source using Maven

Clone the repository
```bash
git clone https://github.com/OpenSTFoundation/ost-kyc-sdk-java.git
cd ost-kyc-sdk-java
```


Package using MVN (without dependencies)
```bash
mvn clean pacakge -DskipTests
```

With dependencies
```bash
mvn clean compile assembly:single -DskipTests
```

The jar file can be found in the target folder.

## Example Usage


Initialize the SDK object:

```java
// the latest valid API endpoint is "https://kyc.sandboxost.com", this may change in the future
HashMap <String,Object> sdkConfig = new HashMap<String,Object>();
sdkConfig.put("apiEndpoint","[API_ENDPOINT]");
sdkConfig.put("apiKey","[YOUR_API_KEY]");
sdkConfig.put("apiSecret","[YOUR_API_SECRET]");

// set OST_KYC_SDK_DEBUG=true for the debbuging purpose of sdk

// The config field is optional for sdkConfig Object
HashMap <String,Object> nestedparam = new HashMap<String,Object>();
// This is the timeout in seconds for which the socket connection will remain open
// The value of timeout will always be of type long
nestedparam.put("timeout", (long) 15);
sdkConfig.put("config", nestedparam);


OSTSDK ostObj = new OSTSDK(sdkConfig);
services = (Manifest) ostObj.services;
```

### Users Module

```java
com.ost.kyc.services.v2.User userService = services.user;
```

Create a new user:

```java
HashMap <String, Object> params = new HashMap<String, Object>();
params.put("email", "email@domain.com");
JsonObject response = userService.create( params );
System.out.println("response: " + response.toString() );
```

Get an existing user:

```java
HashMap <String,Object> params = new HashMap<String,Object>();
params.put("id", "11007");
JsonObject response = userService.get( params );
System.out.println("response: " + response.toString() );
```

Get a list of existing users and other data:

```java
HashMap <String,Object> params = new HashMap<String,Object>();
JsonObject response = userService.list( params );
System.out.println("response: " + response.toString() );
```

### UsersKyc Module

```java
com.ost.kyc.services.v2.UsersKyc usersKycService = services.usersKyc;
```

Get an existing user kyc:

```java
HashMap <String,Object> params = new HashMap<String,Object>();
params.put("user_id", "11007");
JsonObject response = usersKycService.get( params );
System.out.println("response: " + response.toString() );
```

Create/Update a new user kyc:

```java
HashMap <String, Object> params = new HashMap<String, Object>();
params.put("user_id", "11052");
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
JsonObject response = usersKycService.submit_kyc( params );
System.out.println("response: " + response.toString() );
```

Get a list of existing users kyc and other data:

```java
HashMap <String,Object> params = new HashMap<String,Object>();
JsonObject response = usersKycService.list( params );
System.out.println("response: " + response.toString() );
```

Get an existing Presigned URL via POST call:

```java
HashMap <String, Object> params = new HashMap<String, Object>();
HashMap <String, String> nestedparams = new HashMap<String, String>();
nestedparams.put("selfie", "image/jpeg");
params.put("files", nestedparams);
JsonObject response = usersKycService.get_presigned_url_post( params );
System.out.println("response: " + response.toString() );
```

Get an existing Presigned URL via PUT call:

```java
HashMap <String, Object> params = new HashMap<String, Object>();
HashMap <String, String> nestedparams = new HashMap<String, String>();
nestedparams.put("selfie", "image/jpeg");
params.put("files", nestedparams);
JsonObject response = usersKycService.get_presigned_url_put( params );
System.out.println("response: " + response.toString() );
```


### UsersKycDetail Module

```java
com.ost.kyc.services.v2.UsersKycDetail usersKycDetailService = services.usersKycDetail;
```

Get an user kyc detail:

```java
HashMap <String, Object> params = new HashMap<String, Object>();
params.put("user_id", "11052");
JsonObject response = usersKycDetailService.get( params );
System.out.println("response: " + response.toString() );
```

### Validators Module

```java
com.ost.kyc.services.v2.Validators validatorService = services.validators;
```

Verify Ethereum Address:

```java
HashMap <String, Object> params = new HashMap<String, Object>();
params.put("ethereum_address", "0x7f2ED21D1702057C7d9f163cB7e5458FA2B6B7c4");
JsonObject response = validatorService.verify_ethereum_address( params );
System.out.println("response: " + response.toString() );
```


Code to reproduce https://github.com/micronaut-projects/micronaut-core/issues/6663.

Located in [EnvEndpointIssueTest](src/test/java/com/ivyaz/env/endpoint/issue/EnvEndpointIssueTest.java). As shown, regular user can access all info of application, including system properties and environment variables. Configuration `scrt-tkn` is unmasked in the response
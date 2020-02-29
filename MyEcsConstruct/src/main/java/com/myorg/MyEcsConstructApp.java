package com.myorg;

import software.amazon.awscdk.core.App;

import java.util.Arrays;

public class MyEcsConstructApp {
    /*static Environment makeEnv(String account, String region) {
        account = (account == null) ? System.getenv("CDK_DEFAULT_ACCOUNT") : account;
        region = (region == null) ? System.getenv("CDK_DEFAULT_REGION") : region;

        return Environment.builder()
                .account(account)
                .region(region)
                .build();
    }*/
    public static void main(final String[] args) {
        App app = new App();
        //Environment environment=makeEnv("122376722916","us-east-1");

        new MyEcsConstructStack(app, "MyEcsConstructStack");

        app.synth();
    }
}

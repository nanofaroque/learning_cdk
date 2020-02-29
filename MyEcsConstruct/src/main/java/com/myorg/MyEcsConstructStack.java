package com.myorg;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;

import software.amazon.awscdk.core.Environment;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.ec2.*;
import software.amazon.awscdk.services.ecs.*;
import software.amazon.awscdk.services.ecs.patterns.*;

public class MyEcsConstructStack extends Stack {
    public MyEcsConstructStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public MyEcsConstructStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // The code that defines your stack goes here
        Vpc vpc= Vpc.Builder.create(this,"NanofaroqueMyFargateService")
                .maxAzs(3)
                .build();
        Cluster cluster=Cluster.Builder.create(this,"NanofaroqueCluster")
                .vpc(vpc).build();


        ApplicationLoadBalancedFargateService
                .Builder
                .create(this,"NanofaroqueFargateService")
                .cluster(cluster)
                .cpu(512)
                .desiredCount(6)
                .taskImageOptions(ApplicationLoadBalancedTaskImageOptions.builder()
                        .image(ContainerImage.fromRegistry("amazon/amazon-ecs-sample"))
                        .build())
                .memoryLimitMiB(2048)
                .publicLoadBalancer(true)
                .build();
    }
}

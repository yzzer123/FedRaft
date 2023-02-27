package org.bupt.fedraft.rpc.manager.message;

import org.junit.Test;

public class JobSubmitResponseTest {

    @Test
    public void testInstance() {
        JobSubmitResponse defaultInstance = JobSubmitResponse.getDefaultInstance();
        System.out.println(defaultInstance.hasSuccess());
        System.out.println(defaultInstance.hasLogs());
        System.out.println(defaultInstance.getSerializedSize());
        System.out.println(JobSubmitResponse.newBuilder().setSuccess(false).build().getSerializedSize());
        System.out.println(JobConfiguration.getDefaultInstance().getSourceId());
    }

}
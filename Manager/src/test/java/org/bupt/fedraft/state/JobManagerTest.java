package org.bupt.fedraft.state;

import org.bupt.fedraft.utils.NetworkUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class JobManagerTest {

    @Test
    public void testCMD() {
        BufferedReader in = null;

        try {
            String[] cmdArr = {"/bin/bash", "-c", "./Trainer/bin/trainerCli.sh start 16777"};
            Process process = Runtime.getRuntime().exec(cmdArr);
            in = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            process.onExit().thenRun(() -> System.out.println("process exited!!!"));

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
//                if (line.contains("service.server : INFO  trainer server start on port:")){
//                    process.destroy();
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//        if (in != null){
//            return;
//        }

    }

    @Test
    public void testSetup() {
        JobManager jobManager = new JobManager(null, 11000, 1000L, 0, null);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testPort() {
        System.out.println(NetworkUtils.isPortAvailable(16333));
        try {
            System.out.println(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
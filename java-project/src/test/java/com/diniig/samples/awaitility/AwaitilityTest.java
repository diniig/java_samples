package com.diniig.samples.awaitility;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class AwaitilityTest {

    @Test
    void awaitilityTest() {
        AsyncService asyncService = new AsyncService();
        asyncService.initialize(); //async operation
        Awaitility.await("ready")
                .pollDelay(1, TimeUnit.SECONDS)
                .pollInterval(1, TimeUnit.SECONDS)
                .until(() -> asyncService.isInitialized());
    }
}

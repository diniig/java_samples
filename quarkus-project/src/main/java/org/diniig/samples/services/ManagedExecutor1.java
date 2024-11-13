package org.diniig.samples.services;

import org.eclipse.microprofile.context.ManagedExecutor;
import org.eclipse.microprofile.context.ThreadContext;
import org.openjdk.jol.vm.VM;

import java.util.concurrent.TimeUnit;

import io.smallrye.context.api.ManagedExecutorConfig;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class ManagedExecutor1 {
 
    @Inject
    @ManagedExecutorConfig(cleared = ThreadContext.TRANSACTION)
    ManagedExecutor managedExecutor;

    @Transactional
    public void runProcess() {
        Runnable task = () -> {
            log.info("1 hello world");
        };

        log.info("1 managedExecutor {}.\n\n\n Address {}", managedExecutor, VM.current().addressOf(managedExecutor));

        managedExecutor.runAsync(task).completeOnTimeout(null, 300, TimeUnit.SECONDS);
    }
}

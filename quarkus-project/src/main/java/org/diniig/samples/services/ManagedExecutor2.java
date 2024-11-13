package org.diniig.samples.services;

import org.eclipse.microprofile.context.ManagedExecutor;
import org.openjdk.jol.vm.VM;

import java.util.concurrent.TimeUnit;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class ManagedExecutor2 {
 
    @Inject
    ManagedExecutor managedExecutor;

    @Transactional
    public void runProcess() {
        Runnable task = () -> {
            log.info("2 hello world");
        };
        
        log.info("2 managedExecutor {}.\n\n\n Address {}", managedExecutor, VM.current().addressOf(managedExecutor));

        managedExecutor.runAsync(task).completeOnTimeout(null, 300, TimeUnit.SECONDS);
    }
}

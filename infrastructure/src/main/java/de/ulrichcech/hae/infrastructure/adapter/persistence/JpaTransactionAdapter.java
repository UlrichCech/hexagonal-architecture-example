package de.ulrichcech.hae.infrastructure.adapter.persistence;

import de.ulrichcech.hae.application.ports.TransactionalPort;
import jakarta.ejb.DependsOn;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

import java.util.concurrent.Callable;

@LocalBean
@Stateless
@DependsOn("FlywayMigrator")
public class JpaTransactionAdapter implements TransactionalPort {

    @Override
    public final <R> R executeInTransaction(Callable<R> action) {
        try {
            R result = action.call();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

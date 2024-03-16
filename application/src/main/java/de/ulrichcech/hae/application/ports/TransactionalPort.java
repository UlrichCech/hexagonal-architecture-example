package de.ulrichcech.hae.application.ports;

import java.util.concurrent.Callable;

public interface TransactionalPort {

    <R> R executeInTransaction(Callable<R> action);

}

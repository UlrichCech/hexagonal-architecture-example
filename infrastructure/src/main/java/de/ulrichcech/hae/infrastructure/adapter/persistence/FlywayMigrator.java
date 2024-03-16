package de.ulrichcech.hae.infrastructure.adapter.persistence;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import org.flywaydb.core.Flyway;

import javax.sql.DataSource;


/**
 * @author Ulrich Cech
 */
@Singleton
@Startup
public class FlywayMigrator {

    @Resource(lookup = "java:app/jdbc/hexagon")
    private DataSource dataSource;

    protected Flyway migrator;


    @PostConstruct
    public void migrate() {
        this.migrator = Flyway.configure()
                .dataSource(dataSource)
                .schemas("public")
                .locations("db/migration")
                .baselineOnMigrate(true)
                .baselineVersion("0000")
                .load();
        migrator.repair();
        migrator.migrate();
    }

}

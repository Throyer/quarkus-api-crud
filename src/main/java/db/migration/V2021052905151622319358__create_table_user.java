package db.migration;

import static org.jooq.impl.DSL.primaryKey;
import static org.jooq.impl.DSL.quotedName;
import static org.jooq.impl.DSL.unique;
import static org.jooq.impl.DSL.using;
import static org.jooq.impl.SQLDataType.BIGINT;
import static org.jooq.impl.SQLDataType.BOOLEAN;
import static org.jooq.impl.SQLDataType.VARCHAR;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V2021052905151622319358__create_table_user extends BaseJavaMigration {
    public void migrate(Context context) throws Exception {
        var create = using(context.getConnection());
        create.transaction(configuration -> {
            using(configuration)
                .createTableIfNotExists(quotedName("user"))
                    .column(quotedName("id"), BIGINT.identity(true))
                    .column(quotedName("name"), VARCHAR(100).nullable(false))
                    .column(quotedName("email"), VARCHAR(100).nullable(true))
                    .column(quotedName("deleted_email"), VARCHAR(100).nullable(true))
                    .column(quotedName("password"), VARCHAR(100).nullable(false))
                    .column(quotedName("active"), BOOLEAN.defaultValue(true))
                .constraints(
                    primaryKey(quotedName("id")),
                    unique(quotedName("email")))
                .execute();
        });
    }
}
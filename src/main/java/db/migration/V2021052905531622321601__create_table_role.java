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

public class V2021052905531622321601__create_table_role extends BaseJavaMigration {
    public void migrate(Context context) throws Exception {
        var create = using(context.getConnection());
        create.transaction(configuration -> {
            using(configuration)
                .createTableIfNotExists(quotedName("role"))
                    .column(quotedName("id"), BIGINT.identity(true))
                    .column(quotedName("name"), VARCHAR(100).nullable(false))
                    .column(quotedName("deleted_name"), VARCHAR(100).nullable(true))
                    .column(quotedName("initials"), VARCHAR(100).nullable(false))
                    .column(quotedName("deleted_initials"), VARCHAR(100).nullable(true))
                    .column(quotedName("description"), VARCHAR(100).nullable(true))
                    .column(quotedName("active"), BOOLEAN.defaultValue(true))
                .constraints(
                    primaryKey(quotedName("id")),
                    unique(quotedName("name")),
                    unique(quotedName("initials")))
                .execute();
        });
    }
}

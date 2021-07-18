package db.migration;

import static org.jooq.impl.DSL.foreignKey;
import static org.jooq.impl.DSL.quotedName;
import static org.jooq.impl.DSL.using;
import static org.jooq.impl.SQLDataType.BIGINT;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V2021052906011622322101__create_table_user_role extends BaseJavaMigration {
    public void migrate(Context context) throws Exception {
        var create = using(context.getConnection());
        create.transaction(configuration -> {
            using(configuration)
                .createTableIfNotExists(quotedName("user_role"))
                    .column(quotedName("user_id"), BIGINT.nullable(true))
                    .column(quotedName("role_id"), BIGINT.nullable(true))
                .constraints(
                    foreignKey(quotedName("user_id")).references(quotedName("user"), quotedName("id")),
                    foreignKey(quotedName("role_id")).references(quotedName("role"), quotedName("id")))
                .execute();
        });
    }
}

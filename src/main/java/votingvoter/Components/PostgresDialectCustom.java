package votingvoter.Components;

import org.hibernate.dialect.PostgreSQLDialect;
import org.hibernate.dialect.pagination.LimitHandler;
import org.hibernate.dialect.pagination.LimitOffsetLimitHandler;
import org.hibernate.dialect.pagination.OffsetFetchLimitHandler;

public class PostgresDialectCustom extends PostgreSQLDialect {
//    @Override
//    public LimitHandler getLimitHandler() {
//        return OffsetFetchLimitHandler.INSTANCE;
//    }
}

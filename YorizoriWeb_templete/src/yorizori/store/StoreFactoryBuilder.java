package yorizori.store;

import yorizori.store.jdbc.JdbcStoreFactory;

public class StoreFactoryBuilder {

	private static StoreFactoryBuilder builder = new StoreFactoryBuilder();

	private StoreFactory jdbcStoreFactory;

	public synchronized static StoreFactory createJdbcStoreFactory() {
		if (builder.jdbcStoreFactory == null) {
			builder.jdbcStoreFactory = new JdbcStoreFactory();

		}

		return builder.jdbcStoreFactory;
	}

}

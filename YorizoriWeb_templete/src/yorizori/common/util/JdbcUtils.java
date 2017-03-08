package yorizori.common.util;

public class JdbcUtils {
	//
	public static void closeQuietly(AutoCloseable ... closeables) {
		//
		for (AutoCloseable closeable : closeables) {
			if (closeable != null) try {
				closeable.close();
			} catch (Exception e) { }
		}
	}

}

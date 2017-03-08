package shop.store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import shop.domain.Product;
import shop.store.facade.ProductStore;
import shop.store.logic.utils.ConnectionFactory;
import shop.store.logic.utils.JdbcUtils;

public class ProductStoreLogic implements ProductStore {
	private ConnectionFactory factory;

	public ProductStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public List<Product> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<Product> list = new ArrayList<>();

		try {
			conn = factory.createConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery("select SERIALNO,NAME,PRICE, USERLIKE from product_tb");

			while (rs.next()) {
				Product product = new Product();

				product.setSerialNo(rs.getInt("serialNo"));
				product.setName(rs.getString("name"));
				product.setLike(rs.getInt("USERLIKE"));
				product.setPrice(rs.getInt("price"));

				list.add(product);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, rs, stmt);
		}

		return list;
	}

	@Override
	public Product findByNo(int serial) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Product product = null;

		try {
			conn = factory.createConnection();

			pstmt = conn.prepareStatement("select SERIALNO, NAME, PRICE, USERLIKE from product_tb where SERIALNO = ?");
			pstmt.setInt(1, serial);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				product = new Product();
				product.setSerialNo(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setLike(rs.getInt(4));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, rs, pstmt);
		}

		return product;
	}

}

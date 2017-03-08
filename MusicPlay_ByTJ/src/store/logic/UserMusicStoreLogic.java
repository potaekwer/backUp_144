package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Music;
import store.UserMusicStore;
import store.logic.utils.ConnectionFactory;
import store.logic.utils.JdbcUtils;

public class UserMusicStoreLogic implements UserMusicStore {

	private ConnectionFactory factory;

	public UserMusicStoreLogic() {

		factory = ConnectionFactory.getInstance();
	}

	@Override
	public boolean create(String userId, int musicId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		if (existUserMusic(userId, musicId)) {

			try {
				conn = factory.createConnection();
				pstmt = conn.prepareStatement("INSERT INTO USER_music_TB VALUES (?,?)");
				pstmt.setInt(1, musicId);
				pstmt.setString(2, userId);
				
				count = pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtils.closeResource(conn, pstmt);
			}
			return count > 0;

		} else
			return false;
	}

	@Override
	public boolean delete(String userId, int musicId) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("delete from USER_music_TB where USER_ID = ? and MUSIC_ID = ?");
			pstmt.setString(1, userId);
			pstmt.setInt(2, musicId);
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt);
		}
		return count > 0;

	}

	@Override
	public boolean existUserMusic(String userId, int musicId) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select USER_ID  from USER_music_TB where USER_ID = ? and MUSIC_ID = ?");
			pstmt.setString(1, userId);
			pstmt.setInt(2, musicId);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				if (userId.equals(rs.getString("USER_ID"))) {
					count++;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt);
		}
		return !(count > 0);
	}

	@Override
	public List<Music> readMusicsByUser(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Music> list = new ArrayList<>();
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(
					"select M.* " + 
			"from MUSIC_TB M, USER_MUSIC_TB U"
			+ " where M.ID = U.MUSIC_ID and U.USER_ID = ?");
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Music music = new Music();
				music.setId(rs.getInt("id"));
				music.setName(rs.getString("name"));
				music.setArtist(rs.getString("artist_name"));
				music.setAlbum(rs.getString("album_title"));
				music.setImage(rs.getString("image"));
				music.setAgent(rs.getString("agent_name"));
				list.add(music);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}
		return list;
	}

}

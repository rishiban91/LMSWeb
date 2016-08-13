package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.*;

public class GenreDAO extends BaseDAO{
	public GenreDAO (Connection conn) {
		super(conn);
	}

	public void addGenre(Genre gen) throws SQLException{
		save("insert into tbl_genre (genre_id, genre_name) values (?, ?)", 
				new Object[] {gen.getGenreId(), gen.getGenreName()});
	}

	public void updateGenre(Genre gen) throws SQLException {
		save("update tbl_genre set genre_name = ? where genre_id = ?", 
				new Object[] {gen.getGenreName(), gen.getGenreId() });
	}

	public void deleteGenre(Genre gen) throws SQLException {
		save("delete from tbl_genre where genre_id = ?", new Object[] {gen.getGenreId()});
	}

	public List<Genre> readAllGenre() throws SQLException {
		return read("select * from tbl_genre", null, false);
	}

	public Genre readById(Integer genreId) throws SQLException {
		List<Genre> gen = read("select * from tbl_genre where genre_id = ?", new Object[] {genreId}, false);
		if(gen!=null) {
			return gen.get(0);
		}
		return null;
	}
	@Override
	public List<Genre> extractData(ResultSet rs) {
		BookDAO bdao= new BookDAO(conn);
		List<Genre> gen = new ArrayList<Genre>();
		try {
			while(rs.next()){
				Genre g = new Genre();
				g.setGenreId(rs.getInt("genre_id"));
				g.setGenreName(rs.getString("genre_name"));
				g.setBooks(bdao.readFirstLevel("select * from tbl_genre where genre_id IN (select bookId from tbl_book_genres where genre_id = ?)",
						new Object[] { g.getGenreId()}));
				//add genres & publisher
				gen.add(g);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gen;
	}

	@Override
	public List<Genre> extractDataFirstLevel(ResultSet rs) {
		List<Genre> gen = new ArrayList<Genre>();
		try {
			while(rs.next()){
				Genre g = new Genre();
				g.setGenreId(rs.getInt("genre_id"));
				g.setGenreName(rs.getString("genre_name"));	
				gen.add(g);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gen;
	}

}

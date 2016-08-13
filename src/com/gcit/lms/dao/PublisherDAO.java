package com.gcit.lms.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.*;

public class PublisherDAO extends BaseDAO {

	public PublisherDAO (Connection conn) {
		super(conn);
	}

	public void addPublisher(Publisher pub) throws SQLException{
		save("insert into tbl_publisher (publisherId, publisherName, publisherAddress, publisherPhone) values (?, ?, ?, ?)", 
				new Object[] {pub.getPublisherId(), pub.getPublisherName(), pub.getPublisherAddress(), pub.getPublisherPhone()});
	}

	public void updatePublisher(Publisher pub) throws SQLException {
		save("update tbl_publisher set publisherName = ?, publisherAddress=?, publisherPhone=? where publisherId = ?", 
				new Object[] {pub.getPublisherName(), pub.getPublisherAddress(), pub.getPublisherPhone(), pub.getPublisherId()});
	}

	public void deletePublisher(Publisher pub) throws SQLException {
		save("delete from tbl_publisher where publisherId = ?", new Object[] {pub.getPublisherId()});
	}

	public List<Publisher> readAllPublisher() throws SQLException {
		return read("select * from tbl_publisher", null, false);
	}
	
	public Publisher viewById (int pubId) throws Exception {
		List<Publisher> publishers = read("select * from tbl_publisher where publisherId=?", new Object[] {pubId}, false);
		if (publishers!=null) {
			return publishers.get(0);
		}
		return null;
	}

	@Override
	public List<Publisher> extractData(ResultSet rs) {
		BookDAO bdao= new BookDAO(conn);
		List<Publisher> pub = new ArrayList<Publisher>();
		try {
			while(rs.next()){
				Publisher p = new Publisher();
				p.setPublisherId(rs.getInt("publisherId"));
				p.setPublisherName(rs.getString("publisherName"));
				p.setPublisherAddress(rs.getString("publisherAddress"));
				p.setPublisherPhone(rs.getString("publisherPhone"));
				p.setBook(bdao.readFirstLevel("select * from tbl_publisher where publisherId IN (select bookId from tbl_book where pubId = ?)",
						new Object[] { p.getPublisherId()}));
				//add genres & publisher
				pub.add(p);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pub;
	}

	@Override
	public List<Publisher> extractDataFirstLevel(ResultSet rs) {
		List<Publisher> pub = new ArrayList<Publisher>();
		try {
			while(rs.next()){
				Publisher p = new Publisher();
				p.setPublisherId(rs.getInt("publisherId"));
				p.setPublisherName(rs.getString("publisherName"));
				p.setPublisherAddress(rs.getString("publisherAddress"));
				p.setPublisherPhone(rs.getString("publisherPhone"));
				pub.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pub;
	}
}

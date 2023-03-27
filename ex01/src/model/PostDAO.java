package model;

import java.util.ArrayList;

import java.sql.*;

public class PostDAO {
	
	//�Խñۼ���
	public void update(PostsVO vo) {
		try {
			String sql = "update posts set title=?,body=?,date=now() where id=?";
			PreparedStatement ps=DB.CON.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getBody());
			ps.setInt(3, vo.getId());
			ps.execute();
		}catch(Exception e) {
			System.out.println("�Խñ� ����:"+e.toString());
		}
	}
	
	//�ۻ���
	public void delete(int id) {
		try {
			String sql = "delete from posts where id="+id;
			PreparedStatement ps=DB.CON.prepareStatement(sql);
			ps.execute();
		}catch(Exception e) {
			System.out.println("�Խñۻ���:"+e.toString());
		}
	}
	
	//�Խñ������б�
	public PostsVO read(int id) {
		PostsVO vo=new PostsVO();
		try {
			String sql="select * from posts where id=?";
			PreparedStatement ps=DB.CON.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setBody(rs.getString("body"));
				vo.setWriter(rs.getString("writer"));
				vo.setDate(rs.getTimestamp("date"));
//				System.out.println(vo.toString());
			}
		}catch(Exception e) {
			System.out.println("�Խñ� ����..."+e.toString());
		}
		return vo;
	}
	
	//�Խñ� ���
	public void insert(PostsVO vo) {
		try {
			String sql = "insert into posts(title, body, writer) values(?,?,?)";
			PreparedStatement ps=DB.CON.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getBody());
			ps.setString(3, vo.getWriter());
			ps.execute();
		}catch(Exception e) {
			System.out.println("�Խñ۵��:"+e.toString());
		}
	}
	
	
	//�Խñ۸��
	public ArrayList<PostsVO> list(){
		ArrayList<PostsVO> array=new ArrayList<PostsVO>();
		try {
			String sql="select * from posts order by id desc limit 0,5";
			PreparedStatement ps=DB.CON.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				PostsVO vo=new PostsVO();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setBody(rs.getString("body"));
				vo.setWriter(rs.getString("writer"));
				vo.setDate(rs.getTimestamp("date"));
				array.add(vo);
//				System.out.println(vo.toString());
			}
		}catch(Exception e) {
			System.out.println("post list..."+e.toString());
		}
		return array;
	}
}
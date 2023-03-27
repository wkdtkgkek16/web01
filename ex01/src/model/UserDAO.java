package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {
	//����ڸ��
	public ArrayList<UserVO> list(){
		ArrayList<UserVO> array=new ArrayList<UserVO>();
		try {
			String sql="select * from users order by join_date desc";
			PreparedStatement ps=DB.CON.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				UserVO vo=new UserVO();
				vo.setUid(rs.getString("uid"));
				vo.setUpass(rs.getString("upass"));
				vo.setUname(rs.getString("uname"));
				vo.setAddress(rs.getString("address"));
				vo.setJoin_date(rs.getDate("join_date"));
				System.out.println(vo.toString());
				array.add(vo);
			}
		}catch(Exception e) {
			System.out.println("����ڸ��:"+e.toString());
		}
		return array;
	}
}

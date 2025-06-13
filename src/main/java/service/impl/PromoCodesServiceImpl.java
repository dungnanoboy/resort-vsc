package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.PromoCodesBean;
import service.PromoCodesService;
import utility.DBUtil;

public class PromoCodesServiceImpl implements PromoCodesService{
	
	@Override
	public List<PromoCodesBean> getAllPromoCodes() {
		List<PromoCodesBean> promocodes = new ArrayList<PromoCodesBean>();

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT * from PromoCodes");

			rs = ps.executeQuery();

			while (rs.next()) {

				PromoCodesBean promocode = new PromoCodesBean();

				promocode.setPromoId(rs.getInt(1));
				promocode.setPromoCode(rs.getString(2));
				promocode.setDiscountPercent(rs.getDouble(3));
				promocode.setStartDate(rs.getDate(4).toLocalDate());
				promocode.setEndDate(rs.getDate(5).toLocalDate());	
				promocode.setInformation(rs.getString(6));

				promocodes.add(promocode);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);

		return promocodes;
	}

}

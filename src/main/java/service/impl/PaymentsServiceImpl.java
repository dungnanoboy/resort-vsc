package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.PaymentsBean;
import service.PaymentsService;
import utility.DBUtil;

public class PaymentsServiceImpl implements PaymentsService{
	
	@Override
	public List<PaymentsBean> getAllPayments() {
		List<PaymentsBean> payments = new ArrayList<PaymentsBean>();

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT * from Payments");

			rs = ps.executeQuery();

			while (rs.next()) {

				PaymentsBean payment = new PaymentsBean();

				payment.setPaymentId(rs.getInt(1));
				payment.setBookingId(rs.getString(2));
				payment.setPaymentDate(rs.getDate(3).toLocalDate());
				payment.setPaymentAmount(rs.getDouble(4));
				payment.setPaymentMenthod(rs.getString(5));	
				payment.setPromoId(rs.getInt(6));

				payments.add(payment);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);

		return payments;
	}

}

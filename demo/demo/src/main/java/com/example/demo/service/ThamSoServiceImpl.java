package com.example.demo.service;

import com.example.demo.entity.ThamSo;
import com.example.demo.repository.ThamSoRepository;

import oracle.jdbc.OracleTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

@Service
public class ThamSoServiceImpl implements IThamSoService {
	@Autowired
	private ThamSoRepository repo;

	@Override
	public Page<ThamSo> getAllThamSo(ThamSo thamSo, Date startDate, Date endDate, Pageable pageable) {

		Page<ThamSo> page = this.repo.findAll(new Specification<ThamSo>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<ThamSo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				if (thamSo.getTenThamSo() != null) {
					predicates.add(criteriaBuilder.or(
							criteriaBuilder.like(root.get("tenThamSo"), "%" + thamSo.getTenThamSo() + "%"),
							criteriaBuilder.like(root.get("maThamSo"), "%" + thamSo.getTenThamSo() + "%"),
							criteriaBuilder.like(root.get("moTa"), "%" + thamSo.getTenThamSo() + "%")));
				}

				if (startDate != null && endDate != null) {
					predicates.add(criteriaBuilder.between(root.get("ngayTao"), startDate, endDate));
				}

				// TODO Auto-generated method stub
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}, pageable);
		return page;
	}

	@Override
	public ThamSo addThamSo(ThamSo thamSo) {
		return this.repo.save(thamSo);
	}

	@Override
	public ThamSo updateThamSo(ThamSo thamSo, Long id) {
		ThamSo updateThamSo = repo.findById(id).map(newThamSo -> {
			newThamSo.setMaThamSo(thamSo.getMaThamSo());
			newThamSo.setTenThamSo(thamSo.getTenThamSo());
			newThamSo.setLoaiThamSo((thamSo.getLoaiThamSo()));
			newThamSo.setMoTa(thamSo.getMoTa());
			newThamSo.setNgaySua(thamSo.getNgaySua());
			newThamSo.setNguoiSua(thamSo.getNguoiSua());
			return this.repo.save(newThamSo);
		}).orElseGet(() -> {
			return this.repo.save(thamSo);
		});
		return this.repo.save(updateThamSo);
	}

	@Override
	public void delThamSo(Long id) {
		boolean exists = this.repo.existsById(id);
		if (exists) {
			this.repo.deleteById(id);
		}
	}

	@Override
	public List<ThamSo> getAllThamSo() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Autowired
	private DataSource dataSource;

	@Override
	public Page<ThamSo> getProcedure(String p_search_value, Integer p_page, Integer p_limit) {
		// TODO Auto-generated method stub

		List<ThamSo> result = new ArrayList<>();
		try (Connection connection = dataSource.getConnection();
				CallableStatement callableStatement = connection.prepareCall("{CALL GET_THAMSO_LIST(?,?,?,?)}")) {

			callableStatement.setString(1, p_search_value);
			callableStatement.setInt(2, p_page);
			callableStatement.setInt(3, p_limit);
			callableStatement.registerOutParameter(4, OracleTypes.CURSOR);
			callableStatement.execute();

			ResultSet resultSet = (ResultSet) callableStatement.getObject(4);
			while (resultSet.next()) {
				ThamSo thamSo = new ThamSo();
				thamSo.setId(resultSet.getLong("ID"));
				thamSo.setMaThamSo(resultSet.getString("MA_THAM_SO"));
				thamSo.setTenThamSo(resultSet.getString("TEN_THAM_SO"));
				thamSo.setMoTa(resultSet.getString("MO_TA"));
				thamSo.setNgayTao(resultSet.getDate("NGAY_TAO"));
				thamSo.setNguoiTao(resultSet.getString("NGUOI_TAO"));
				thamSo.setNgaySua(resultSet.getDate("NGAY_SUA"));
				thamSo.setNguoiSua(resultSet.getString("NGUOI_SUA"));

				// set properties of thamSo from resultSet
				result.add(thamSo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		int value = p_page - 1;
		if (value < 0) {
			value = 0;
		}
		int start = value * p_limit;
		int end = start + p_limit;
		if (end > result.size()) {
			end = result.size();
		}
		List<ThamSo> subList = result.subList(start, end);
		return new PageImpl<>(subList, PageRequest.of(p_page, p_limit), result.size());
	}

}

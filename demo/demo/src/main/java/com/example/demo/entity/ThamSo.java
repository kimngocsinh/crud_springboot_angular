package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "THAM_SO")
public class ThamSo {
	@Id
	@Column(name = "ID")
    @SequenceGenerator(name = "THAM_SO_SEQ",sequenceName = "THAM_SO_SEQ",allocationSize = 1)
    @GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "THAM_SO_SEQ")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "MA_THAM_SO")
	private String maThamSo;

	@Column(name = "TEN_THAM_SO")
	private String tenThamSo;

	@Column(name = "LOAI_THAM_SO")
	private int loaiThamSo;

	@Column(name = "MO_TA")
	private String moTa;

	@Temporal(TemporalType.DATE)
	@CreatedDate
	@Column(name = "NGAY_TAO")
	private Date ngayTao;

	@CreatedBy
	@Column(name = "NGUOI_TAO")
	private String nguoiTao;

	@LastModifiedBy
	@Column(name = "NGUOI_SUA")
	private String nguoiSua;

	@Temporal(TemporalType.DATE)
	@LastModifiedDate
	@Column(name = "NGAY_SUA")
	private Date ngaySua;

	@Transient
	private int page;

	@Transient
	private int size;

	@Transient
	private Date startDate;

	@Transient
	private Date endDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		if (size == 0) {
			size = 10;
		}
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaThamSo() {
		if (maThamSo == null) {
			maThamSo = "";
		}
		return maThamSo;
	}

	public void setMaThamSo(String maThamSo) {
		this.maThamSo = maThamSo;
	}

	public String getTenThamSo() {
		if (tenThamSo == null) {
			tenThamSo = "";
		}
		return tenThamSo;
	}

	public void setTenThamSo(String tenThamSo) {
		this.tenThamSo = tenThamSo;
	}

	public int getLoaiThamSo() {
		return loaiThamSo;
	}

	public void setLoaiThamSo(int loaiThamSo) {
		this.loaiThamSo = loaiThamSo;
	}

	public String getMoTa() {
		if (moTa == null) {
			moTa = "";
		}
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getNguoiTao() {
		return nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		this.nguoiTao = nguoiTao;
	}

	public String getNguoiSua() {
		return nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		this.nguoiSua = nguoiSua;
	}

	public Date getNgaySua() {
		return ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		this.ngaySua = ngaySua;
	}
}

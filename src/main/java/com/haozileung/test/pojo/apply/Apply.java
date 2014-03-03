/**
 * <p>文件的说明</p>
 * 创建时间：2014年3月3日 下午2:11:17 
 * @author lianghaopeng
 */
package com.haozileung.test.pojo.apply;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.haozileung.test.common.base.IEntity;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2014年3月3日 下午2:11:17
 * 
 * @author lianghaopeng
 * @version V1.0
 */
@Entity(name = "t_apply")
@Access(AccessType.FIELD)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Apply implements IEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5484207538160010711L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer applyId;

	@Column(name = "applier")
	private String applier;
	@Column(name = "applyDate")
	private Date applyDate;
	@Column(name = "content")
	private String content;
	@Column(name = "result")
	private Integer result;
	@Column(name = "comment")
	private String comment;
	@Column(name = "charge")
	private Double charge;
	@Column(name = "status")
	private Integer status;

	public Apply(Integer applyId, String applier, Date applyDate,
			String content, Integer result, String comment, Double charge,
			Integer status) {
		super();
		this.applyId = applyId;
		this.applier = applier;
		this.applyDate = applyDate;
		this.content = content;
		this.result = result;
		this.comment = comment;
		this.charge = charge;
		this.status = status;
	}

	public Apply() {
	}

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public String getApplier() {
		return applier;
	}

	public void setApplier(String applier) {
		this.applier = applier;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Double getCharge() {
		return charge;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}	
}

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
import javax.persistence.Transient;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

import com.haozileung.test.common.base.IEntity;
import com.haozileung.test.common.utils.JsonDateSerializer;

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
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date applyDate;
	@Column(name = "content")
	private String content;
	@Column(name = "result1")
	private Integer result1;
	@Column(name = "comment1")
	private String comment1;
	@Column(name = "result2")
	private Integer result2;
	@Column(name = "comment2")
	private String comment2;
	@Column(name = "numberOfDays")
	private Integer numberOfDays;
	@Column(name = "status")
	private Integer status;
	@Transient
	private String processInstanceId;
	@Transient
	private String taskId;
	@Transient
	private Integer isClaim;

	/**
	 * 
	 */
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

	public Integer getResult1() {
		return result1;
	}

	public void setResult1(Integer result1) {
		this.result1 = result1;
	}

	public String getComment1() {
		return comment1;
	}

	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}

	public Integer getResult2() {
		return result2;
	}

	public void setResult2(Integer result2) {
		this.result2 = result2;
	}

	public String getComment2() {
		return comment2;
	}

	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}

	public Integer getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(Integer numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Integer getIsClaim() {
		return isClaim;
	}

	public void setIsClaim(Integer isClaim) {
		this.isClaim = isClaim;
	}
}

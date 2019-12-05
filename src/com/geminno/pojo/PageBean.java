package com.geminno.pojo;

import java.util.List;

public class PageBean {
	private Integer curPage = 1;
	private Integer pageSize;
	private Integer totalNum; 
	private Integer pageCount;
	private List data;
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
		if(this.totalNum%this.pageSize==0){
			this.pageCount=(this.totalNum/this.pageSize);
		}else{
			this.pageCount=(this.totalNum/this.pageSize)+1;
		}
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	
}

package com.smart.school.dialog;


import com.smart.school.adapter.item.CommItem;

import java.util.ArrayList;

public class CDialogReturnItem {
	private CDialog.Flag flag;
	private String no;
	private String code;
	private String name;
	private String symbol;
	private String currency_flag;
	private int index;
	private ArrayList<CommItem> list;

	public CDialogReturnItem(CDialog.Flag flag, String no, String name) {
		super();
		this.flag = flag;
		this.no = no;
		this.name = name;
	}

	public CDialogReturnItem(CDialog.Flag flag, String no, String name, String code) {
		super();
		this.flag = flag;
		this.no = no;
		this.name = name;
		this.code = code;
	}

	public CDialogReturnItem(CDialog.Flag flag, String no, String name, int index) {
		super();
		this.flag = flag;
		this.no = no;
		this.name = name;
		this.index = index;
	}

	public CDialogReturnItem(CDialog.Flag flag, ArrayList<CommItem> arr){
		super();
		this.flag = flag;
		this.list = arr;
	}

	public CDialogReturnItem(CDialog.Flag flag, String no, String code, String name, String symbol, String currency_flag) {
		this.flag = flag;
		this.no = no;
		this.code = code;
		this.name = name;
		this.symbol = symbol;
		this.currency_flag = currency_flag;
	}

	public CDialog.Flag getFlag() {
		return flag;
	}
	public void setFlag(CDialog.Flag flag) {
		this.flag = flag;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ArrayList<CommItem> getList() {
		return list;
	}

	public void setList(ArrayList<CommItem> list) {
		this.list = list;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getCode() {
		return code;
	}

	public String getCurrency_flag() {
		return currency_flag;
	}

}
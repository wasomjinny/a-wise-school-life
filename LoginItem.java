package com.smart.school.school.item;

import android.os.Parcel;
import android.os.Parcelable;

public class LoginItem implements Parcelable{

	private String user_no;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_tel;
	private String user_kind;
	private String user_info_value1;
	private String user_info_value2;
	private String user_info_value3;
	private String bus_no;
	private String busstop_no;
	private String allergy_info;


	public LoginItem(String user_no, String user_id, String user_pw, String user_name, String user_tel,
					 String user_kind, String user_info_value1, String user_info_value2, String user_info_value3,
					 String bus_no, String busstop_no, String allergy_info) {
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_tel = user_tel;
		this.user_kind = user_kind;
		this.user_info_value1 = user_info_value1;
		this.user_info_value2 = user_info_value2;
		this.user_info_value3 = user_info_value3;
		this.bus_no = bus_no;
		this.busstop_no = busstop_no;
		this.allergy_info = allergy_info;
	}


	protected LoginItem(Parcel in) {
		user_no = in.readString();
		user_id = in.readString();
		user_pw = in.readString();
		user_name = in.readString();
		user_tel = in.readString();
		user_kind = in.readString();
		user_info_value1 = in.readString();
		user_info_value2 = in.readString();
		user_info_value3 = in.readString();
		bus_no = in.readString();
		busstop_no = in.readString();
		allergy_info = in.readString();
	}

	public static final Creator<LoginItem> CREATOR = new Creator<LoginItem>() {
		@Override
		public LoginItem createFromParcel(Parcel in) {
			return new LoginItem(in);
		}

		@Override
		public LoginItem[] newArray(int size) {
			return new LoginItem[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(user_no);
		dest.writeString(user_id);
		dest.writeString(user_pw);
		dest.writeString(user_name);
		dest.writeString(user_tel);
		dest.writeString(user_info_value1);
		dest.writeString(user_info_value2);
		dest.writeString(user_info_value3);
		dest.writeString(bus_no);
		dest.writeString(busstop_no);
		dest.writeString(allergy_info);
	}

	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public String getUser_kind() {
		return user_kind;
	}

	public void setUser_kind(String user_kind) {
		this.user_kind = user_kind;
	}

	public String getUser_info_value1() {
		return user_info_value1;
	}

	public void setUser_info_value1(String user_info_value1) {
		this.user_info_value1 = user_info_value1;
	}

	public String getUser_info_value2() {
		return user_info_value2;
	}

	public void setUser_info_value2(String user_info_value2) {
		this.user_info_value2 = user_info_value2;
	}

	public String getUser_info_value3() {
		return user_info_value3;
	}

	public void setUser_info_value3(String user_info_value3) {
		this.user_info_value3 = user_info_value3;
	}

	public String getBus_no() {
		return bus_no;
	}

	public void setBus_no(String bus_no) {
		this.bus_no = bus_no;
	}

	public String getBusstop_no() {
		return busstop_no;
	}

	public void setBusstop_no(String busstop_no) {
		this.busstop_no = busstop_no;
	}

	public String getAllergy_info() {
		return allergy_info;
	}

	public void setAllergy_info(String allergy_info) {
		this.allergy_info = allergy_info;
	}
}
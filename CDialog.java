package com.smart.school.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.smart.school.R;
import com.smart.school.adapter.item.CommItem;
import com.smart.school.app.config.AppController;
import com.smart.school.app.config.iConfig;
import com.smart.school.app.widget.CustomEditText2;
import com.smart.school.dialog.adapter.CDialogAdapter;
import com.smart.school.dialog.adapter.CDialogAdapter2;
import com.smart.school.dialog.adapter.item.CurrencyItem;
import com.smart.school.school.item.NoNameItem;
import com.smart.school.school.item.SchoolListItem;
import com.smart.school.util.helper.CSharedPreferencesHelper;

import java.util.ArrayList;
import java.util.List;

public class CDialog extends DialogFragment implements DialogInterface.OnClickListener{

	public enum Flag{
		FLAG_LIST,
		FLAG_LIST2,
		FLAG_LIST3,
		FLAG_LIST4,
		FLAG_LIST5,
		FLAG_LIST6,
		FLAG_LIST7,
		FLAG_TEXT,
		FLAG_TEXT2,
		FLAG_TEXT3,
		FLAG_TEXT4,
		FLAG_TEXT5,
		FLAG_TEXT6,
		FLAG_TEXT7,
		FLAG_TEXT8,
		FLAG_TEXT9,
		FLAG_TEXT10,
		FLAG_CHECKBOX,
		FLAG_REST_CUSTOM,
		FLAG_RADIOBUTTON,
		FLAG_RADIOBUTTON2,
		FLAG_RADIOBUTTON3,
		FLAG_RADIOBUTTON4,
		FLAG_RADIOBUTTON5,
		FLAG_RADIOBUTTON6,
		FLAG_EDIT_TEXT,
		FLAG_EDIT_TEXT2
	}

	private static ArrayList<?> 	mList;
	private static Flag mFlag 		= Flag.FLAG_LIST;
	private static String mTitle 	= "";
	private static String mMsg 		= "";
	private static String mBtnStr	= "";
	private static int nId 			= -1;

	private CustomEditText2 mEt;
	private CustomEditText2 mEt_Pw;
	private CustomEditText2 mEt_NewPw;
	private CustomEditText2 mEt_RePw;

	private String[] mStrLang = new String[iConfig.CHILD_COUNT_5];
	private String[] mStrSex = new String[iConfig.CHILD_COUNT_2];
	private String[] mStrCity_no;
	private String[] mStrCity_name;
	private String[] mStrLangSelectPos = {"0", "1", "2", "3", "4"};
	private String[] mStrSexSelectPos = {"1", "2"};

	private int nCheckPos;
	private int nRegionPos;
	private int nLangPos;
	private int nPos;

	private CDialogListener mListener;
	private CDialogReturnItem mReturn;
	private AppCompatActivity mAct;

	public static CDialog newInstance(Flag flag, String title, String msg){
		mFlag = flag;
		mTitle = title;
		mMsg = msg;

		return new CDialog();
	}

	public static CDialog newInstance(Flag flag, String title, String msg, String btnStr){
		mFlag = flag;
		mTitle = title;
		mMsg = msg;
		mBtnStr = btnStr;

		return new CDialog();
	}

	public static CDialog newInstance(Flag flag, String title, String msg, int id){
		mFlag = flag;
		mTitle = title;
		mMsg = msg;
		nId = id;

		return new CDialog();
	}

	public static CDialog newInstance(Flag flag, String title, ArrayList<?> list){
		mFlag = flag;
		mTitle = title;
		mList = list;

		return new CDialog();
	}

	/*public static CDialog newInstance(Flag flag, String title, int layout, ArrayList<?> mList){
		mFlag = flag;
		mTitle = title;
		mList = mList;
		return new CDialog();
	}*/

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if(context != null) {
			mAct = (AppCompatActivity) context;
		}else{
			mAct = (AppCompatActivity) AppController.getGlobalApplicationContext();
		}
	}

	@NonNull
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(mAct, R.style.DialogTheme2);

		if(mTitle != null) {
			builder.setTitle(Html.fromHtml(mTitle));
		}

		builder = initView(builder);
		builder = initButton(builder);

		return builder.create();
	}

	@SuppressWarnings("unchecked")
	private AlertDialog.Builder initView(final AlertDialog.Builder builder){
		switch (mFlag) {
			case FLAG_LIST:
			{
				mListener = (CDialogListener) mAct;
				CDialogAdapter mAdapter = new CDialogAdapter(mAct, R.layout.row_list, (List<CommItem>) mList);
				builder.setAdapter(mAdapter, this);
			}
			break;

			case FLAG_LIST2:
			{
				mListener = (CDialogListener)mAct;
				String[] region = new String[mList.size()];
				for(int i = 0; i < mList.size(); i++){
					SchoolListItem item = (SchoolListItem) mList.get(i);
					region[i] = item.getName();
				}

				builder.setItems(region, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						SchoolListItem item = (SchoolListItem)mList.get(which);
						mReturn = new CDialogReturnItem(mFlag, item.getNo(), item.getName());
						mListener.onDialogClick(CDialog.this);
						dismiss();
					}
				});
			}
			break;

			case FLAG_LIST3:
			{
				mListener = (CDialogListener) mAct;
				CDialogAdapter2 mAdapter = new CDialogAdapter2(mAct, R.layout.row_list, (List<CommItem>) mList);
				builder.setAdapter(mAdapter, this);
			}
			break;

			case FLAG_LIST4:
			{
				mListener = (CDialogListener)mAct;
				String[] region = new String[mList.size()];
				for(int i = 0; i < mList.size(); i++){
					NoNameItem item = (NoNameItem) mList.get(i);
					region[i] = item.getName();
				}

				builder.setItems(region, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						NoNameItem item = (NoNameItem) mList.get(which);
						mReturn = new CDialogReturnItem(mFlag, item.getNo(), item.getName());
						mListener.onDialogClick(CDialog.this);
						dismiss();
					}
				});
			}
			break;

			case FLAG_LIST7:
			{

				mListener = (CDialogListener)mAct;

			}
			break;

			case FLAG_RADIOBUTTON:
			{
				mStrLang[0] = getString(R.string.s3);
				mStrLang[1] = getString(R.string.s3);
				mStrLang[2] = getString(R.string.s3);
				mStrLang[3] = getString(R.string.s3);
				mStrLang[4] = getString(R.string.s3);

				mListener = (CDialogListener)mAct;

				nLangPos = CSharedPreferencesHelper.getValue(mAct, "LANG", "LANG_POS", -1);

				builder.setSingleChoiceItems(mStrLang, (nLangPos == -1 ? 4 : nLangPos),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// 각 리스트를 선택했을때
								nLangPos = whichButton;
							}
						}).setPositiveButton(getString(R.string.s4),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// OK 버튼 클릭시 , 여기서 선택한 값을 메인 Activity 로 넘기면 된다.
								mReturn = new CDialogReturnItem(mFlag, mStrLangSelectPos[nLangPos], mStrLang[nLangPos]);
								mListener.onDialogClick(CDialog.this);
								dismiss();
							}
						}).setNegativeButton(getString(R.string.s5),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// Cancel 버튼 클릭시
								mReturn = new CDialogReturnItem(mFlag, "-1", "-1");
								mListener.onDialogClick(CDialog.this);
								dismiss();
							}
						});
			}
			break;

			case FLAG_TEXT:
			case FLAG_TEXT2:
			case FLAG_TEXT3:
			case FLAG_TEXT4:
			case FLAG_TEXT5:
			case FLAG_TEXT6:
			case FLAG_TEXT7:
			case FLAG_TEXT8:
			case FLAG_TEXT9:
			case FLAG_TEXT10:
			{
				mListener = (CDialogListener) mAct;
				builder.setMessage(mMsg);
			}
			break;

			case FLAG_RADIOBUTTON2:
			{
				mStrSex[0] = "도착";
				mStrSex[1] = "출발";

				mListener = (CDialogListener)mAct;
				builder.setSingleChoiceItems(mStrSex, (nId != - 1 ? nId : 0),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// 각 리스트를 선택했을때
								nCheckPos = whichButton;
							}
						}).setPositiveButton(getString(R.string.s4),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// OK 버튼 클릭시 , 여기서 선택한 값을 메인 Activity 로 넘기면 된다.
								mReturn = new CDialogReturnItem(mFlag, mStrSexSelectPos[nCheckPos], mStrSex[nCheckPos]);
								mListener.onDialogClick(CDialog.this);
								dismiss();
							}
						}).setNegativeButton(getString(R.string.s5),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// Cancel 버튼 클릭시
								dismiss();
							}
						});
			}
			break;

			case FLAG_RADIOBUTTON3:
			{
				nRegionPos = CSharedPreferencesHelper.getValue(mAct, "SURF", "REGION_POS", 0);

				mStrCity_no = new String[mList.size()];
				mStrCity_name = new String[mList.size()];
				for(int i = 0; i < mList.size(); i++){
					CommItem item = (CommItem) mList.get(i);

					mStrCity_no[i] = item.getNo();
					mStrCity_name[i] = item.getName();
				}
				mListener = (CDialogListener)mAct;
				builder.setSingleChoiceItems(mStrCity_name, (nRegionPos != -1 ? nRegionPos : 0),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// 각 리스트를 선택했을때
								nRegionPos = whichButton;
							}
						}).setPositiveButton(getString(R.string.s4),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// OK 버튼 클릭시 , 여기서 선택한 값을 메인 Activity 로 넘기면 된다.

								CSharedPreferencesHelper.setValue(mAct, "SURF", "REGION_POS", nRegionPos);
								mReturn = new CDialogReturnItem(mFlag, mStrCity_no[nRegionPos], mStrCity_name[nRegionPos]);
								mListener.onDialogClick(CDialog.this);
								dismiss();
							}
						}).setNegativeButton(getString(R.string.s5),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// Cancel 버튼 클릭시
								dismiss();
							}
						});
			}
			break;

			//방문할 쇼핑스팟
			case FLAG_RADIOBUTTON4:
			{
				final String[] index = new String[mList.size()];
				final String[] no = new String[mList.size()];
				final String[] name = new String[mList.size()];
				for(int i = 0; i < mList.size(); i++){
					CommItem item = (CommItem) mList.get(i);

					index[i]	= item.getCode();
					no[i] 		= item.getNo();
					name[i] 	= item.getName();

					if(item.isSelect()){
						nPos = i;
					}
				}

				mListener = (CDialogListener)getActivity();
				builder.setSingleChoiceItems(name, (nPos != -1 ? nPos : 0),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// 각 리스트를 선택했을때
								nPos = whichButton;
							}
						}).setPositiveButton(getString(R.string.s4),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// OK 버튼 클릭시 , 여기서 선택한 값을 메인 Activity 로 넘기면 된다.

								if(index[nPos] != null){
									mReturn = new CDialogReturnItem(mFlag, index[nPos] + "@@" + no[nPos], name[nPos]);
								}else {
									mReturn = new CDialogReturnItem(mFlag, no[nPos], name[nPos]);
								}
								mListener.onDialogClick(CDialog.this);
								dismiss();
							}
						}).setNegativeButton(getString(R.string.s5),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// Cancel 버튼 클릭시
								dismiss();
							}
						});

				/*mListener = (CDialogListener)getActivity();
				mAdapter4 = new CityListCDialogAdapter(getActivity(), RES_ID_LAYOUT3, (ArrayList<CommItem>)mList);
				builder.setAdapter(mAdapter4, this);*/
			}
			break;

			case FLAG_RADIOBUTTON5:
			{
				final String[] index = new String[mList.size()];
				final String[] no = new String[mList.size()];
				final String[] name = new String[mList.size()];
				for(int i = 0; i < mList.size(); i++){
					CommItem item = (CommItem) mList.get(i);

					index[i]	= item.getCode();
					no[i] 		= item.getNo();
					name[i] 	= item.getName();

					if(item.isSelect()){
						nPos = i;
					}
				}

				mListener = (CDialogListener)getActivity();
				builder.setSingleChoiceItems(name, (nPos != -1 ? nPos : 0),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// 각 리스트를 선택했을때
								nPos = whichButton;
							}
						}).setPositiveButton(getString(R.string.s4),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// OK 버튼 클릭시 , 여기서 선택한 값을 메인 Activity 로 넘기면 된다.

								if(index[nPos] != null){
									mReturn = new CDialogReturnItem(mFlag, index[nPos] + "@@" + no[nPos], name[nPos]);
								}else {
									mReturn = new CDialogReturnItem(mFlag, no[nPos], name[nPos]);
								}
								mListener.onDialogClick(CDialog.this);
								dismiss();
							}
						}).setNegativeButton(getString(R.string.s5),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// Cancel 버튼 클릭시
								dismiss();
							}
						});

				/*mListener = (CDialogListener)getActivity();
				mAdapter4 = new CityListCDialogAdapter(getActivity(), RES_ID_LAYOUT3, (ArrayList<CommItem>)mList);
				builder.setAdapter(mAdapter4, this);*/
			}
			break;

			case FLAG_RADIOBUTTON6:
			{
				final String[] index = new String[mList.size()];
				final String[] no = new String[mList.size()];
				final String[] name = new String[mList.size()];
				for(int i = 0; i < mList.size(); i++){
					CommItem item = (CommItem) mList.get(i);

					index[i]	= item.getCode();
					no[i] 		= item.getNo();
					name[i] 	= item.getName();

					if(item.isSelect()){
						nPos = i;
					}
				}

				mListener = (CDialogListener)getActivity();
				builder.setSingleChoiceItems(name, (nPos != -1 ? nPos : 0),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// 각 리스트를 선택했을때
								nPos = whichButton;
							}
						}).setPositiveButton(getString(R.string.s4),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// OK 버튼 클릭시 , 여기서 선택한 값을 메인 Activity 로 넘기면 된다.

								if(index[nPos] != null){
									mReturn = new CDialogReturnItem(mFlag, index[nPos] + "@@" + no[nPos], name[nPos]);
								}else {
									mReturn = new CDialogReturnItem(mFlag, no[nPos], name[nPos]);
								}
								mListener.onDialogClick(CDialog.this);
								dismiss();
							}
						}).setNegativeButton(getString(R.string.s5),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								// Cancel 버튼 클릭시
								dismiss();
							}
						});

				/*mListener = (CDialogListener)getActivity();
				mAdapter4 = new CityListCDialogAdapter(getActivity(), RES_ID_LAYOUT3, (ArrayList<CommItem>)mList);
				builder.setAdapter(mAdapter4, this);*/
			}
			break;


			case FLAG_EDIT_TEXT:
			{
				mListener = (CDialogListener)mAct;

				View view = View.inflate(mAct, R.layout.row_edittext, null);
				builder.setView(view);

				mEt = view.findViewById(R.id.et_cdialog);

				if(mMsg.equals(getString(R.string.s2))
						|| mMsg.equals(getString(R.string.s6))
						|| mMsg.equals(getString(R.string.s7))){
					mEt.setHint(mMsg);
				}else{
					mEt.setText(mMsg);
				}
				mEt.setSelection(mEt.getLength());
			}
			break;

			case FLAG_EDIT_TEXT2:
			{
				mListener = (CDialogListener)mAct;

				View view = View.inflate(mAct, R.layout.row_edittext2, null);
				builder.setView(view);

				mEt_Pw 				= view.findViewById(R.id.cet_edittext2_pw);
				mEt_NewPw = view.findViewById(R.id.cet_edittext2_new_pw);
				mEt_RePw = view.findViewById(R.id.cet_edittext2_new_pw_confirm);
			}
			break;

			default:
				break;
		}
		return builder;
	}

	private AlertDialog.Builder initButton(AlertDialog.Builder builder){
		switch (mFlag) {
			case FLAG_LIST:
			{
				//			builder.setPositiveButton("확인", this);
			}
			break;

			case FLAG_LIST4:
			{
				/*builder.setPositiveButton(getString(R.string.s1954), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						int index = -1;
						for(int i = 0; i < ((ArrayList<TourListItem>) mList).size(); i++){
							if(((ArrayList<TourListItem>) mList).get(i).getComment_yn().equals("Y")){
								index = i;
								break;
							}
						}
						if(index != -1) {
							mReturn = new CDialogReturnItem(mFlag, ((ArrayList<TourListItem>) mList).get(index).getNo_tour(), ((ArrayList<TourListItem>) mList).get(index).getCity_no());
							mListener.onDialogClick(CDialog.this);
							dismiss();
						}
					}
				});
				builder.setNegativeButton(getString(R.string.s5640), this);*/
			}
			break;



			case FLAG_TEXT:
			{
				builder.setPositiveButton(getString(R.string.s8), new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						mReturn = new CDialogReturnItem(mFlag, "1", "");
						mListener.onDialogClick(CDialog.this);
						dismiss();
					}
				});
			}
			break;

			case FLAG_TEXT2:
			{
				builder.setPositiveButton(getString(R.string.s8), new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						mReturn = new CDialogReturnItem(mFlag, "1", "");
						mListener.onDialogClick(CDialog.this);
						dismiss();
					}
				});
				builder.setNegativeButton(getString(R.string.s9), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						mReturn = new CDialogReturnItem(mFlag, "0", "");
						mListener.onDialogClick(CDialog.this);
						dismiss();
					}
				});
			}
			break;

			case FLAG_TEXT3:
			{
				builder.setPositiveButton(getString(R.string.s10), new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						mReturn = new CDialogReturnItem(mFlag, "1", "");
						mListener.onDialogClick(CDialog.this);
						dismiss();
					}
				});
				builder.setNegativeButton(getString(R.string.s11), this);
			}
			break;

			case FLAG_TEXT4:
			{
				builder.setPositiveButton(getString(R.string.s10), new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						/*mReturn = new CDialogReturnItem(mFlag, "0", "");
						mListener.onDialogClick(CDialog.this);*/
						dismiss();
					}
				});
				builder.setNegativeButton(getString(R.string.s12), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						mReturn = new CDialogReturnItem(mFlag, "1", "");
						mListener.onDialogClick(CDialog.this);
					}
				});
			}
			break;

			case FLAG_TEXT5:
			{
				builder.setPositiveButton("권한설정", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						mReturn = new CDialogReturnItem(mFlag, "1", "");
						mListener.onDialogClick(CDialog.this);
					}
				});
				builder.setNegativeButton(getString(R.string.s11), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						mReturn = new CDialogReturnItem(mFlag, "0", "");
						mListener.onDialogClick(CDialog.this);
					}
				});
			}
			break;

			case FLAG_TEXT6:
			{
				builder.setOnKeyListener(new DialogInterface.OnKeyListener() {
					@Override
					public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
						if(keyCode == KeyEvent.KEYCODE_BACK){
							mReturn = new CDialogReturnItem(mFlag, "0", "");
							mListener.onDialogClick(CDialog.this);
							dismiss();
						}
						return false;
					}
				});

				builder.setPositiveButton(getString(R.string.s13), new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						mReturn = new CDialogReturnItem(mFlag, "1", "");
						mListener.onDialogClick(CDialog.this);
						dismiss();
					}
				});
			}
			break;

			case FLAG_TEXT7:
			{
				builder.setOnKeyListener(new DialogInterface.OnKeyListener() {
					@Override
					public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
						if(keyCode == KeyEvent.KEYCODE_BACK){
							mReturn = new CDialogReturnItem(mFlag, "0", "");
							mListener.onDialogClick(CDialog.this);
							dismiss();
						}
						return false;
					}
				});

				builder.setPositiveButton(getString(R.string.s4), new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						mReturn = new CDialogReturnItem(mFlag, "1", "");
						mListener.onDialogClick(CDialog.this);
						dismiss();
					}
				});
			}
			break;

			case FLAG_TEXT8:
			{
				builder.setPositiveButton(getString(R.string.s4), new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						mReturn = new CDialogReturnItem(mFlag, "1", "");
						mListener.onDialogClick(CDialog.this);
						dismiss();
					}
				});
			}
			break;

			case FLAG_TEXT9:
			{
				builder.setPositiveButton("다시 시도", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						mReturn = new CDialogReturnItem(mFlag, "1", "");
						mListener.onDialogClick(CDialog.this);
						dismiss();
					}
				});
			}
			break;

			case FLAG_TEXT10:
			{
				builder.setPositiveButton(getString(R.string.s4), new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						mReturn = new CDialogReturnItem(mFlag, "1", "");
						mListener.onDialogClick(CDialog.this);
						dismiss();
					}
				});
				builder.setNegativeButton(getString(R.string.s5), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						mReturn = new CDialogReturnItem(mFlag, "0", "");
						mListener.onDialogClick(CDialog.this);
					}
				});
			}
			break;

			case FLAG_CHECKBOX:
			{
				builder.setPositiveButton(getString(R.string.s10), new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dismiss();
					}
				});
			}
			break;

			case FLAG_EDIT_TEXT:
			{

				builder.setPositiveButton(nId != -1 ? getString(R.string.s12) : getString(R.string.s14), new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						mReturn = new CDialogReturnItem(mFlag, "1", mEt.getText(), nId);
						mListener.onDialogClick(CDialog.this);
						dismiss();
					}
				});
				builder.setNegativeButton(getString(R.string.s11), this);
			}
			break;

			case FLAG_EDIT_TEXT2:
			{
				builder.setPositiveButton(getString(R.string.s14), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						if (mEt_NewPw.getText().equals(mEt_RePw.getText())) {
							mReturn = new CDialogReturnItem(mFlag, mEt_Pw.getText(), mEt_NewPw.getText(), mEt_RePw.getText());
							mListener.onDialogClick(CDialog.this);
							dismiss();
						} else {
							Toast.makeText(mAct, getString(R.string.s15), Toast.LENGTH_SHORT).show();
						}
					}
				});
				builder.setNegativeButton(getString(R.string.s11), this);
			}
			break;

			case FLAG_RADIOBUTTON3:
			{

			}
			break;

			default:
				break;
		}
		return builder;
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		switch (mFlag) {

			case FLAG_LIST2:
			{
				CurrencyItem item = (CurrencyItem) mList.get(which);
				mReturn = new CDialogReturnItem(mFlag, item.getNo(), item.getCode(), item.getName(),
						item.getSymbol(), item.getFlag());
				mListener.onDialogClick(CDialog.this);
				dismiss();
			}
			break;



			case FLAG_LIST4:
			{
				/*mReturn = new CDialogReturnItem(mFlag, ((ArrayList<TourListItem>)mList).get(which).getNo_tour(),((ArrayList<TourListItem>)mList).get(which).getCity_no());
				mListener.onDialogClick(CDialog.this);
				dismiss();*/
			}
			break;

			case FLAG_LIST5:
			{
				/*DialogInterface.OnShowListener onShowListener = new DialogInterface.OnShowListener() {
					@Override
					public void onShow(DialogInterface dialog) {
					}
				};*/
			}
			break;

			case FLAG_TEXT:
			{
				mReturn = new CDialogReturnItem(mFlag, "1", "");
				mListener.onDialogClick(CDialog.this);
				dismiss();
			}
			break;

			case FLAG_TEXT2:
			{

			}
			break;

			case FLAG_RADIOBUTTON3:
			{
				// 각 리스트를 선택했을때
				nCheckPos = which;
			}
			break;

			default:
				break;
		}
	}

	public CDialogReturnItem getReturn() {
		return mReturn;
	}

	public void setReturn(CDialogReturnItem mReturn) {
		this.mReturn = mReturn;
	}

	public interface CDialogListener{

		void onDialogClick(DialogFragment dialog);
	}
}
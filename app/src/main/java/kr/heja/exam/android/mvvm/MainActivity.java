package kr.heja.exam.android.mvvm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import kr.heja.exam.android.mvvm.data.User;
import kr.heja.exam.android.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
	private ActivityMainBinding mBinding;
	private User mUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		mUser = new User("FirstName", "LastName");
		mBinding.setUser(mUser);
	}

	private void setUser() {
		mUser.firstName.set("FTest2");
		mUser.lastName.set("LTest2");
	}

	private void showUserDlg() {
		mUser.applyFromView(mBinding);

		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setTitle("사용자 정보")
				.setMessage("firstName: " + mUser.firstName.get() + " / lastName" + mUser.lastName.get())
				.setPositiveButton("확인", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				})
				.show();
	}

	public void onButtonClick(View v) {
		switch (v.getId()) {
			case R.id.btnSetUser:
				setUser();
				break;

			case R.id.btnShowUserDlg:
				showUserDlg();
				break;
		}
	}
}

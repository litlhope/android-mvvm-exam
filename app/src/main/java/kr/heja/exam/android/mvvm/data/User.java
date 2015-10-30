package kr.heja.exam.android.mvvm.data;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * Created by wesi on 15. 10. 30..
 */
public class User extends BaseObservable {
	public ObservableField<String> firstName = new ObservableField<>();
	public ObservableField<String> lastName = new ObservableField<>();

	public User(String firstName, String lastName) {
		this.firstName.set(firstName);
		this.lastName.set(lastName);
	}
}

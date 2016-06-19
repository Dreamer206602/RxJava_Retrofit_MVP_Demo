package com.mx.booboo.fragment;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.mx.booboo.R;
import com.mx.booboo.utils.UIUtils;

import butterknife.Bind;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment {

    @Bind(R.id.email)
    AutoCompleteTextView mEmail;
    @Bind(R.id.password)
    EditText mPassword;
    @Bind(R.id.email_sign_in_button)
    Button mEmailSignInButton;

    @Override
    protected View initView() {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_login, null);
    }

    @Override
    protected void initData() {

        mEmailSignInButton.setEnabled(false);
        bindViewByRxBing();
    }

    private void bindViewByRxBing() {
        Observable<CharSequence> observableEmail= RxTextView.textChanges(mEmail);
        Observable<CharSequence> observablePassword= RxTextView.textChanges(mPassword);

       Observable.combineLatest(observableEmail, observablePassword, new Func2<CharSequence, CharSequence, Boolean>() {
           @Override
           public Boolean call(CharSequence email, CharSequence password) {
               return isEmailValid(email.toString())&&isPassword(password.toString());
           }
       }).subscribe(new Action1<Boolean>() {
           @Override
           public void call(Boolean verify) {

               if(verify){
                   mEmailSignInButton.setEnabled(true);
                   mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Toast("Login");
                       }
                   });

               }else{
                   mEmailSignInButton.setEnabled(false);
               }

           }
       });
    }

    private boolean isPassword(String password) {
        return password.length()>4;
    }


    private boolean isEmailValid(String email) {
        return email.contains("@");
    }


}

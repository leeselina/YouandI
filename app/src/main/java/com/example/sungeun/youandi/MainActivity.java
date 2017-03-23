package com.example.sungeun.youandi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends Activity {

    FirebaseAuth mFirebaseAuth;
    FirebaseUser mFirebaseUser;

    String mUsername;
    String mPhotoUrl;

    final String TAG = MainActivity.class.getName();

    //Button btn_register, btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if (mFirebaseUser == null) {
            // FIXME: 로그인이 필요합니다.
            Toast.makeText(this, "로그인이 필요합니다", Toast.LENGTH_SHORT).show();
        } else {
            mUsername = mFirebaseUser.getDisplayName();
            if (mFirebaseUser.getPhotoUrl() != null) {
                mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
            }
        }
    }
        /*

        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomerRegister.class);
                startActivity(intent);
                finish();
            }
        });

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomerLoginCheck.class);
                startActivity(intent);
                finish();
            }
        });

        TextView find_idpw = (TextView) findViewById(R.id.find_idpw);
        find_idpw.setText(Html.fromHtml("<a href=\"http://www.naver.com\">아이디/비밀번호 찾기</a>"));
        find_idpw.setMovementMethod(LinkMovementMethod.getInstance());

        TextView facebook = (TextView) findViewById(R.id.login_facebook);
        facebook.setText(Html.fromHtml("<a href=\"http://www.facebook.com\">페이스북 로그인</a>"));
        facebook.setMovementMethod(LinkMovementMethod.getInstance());

    }*/
}

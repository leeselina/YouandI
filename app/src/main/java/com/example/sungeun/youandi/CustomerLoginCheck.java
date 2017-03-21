package com.example.sungeun.youandi;

/**
 * Created by sungeun on 2017-03-21.
 */


import android.os.Bundle;

/**
 * Created by sungeun on 2017-03-07.
 */
//로그인 성공시 다음창으로 넘어가기 위한 중복 체크하는 곳. 디비 id/pw와 연동하여 true면 새로운 activity창 부르기.
// false이면 alert창을 띄워 '아이디가 틀렸습니다' '비밀번호가 틀렸습니다' 알림띄우기

// 아이디가 null값일 경우에, 아이디를 입력해주세요. 비밀번호가 null값일 경우에, 비밀번호를 입력해주세요.
// 둘다 null값이면  --- switch문으로 해야 될듯 나중에 추가추가 할때(비밀번호 틀렸을 때/아이디 없을때..). 그게 편하니까

public class CustomerLoginCheck extends MainActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passlogin);

    }

}
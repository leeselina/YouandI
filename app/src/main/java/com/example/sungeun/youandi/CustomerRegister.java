package com.example.sungeun.youandi;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by sungeun on 2017-03-21.
 */

public class CustomerRegister extends AppCompatActivity {


    private int mYear;
    private int mMonth;
    private int mDay;
    static final int DATE_DIALOG_ID = 0;


    private EditText editTextName, editTextId, editTextPw;
    public Button edit_birth;
    public EditText editTextphone;
    public EditText editTextheight;
    public EditText editTextweight;
    public Button surgerydate;
    public Button leavinghospital;
    Button register_done,btn_idcheck;
    EditText edittext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginregister);


        //db에 연동시킬 항목
        editTextName = (EditText) findViewById(R.id.name);
        editTextId = (EditText) findViewById(R.id.id);
        editTextPw = (EditText) findViewById(R.id.pw);

        edit_birth = (Button)findViewById(R.id.edit_birth);

        editTextphone = (EditText) findViewById(R.id.phone);
        editTextheight = (EditText) findViewById(R.id.height);
        editTextweight = (EditText) findViewById(R.id.weight);

        surgerydate = (Button)findViewById(R.id.surgerydate);
        leavinghospital = (Button)findViewById(R.id.leavinghospital);



        //datepicker - 생년월일
        edit_birth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DialogFragment dialogfragment = new DatePickerDialogTheme1();

                dialogfragment.show(getFragmentManager(), "Theme 1");

            }//테스트

        });


        //datepicker - 수술일
        surgerydate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DialogFragment dialogfragment = new DatePickerDialogTheme2();
                dialogfragment.show(getFragmentManager(), "Theme 2");
            }
        });

        //datepicker - 퇴원일
        leavinghospital.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DialogFragment dialogfragment = new DatePickerDialogTheme3();

                dialogfragment.show(getFragmentManager(), "Theme 3");

            }

        });


        //spinner - 지역선택
        final TextView tv = (TextView)findViewById(R.id.textView1);
        final Spinner s = (Spinner)findViewById(R.id.spinner1);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                tv.setText((String)parent.getItemAtPosition(position));

                //String selectedItem = parent.getItemAtPosition(position).toString();


                // selectedArea = selectedItem;

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        //spinner - 수술방법선택
        final TextView tv2 = (TextView)findViewById(R.id.textView2);
        Spinner s2 = (Spinner)findViewById(R.id.spinner2);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                tv2.setText((String)parent.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        //spinner - 판정기수
        final TextView tvjudgement = (TextView)findViewById(R.id.textViewJudgement);
        Spinner sjudge = (Spinner)findViewById(R.id.spinnerJudgement);
        sjudge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                tvjudgement.setText((String) parent.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        //spinner - 수술경험여부선택
        final TextView tvnumsurgery = (TextView)findViewById(R.id.textViewNumsurgery);
        Spinner snum = (Spinner)findViewById(R.id.spinnerNumsurgery);
        snum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                tvnumsurgery.setText((String) parent.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        //spinner - 결혼여부
        final TextView tvmarital = (TextView)findViewById(R.id.textViewMarital);
        Spinner smari = (Spinner)findViewById(R.id.spinnerMarital);
        smari.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                tvmarital.setText((String) parent.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        //spinner - 자녀유무
        final TextView tvchildren = (TextView)findViewById(R.id.textViewChildren);
        Spinner schild = (Spinner)findViewById(R.id.spinnerChildren);
        schild.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                tvchildren.setText((String) parent.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });



        //등록완료버튼
        register_done = (Button) findViewById(R.id.register_done);
        register_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerRegister.this, MainActivity.class);
                startActivity(intent);

                String id = editTextId.getText().toString();
                String pw = editTextPw.getText().toString();
                String name = editTextName.getText().toString();


                String dateofbirth = edit_birth.getText().toString();
                String phone = editTextphone.getText().toString();

                String area = tv.getText().toString();

                String height = editTextheight.getText().toString();
                String weight = editTextweight.getText().toString();

                String judgement = tvjudgement.getText().toString();
                String numsurgery = tvnumsurgery.getText().toString();

                String howtooper = tv2.getText().toString();

                String dateofoper = surgerydate.getText().toString();
                String dateofout = leavinghospital.getText().toString();

                String maritalstatus = tvmarital.getText().toString();
                String children = tvchildren.getText().toString();

                insertToDatabase(id, pw, name, dateofbirth, phone, area, height, weight, judgement, numsurgery, howtooper, dateofoper,dateofout, maritalstatus, children);
            }
        });

        //db와 연결시켜 중복체크 확인해야하지만 우선 아이디 값을 받아와서 토스트메세지로 띄워본 것.
        edittext = (EditText) findViewById(R.id.id);
        btn_idcheck = (Button) findViewById(R.id.idcheck);

        btn_idcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idText = edittext.getText().toString();
                Toast.makeText(CustomerRegister.this, idText, Toast.LENGTH_SHORT).show();
            }
        });
    }


    //db에 추가
    private void insertToDatabase(String id, String pw, String name, String dateofbirth, String phone, String area, String height, String weight, String judgement, String numsurgery, String howtooper, String dateofoper, String dateofout, String maritalstatus, String children){

        class InsertData extends AsyncTask<String, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(CustomerRegister.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {

                try{
                    String id = (String)params[0];
                    String pw = (String)params[1];
                    String name = (String)params[2];
                    String dateofbirth = (String)params[3];
                    String phone = (String)params[4];
                    String area = (String)params[5];
                    String height = (String)params[6];
                    String weight = (String)params[7];
                    String judgement = (String)params[8];
                    String numsurgery = (String)params[9];
                    String howtooper = (String)params[10];
                    String dateofoper = (String)params[11];
                    String dateofout = (String)params[12];
                    String maritalstatus = (String)params[13];
                    String children = (String)params[14];


                    String link="http://192.168.99.75/registration.php";
                    String data  = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
                    data += "&" + URLEncoder.encode("pw", "UTF-8") + "=" + URLEncoder.encode(pw, "UTF-8");
                    data += "&" + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
                    data += "&" + URLEncoder.encode("dateofbirth", "UTF-8") + "=" + URLEncoder.encode(dateofbirth, "UTF-8");
                    data += "&" + URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8");
                    data += "&" + URLEncoder.encode("area", "UTF-8") + "=" + URLEncoder.encode(area, "UTF-8");
                    data += "&" + URLEncoder.encode("height", "UTF-8") + "=" + URLEncoder.encode(height, "UTF-8");
                    data += "&" + URLEncoder.encode("weight", "UTF-8") + "=" + URLEncoder.encode(weight, "UTF-8");
                    data += "&" + URLEncoder.encode("judgement", "UTF-8") + "=" + URLEncoder.encode(judgement, "UTF-8");
                    data += "&" + URLEncoder.encode("numsurgery", "UTF-8") + "=" + URLEncoder.encode(numsurgery, "UTF-8");
                    data += "&" + URLEncoder.encode("howtooper", "UTF-8") + "=" + URLEncoder.encode(howtooper, "UTF-8");
                    data += "&" + URLEncoder.encode("dateofoper", "UTF-8") + "=" + URLEncoder.encode(dateofoper, "UTF-8");
                    data += "&" + URLEncoder.encode("dateofout", "UTF-8") + "=" + URLEncoder.encode(dateofout, "UTF-8");
                    data += "&" + URLEncoder.encode("maritalstatus", "UTF-8") + "=" + URLEncoder.encode(maritalstatus, "UTF-8");
                    data += "&" + URLEncoder.encode("children", "UTF-8") + "=" + URLEncoder.encode(children, "UTF-8");


                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                    wr.write( data );
                    wr.flush();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while((line = reader.readLine()) != null)
                    {
                        sb.append(line);
                        break;
                    }
                    return sb.toString();
                }
                catch(Exception e){
                    return new String("Exception: " + e.getMessage());
                }

            }
        }

        InsertData task = new InsertData();
        task.execute(id,pw,name,dateofbirth,phone,area,height,weight,judgement,numsurgery,howtooper,dateofoper,dateofout,maritalstatus,children);
    }

}

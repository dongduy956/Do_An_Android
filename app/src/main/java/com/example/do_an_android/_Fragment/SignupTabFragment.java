package com.example.do_an_android._Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.do_an_android.Model.Server;
import com.example.do_an_android.Model.Support;
import com.example.do_an_android.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class SignupTabFragment extends Fragment implements View.OnClickListener {


    EditText username_sigup, password_signup, password_confirm_signup, name_signup, address_signup, phone_signup;
    Button btnSignup;
    Context context;

    public SignupTabFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signup_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setControl(view);
        btnSignup.setOnClickListener(this);
    }


    private boolean validateEditText(EditText txt, String description) {

        if (txt.getText().toString().trim().length() == 0) {
            Toast.makeText(context, description, Toast.LENGTH_SHORT).show();
            txt.requestFocus();
            return true;
        }
        return false;
    }

    private void setControl(View view) {
        username_sigup = view.findViewById(R.id.username_sigup);
        password_signup = view.findViewById(R.id.password_signup);
        password_confirm_signup = view.findViewById(R.id.password_confirm_signup);
        name_signup = view.findViewById(R.id.name_signup);
        address_signup = view.findViewById(R.id.address_signup);
        phone_signup = view.findViewById(R.id.phone_signup);
        btnSignup = view.findViewById(R.id.btnSignup);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnSignup:
                if (!(validateEditText(username_sigup, "Tài khoản không được rỗng.")
                        || validateEditText(password_signup, "Mật khẩu không được rỗng.")
                        || validateEditText(name_signup, "Tên khách hàng không được rỗng.")
                        || validateEditText(address_signup, "Địa chỉ không được rỗng.")
                        || validateEditText(phone_signup, "Số điện thoại không được rỗng.")
                )) {
                    if (password_signup.getText().toString().equals(password_confirm_signup.getText().toString()))
                        Sigup();
                    else {
                        Toast.makeText(context, "Nhập lại mật khẩu không trùng nhau.", Toast.LENGTH_SHORT).show();
                        password_confirm_signup.requestFocus();
                    }
                }

                break;
        }
    }

    private void Sigup() {

        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.urlSignup, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                if (response.toString().equals("0"))
                    Toast.makeText(context, "Trùng tên tài khoản.", Toast.LENGTH_SHORT).show();
                else if (response.toString().equals("-1"))
                    Toast.makeText(context, "Có lỗi xảy ra.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, "Đăng kí thành công.", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username_sigup.getText().toString());
                params.put("name", name_signup.getText().toString());
                params.put("password", Support.EndcodeMD5(password_signup.getText().toString()));
                params.put("address", address_signup.getText().toString());
                params.put("phone", phone_signup.getText().toString());
                return params;
            }
        };
        queue.add(stringRequest);
    }
}
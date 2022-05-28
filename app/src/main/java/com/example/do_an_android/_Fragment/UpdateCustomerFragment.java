package com.example.do_an_android._Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.do_an_android.Activity.MainActivity;
import com.example.do_an_android.Model.Server;
import com.example.do_an_android.Model.Support;
import com.example.do_an_android.R;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class UpdateCustomerFragment extends Fragment implements View.OnClickListener {

    Context context;
    ImageView imageCustomer;
    TextView textCustomer, logout;
    EditText name_updateCustomer, address_updateCustomer, phone_updateCustomer, passOld, passNew, passNewConfirm;
    Button btnUpdateCustomer, btnChangepass, btnConfirmChangpass, btnCancelChangpass;
    SharedPreferences sharedPreferencesUser;
    String username;
    Dialog dialog;

    public UpdateCustomerFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_customer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setControl(view);
        getDataCustomer();
        setClick();
    }

    private void setClick() {
        logout.setOnClickListener(this);
        btnUpdateCustomer.setOnClickListener(this);
        btnChangepass.setOnClickListener(this);
    }

    private void getDataCustomer() {
        sharedPreferencesUser = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        username = sharedPreferencesUser.getString("username", "");
        textCustomer.setText(username);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Server.urlGetCustomerByUsername + "?username=" + username, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Picasso.get().load(Server.urlImage + response.getString("image")).into(imageCustomer);
                    name_updateCustomer.setText(response.getString("name"));
                    address_updateCustomer.setText(response.getString("address"));
                    phone_updateCustomer.setText(0 + response.getString("phone"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(context).add(jsonObjectRequest);
    }

    private void setControl(View view) {
        imageCustomer = view.findViewById(R.id.imageCustomer);
        textCustomer = view.findViewById(R.id.textCustomer);
        logout = view.findViewById(R.id.logout);
        name_updateCustomer = view.findViewById(R.id.name_updateCustomer);
        address_updateCustomer = view.findViewById(R.id.address_updateCustomer);
        phone_updateCustomer = view.findViewById(R.id.phone_updateCustomer);
        btnUpdateCustomer = view.findViewById(R.id.btnUpdateCustomer);
        btnChangepass = view.findViewById(R.id.btnChangepass);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.logout:
                sharedPreferencesUser.edit().clear().commit();
                startActivity(new Intent(context, MainActivity.class));
                break;
            case R.id.btnUpdateCustomer:
                updateInfoCustomer();
                break;
            case R.id.btnChangepass:
                openDialogChangPass();
                break;
            case R.id.btnCancelChangpass:
                dialog.dismiss();
                break;
            case R.id.btnConfirmChangpass:
                if (validateEditText(passOld, "Mật khẩu cũ không được rỗng.")
                        || validateEditText(passNew, "Mật khẩu mới không được rông."))
                    break;
                if (!passNew.getText().toString().equals(passNewConfirm.getText().toString()))
                    Toast.makeText(context, "Nhập lại mật khẩu không trùng nhau.", Toast.LENGTH_SHORT).show();
                else
                    changePass();
                break;
        }
    }

    private void changePass() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.urlChangePassCustomer, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.toString().equals("-1"))
                    Toast.makeText(context, "Mật khẩu cũ không chính xác.", Toast.LENGTH_SHORT).show();
                else if (response.toString().equals("0"))
                    Toast.makeText(context, "Có lỗi xảy ra.", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(context, "Đổi mật khẩu thành công.", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }


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
                params.put("username", username);
                params.put("pass_old", Support.EndcodeMD5(passOld.getText().toString()));
                params.put("pass_new", Support.EndcodeMD5(passNew.getText().toString()));
                return params;
            }
        };
        Volley.newRequestQueue(context).add(stringRequest);
    }

    private void openDialogChangPass() {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.diaglog_change_pass);
        dialog.setCanceledOnTouchOutside(false);
        //ánh xạ
        passOld = dialog.findViewById(R.id.passOld);
        passNew = dialog.findViewById(R.id.passNew);
        passNewConfirm = dialog.findViewById(R.id.passNewConfirm);
        btnConfirmChangpass = dialog.findViewById(R.id.btnConfirmChangpass);
        btnCancelChangpass = dialog.findViewById(R.id.btnCancelChangpass);
        btnConfirmChangpass.setOnClickListener(this);
        btnCancelChangpass.setOnClickListener(this);
        dialog.show();
    }


    private boolean validateEditText(EditText txt, String description) {

        if (txt.getText().toString().trim().length() == 0) {
            Toast.makeText(context, description, Toast.LENGTH_SHORT).show();
            txt.requestFocus();
            return true;
        }
        return false;
    }

    private void updateInfoCustomer() {
        if (validateEditText(name_updateCustomer, "Tên khách hàng không được rỗng.")
                || validateEditText(address_updateCustomer, "Địa chỉ không được rỗng.")
                || validateEditText(phone_updateCustomer, "Số điện thoại không được rỗng."))
            return;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.urlUpdateCustomer, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.toString().equals("1"))
                    Toast.makeText(context, "Cập nhật thành công.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, "Có lỗi xảy ra.", Toast.LENGTH_SHORT).show();

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
                params.put("username", username);
                params.put("name", name_updateCustomer.getText().toString());
                params.put("address", address_updateCustomer.getText().toString());
                params.put("phone", phone_updateCustomer.getText().toString());
                return params;
            }
        };
        Volley.newRequestQueue(context).add(stringRequest);
    }
}
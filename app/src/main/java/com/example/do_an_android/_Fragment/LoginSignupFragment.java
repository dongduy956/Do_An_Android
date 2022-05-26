package com.example.do_an_android._Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.do_an_android.Adapter.ViewPagerAdapter;
import com.example.do_an_android.R;
import com.google.android.material.tabs.TabLayout;


public class LoginSignupFragment extends Fragment {
    Context context;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewpagerAdapter;

    public LoginSignupFragment(Context context) {
        this.context = context;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_login_signup, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setControl(view);
        viewpagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        tabLayout.setupWithViewPager(viewPager);
        viewpagerAdapter.addFragment(new LoginTabFragment(), "Đăng nhập");
        viewpagerAdapter.addFragment(new SignupTabFragment(context), "Đăng kí");
        viewPager.setAdapter(viewpagerAdapter);
    }

    private void setControl(View view) {
        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tab_layout);
    }
}
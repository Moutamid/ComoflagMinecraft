package com.moliyacentre.topcamouflageskinsmcpe;

import androidx.fragment.app.DialogFragment;
import com.moliyacentre.topcamouflageskinsmcpe.fragment.BaseFragment;


public interface IMainManager {
    void addScreen(BaseFragment baseFragment);

    void closeScreen();

    void setScreen(BaseFragment baseFragment);

    void showDialog(DialogFragment dialogFragment);
}

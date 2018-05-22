package com.goldpalm.emergencyinquiry.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;


public class CustomDialog {

    private static CustomDialog myPopupDialog;
    private Dialog dialog = null;
    private View layoutView;


    private CustomDialog() {
        // TODO Auto-generated constructor stub
    }

    public static CustomDialog getInstance(){
        if(myPopupDialog==null) {
            synchronized (CustomDialog.class) {
                if(myPopupDialog == null) {
                    myPopupDialog = new CustomDialog();
                }
            }
        }
        return myPopupDialog;
    }


    public void showPopupDialog(Context context, int resId, int styleId) {
        dialog = new Dialog(context,styleId);
        dialog.setCanceledOnTouchOutside(true);
        layoutView= LayoutInflater.from(context).inflate(resId, null);
        dialog.setContentView(layoutView);
    }

    public void setDlgParams(int anim,int width, int height, int gravity){
        dialog.getWindow().setWindowAnimations(anim);
        WindowManager.LayoutParams wmlp =dialog.getWindow().getAttributes();
        wmlp.width=width;
        wmlp.height=height;
        wmlp.gravity = gravity;
        dialog.getWindow().setAttributes(wmlp);
    }

    public void showDlg(){
        if(dialog!=null&&!dialog.isShowing())dialog.show();
    }

    public void dismiss(){
        if(dialog!=null&&dialog.isShowing())dialog.dismiss();
    }
    public boolean isShowing() {
        if (dialog!=null)
        {

            return dialog.isShowing();
        }else
        {
            return false;
        }
    }

}

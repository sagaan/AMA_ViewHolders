package com.ama.viewholders;


import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private TextView txtNombre;
    private ImageView imgTaco;

    public TextView getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(TextView txtNombre) {
        this.txtNombre = txtNombre;
    }

    public ImageView getImgTaco() {
        return imgTaco;
    }

    public void setImgTaco(ImageView imgTaco) {
        this.imgTaco = imgTaco;
    }
}

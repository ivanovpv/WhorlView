# WhorlViewProgressDialog

Fork of Whorlview by Kyson (https://github.com/Kyson/WhorlView)

![https://github.com/ivanovpv/WhorlView/blob/master/art/whorl_progress_showcase.gif](https://github.com/ivanovpv/WhorlView/blob/master/art/whorl_progress_showcase.gif)

Adopted to `ProgressDialog` with spinner style (indeterminate length) - `STYLE_SPINNER`

## Usage:


     WhorlViewDialogProgress progressDialog=new WhorlViewProgressDialog(context);
     progressDialog.show();

     //blah-blah

     //now stop/hide it
     progressDialog.dismiss();

or:

    WhorlViewDialogProgress progressDialog=new WhorlViewProgressDialog(context)
        .withLayout(R.layout.my_custom_layout).show();
    //blah-blah
    //now stop/hide it
    progressDialog.dismiss();

layout has to contain at least one tag WhorlView, like:

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center_horizontal"
        android:orientation="vertical"
        >
        <com.tt.whorlviewlibrary.WhorlView
            android:id="@+id/whorl1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="32dp"
            app:whorlview_circle_colors="#F14336_#ffffff_#4CAF50_#5677fc_#F44336_#4CAF50"
            app:whorlview_circle_speed="270"
            app:whorlview_parallax="fast"
            app:whorlview_strokeWidth="8"
            app:whorlview_sweepAngle="8"/>
        <com.tt.whorlviewlibrary.WhorlView
            android:id="@+id/whorl2"
            android:layout_width="1dp"
            android:layout_height="1dp"
            android:layout_marginTop="32dp"
            app:whorlview_circle_speed="360"
            app:whorlview_parallax="fast"
            app:whorlview_strokeWidth="16"
            app:whorlview_sweepAngle="135"/>
    </LinearLayout>

## License

Copyright (c) 2015 Kyson, 2016 Pavel Ivanov

Licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)


package com.example.ungdungdoctruyen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.app.Notification;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    ListView listView,listViewNew,listViewThongTin;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        ActionViewFlipper();
    }
//Phương thức cho chạy quảng cáo với ViewFlipper
    private void ActionViewFlipper() {
        //mảng chữ ảnh cho quảng cáo
        ArrayList<String> mangquangcao = new ArrayList<>();
//Add anhe vào mảng
        mangquangcao.add("https://lh3.googleusercontent.com/p/AF1QipNNMbETsHCu-WI7MO0uI0mUYQo6AZYSLa1JIC87=s1360-w1360-h1020");
        mangquangcao.add("https://toplist.vn/images/800px/deo-chuong-cho-meo-230180.jpg");
        mangquangcao.add("https://toplist.vn/images/800px/cu-cai-trang-230181.jpg");
        mangquangcao.add("https://toplist.vn/images/800px/de-den-va-de-trang-230182.jpg");

        //Thực hiện vòng lặp for gán ảnh vào Imageview rồi từ imageview lên app
        for (int i = 0; i < mangquangcao.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            //Sử dụng hàm thư viện pisscsso
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            //phương thức chỉnh tấm hỉnh vừa khung quảng cáo
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            //thêm ảnh từ imageview vào viewlipper
            viewFlipper.addView(imageView);

        }
        //thiết lập tự động chạy trong 4s
        viewFlipper.setFlipInterval(4000);
//run viewfliper
        viewFlipper.setAutoStart(true);

        //gọi amination cho vào và ra
        Animation animation_slide_inn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        //Gọi am=nimation vào viewlipper
        viewFlipper.setInAnimation(animation_slide_inn);
        viewFlipper.setInAnimation(animation_slide_out);
    }
    //Phương thức ánh xạ
    private void AnhXa() {
toolbar = findViewById(R.id.toolbarmanhinhchinh);
viewFlipper = findViewById(R.id.viewflipper);
listViewNew = findViewById(R.id.listviewNew);
listView = findViewById(R.id.listviewmanhinhchinh);
listViewThongTin=findViewById(R.id.listviewthongtin);
navigationView = findViewById(R.id.navigationView);
drawerLayout = findViewById(R.id.drawerlayout);


    }
}
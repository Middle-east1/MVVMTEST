package in.ac.srmuniv.mvvmtest.model;

import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class AnimeModel {

    private String name, title, image;

    int id;

    public AnimeModel(String name, String title, String image, int id) {
        this.name = name;
        this.title = title;
        this.image = image;
        this.id = id;
    }

    public AnimeModel() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String imag) {
        this.image = imag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @BindingAdapter("loadImage")
    public static  void img(View view , String image){
        ImageView imageView  = (ImageView) view;
        Glide.with(imageView.getContext()).load(image).into(imageView);

    }
}

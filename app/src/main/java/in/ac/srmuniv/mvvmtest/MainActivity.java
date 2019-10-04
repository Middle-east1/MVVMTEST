package in.ac.srmuniv.mvvmtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

import in.ac.srmuniv.mvvmtest.adapter.AnimeAdapter;
import in.ac.srmuniv.mvvmtest.databinding.ActivityMainBinding;
import in.ac.srmuniv.mvvmtest.model.AnimeModel;

public class MainActivity extends AppCompatActivity {

    AnimeAdapter adapter ;
    private MainViewModel mainViewModel ;
    private ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mainViewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.init("anime","id",1);
        mainViewModel.getData().observe(this, new Observer<List<QueryDocumentSnapshot>>() {
            @Override
            public void onChanged(List<QueryDocumentSnapshot> queryDocumentSnapshots) {
                List<AnimeModel> animeAdapterList  = new ArrayList<>();
                for (QueryDocumentSnapshot snapshot: queryDocumentSnapshots) {

                    AnimeModel animeModel = snapshot.toObject(AnimeModel.class);

                  animeAdapterList.add(animeModel);

                }

                adapter.getdata(animeAdapterList);

            }
        });


        mainBinding.recyclerViewAnime.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AnimeAdapter(this);
        mainBinding.recyclerViewAnime.setAdapter(adapter);


    }
}

package in.ac.srmuniv.mvvmtest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.List;

import in.ac.srmuniv.mvvmtest.model.AnimeModel;

public class Repository {

    private AnimeModel animeModel  = new AnimeModel();
    private static  Repository instance ;
    public static  Repository getInstance (){

        if (instance==null){

            instance = new Repository();

        }
return instance ;


    }


    public LiveData<List<QueryDocumentSnapshot>> getdatawherefrom(String path , String name , Object value){


        CollectionReference collection = FirebaseFirestore.getInstance().collection(path);

        Query query = collection.whereEqualTo(name, value);

        LiveDataListener liveDataListener = new LiveDataListener(query);

        return liveDataListener.getDataLive();


    }

}

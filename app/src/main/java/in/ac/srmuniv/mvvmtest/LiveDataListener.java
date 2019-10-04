package in.ac.srmuniv.mvvmtest;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class LiveDataListener extends LiveData<DocumentSnapshot> implements EventListener<QuerySnapshot> {

    private Query query ;
    private ListenerRegistration listenerRegistration ;
    private MutableLiveData<List<QueryDocumentSnapshot>> listMutableLiveData;


    public LiveDataListener(Query query){

        this.query =query;

        listMutableLiveData = new MutableLiveData<>();
        listenerRegistration =this.query.addSnapshotListener(this);
    }
    @Override
    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {


        if (queryDocumentSnapshots!=null&&e==null) {
            ArrayList<QueryDocumentSnapshot> myList = new ArrayList<>();
            for (QueryDocumentSnapshot snapshot : queryDocumentSnapshots) {

                myList.add(snapshot);

            }
            listMutableLiveData.setValue(myList);

        }else {

            sendLog(e.getMessage());

        }
    }


    @Override
    protected void onActive() {
        super.onActive();

        listenerRegistration = query.addSnapshotListener(this);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        listenerRegistration.remove();
        listenerRegistration = null;
    }


    private void sendLog(String msg){

        Log.i("myLog", msg);

    }

    public MutableLiveData<List<QueryDocumentSnapshot>> getDataLive(){


        return listMutableLiveData;
    }
}

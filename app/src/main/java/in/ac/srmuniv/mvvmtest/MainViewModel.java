package in.ac.srmuniv.mvvmtest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.List;


public class MainViewModel extends ViewModel {

    private LiveData<List<QueryDocumentSnapshot>> data ;
    private Repository repository ;

    public void  init (String Path , String name , Object value){
        if (data!=null){

            return;
        }
        repository = Repository.getInstance();
        data = repository.getdatawherefrom(Path,name,value);

    }



    public LiveData<List<QueryDocumentSnapshot>> getData (){

        return data;
    }
}

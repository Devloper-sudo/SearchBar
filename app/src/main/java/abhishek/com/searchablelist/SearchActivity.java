package abhishek.com.searchablelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private EditText searchEt;
    private RecyclerView recy;
    private SearchAdapter searchAdapter;
    private List<User> userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        searchEt = findViewById(R.id.searchView);
        recy = findViewById(R.id.recy);
        userList = new ArrayList<>();


        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recy.setLayoutManager(manager);
        searchAdapter = new SearchAdapter(userList);
        recy.setAdapter(searchAdapter);


        searchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        setData();


    }


    void setData() {
        userList.add(new User("100", "Marsh"));
        userList.add(new User("1002", "Tom Hoody"));
        userList.add(new User("434", "Johhny Depp"));
        userList.add(new User("938321", "Steven"));
        userList.add(new User("138340", "John Cena"));
        userList.add(new User("3827", "UnderTaker"));
        userList.add(new User("138340", "Tripple H"));
        searchAdapter.notifyDataSetChanged();

    }


}

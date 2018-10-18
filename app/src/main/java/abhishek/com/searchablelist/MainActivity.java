package abhishek.com.searchablelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClicByEdittext(View view) {

        Intent intent=new Intent(this,SearchActivity.class);
        startActivity(intent);

    }

    public void onClicByToolbar(View view) {

        Intent intent=new Intent(this,ToolBarActivity.class);
        startActivity(intent);
    }
}

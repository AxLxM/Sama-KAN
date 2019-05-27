package samakan.alm.com;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class StudentActivity extends AppCompatActivity {

    private RecyclerView.Adapter mAdapter;
    ArrayList<ExampleItem0> mExampleList;
    ImageView imgBack, imgHozor, imgApp;

    EditText edtUser;
    public LinearLayout lyrTFW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        edtUser = findViewById(R.id.edtUser);
        imgApp = findViewById(R.id.imgApp);
        imgHozor = findViewById(R.id.imgHozor);
        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                finish();
            }
        });
        lyrTFW = findViewById(R.id.lyrTFW);
        imgHozor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomNavigationView btm = findViewById(R.id.btmTFW);
                btm.setOnNavigationItemSelectedListener(tfw);
                lyrTFW.setVisibility(VISIBLE);
            }
        });

        loadData();
        buildRecyclerView();
        setInsertButton();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener tfw = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch (menuItem.getItemId()) {
                case R.id.false_tfw:
                    imgHozor.setImageResource(R.drawable.ic_absent);
                    lyrTFW.setVisibility(GONE);
                    return true;
                case R.id.true_tfw:
                    imgHozor.setImageResource(R.drawable.ic_present);
                    lyrTFW.setVisibility(GONE);
                    return true;
                case R.id.warning_tfw:
                    imgHozor.setImageResource(R.drawable.ic_late);
                    lyrTFW.setVisibility(GONE);
                    return true;
                default:
                    return false;
            }
        }
    };

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("student", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mExampleList);
        editor.putString("tfw", json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("student", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("tfw", null);
        Type type = new TypeToken<ArrayList<ExampleItem0>>() {
        }.getType();
        mExampleList = gson.fromJson(json, type);

        if (mExampleList == null) {
            mExampleList = new ArrayList<>();
        }
    }

    private void buildRecyclerView() {
        RecyclerView mRecyclerView = findViewById(R.id.rcv);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        mAdapter = new ExampleAdapter0(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void setInsertButton() {
        imgApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User = edtUser.getText().toString();
                int pic = R.drawable.img;
                int hozor = R.drawable.ic_late;
                insertItem(pic, hozor, User);
                saveData();
            }
        });
    }

    private void insertItem(int line1, int line2, String line3) {
        mExampleList.add(new ExampleItem0(line1, line2, line3));
        mAdapter.notifyItemInserted(mExampleList.size());
    }

}

package samakan.alm.com;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class ExampleAdapter0 extends RecyclerView.Adapter<ExampleAdapter0.ExampleViewHolder0> {

    private ArrayList<ExampleItem0> mExampleList;

    public static class ExampleViewHolder0 extends RecyclerView.ViewHolder {
        public ImageView imgUser;
        public ImageView imgTFW;
        TextView mTextView2;
        public LinearLayout lyrTFW;


        public ExampleViewHolder0(final View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.imgUser);
            imgTFW = itemView.findViewById(R.id.imgTFW);
            mTextView2 = itemView.findViewById(R.id.txtName);
            lyrTFW = itemView.findViewById(R.id.lyrTFW);

            imgTFW.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BottomNavigationView btm = itemView.findViewById(R.id.tfw);
                    btm.setOnNavigationItemSelectedListener(tfw);
                    lyrTFW.setVisibility(VISIBLE);
                }
            });
        }
        private BottomNavigationView.OnNavigationItemSelectedListener tfw = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.false_tfw:
                        imgTFW.setImageResource(R.drawable.ic_absent);
                        lyrTFW.setVisibility(GONE);
                        return true;
                    case R.id.true_tfw:
                        imgTFW.setImageResource(R.drawable.ic_present);
                        lyrTFW.setVisibility(GONE);
                        return true;
                    case R.id.warning_tfw:
                        imgTFW.setImageResource(R.drawable.ic_late);
                        lyrTFW.setVisibility(GONE);
                        return true;
                    default:
                        return false;
                }
            }
        };
    }


    public ExampleAdapter0(ArrayList<ExampleItem0> EX) {
        mExampleList = EX;
    }

    @Override
    public ExampleViewHolder0 onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item0, parent, false);
        ExampleViewHolder0 evh = new ExampleViewHolder0(v);
        return evh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ExampleViewHolder0 holder, int position) {
        ExampleItem0 currentItem = mExampleList.get(position);

        holder.imgUser.setImageResource(currentItem.getImg());
        holder.imgTFW.setImageResource(currentItem.getText());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

}

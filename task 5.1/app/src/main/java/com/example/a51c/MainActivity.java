package com.example.a51c;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";//debug



    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImagesUrls = new ArrayList<>();
    private ArrayList<String> content = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started");//started debug



        initImageBitmaps();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.container, new Fragment1());
//        fragmentTransaction.commit();
        //onBindViewHolder();






    }
    public void onclick(){

    }

//    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder) {
////        Log.d(TAG, "onBindViewHolder: called");
////        Glide.with(mContext)
////                .asBitmap()
////                .load(mImages.get(position))
////                .into(holder.imageView);
////
////
////        holder.imageName.setText(mImageNmaes.get(position));
////        holder.content.setText(content.get(position));
////        //imageview onclick listener
//        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.container, new Fragment1());
//                fragmentTransaction.commit();
//
//
//            }
//        });
//
//    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: perparing bitmaps");

        mImagesUrls.add("https://www.australia.com/content/australia/en_ca/places/gold-coast-and-surrounds/guide-to-the-gold-coast/_jcr_content/hero/mobile.adapt.768.high.jpg");
        mNames.add("Gold Coast");
        content.add("The Gold Coast is a coastal city in the Australian state of Queensland");

        mImagesUrls.add("https://s1.at.atcdn.net/wp-content/uploads/2018/09/Uluru_hero-768x369.jpg");
        mNames.add("Uluru");
        content.add("Ayers Rock, is a large sandstone rock formation in the southern part of the Northern Territory in Australia. ");

        mImagesUrls.add("https://www.businessdestinations.com/wp-content/uploads/2017/02/E011_rt-featured.jpg");
        mNames.add("Great Barrier Reef");
        content.add("The Great Barrier Reef is the world's largest coral reef system");

        mImagesUrls.add("https://www.tripsavvy.com/thmb/NrpZyAWL1TgfxvmENhSOK-os3Gs=/1885x1414/smart/filters:no_upscale()/OperaHouse-755d893182dc4811b608eb1a99792fd7.jpg");
        mNames.add("Sydney Opera House");
        content.add("The Sydney Opera House is a multi-venue performing arts centre at Sydney Harbour located in Sydney");


        mImagesUrls.add("https://upload.wikimedia.org/wikipedia/commons/8/80/Pinnacles_pano_2005-08-26.jpg");
        mNames.add("The Pinnacles");
        content.add("The Pinnacles are limestone formations within Nambung National Park, near the town of Cervantes, Western Australia.");


        mImagesUrls.add("https://www.travelonline.com/victoria/attractions/12-apostles/12-apostles-11504.jpg");
        mNames.add("The Twelve Apostles");
        content.add("The Twelve Apostles is a collection of limestone stacks off the shore of Port Campbell National Park");


        mImagesUrls.add("https://images.thebrag.com/td/uploads/2017/10/st-pauls-768x486.jpg");
        mNames.add("St. Paul's Cathedral");
        content.add("St Paul's Cathedral is an Anglican cathedral in Melbourne, Australia.");


        mImagesUrls.add("https://www.visitvictoria.com/-/media/images/great-ocean-road/things-to-do/nature-and-wildlife/beaches-and-coastlines/lorne-great-ocean-road_gor_u_1233198_1150x863.jpg?ts=20150625371240");
        mNames.add("Great Ocean Road");
        content.add("The Great Ocean Road is an Australian National Heritage listed 243-kilometre in VIC");


        initRecyclerView();

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerView");
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        RecyclerView recyclerView2 = findViewById(R.id.recycleView2);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImagesUrls,content);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager managers = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(managers);



        RecyclerViewAdapter_2 adapter2 = new RecyclerViewAdapter_2(this,mImagesUrls);
        recyclerView2.setAdapter(adapter2);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(manager);
    }



















    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {




        private static final String TAG = "RecyclerViewAdapter";

        private ArrayList<String> mImageNmaes = new ArrayList<>();
        private ArrayList<String> mImages = new ArrayList<>();
        private ArrayList<String> content = new ArrayList<>();
        private Context mContext;


        public RecyclerViewAdapter(Context mContext, ArrayList<String> mImageNmaes, ArrayList<String> mImages, ArrayList<String> content) {
            this.mImageNmaes = mImageNmaes;
            this.mImages = mImages;
            this.mContext = mContext;

            this.content = content;
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Log.d(TAG, "onBindViewHolder: called");
            Glide.with(mContext)
                    .asBitmap()
                    .load(mImages.get(position))
                    .into(holder.imageView);


            holder.imageName.setText(mImageNmaes.get(position));
            holder.content.setText(content.get(position));
            //imageview onclick listener
            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Bundle bundle = new Bundle();
                    bundle.putString("mImageNames", mImageNmaes.get(position));
                    bundle.putString("content",content.get(position));
                    bundle.putString("mImage",mImages.get(position));
                    bundle.putString("context",mContext.toString());

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    Fragment1 fragment1 = new Fragment1();
                    fragment1.setArguments(bundle);

                    fragmentTransaction.replace(R.id.container,fragment1);
                    fragmentTransaction.commit();




                }
            });

        }

        @Override
        public int getItemCount() {
            return mImageNmaes.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            CircleImageView imageView;
            TextView imageName;
            RelativeLayout parentLayout;
            TextView content;



            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.image);
                imageName = itemView.findViewById(R.id.image_name);
                parentLayout = itemView.findViewById(R.id.parent_layout);
                content = itemView.findViewById(R.id.content);
            }
        }


    }



















    public static class  RecyclerViewAdapter_2 extends RecyclerView.Adapter<RecyclerViewAdapter_2.ViewHolder> {


        private static final String TAG = "RecyclerViewAdapter";

        private ArrayList<String> mImages = new ArrayList<>();
        private Context mContext;



        public RecyclerViewAdapter_2(Context mContext, ArrayList<String> mImages) {
            this.mImages = mImages;
            this.mContext = mContext;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView, imageView2, imageView3;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.image);
    //
            }
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_listitem2, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Log.d(TAG, "onBindViewHolder: called");
            Glide.with(mContext)
                    .asBitmap()
                    .load(mImages.get(position))
                    .into(holder.imageView);
    //        if (mImages.size()-1>position){
    //        Glide.with(mContext)
    //                .asBitmap()
    //                .load(mImages.get(position+1))
    //                .into(holder.imageView2);
    //        }
    //        if (mImages.size()-1>position){
    //        Glide.with(mContext)
    //                .asBitmap()
    //                .load(mImages.get(position))
    //                .into(holder.imageView3);
    //        }
        }

        @Override
        public int getItemCount() {
            return mImages.size();
        }
    }
}
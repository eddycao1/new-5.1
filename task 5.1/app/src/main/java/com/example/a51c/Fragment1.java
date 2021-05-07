package com.example.a51c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class Fragment1 extends Fragment {
    TextView mImageNmaes, contents;
    ImageView mImages;
    private Context C;


//    public Context RecyclerViewAdapter(Context mContext) {
//
//        this.C = mContext;
//
//        return C;
//
//
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_1,container,false);

        mImageNmaes = (TextView) rootView.findViewById(R.id.mImageNmaes);
        contents = (TextView) rootView.findViewById(R.id.content);
        mImages=(ImageView)rootView.findViewById(R.id.mImages);

        Bundle bundle = getArguments();

        String ImageNames = bundle.getString("mImageNames");
        String content = bundle.getString("content");
        String Images = bundle.getString("mImage");










        mImageNmaes.setText(ImageNames);
        contents.setText(content);

        Glide.with(getContext())
                .load(Images)
                .into(mImages);




        // mImages.setImageResource("");
        mImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });


        return rootView;


    }
}

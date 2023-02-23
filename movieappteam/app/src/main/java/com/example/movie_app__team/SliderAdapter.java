//package com.example.movie_app__team;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.makeramen.roundedimageview.RoundedImageView;
//
//public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder>{
//
//    @NonNull
//    @Override
//    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new SliderViewHolder(
//                LayoutInflater.from(parent.getContext()).inflate(
//                        R.layout.slide_item_container, parent,false
//                )
//        );
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    class SliderViewHolder extends RecyclerView.ViewHolder{
//
//        private RoundedImageView imageView;
//
//        public SliderViewHolder(@NonNull View itemView) {
//            super(itemView);
//            imageView = itemView.findViewById(R.id.imageSlide);
//        }
//
//        void setImageView(SliderItem sliderItem){
//            imageView.setImageResource(sliderItem.getImage());
//        }
//    }
//}

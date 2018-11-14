package com.example.samplestickerapp.Holders;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.example.samplestickerapp.R;
import com.squareup.picasso.Picasso;

public class loveViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    private CardView cardView;
    private String imgsrc;
    public String parent;

    public loveViewHolder(View itemView){
        super(itemView);
        imageView= itemView.findViewById(R.id.imageViewcomedy);
        cardView=itemView.findViewById(R.id.cardviewComedy);
    }
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public CardView getCardView() {
        return cardView;
    }

    public void setCardView(CardView cardView) {
        this.cardView = cardView;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public void setImage(Context context , String image){

        Picasso.with(context).load(image).into(imageView);

    }
}

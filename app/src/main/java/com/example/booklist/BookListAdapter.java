package com.example.booklist;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import org.w3c.dom.Text;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookViewHolder> {
        private Context context;
        private List<Items> items;


    public BookListAdapter(List<Items> items, Context context) {
        this.context = context;
        this.items = items;
        }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list_item ,parent,false);
        BookViewHolder viewHolder = new BookViewHolder(view);
            return viewHolder;
        }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.itemView.setTag(items.get(position));
        Items currentBook = items.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bookIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(currentBook.getVolumeInfo().getInfoLink()));
                context.startActivity(bookIntent);
            }
        });

        holder.title.setText(currentBook.getVolumeInfo().getTitle());

        if (currentBook.getVolumeInfo().getAuthors() == null) {
            holder.author.setVisibility(View.GONE);
        }
        else {
            holder.author.setText("by " + currentBook.getVolumeInfo().getAuthors()
                    .toString()
                    .replace("[", "")
                    .replace("]", ""));
        }

        holder.date.setText(currentBook.getVolumeInfo().getPublishedDate());

        if (currentBook.getVolumeInfo().getPageCount() == null) {
            holder.pages.setVisibility(View.GONE);
        }
        else {
            holder.pages.setText(currentBook.getVolumeInfo().getPageCount() + " pages");
        }

        holder.ratingBar.setRating(currentBook.getVolumeInfo().getAverageRating());

        Glide
                .with(context)
                .load(currentBook.getVolumeInfo().getImageLinks().getSmallThumbnail())
                .into(holder.image);
    }



    @Override
    public int getItemCount() {
        if (items != null) {
            return items.size();
        } else {
            return 0;
        }
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }


    public void addAll(List<Items> items) {
        this.items = items;
        notifyDataSetChanged();
    }


    public class BookViewHolder  extends RecyclerView.ViewHolder{
       public TextView title;
       public TextView author;
       public TextView pages;
       public TextView date;public ImageView image;
       public RatingBar ratingBar;


    public BookViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.book_title);
        author = itemView.findViewById(R.id.book_author);
        pages = itemView.findViewById(R.id.book_pages);
        date = itemView.findViewById(R.id.book_date);
        image = itemView.findViewById(R.id.book_image);
        ratingBar = itemView.findViewById(R.id.book_rating);

        }
    }
}

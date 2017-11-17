package com.radionov.nyreaderspidertest.ui.articles;

import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.radionov.nyreaderspidertest.R;
import com.radionov.nyreaderspidertest.model.dto.ArticleDto;
import com.radionov.nyreaderspidertest.utilities.ImageHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * RecyclerView Adapter
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private static final DateFormat dateFormat =
            new SimpleDateFormat("d-MMM-y", Locale.ROOT);
    private final List<ArticleDto> articles;
    private final OnItemClickListener clickListener;

    public interface OnItemClickListener {
        void onItemClick(String articleUrl);
    }

    public ArticleAdapter(List<ArticleDto> articles, OnItemClickListener listener) {
        this.articles = articles;
        this.clickListener = listener;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_card, parent, false);
        return new ArticleViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardView;

        ArticleViewHolder(CardView itemView) {
            super(itemView);
            cardView = itemView;
            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            ArticleDto article = articles.get(position);

            TextView section = cardView.findViewById(R.id.article_section);
            section.setPaintFlags(section.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            section.setText(article.getSection());
            ((TextView) cardView.findViewById(R.id.article_title)).setText(article.getTitle());
            ((TextView) cardView.findViewById(R.id.article_byline)).setText(article.getByline());
            ((TextView) cardView.findViewById(R.id.article_byline)).setText(article.getByline());

            ((TextView) cardView.findViewById(R.id.article_abstract_text))
                    .setText(article.getAbstractText());
            ((TextView) cardView.findViewById(R.id.article_published_date))
                    .setText(dateFormat.format(article.getPublishedDate()));

            ImageView imageView = cardView.findViewById(R.id.article_image);
            ImageHelper.loadImage(cardView.getContext(), article.getThumbnail(), imageView);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            String articleUrl = articles.get(adapterPosition).getUrl();
            clickListener.onItemClick(articleUrl);
        }
    }
}

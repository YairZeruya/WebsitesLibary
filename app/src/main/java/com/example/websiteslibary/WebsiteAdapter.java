package com.example.websiteslibary;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mywebsites.WebsitesPerCategory;

import java.util.List;

public class WebsiteAdapter extends ArrayAdapter<WebsitesPerCategory> {

    private List<WebsitesPerCategory> websitesList;
    private Context context;

    public WebsiteAdapter(Context context, List<WebsitesPerCategory> websitesList) {
        super(context, 0, websitesList);
        this.context = context;
        this.websitesList = websitesList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item_website, parent, false);
        }
        // Get the current website
        WebsitesPerCategory currentWebsite = websitesList.get(position);
        TextView websiteNameTextView = listItemView.findViewById(R.id.textViewWebsiteName);
        websiteNameTextView.setText(currentWebsite.getUrl());

        listItemView.setOnClickListener(v -> {
            String url = currentWebsite.getUrl();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(intent);
        });
        return listItemView;
    }
}

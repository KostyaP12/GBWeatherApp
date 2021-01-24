package com.geekbrains.gbweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.ViewHolder> {


    private Context context;
    private final List<Weather> weathers;

    public RecyclerDataAdapter(List<Weather> weathers) {

        this.weathers = weathers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).
                inflate(R.layout.weather_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerDataAdapter.ViewHolder holder, int position) {
        Weather weather = weathers.get(position);
        holder.iconView.setImageResource(weather.getWeatherIcon());
        holder.dayOfWeekView.setText(weather.getDayOfWeek());
        holder.temperatureView.setText(weather.getTemperature());
    }

    @Override
    public int getItemCount() {
        return weathers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView iconView;
        final TextView dayOfWeekView, temperatureView;

        ViewHolder(View view) {
            super(view);
            iconView = (ImageView) view.findViewById(R.id.item_image_icon);
            dayOfWeekView = (TextView) view.findViewById(R.id.item_day_of_week);
            temperatureView = (TextView) view.findViewById(R.id.item_temperature);
        }
    }
}

